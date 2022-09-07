package com.ruslooob;

import com.ruslooob.Database.DatabaseService;
import com.ruslooob.Settings.SettingsController;
import com.ruslooob.Settings.SettingsView;
import com.ruslooob.TodoList.TodoList;
import com.ruslooob.TodoList.TodoListController;
import com.ruslooob.TodoList.TodoListView;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

import static com.ruslooob.Helpers.SplitPaneHelper.splitPane;
import static com.ruslooob.Helpers.StageHelpers.stage;
import static com.ruslooob.LangLoader.$;
import static javafx.scene.control.Alert.AlertType.CONFIRMATION;
import static javafx.scene.control.Alert.AlertType.ERROR;

public class App extends Application {

    Stage primaryStage;
    DatabaseService databaseService = new DatabaseService();
    TodoListController controller;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TodoList todoList = databaseService.loadInitStateFromFile();
        TodoListView todoListView = new TodoListView();
        controller = new TodoListController(todoListView, todoList);
        SettingsView settingsView = new SettingsView();
        SettingsController settingsController = new SettingsController(settingsView, todoList);


        this.primaryStage =
                stage(primaryStage)
                        .title($("main_window_title"))
                        .scene(
                                new Scene(
                                        splitPane()
                                                .dividerPosition(0, 0.25)
                                                .items(settingsView.get(), todoListView.get())
                                                .resizableWithParent(settingsView.get(), false)
                                                .build(),
                                        1000,
                                        570
                                )
                        )
                        .icon(new javafx.scene.image.Image(getResourceAsStream("/img/app-icon.png")))
                        .onCloseRequest(this::primaryStageOncloseRequestOnAction)
                        .build();

        Platform.setImplicitExit(false);
        addIconToTray();
        primaryStage.show();
    }

    private void addIconToTray() throws Exception {
        Toolkit.getDefaultToolkit();

        if (!SystemTray.isSupported()) {
            Alert alert = new Alert(ERROR, $("no_system_tray_support_alert_text"));
            alert.showAndWait();
            Platform.exit();
        }

        SystemTray tray = SystemTray.getSystemTray();
        Image image = ImageIO.read(getResourceAsStream("/img/app-icon.png"));
        TrayIcon trayIcon = new TrayIcon(image);
        trayIcon.addActionListener(event -> Platform.runLater(() -> trayIconOnDoubleClick(primaryStage)));

        PopupMenu popup = new PopupMenu();
        popup.add(getNewTodoItem());
        popup.addSeparator();
        popup.add(getExitItem(tray, trayIcon));

        trayIcon.setPopupMenu(popup);
        tray.add(trayIcon);
    }

    private void trayIconOnDoubleClick(Stage primaryStage) {
        primaryStage.show();
        primaryStage.toFront();
    }

    private MenuItem getNewTodoItem() {
        MenuItem newTodoItem = new MenuItem($("new_todo_tray_icon_text"));
        newTodoItem.addActionListener(event -> Platform.runLater(() -> trayIconOnDoubleClick(primaryStage)));
        Font defaultFont = Font.decode("TIMES-NEW-ROMAN-BOLD-14");
        newTodoItem.setFont(defaultFont);
        return newTodoItem;
    }

    private MenuItem getExitItem(SystemTray tray, TrayIcon trayIcon) {
        MenuItem exitItem = new MenuItem($("exit_tray_icon_text"));
        Font defaultFont = Font.decode("TIMES-NEW-ROMAN-14");
        exitItem.setFont(defaultFont);
        exitItem.addActionListener(event -> {
            Platform.exit();
            tray.remove(trayIcon);
        });
        return exitItem;
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
