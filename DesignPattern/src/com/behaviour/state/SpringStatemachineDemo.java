package com.behaviour.state;

// This program has exception 
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

// plural because SSM defines a class called State already
enum MobileState
{
  OFF_HOOK, // starting
  ON_HOOK, // terminal
  CONNECTING,
  CONNECTED,
  ON_HOLD
}

enum Events
{
  CALL_DIALED,
  HUNG_UP,
  CALL_CONNECTED,
  PLACED_ON_HOLD,
  TAKEN_OFF_HOLD,
  LEFT_MESSAGE,
  STOP_USING_PHONE
}

public class SpringStatemachineDemo
{
  public static StateMachine<MobileState, Events> buildMachine()
    throws Exception
  {
    StateMachineBuilder.Builder<MobileState, Events> builder
      = StateMachineBuilder.builder();

    builder.configureStates()
      .withStates()
        .initial(MobileState.OFF_HOOK)
        .states(EnumSet.allOf(MobileState.class));

    builder.configureTransitions()
      .withExternal()
        .source(MobileState.OFF_HOOK)
        .event(Events.CALL_DIALED)
        .target(MobileState.CONNECTING)
        .and()
      .withExternal()
        .source(MobileState.OFF_HOOK)
        .event(Events.STOP_USING_PHONE)
        .target(MobileState.ON_HOOK)
        .and()
      .withExternal()
        .source(MobileState.CONNECTING)
        .event(Events.HUNG_UP)
        .target(MobileState.OFF_HOOK)
        .and()
      .withExternal()
        .source(MobileState.CONNECTING)
        .event(Events.CALL_CONNECTED)
        .target(MobileState.CONNECTED)
        .and()
      .withExternal()
        .source(MobileState.CONNECTED)
        .event(Events.LEFT_MESSAGE)
        .target(MobileState.OFF_HOOK)
        .and()
      .withExternal()
        .source(MobileState.CONNECTED)
        .event(Events.HUNG_UP)
        .target(MobileState.OFF_HOOK)
        .and()
      .withExternal()
        .source(MobileState.CONNECTED)
        .event(Events.PLACED_ON_HOLD)
        .target(MobileState.OFF_HOOK)
        .and()
      .withExternal()
        .source(MobileState.ON_HOLD)
        .event(Events.TAKEN_OFF_HOLD)
        .target(MobileState.CONNECTED)
        .and()
      .withExternal()
        .source(MobileState.ON_HOLD)
        .event(Events.HUNG_UP)
        .target(MobileState.OFF_HOOK);

    return builder.build();
  }

  // requires org.springframework.statemachine
  public static void main(String[] args) throws Exception
  {
    StateMachine<MobileState, Events> machine = buildMachine();
    machine.start();

    MobileState exitState = MobileState.ON_HOOK;

    BufferedReader console = new BufferedReader(
      new InputStreamReader(System.in)
    );

    while (true)
    {
      State<MobileState, Events> state = machine.getState();

      System.out.println("The phone is currently " + state.getId());
      System.out.println("Select a trigger:");

      List<Transition<MobileState, Events>> ts = machine.getTransitions()
        .stream()
        .filter(t -> t.getSource() == state)
        .collect(Collectors.toList());
      for (int i = 0; i < ts.size(); ++i)
      {
        System.out.println("" + i + ". " +
          ts.get(i).getTrigger().getEvent());
      }

      boolean parseOK;
      int choice = 0;
      do
      {
        try
        {
          System.out.println("Please enter your choice:");

          choice = Integer.parseInt(console.readLine());
          parseOK = choice >= 0 && choice < ts.size();
        }
        catch (Exception e)
        {
          parseOK = false;
        }
      } while (!parseOK);

      // perform the transition
      machine.sendEvent(ts.get(choice).getTrigger().getEvent());

      if (machine.getState().getId() == exitState)
        break;
    }
    System.out.println("And we are done!");
  }
}

