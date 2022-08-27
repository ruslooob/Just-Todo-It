package com.ruslooob.TodoList;

import com.ruslooob.TodoItem.TodoItem;
import com.ruslooob.TodoItem.TodoItemCell;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class TodoListView {

    Label header = new Label("Все заметки");
    Parent view;

    ListView<TodoItem> listItems = new ListView<>();

    public TodoListView() {
        this.view = create();
    }

    private Parent create() {
        GridPane container = new GridPane();
        container.setPadding(new Insets(30));
        container.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.web("#ddedfa"),
                                CornerRadii.EMPTY,
                                null)
                )
        );
        listItems.setCellFactory(param -> new TodoItemCell());
        listItems.prefWidthProperty().bind(container.widthProperty());
        listItems.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.web("#ddedfa"),
                                null,
                                null
                        )
                )
        );
        listItems.setBorder(
                new Border(
                    new BorderStroke(
                            null,
                            BorderStrokeStyle.NONE,
                            new CornerRadii(10),
                            null
                    )
                )
        );
        GridPane.setConstraints(header, 0, 0);
        GridPane.setConstraints(listItems,0, 1);
        container.setVgap(20);
        container.getChildren().addAll(header, listItems);
        ScrollPane scrollPane = new ScrollPane(container);
        scrollPane.setFitToWidth(true);
        return scrollPane;
    }

    public Parent get() {
        return view;
    }

}
