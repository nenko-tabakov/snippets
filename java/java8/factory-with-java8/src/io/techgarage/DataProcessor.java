package io.techgarage;

public class DataProcessor {

    public void printStudents(DataAccess dataAccess) {
        for (String student : dataAccess.getAllStudents()) {
            System.out.println(student);
        }
    }
}
