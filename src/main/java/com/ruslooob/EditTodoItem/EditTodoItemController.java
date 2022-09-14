package com.ruslooob.EditTodoItem;

import com.ruslooob.Commands.Command;
import com.ruslooob.TodoItem;
import javafx.scene.Node;
import javafx.stage.Stage;

public class EditTodoItemController {
    private final EditTodoItemView view;
    private final Command editTodoItemCommand;
    private final TodoItem todoItem;

    public EditTodoItemController(EditTodoItemView view, TodoItem todoItem, Command editTodoItemCommand) {
        this.view = view;
        this.todoItem = todoItem;
        this.editTodoItemCommand = editTodoItemCommand;
    }

    public void start() {
//        view.header.setText(todoItem.getHeader());
        view.content.setText(todoItem.getContent());
        view.saveButton.setOnAction(event -> {
//            todoItem.setHeader(view.header.getText());
            todoItem.setContent(view.content.getText());
            editTodoItemCommand.execute();
            ((Stage)((Node)(event.getTarget())).getScene().getWindow()).close();
        });
    }

}
