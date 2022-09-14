package com.ruslooob.Helpers;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;

public class HBox {
    public javafx.scene.layout.HBox container = new javafx.scene.layout.HBox();

    public HBox() {
    }

    public javafx.scene.layout.HBox build() {
        return container;
    }

    public HBox prefWidth(double width) {
        container.setPrefWidth(width);
        return this;
    }

    public HBox maxWidth(Double width) {
        container.setMaxWidth(width);
        return this;
    }

    public HBox minWidth(Double width) {
        container.setMinWidth(width);
        return this;
    }

    public HBox background(Background background) {
        container.setBackground(background);
        return this;
    }

    public HBox border(Border border) {
        container.setBorder(border);
        return this;
    }

    public HBox padding(Insets insets) {
        container.setPadding(insets);
        return this;
    }

    public HBox spacing(double spacing) {
        container.setSpacing(spacing);
        return this;
    }

    public HBox childrens(Node... childrens) {
        container.getChildren().addAll(childrens);
        return this;
    }
}
