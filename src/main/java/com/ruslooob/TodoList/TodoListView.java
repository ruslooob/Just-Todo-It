package com.ruslooob.TodoList;

import com.ruslooob.TodoItem.TodoItemView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class TodoListView {
    Label header = new Label("Все заметки");
    Parent view;

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
        VBox listItems = new VBox(5);
        for (int i = 0; i < 10; i++) {
            Parent parent = new TodoItemView().get();
            listItems.getChildren().add(parent);
        }
        container.getColumnConstraints().add(
                new ColumnConstraints(
                        Control.USE_COMPUTED_SIZE,
                        Control.USE_COMPUTED_SIZE,
                        Control.USE_COMPUTED_SIZE
                )
        );
        container.getRowConstraints().add(
                new RowConstraints(
                Control.USE_COMPUTED_SIZE,
                Control.USE_COMPUTED_SIZE,
                Control.USE_COMPUTED_SIZE
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
