package com.ruslooob.Helpers;

import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class StageHelpers {

    public static Stage stage(String title, Window owner, Modality modality, Scene scene) {
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.initOwner(owner);
        stage.initModality(modality);
        stage.setScene(scene);
        return stage;
    }

}
