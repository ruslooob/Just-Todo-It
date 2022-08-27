package com.ruslooob.TodoItem;

import java.time.format.DateTimeFormatter;

public class TodoItemController {

    TodoItem todoItem;

    public TodoItemController(TodoItemView view) {
        setView(view);
    }

    private void setView(TodoItemView view) {
        todoItem = new TodoItem();
        view.header.setText(todoItem.getHeader());
        view.content.textProperty().bind(todoItem.content);
        view.createDate.setText(todoItem.getCreateDate().format(DateTimeFormatter.ofPattern("dd.MM.yy")));
    }

}
