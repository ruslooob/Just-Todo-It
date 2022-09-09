package com.ruslooob.CreateTodoItem;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import static com.ruslooob.Helpers.HBoxHelpers.hbox;
import static com.ruslooob.Helpers.VBoxHelper.vbox;
import static com.ruslooob.LangLoader.$;

public class CreateTodoItemView {

    private final Region view;
    TextField header;
    TextArea content;
    Button saveButton = new Button($("create_todo_save_button_text"));

    public CreateTodoItemView() {
        this.view = create();
    }

    private Region create() {
        VBox container = vbox(
                15,
                getHeader(),
                getContent(),
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
