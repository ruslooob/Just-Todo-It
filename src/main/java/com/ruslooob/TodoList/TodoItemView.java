package com.ruslooob.TodoList;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import static com.ruslooob.Helpers.HBoxHelpers.hbox;
import static com.ruslooob.Helpers.VBoxHelper.vbox;

public class TodoItemView {

    private final Parent view;
    Label header = new Label("");
    Label content = new Label("");
    Label createDate = new Label("");

    public TodoItemView() {
        view = create();
    }

    private Parent create() {
        VBox headerWithContent = vbox(10, header, content);
        HBox container = hbox(
                671.,
                new Background(
                        new BackgroundFill(
                                Color.web("#ffffff", 0.5),
                                null,
                                null
                        )
                ),
                new Border(
                        new BorderStroke(
                                null,
                                null,
                                new CornerRadii(10),
                                null)
                ),
                new Insets(5, 10, 5, 10),
                50.,
                headerWithContent,
                getSeparator(),
                createDate
        );
        content.setTextOverrun(OverrunStyle.ELLIPSIS);
        createDate.setMinWidth(80);
        return new StackPane(container);
    }

    private Node getSeparator() {
        Pane separator = new Pane();
        HBox.setHgrow(separator, Priority.ALWAYS);
        return separator;
    }

    public Parent get() {
        return view;
    }

}
