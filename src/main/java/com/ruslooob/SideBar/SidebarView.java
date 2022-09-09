package com.ruslooob.SideBar;

import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.util.Callback;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignC;
import org.kordamp.ikonli.materialdesign2.MaterialDesignI;
import org.kordamp.ikonli.materialdesign2.MaterialDesignS;
import org.kordamp.ikonli.materialdesign2.MaterialDesignT;

import static com.ruslooob.LangLoader.$;
import static javafx.collections.FXCollections.observableArrayList;

public class SidebarView {

    private final Parent view;

    public SidebarView() {
        view = createView();
        view.getStylesheets().add("/css/sidebar.css");
    }

    private Parent createView() {
        //        Label favoritesText = new Label($("sidebar_favorites_option_text"));
        //        favoritesText.getStyleClass().add("favorites-label");
        //        Label trashText = new Label($("sidebar_trash_option_text"));
        //        trashText.getStyleClass().add("trash-label");
        //        Label preferencesText = new Label($("sidebar_preferences_option_text"));
        //        preferencesText.getStyleClass().add("preferences-label");
        //        Label aboutText = new Label($("sidebar_about_option_text"));
        //        aboutText.getStyleClass().add("about-label");

        ListView<String> container = new ListView<>(observableArrayList(
                $("sidebar_favorites_option_text"),
                $("sidebar_trash_option_text"),
                $("sidebar_preferences_option_text"),
                $("sidebar_about_option_text")
        ));

        container.setCellFactory(new Callback<>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new ListCell<>() {
                    @Override
                    protected void updateItem(String text, boolean empty) {
                        super.updateItem(text, empty);

                        if (empty || text == null) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            setGraphic(getIconByText(text));
                            setText(text);
                            setFont(Font.font(16));
                            setGraphicTextGap(15);
                        }
                    }
                };
            }
        });
        return new StackPane(container);
    }

    private FontIcon getIconByText(String text) {
        if ($("sidebar_favorites_option_text").equals(text)) {
            return new FontIcon(MaterialDesignS.STAR_OUTLINE);
        } else if ($("sidebar_trash_option_text").equals(text)) {
            return new FontIcon(MaterialDesignT.TRASH_CAN_OUTLINE);
        } else if ($("sidebar_preferences_option_text").equals(text)) {
            return new FontIcon(MaterialDesignC.COG_OUTLINE);
        } else if ($("sidebar_about_option_text").equals(text)) {
            return new FontIcon(MaterialDesignI.INFORMATION_OUTLINE);
        }
        throw new RuntimeException("Unreachable statement");
    }

    public Parent get() {
        return view;
    }

}
