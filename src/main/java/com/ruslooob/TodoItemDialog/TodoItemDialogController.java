package com.ruslooob.TodoItemDialog;

import com.ruslooob.Commands.Command;
import com.ruslooob.TodoItem;

public class TodoItemDialogController {
    private final TodoItemDialog view;
    private final Command command;
    private final TodoItem todoItem;

    public TodoItemDialogController(TodoItemDialog view, TodoItem todoItem, Command command) {
        this.view = view;
        this.todoItem = todoItem;
        this.command = command;
    }

    public void start() {
        view.setHeader(todoItem.getHeader());
        view.content.setText(todoItem.getContent());
        view.closeProperty().addListener(listener -> {
            todoItem.setHeader(view.getHeader().getText());
            todoItem.setContent(view.content.getText());
            command.execute();
        });
    }

}
