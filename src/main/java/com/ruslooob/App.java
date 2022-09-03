package com.ruslooob;

import com.ruslooob.Database.DatabaseService;
import com.ruslooob.TodoList.LeftBar.SettingsView;
import com.ruslooob.TodoList.TodoList;
import com.ruslooob.TodoList.TodoListController;
import com.ruslooob.TodoList.TodoListView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.io.InputStream;

import static com.ruslooob.Helpers.SplitPaneHelper.splitPane;
import static com.ruslooob.Helpers.StageHelpers.stage;
import static com.ruslooob.LangLoader.$;
import static javafx.scene.control.Alert.AlertType.CONFIRMATION;

public class App extends Application {
    DatabaseService databaseService = new DatabaseService();
    TodoListController controller;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        TodoList todoList = databaseService.loadInitStateFromFile();
        TodoListView todoListView = new TodoListView();
        controller = new TodoListController(todoListView, todoList);
        SettingsView settings = new SettingsView();
        stage(primaryStage)
                .title($("main_window_title"))
                .scene(
                        new Scene(
                                splitPane()
                                        .dividerPosition(0, 0.25)
                                        .items(settings.get(), todoListView.get())
                                        .resizableWithParent(settings.get(), false)
                                        .build(),
                                1000,
                                570
                        )
                )
                .icon(new Image(getResourceAsStream("/img/app-icon.png")))
                .onCloseRequest(this::primaryStageOncloseRequestOnAction)
                .build()
                .show();
    }

    @SuppressWarnings("all")
    private InputStream getResourceAsStream(String path) {
        return getClass().getResourceAsStream(path);
    }

    private void primaryStageOncloseRequestOnAction(WindowEvent event) {
        //todo write alert builder
        Alert alert = new Alert(
                CONFIRMATION,
                $("main_window_exit_confirmation_content"),
                new ButtonType($("yes"), ButtonBar.ButtonData.OK_DONE),
                new ButtonType($("no"), ButtonBar.ButtonData.CANCEL_CLOSE)
        );
        alert.setTitle($("main_window_exit_confirmation_title"));
        alert.setHeaderText($("main_window_exit_confirmation_header"));
        alert.showAndWait()
             .ifPresent(response -> alertReceiveResponseOnAction(response, event));
    }

    private void alertReceiveResponseOnAction(ButtonType response, WindowEvent event) {
        if (response.getButtonData() != ButtonBar.ButtonData.OK_DONE) {
            event.consume();
        }
    }

    @Override
    public void stop() throws IOException {
        TodoList list = controller.getTodoList();
        databaseService.storeStateToFile(list);
    }

}
