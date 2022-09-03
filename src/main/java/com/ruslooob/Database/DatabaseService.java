package com.ruslooob.Database;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.ruslooob.TodoList.TodoList;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DatabaseService {

    private final String STATE_FILE_PATH = "todos.txt";

    /* todo show confirmaiton alert with critical error*/
    public TodoList loadInitStateFromFile() throws IOException {
        File file = new File(STATE_FILE_PATH);
        boolean fileWasCreated = file.createNewFile();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JSR310Module());
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        TodoList todoList = new TodoList();
        /*fixme bug with firs launch with empty file*/
        if (!fileWasCreated) {
            //            todoList = objectMapper.readValue(file, TodoList.class);
        }
        return todoList;
    }

    public void storeStateToFile(TodoList todoList) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // fixme deprecated class usage
        mapper.registerModule(new JSR310Module());
        Path path = Paths.get("todos.txt");
        String json = mapper.writeValueAsString(todoList);
        Files.writeString(path, json);
    }

}
