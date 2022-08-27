package com.ruslooob.TodoItem;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class TodoItemView {

    Parent view;
    Label header = new Label("");
    Label content = new Label("");
    Label createDate = new Label("");

    public TodoItemView() {
        view = create();
    }

    private Parent create() {
        HBox container = new HBox();
        container.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.web("#ffffff", 0.5),
                                null,
                                null
                        )
                )
        );
        container.setPadding(new Insets(5, 10, 5, 10));
        container.setMaxWidth(671);
        content.setTextOverrun(OverrunStyle.ELLIPSIS);
        VBox headerWithContent = new VBox(10, header, content);
        VBox.setVgrow(headerWithContent, Priority.ALWAYS);
        createDate.setMinWidth(80);
        container.getChildren().addAll(headerWithContent, createDate);
        container.setBorder(
                new Border(
                        new BorderStroke(
                                null,
                                null,
                                new CornerRadii(10),
                                null)
                )
        );

        return new StackPane(container);
    }

    public Parent get() {
        return view;
    }

}
