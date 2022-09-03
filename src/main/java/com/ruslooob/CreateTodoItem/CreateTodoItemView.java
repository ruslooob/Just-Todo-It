package com.ruslooob.CreateTodoItem;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import static com.ruslooob.Helpers.HBoxHelpers.hbox;
import static com.ruslooob.Helpers.VBoxHelper.vbox;
import static com.ruslooob.LangLoader.$;

public class CreateTodoItemView {

    private final Parent view;
    TextField header = new TextField("");
    TextField content = new TextField("");
    Button saveButton = new Button($("create_todo_save_button_text"));

    public CreateTodoItemView() {
        this.view = create();
    }

    private Parent create() {
        VBox container = vbox(
                15,
                hbox(10, new Label($("create_todo_header_label_text")), header),
                hbox(10, new Label($("create_todo_content_label_text")), content),
                saveButton
        );
        container.setPadding(new Insets(20));
        return container;
    }

    public Parent get() {
        return view;
    }

}
