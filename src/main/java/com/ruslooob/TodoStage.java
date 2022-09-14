package com.ruslooob;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.jetbrains.annotations.NotNull;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignR;
import org.kordamp.ikonli.materialdesign2.MaterialDesignW;


/*todo сделать todo stage часть вьюхи, чтобы можно было внутри него получать доступ к header-у*/
public class TodoStage extends Stage {
    private Label header;
    private Button restoreButton;
    private Button exitButton;
    private Region content;

    public TodoStage(@NotNull Region content) {
        super();
        this.content = content;
        initialize();
    }

    void initialize() {
        initStyle(StageStyle.UNDECORATED);
        BorderPane container = new BorderPane();
        container.setTop(getTopPane());
        container.setCenter(content);
        container.getStyleClass().add("todo-stage-container");
        container.getStylesheets().add("/css/todo-stage.css");
        Scene scene = new Scene(container);
        setScene(scene);
    }

    private Node getTopPane() {
        HBox headerContainer = new HBox(getHeader());
        headerContainer.getStyleClass().add("header-container");
        HBox topPane = new HBox(headerContainer, getRestoreButton(), getExitButton());
        topPane.setAlignment(Pos.CENTER_RIGHT);
        HBox.setHgrow(headerContainer, Priority.ALWAYS);
        headerContainer.setAlignment(Pos.CENTER);
        topPane.setOnMousePressed(pressEvent -> {
            topPane.setOnMouseDragged(dragEvent -> {
                setX(dragEvent.getScreenX() - pressEvent.getSceneX());
                setY(dragEvent.getScreenY() - pressEvent.getSceneY());
            });
        });
        MenuItem alwaysOnTopMenuItem = new MenuItem("Поверх других");
        alwaysOnTopMenuItem.setOnAction(event -> setAlwaysOnTop(!isAlwaysOnTop()));
        MenuItem renameNoteMenuItem = new MenuItem("Переименовать");
        renameNoteMenuItem.setOnAction(this::renameNoteMenuItem);

        ContextMenu contextMenu = new ContextMenu(alwaysOnTopMenuItem, renameNoteMenuItem);
        topPane.setOnContextMenuRequested(e -> {
            contextMenu.show(topPane.getScene().getWindow(), e.getScreenX(), e.getScreenY());
        });
        topPane.getStyleClass().add("top-pane");
        return topPane;
    }

    private void renameNoteMenuItem(ActionEvent event) {
        Stage stage = new Stage();
        TextField textField = new TextField();
        textField.setText(getHeader().getText());
        textField.setPromptText("Название");
        Button saveButton = new Button("Сохранить");
        saveButton.setOnAction(event1 -> {
            setHeader(textField.getText());
            stage.close();
        });
        VBox renameView = new VBox(15, textField, saveButton);
        Scene scene = new Scene(renameView, 200, 100);
        stage.setScene(scene);
        stage.show();
    }

    private Label getHeader() {
        if (header == null) {
            header = new Label("");
            header.getStyleClass().add("header");
        }
        return header;
    }

    public void setHeader(String text) {
        header.setText(text);
    }

    private Button getExitButton() {
        if (exitButton == null) {
            exitButton = new Button("", new FontIcon(MaterialDesignW.WINDOW_CLOSE));
            exitButton.setOnAction(event -> this.close());
            exitButton.getStyleClass().add("exit-button");
        }
        return exitButton;
    }

    private Button getRestoreButton() {
        if (restoreButton == null) {
            restoreButton = new Button("", new FontIcon(MaterialDesignR.RECTANGLE_OUTLINE));
            restoreButton.setOnAction(event -> {
                content.setVisible(!content.isVisible());
                content.setManaged(!content.isManaged());
                /*todo fix this shit*/
                double prevWidth = getWidth();
                sizeToScene();
                setWidth(prevWidth);
            });
            restoreButton.getStyleClass().add("restore-button");
        }
        return restoreButton;
    }

}
