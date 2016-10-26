package com.serialization.test;

import java.io.InvalidObjectException;
import java.io.ObjectInputValidation;
import java.io.Serializable;

public class Employee extends Manager implements Company, Serializable, ObjectInputValidation {
    private static final long serialVersionUID = 456778567857L;
    public String firstName = "First Name";
    public transient static String middleName = "Middle Name";
    public transient final String lastName;
    public transient final String nickName = "Nick Name";
    private int explicitAge = 45;// Will not be read
    PersonalDetails pd = new PersonalDetails(26, 'F');// If we make it transient
                                                      // then null pointer
                                                      // exception
//    Manager m = new Manager();
    transient static PersonalDetails pdstat = new PersonalDetails(30, 'M');

    public Employee(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public void validateObject() throws InvalidObjectException {
        // TODO Auto-generated method stub
        System.err.println("Object Validation In Progress");
        if (this.explicitAge == 45 || this.nickName.equals("Nick Name")) {
            System.err.println("Object Validation Passed");
        } else {
            throw new InvalidObjectException("Object Validation Failed");
        }
    }
    
    public static void main(String[] args) {
        Employee e = new Employee("last");
        System.out.println(e.managerName);
    }
}

class Manager {
    public transient String managerName = "Manager Name";// Transient field wont
                                                         // work here as Manager
                                                         // is not implementing
                                                         // Serializable
}

interface Company {
    String  companyCEO = "Mr CEO";
    String companyName = "Company Name";
}

class PersonalDetails {
    transient int age = 40;
    char gender = 'F';

    public PersonalDetails(int age, char gender) {
        this.age = age;
        this.gender = gender;
    }
}
