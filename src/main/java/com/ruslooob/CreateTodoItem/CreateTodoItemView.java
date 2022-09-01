package com.ruslooob.CreateTodoItem;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import static com.ruslooob.Helpers.HBoxHelpers.hbox;
import static com.ruslooob.Helpers.VBoxHelper.vbox;

public class CreateTodoItemView {

    private final Parent view;
    TextField header = new TextField("");
    TextField content = new TextField("");
    Button saveButton = new Button("Создать");

    public CreateTodoItemView() {
        this.view = create();
    }

    private Parent create() {
        VBox container = vbox(
                15,
                hbox(10, new Label("Заголовок"), header),
                hbox(10, new Label("Содержимое"), content),
                saveButton
        );
        container.setPadding(new Insets(20));
        return container;
    }

    public Parent get() {
        return view;
    }

}
