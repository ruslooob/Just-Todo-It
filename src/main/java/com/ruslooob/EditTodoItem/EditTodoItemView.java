package com.ruslooob.EditTodoItem;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import static com.ruslooob.Helpers.VBoxHelper.vbox;
import static com.ruslooob.LangLoader.$;

public class EditTodoItemView {
    private final Parent view;
    TextField header = new TextField("");
    TextField content = new TextField("");
    Button saveButton = new Button($("edit_todo_save_button_text"));

    public EditTodoItemView() {
        this.view = create();
    }

    private Parent create() {
        VBox container = vbox(
                15,
                new HBox(10, new Label($("edit_todo_edit_button_text")), header),
                new HBox(10, new Label($("edit_todo_delete_button_text")), content),
                saveButton
        );
        container.setPadding(new Insets(20));
        return container;
    }

    public Parent get() {
        return view;
    }
}
