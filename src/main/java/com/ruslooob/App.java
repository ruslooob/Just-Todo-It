package com.ruslooob;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.ruslooob.LeftBar.SettingsView;
import com.ruslooob.TodoList.TodoList;
import com.ruslooob.TodoList.TodoListController;
import com.ruslooob.TodoList.TodoListView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import static javafx.scene.control.Alert.AlertType.CONFIRMATION;

public class App extends Application {
    Path path = Paths.get("todos.txt");
    TodoListController controller;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        File file = new File("todos.txt");
        boolean newFile = file.createNewFile();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JSR310Module());
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        TodoList todoList = new TodoList();
        /*fixme bug with firs launch with empty file*/
        if (!newFile) {
            todoList = objectMapper.readValue(file, TodoList.class);
        }
        TodoListView view = new TodoListView();
        controller = new TodoListController(view, todoList);
        SettingsView settings = new SettingsView();
        SplitPane splitPane = new SplitPane(settings.get(), view.get());
        splitPane.setDividerPosition(0, 0.25);
        SplitPane.setResizableWithParent(settings.get(), false);
        primaryStage.setTitle("Just Todo It");
        primaryStage.setScene(new Scene(splitPane, 1000, 570));
        Image ico = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/app-icon.png")));
        primaryStage.getIcons().add(ico);
        primaryStage.setOnCloseRequest(event -> {
            Alert alert = new Alert(CONFIRMATION, "Вы действительно хотите выйти?");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.CANCEL) {
                event.consume();
            }
        });
        primaryStage.show();
    }

    @Override
    public void stop() {
        TodoList list = controller.getTodoList();
        ObjectMapper mapper = new ObjectMapper();
        // fixme deprecated class usage
        mapper.registerModule(new JSR310Module());
        try {
            String json = mapper.writeValueAsString(list);
            Files.writeString(path, json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
