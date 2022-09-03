package com.ruslooob.Helpers;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

public class Stage {

    private final javafx.stage.Stage container;

    public Stage() {
        container = new javafx.stage.Stage();
    }

    public Stage(javafx.stage.Stage container) {
        this.container = container;
    }

    public Stage title(String title) {
        container.setTitle(title);
        return this;
    }

    public Stage scene(Scene scene) {
        container.setScene(scene);
        return this;
    }

    public Stage icon(Image image) {
        container.getIcons().add(image);
        return this;
    }

    public Stage icons(Image... images) {
        container.getIcons().addAll(images);
        return this;
    }

    public Stage owner(Window window) {
        container.initOwner(window);
        return this;
    }

    public Stage modality(Modality modality) {
        container.initModality(modality);
        return this;
    }

    public Stage onCloseRequest(EventHandler<WindowEvent> event) {
        container.setOnCloseRequest(event);
        return this;
    }

    public javafx.stage.Stage build() {
        return container;
    }

}
