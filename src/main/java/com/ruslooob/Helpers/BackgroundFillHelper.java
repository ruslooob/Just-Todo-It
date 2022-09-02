package com.ruslooob.Helpers;

import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class BackgroundFillHelper {

    public static BackgroundFill backgroundFill(Color color) {
        return new BackgroundFill(
                Color.web("#ffffff", 0.5),
                null,
                null
        );
    }
}
