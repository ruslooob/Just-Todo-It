package com.ruslooob.Commands;

import com.ruslooob.TodoItem;
import javafx.collections.ObservableList;

public class EditTodoItemCommand {

    private final ObservableList<TodoItem> todoItems;

    public EditTodoItemCommand(ObservableList<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }

    public void execute(TodoItem todoItem) {
        TodoItem itemForReplace = todoItems.stream()
                                           .filter(item -> item.equals(todoItem))
                                           .findAny().orElseThrow();
        // todo make copy-constructor
        itemForReplace.setHeader(todoItem.getHeader());
        itemForReplace.setContent(todoItem.getContent());
    }

}
