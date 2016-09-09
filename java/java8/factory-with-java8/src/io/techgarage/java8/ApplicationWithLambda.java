package io.techgarage.java8;

import io.techgarage.DataAccess;
import io.techgarage.DataProcessor;
import io.techgarage.MongoAccess;
import io.techgarage.RdbmsAccess;

import java.util.function.Supplier;

public class ApplicationWithLambda {

    public static void main(String[] args) {
        if (args.length > 0) {
            DataProcessor dataProcessor = new DataProcessor();

            Supplier<DataAccess> dataAccessSupplier = () -> {
                String type = args[0];
                if ("mongo".equals(type)) {
                    return new MongoAccess();
                }

                if ("dbms".equals(type)) {
                    return new RdbmsAccess();
                }

                throw new IllegalArgumentException("The specified type is not supported");
            };

            dataProcessor.printStudents(dataAccessSupplier.get());
        } else {
            System.out.println("Specify data access type");
        }
    }
}
