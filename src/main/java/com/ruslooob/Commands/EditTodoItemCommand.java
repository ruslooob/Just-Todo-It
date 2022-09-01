package com.ruslooob.Commands;

import com.ruslooob.TodoItem;
import javafx.collections.ObservableList;

public class EditTodoItemCommand {

    private final TodoItem itemForReplace;

    public EditTodoItemCommand(TodoItem itemForReplace) {
        this.itemForReplace = itemForReplace;
    }

    public void execute() {
        // запрос на сервис
    }

}
