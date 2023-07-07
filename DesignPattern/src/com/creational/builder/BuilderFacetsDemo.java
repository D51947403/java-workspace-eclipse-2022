package com.creational.builder;

class Person2
{
  // address
  public String streetAddress, postcode, city;

  // employment
  public String companyName, position;
  public int annualIncome;

  @Override
  public String toString()
  {
    return "Person{" +
      "streetAddress='" + streetAddress + '\'' +
      ", postcode='" + postcode + '\'' +
      ", city='" + city + '\'' +
      ", companyName='" + companyName + '\'' +
      ", position='" + position + '\'' +
      ", annualIncome=" + annualIncome +
      '}';
  }
}

// builder facade
class PersonBuilderDemo
{
  // the object we're going to build
  protected Person2 person2 = new Person2(); // reference!

  public PersonJobBuilder works()
  {
    return new PersonJobBuilder(person2);
  }

  public PersonAddressBuilder lives()
  {
    return new PersonAddressBuilder(person2);
  }

  public Person2 build()
  {
    return person2;
  }
}

class PersonAddressBuilder extends PersonBuilderDemo
{
  public PersonAddressBuilder(Person2 person2)
  {
    this.person2 = person2;
  }

  public PersonAddressBuilder at(String streetAddress)
  {
    person2.streetAddress = streetAddress;
    return this;
  }

  public PersonAddressBuilder withPostcode(String postcode)
  {
    person2.postcode = postcode;
    return this;
  }

  public PersonAddressBuilder in(String city)
  {
    person2.city = city;
    return this;
  }
}

class PersonJobBuilder extends PersonBuilderDemo
{
  public PersonJobBuilder(Person2 person2)
  {
    this.person2 = person2;
  }

  public PersonJobBuilder at(String companyName)
  {
    person2.companyName = companyName;
    return this;
  }

  public PersonJobBuilder asA(String position)
  {
    person2.position = position;
    return this;
  }

  public PersonJobBuilder earning(int annualIncome)
  {
    person2.annualIncome = annualIncome;
    return this;
  }
}

public class BuilderFacetsDemo
{
  public static void main(String[] args)
  {
    PersonBuilderDemo pb = new PersonBuilderDemo();
    Person2 person = pb
      .lives()
        .at("123 London Road")
        .in("London")
        .withPostcode("SW12BC")
      .works()
        .at("Fabrikam")
        .asA("Engineer")
        .earning(123000)
      .build();
    System.out.println(person);
  }
}
