package com.ruslooob;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.jetbrains.annotations.NotNull;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignR;
import org.kordamp.ikonli.materialdesign2.MaterialDesignW;


public class TodoStage extends Stage {

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
        container.setTop(getButtons());
        container.setCenter(content);
        container.getStyleClass().add("todo-stage-container");
        container.getStylesheets().add("/css/todo-stage.css");
        Scene scene = new Scene(container);
        setScene(scene);
    }

    private HBox getButtons() {
        HBox buttons = new HBox(getRestoreButton(), getExitButton());
        buttons.setOnMousePressed(pressEvent -> {
            buttons.setOnMouseDragged(dragEvent -> {
                setX(dragEvent.getScreenX() - pressEvent.getSceneX());
                setY(dragEvent.getScreenY() - pressEvent.getSceneY());
            });
        });
        buttons.getStyleClass().add("buttons");
        return buttons;
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
                sizeToScene();
            });
            restoreButton.getStyleClass().add("restore-button");
        }
        return restoreButton;
    }

}
