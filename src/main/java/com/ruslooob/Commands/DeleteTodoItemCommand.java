package com.ruslooob.Commands;

import com.ruslooob.TodoItem;
import javafx.collections.ObservableList;

public class DeleteTodoItemCommand {

    private final ObservableList<TodoItem> todoItems;

    public DeleteTodoItemCommand(ObservableList<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }

    public void execute(TodoItem todoItem) {
        todoItems.removeIf(item -> item.equals(todoItem));
    }

}
