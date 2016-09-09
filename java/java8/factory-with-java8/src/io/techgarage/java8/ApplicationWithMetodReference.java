package io.techgarage.java8;

import io.techgarage.MongoAccess;
import io.techgarage.DataAccess;
import io.techgarage.DataProcessor;
import io.techgarage.RdbmsAccess;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ApplicationWithMetodReference {

    public static void main(String[] args) {
        if (args.length > 0) {
            Map<String, Supplier<DataAccess>> factories = new HashMap<>();
            factories.put("mongo", MongoAccess::new);
            factories.put("rdbms", RdbmsAccess::new);

            DataProcessor dataProcessor = new DataProcessor();
            dataProcessor.printStudents(factories.get(args[0]).get());
        } else {
            System.out.println("Specify data access type");
        }
    }
}
