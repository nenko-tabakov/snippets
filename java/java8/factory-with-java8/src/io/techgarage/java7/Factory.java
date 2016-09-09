package io.techgarage.java7;

import io.techgarage.DataAccess;
import io.techgarage.MongoAccess;
import io.techgarage.RdbmsAccess;

public class Factory {

    DataAccess create(String type) {
        if ("mongo".equals(type)) {
            return new MongoAccess();
        }

        if ("dbms".equals(type)) {
            return new RdbmsAccess();
        }

        throw new IllegalArgumentException("The specified type is not supported");
    }
}
