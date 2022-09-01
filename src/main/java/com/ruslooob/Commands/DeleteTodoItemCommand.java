package com.ruslooob.Commands;

import com.ruslooob.TodoItem;
import javafx.collections.ObservableList;

public class DeleteTodoItemCommand {

    private final ObservableList<TodoItem> todoItems;
    private final TodoItem itemForRemove;

    public DeleteTodoItemCommand(ObservableList<TodoItem> todoItems, TodoItem itemForRemove) {
        this.todoItems = todoItems;
        this.itemForRemove = itemForRemove;
    }

    public void execute() {
        todoItems.removeIf(item -> item.equals(itemForRemove));
    }

}
