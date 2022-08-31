package com.ruslooob.EditTodoItem;

import com.ruslooob.Commands.EditTodoItemCommand;
import com.ruslooob.TodoItem;

public class EditTodoItemController {

    public EditTodoItemController(EditTodoItemView view, TodoItem todoItem, EditTodoItemCommand editTodoItemCommand) {
        view.header.setText(todoItem.getHeader());
        view.content.setText(todoItem.getContent());
        view.saveButton.setOnAction(event -> {
            todoItem.setHeader(view.header.getText());
            todoItem.setContent(view.content.getText());
            editTodoItemCommand.execute(todoItem);
        });
    }

}
