package io.techgarage;


import java.util.Arrays;
import java.util.Collection;

public class MongoAccess implements DataAccess {

    @Override
    public Collection<String> getAllStudents() {
        System.out.println("Getting data from Mongo");
        return Arrays.asList("Student1 from Mongo", "Student2 from Mongo");
    }
}
