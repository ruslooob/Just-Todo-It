package com.ruslooob.Helpers;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;


// todo подумать, как сделать разъединение между стилями и размерами
// пока мысль только про билдеры
public class HBoxHelpers {

    public static HBox hbox(double spacing, Node... nodes) {
        return new HBox(spacing, nodes);
    }

    // maxwidth, background, border, padding, spacing, nodes
    public static HBox hbox(Double maxWidth, Background background, Border border, Insets padding, Double spacing, Node... nodes) {
        HBox hBox = new HBox();
        hBox.setMaxWidth(maxWidth);
        hBox.setBackground(background);
        hBox.setBorder(border);
        hBox.setPadding(padding);
        hBox.setSpacing(spacing);
        hBox.getChildren().addAll(nodes);
        return hBox;
    }

}
