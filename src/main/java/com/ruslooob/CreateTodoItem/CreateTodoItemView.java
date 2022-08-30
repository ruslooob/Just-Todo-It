package com.ruslooob.CreateTodoItem;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CreateTodoItemView {
    Parent view;
    TextField header = new TextField("");
    TextField content = new TextField("");
    Button saveButton = new Button("Создать");

    public CreateTodoItemView() {
        this.view = create();
    }

    private Parent create() {
        VBox container = new VBox(15,
                new HBox(10, new Label("Заголовок"), header),
                new HBox(10, new Label("Содержимое"), content),
                saveButton
        );
        container.setPadding(new Insets(20));
        return container;
    }

    public Parent get() {
        return view;
    }
}
