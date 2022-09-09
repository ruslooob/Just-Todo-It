package com.ruslooob.Controls;

import javafx.scene.Node;
import javafx.scene.control.Label;

public class StyledLabel extends Label {

    public StyledLabel(String text, Node graphic, String... styleClasses) {
        super(text, graphic);
        getStyleClass().addAll(styleClasses);
    }

}
