package com.ruslooob.Settings;

import com.ruslooob.FontFamily;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import org.kordamp.ikonli.fontawesome.FontAwesome;
import org.kordamp.ikonli.javafx.FontIcon;

import static com.ruslooob.Helpers.VBoxHelper.vbox;
import static com.ruslooob.LangLoader.$;

public class SettingsView {

    private final Parent view;

    public SettingsView() {
        view = createView();
    }

    private Parent createView() {
        Label favoritesText = new Label($("settings_favorites_option_text"), new FontIcon(FontAwesome.STAR_O));
        favoritesText.setFont(Font.font(FontFamily.TIMES_NEW_ROMAN, 18));
        favoritesText.setGraphicTextGap(10);
        HBox favorites = new HBox(favoritesText);
        Label trashText = new Label($("settings_trash_option_text"), new FontIcon(FontAwesome.TRASH));
        trashText.setFont(Font.font(FontFamily.TIMES_NEW_ROMAN, 18));
        trashText.setGraphicTextGap(10);
        HBox trash = new HBox(trashText);
        Label preferencesText = new Label($("settings_preferences_option_text"), new FontIcon(FontAwesome.GEAR));
        preferencesText.setFont(Font.font(FontFamily.TIMES_NEW_ROMAN, 18));
        preferencesText.setGraphicTextGap(10);
        HBox preferences = new HBox(preferencesText);
        Label aboutText = new Label($("settings_about_option_text"), new FontIcon(FontAwesome.INFO_CIRCLE));
        aboutText.setFont(Font.font(FontFamily.TIMES_NEW_ROMAN, 18));
        aboutText.setGraphicTextGap(10);
        HBox aboutProgram = new HBox(aboutText);
        favorites.setOnMouseClicked(event -> {

        });
        VBox container = vbox()
                .childrens(
                        favorites,
                        trash,
                        preferences,
                        aboutProgram
                ).build();
        return new StackPane(container);
    }

    public Parent get() {
        return view;
    }

}
