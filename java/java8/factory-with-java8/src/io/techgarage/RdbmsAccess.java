package io.techgarage;

import java.util.Arrays;
import java.util.Collection;

public class RdbmsAccess implements DataAccess {

    @Override
    public Collection<String> getAllStudents() {
        System.out.println("Getting data from RDBMS");
        return Arrays.asList("Student1 from RDBMS", "Student2 from RDBMS");
    }
}
