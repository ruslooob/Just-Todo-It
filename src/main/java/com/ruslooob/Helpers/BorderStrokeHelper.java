package com.ruslooob.Helpers;

import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.CornerRadii;

public class BorderStrokeHelper {
    public static BorderStroke borderStroke(CornerRadii radii) {
        return new BorderStroke(
                null,
                null,
                new CornerRadii(10),
                null
        );
    }
}
