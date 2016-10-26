package com.serialization.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
public class SerializaitonClass {
    public static void main(String[] args) {
        Employee emp = new Employee("Last Name");
        emp.firstName = "Overriden First Name";
        emp.middleName = "Overriden Middle Name";
        emp.managerName = "Overriden Manager Name";
        emp.pd.age = 28;
        emp.pd.gender = 'M';
        emp.pdstat.age = 35;
        emp.pdstat.gender = 'M';
        try {
            FileOutputStream fileOut = new FileOutputStream("./employee.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(emp);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in ./employee.txt file");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}