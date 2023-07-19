package com.behaviour.state;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.javatuples.Pair;

enum PhoneState{
	OFF_HOOK,
	ON_HOOK,
	CONNECTING,
	CONNECTED,
	ON_HOLD
}

enum Trigger {
	CALL_DIALLED,
	HUNG_UP,
	CALL_CONNECTED,
	PLACED_ON_HOLD,
	TAKEN_OFF_HOLD,
	LEFT_MESSAGE,
	STOP_USING_PHONE
}

public class StateMachineDemo {
	private static Map<PhoneState, List<Pair<Trigger,PhoneState>>> 
	rules = new HashMap<>();
	static {
		rules.put(PhoneState.OFF_HOOK, List.of(
				new Pair<>(Trigger.CALL_DIALLED ,PhoneState.CONNECTING),
				new Pair<>(Trigger.STOP_USING_PHONE ,PhoneState.ON_HOOK)
				));
		rules.put(PhoneState.CONNECTING, List.of(
				new Pair<>(Trigger.HUNG_UP  ,PhoneState.OFF_HOOK),
				new Pair<>(Trigger.CALL_CONNECTED ,PhoneState.CONNECTED)
				));
		rules.put(PhoneState.CONNECTED, List.of(
				new Pair<>(Trigger.LEFT_MESSAGE ,PhoneState.OFF_HOOK),
				new Pair<>(Trigger.HUNG_UP ,PhoneState.OFF_HOOK),
				new Pair<>(Trigger.PLACED_ON_HOLD ,PhoneState.ON_HOLD)
				));
		rules.put(PhoneState.ON_HOLD, List.of(
				new Pair<>(Trigger.TAKEN_OFF_HOLD ,PhoneState.CONNECTED),
				new Pair<>(Trigger.HUNG_UP ,PhoneState.OFF_HOOK)
				));
		
	}
	private static PhoneState currentState =PhoneState.OFF_HOOK;
	private static PhoneState exitState =PhoneState.ON_HOOK;
	
	public static void main(String[] args) {
	 BufferedReader  bufferReader = new BufferedReader(
           new InputStreamReader(System.in)
			 );
        while(true) {
        	System.out.println("The phone is currently "+currentState);
        	System.out.println("Select a trigger :");
        for(int i=0; i< rules.get(currentState).size(); ++i) {
        		Trigger trigger=rules.get(currentState).get(i).getValue0();
        		System.out.println(" "+i+" ."+trigger);
        	}
        boolean parseOk = false;
        int choice =0;
        do {
        	try {
        		System.out.println("Please enter your choice :");
        		choice = Integer.parseInt(bufferReader.readLine());
        		parseOk =choice >=0 &&
        				choice <=rules.get(currentState).size();
        	}catch(Exception e) {
        		parseOk=false;
        	}
          }while(!parseOk);
        currentState = rules.get(currentState).get(choice).getValue1();
        if(currentState ==exitState) break;
        }
        System.out.println("We are done !");
	}

}
