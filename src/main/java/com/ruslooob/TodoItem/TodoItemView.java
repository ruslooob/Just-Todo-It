package com.ruslooob.TodoItem;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class TodoItemView {

    Parent view;
    Label header = new Label("TO-13441");
    Label content = new Label("Lorem Ipsum - это текст-\"рыба\", часто используемый в печати и вэб-дизайне. Lorem Ipsum является стандартной \"рыбой\" для текстов на латинице с начала XVI века.");
    Label createDate = new Label("10.08.2022");

    public TodoItemView() {
        view = create();
    }

    private Parent create() {
        HBox container = new HBox();
        container.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.web("#ffffff", 0.5),
                                new CornerRadii(10),
                                null
                        )
                )
        );
        container.setPadding(new Insets(5, 10, 5, 10));
        content.setTextOverrun(OverrunStyle.ELLIPSIS);
        VBox headerWithContent = new VBox(10, header, content);
        VBox.setVgrow(headerWithContent, Priority.ALWAYS);
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

        return container;
    }

    public Parent get() {
        return view;
    }

}
