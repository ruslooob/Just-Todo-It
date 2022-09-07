package com.ruslooob.EditTodoItem;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import static com.ruslooob.Helpers.VBoxHelper.vbox;
import static com.ruslooob.LangLoader.$;

public class EditTodoItemView {
    private final Region view;
    TextField header;
    TextArea content;
    Button saveButton = new Button($("edit_todo_save_button_text"));

    public EditTodoItemView() {
        this.view = create();
    }

    private Region create() {
        VBox container = vbox(
                10,
                new HBox(getHeader()),
                new HBox(getContent()),
                saveButton
        );
        container.setPadding(new Insets(10));
        return container;
    }

    private TextField getHeader() {
        if (header == null) {
            header = new TextField("");
            header.setPrefWidth(250);
        }
        return header;
    }

    private TextArea getContent() {
        if (content == null) {
            content = new TextArea("");
            content.setPrefWidth(250);
            content.setPrefHeight(100);
            content.setWrapText(true);
        }
        return content;
    }

    public Region get() {
        return view;
    }
}
