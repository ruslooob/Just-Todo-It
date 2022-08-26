package com.ruslooob;

import com.ruslooob.TodoList.TodoListView;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Objects;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        TodoListView todoListView = new TodoListView();
        SplitPane splitPane = new SplitPane(new VBox(), todoListView.get());
        splitPane.setDividerPosition(0, 0.25);
        primaryStage.setTitle("Just Todo It");
        primaryStage.setScene(new Scene(splitPane, 1000, 570));
        Image ico = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/app-icon.png")));
        primaryStage.getIcons().add(ico);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
