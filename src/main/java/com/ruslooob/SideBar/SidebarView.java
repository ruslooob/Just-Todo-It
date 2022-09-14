package com.ruslooob.SideBar;

import com.ruslooob.Controls.StyledLabel;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;
import org.kordamp.ikonli.javafx.FontIcon;

import static com.ruslooob.LangLoader.$;
import static javafx.collections.FXCollections.observableArrayList;

/*сделать переходы*/
public class SidebarView {

    private final Parent view;

    public SidebarView() {
        view = createView();
        view.getStylesheets().add("/css/sidebar.css");
    }

    private Parent createView() {
        Label allNotes = new StyledLabel($("sidebar_all_notes_option_text"), new FontIcon(), "all-notes-label", "label");
        Label favoritesLabel = new StyledLabel($("sidebar_favorites_option_text"), new FontIcon(), "favorites-label", "label");
        Label trashLabel = new StyledLabel($("sidebar_trash_option_text"), new FontIcon(), "trash-label", "label");
        Label preferencesLabel = new StyledLabel($("sidebar_preferences_option_text"), new FontIcon(), "preferences-label", "label");
        Label aboutLabel = new StyledLabel($("sidebar_about_option_text"), new FontIcon(), "about-label", "label");
        aboutLabel.getStyleClass().addAll();
        ListView<Label> container = new ListView<>(observableArrayList(
                allNotes, favoritesLabel, trashLabel, preferencesLabel, aboutLabel
        ));

        container.setCellFactory(new Callback<>() {
            @Override
            public ListCell<Label> call(ListView<Label> param) {
                return new ListCell<>() {
                    @Override
                    protected void updateItem(Label label, boolean empty) {
                        super.updateItem(label, empty);

                        if (empty || label == null) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            setGraphic(label.getGraphic());
                            setText(label.getText());
                            getStyleClass().addAll(label.getStyleClass());
                        }
                    }
                };
            }
        });
        container.getStyleClass().add("container");
        return new StackPane(container);
    }

    public Parent get() {
        return view;
    }

}
