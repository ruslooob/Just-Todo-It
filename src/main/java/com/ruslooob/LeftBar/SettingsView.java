package com.ruslooob.LeftBar;

import com.ruslooob.FontFamily;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Callback;

import static javafx.collections.FXCollections.observableArrayList;

public class SettingsView {
    private final Parent view;

    public SettingsView() {
        view = createView();
    }

    private Parent createView() {
        ListView<String> settings = new ListView<>(observableArrayList("Избранные", "Корзина", "Настройки", "О программе"));
        settings.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new ListCell<>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null) {
                            setText(null);
                            setGraphic(null);
                        } else {
                            setText(item);
                            Font font = Font.font(FontFamily.COMIC_SANS_MS, FontWeight.NORMAL,  15);
                            setFont(font);
                        }
                    }
                };
            }
        });
        return settings;
    }

    public Parent get() {
        return view;
    }

}
