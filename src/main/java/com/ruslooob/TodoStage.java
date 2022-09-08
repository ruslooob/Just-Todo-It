package com.ruslooob;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
    private Insets buttonInsets = new Insets(5, 10, 5, 10);
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
        Scene scene = new Scene(container, -1, -1);
        setScene(scene);
    }

    private HBox getButtons() {
        HBox buttons = new HBox(getRestoreButton(), getExitButton());
        buttons.setPrefWidth(300);
        buttons.setAlignment(Pos.CENTER_RIGHT);
        buttons.setOnMousePressed(pressEvent -> {
            buttons.setOnMouseDragged(dragEvent -> {
                setX(dragEvent.getScreenX() - pressEvent.getSceneX());
                setY(dragEvent.getScreenY() - pressEvent.getSceneY());
            });
        });
        return buttons;
    }

    private Button getExitButton() {
        if (exitButton == null) {
            exitButton = new Button("", new FontIcon(MaterialDesignW.WINDOW_CLOSE));
            exitButton.setPadding(buttonInsets);
            exitButton.setBackground(null);
            exitButton.setBorder(null);
            exitButton.setOnAction(event -> {
                this.close();
            });
        }
        return exitButton;
    }

    private Button getRestoreButton() {
        if (restoreButton == null) {
            restoreButton = new Button("", new FontIcon(MaterialDesignR.RECTANGLE_OUTLINE));
            restoreButton.setPadding(buttonInsets);
            restoreButton.setBackground(null);
            restoreButton.setBorder(null);
            restoreButton.setOnAction(event -> {
                content.setVisible(!content.isVisible());
                content.setManaged(!content.isManaged());
                sizeToScene();
            });
        }
        return restoreButton;
    }

}
