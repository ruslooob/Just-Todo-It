package com.ruslooob.Helpers;

import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class VBoxHelper {

    public static com.ruslooob.Helpers.VBox vbox() {
        return new com.ruslooob.Helpers.VBox();
    }

    public static VBox vbox(double spacing, Node... nodes) {
        return new VBox(spacing, nodes);
    }

}
