package io.techgarage.java7;

import io.techgarage.DataAccess;
import io.techgarage.DataProcessor;

public class Application {

    public static void main(String[] args) {
        if (args.length > 0) {
            Factory factory = new Factory();
            DataAccess dataAccess = factory.create(args[0]);

            DataProcessor dataProcessor = new DataProcessor();
            dataProcessor.printStudents(dataAccess);
        } else {
            System.out.println("Specify data access type");
        }
    }
}
