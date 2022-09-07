package com.ruslooob.Helpers;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;

public class VBox {

    public javafx.scene.layout.VBox container = new javafx.scene.layout.VBox();

    public javafx.scene.layout.VBox build() {
        return container;
    }

    public VBox prefWidth(Double width) {
        container.setPrefWidth(width);
        return this;
    }

    public VBox maxWidth(Double width) {
        container.setMaxWidth(width);
        return this;
    }

    public VBox minWidth(Double width) {
        container.setMinWidth(width);
        return this;
    }

    public VBox background(Background background) {
        container.setBackground(background);
        return this;
    }

    public VBox border(Border border) {
        container.setBorder(border);
        return this;
    }

    public VBox padding(Insets insets) {
        container.setPadding(insets);
        return this;
    }

    public VBox spacing(double spacing) {
        container.setSpacing(spacing);
        return this;
    }

    public VBox childrens(Node... childrens) {
        container.getChildren().addAll(childrens);
        return this;
    }

}
