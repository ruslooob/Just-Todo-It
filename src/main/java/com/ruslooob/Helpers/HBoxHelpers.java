package com.ruslooob.Helpers;

import javafx.scene.Node;


public class HBoxHelpers {

    public static HBox hbox() {
        return new HBox();
    }

    public static javafx.scene.layout.HBox hbox(double spacing, Node... nodes) {
        return new com.ruslooob.Helpers.HBox()
                .spacing(spacing)
                .childrens(nodes).container;
    }

}
