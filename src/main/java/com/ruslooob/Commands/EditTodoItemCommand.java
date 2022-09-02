package com.ruslooob.Commands;

import com.ruslooob.TodoItem;

public class EditTodoItemCommand implements Command {

    private final TodoItem itemForReplace;

    public EditTodoItemCommand(TodoItem itemForReplace) {
        this.itemForReplace = itemForReplace;
    }

    public void execute() {
        // запрос на сервис
    }

}
