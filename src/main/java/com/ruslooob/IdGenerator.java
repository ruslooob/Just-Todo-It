package com.ruslooob;

public class IdGenerator {
    private static Long id = 0L;

    public static Long nextId() {
        id++;
        return id;
    }

}
