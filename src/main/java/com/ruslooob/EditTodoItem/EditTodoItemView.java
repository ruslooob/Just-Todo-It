package com.ruslooob.EditTodoItem;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/*todo  удалить одну из вью или эту или createtodoView как дуближ*/

import static com.ruslooob.LangLoader.$;

public class EditTodoItemView {
    private final Region view;
    TextArea content;
    Button saveButton = new Button($("edit_todo_save_button_text"));

    public EditTodoItemView() {
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
