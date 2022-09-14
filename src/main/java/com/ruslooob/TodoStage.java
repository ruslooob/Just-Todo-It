package com.ruslooob;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.jetbrains.annotations.NotNull;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignD;
import org.kordamp.ikonli.materialdesign2.MaterialDesignP;
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
        /*todo это свойство нужно хранить в самой заметке, чтобы при закрытии приложении оно все равно сохранялось*/
        alwaysOnTopMenuItem.setOnAction(event -> setAlwaysOnTop(!isAlwaysOnTop()));
        alwaysOnTopMenuItem.setGraphic(new FontIcon(MaterialDesignD.DOCK_WINDOW));

        MenuItem renameNoteMenuItem = new MenuItem("Переименовать");
        renameNoteMenuItem.setOnAction(this::renameNoteMenuItem);
        renameNoteMenuItem.setGraphic(new FontIcon(MaterialDesignP.PENCIL_OUTLINE));

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
        Label header = new Label("Переименовать");
        textField.setText(getHeader().getText());
        textField.setPromptText("Название");
        Button saveButton = new Button("Сохранить");
        saveButton.setOnAction(event1 -> {
            setHeader(textField.getText());
            stage.close();
        });
        Button cancelButton = new Button("Отменить");
        cancelButton.setOnAction(event2 -> {
            stage.close();
        });
        VBox renameView = new VBox(15, header, textField, new HBox(15, saveButton, cancelButton));
        renameView.setPadding(new Insets(20));
        Scene scene = new Scene(renameView, 250, 150);
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
