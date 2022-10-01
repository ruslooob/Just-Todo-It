package com.ruslooob.TodoItemDialog;

import com.ruslooob.TodoStage;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Region;

public class TodoItemDialog extends TodoStage {
    private final Region view;
    TextArea content;

    public TodoItemDialog() {
        this.view = create();
        view.getStylesheets().add("/css/create-todo.css");
        setCenter(content);
    }

    private Region create() {
        return getContent();
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

    public void setHeader(String header) {
        getHeader().setText(header);
    }

}
