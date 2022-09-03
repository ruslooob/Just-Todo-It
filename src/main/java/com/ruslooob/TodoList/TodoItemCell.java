package com.ruslooob.TodoList;

import com.ruslooob.TodoItem;
import javafx.geometry.Insets;
import javafx.scene.control.ListCell;

import java.time.format.DateTimeFormatter;

public class TodoItemCell extends ListCell<TodoItem> {

    @Override
    protected void updateItem(TodoItem item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            setText(null);
            setGraphic(null);
        } else {
            setText(null);
            TodoItemView view = new TodoItemView();
            view.header.setText(item.getHeader());
            view.content.setText(item.getContent());
            view.createDate.setText(item.getCreateDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
            setPadding(new Insets(0));
            setGraphic(view.get());
        }
    }

}
