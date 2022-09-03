package com.ruslooob.Helpers;

import javafx.stage.Stage;

public class StageHelpers {

    public static com.ruslooob.Helpers.Stage stage() {
        return new com.ruslooob.Helpers.Stage();
    }

    public static com.ruslooob.Helpers.Stage stage(Stage stage) {
        return new com.ruslooob.Helpers.Stage(stage);
    }


}
