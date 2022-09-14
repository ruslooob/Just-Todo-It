package com.ruslooob.CreateTodoItem;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import static com.ruslooob.LangLoader.$;

public class CreateTodoItemView {

    private final Region view;
    TextArea content;
    Button saveButton = new Button($("create_todo_save_button_text"));

    public CreateTodoItemView() {
        this.view = create();
        view.getStylesheets().add("/css/create-todo.css");

    }

    private Region create() {
        VBox container = new VBox(getContent(), saveButton);
        container.setPadding(new Insets(10));
        return container;
    }

    private TextArea getContent() {
        if (content == null) {
            content = new TextArea("");
            content.setPrefWidth(250);
            content.setPrefHeight(100);
            content.setWrapText(true);
            content.getStyleClass().add("content");
        }
        return content;
    }

    public Region get() {
        return view;
    }

}
