package com.ruslooob.Commands;

import com.ruslooob.TodoItem;
import javafx.collections.ObservableList;

public class CreateTodoItemCommand {
    ObservableList<TodoItem> todoItems;
    public CreateTodoItemCommand(ObservableList<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }

    public void execute(TodoItem todoItem) {
        this.todoItems.add(todoItem);
    }
}
