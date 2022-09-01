package com.ruslooob.CreateTodoItem;

import com.ruslooob.Commands.Command;
import com.ruslooob.TodoItem;
import javafx.scene.Node;
import javafx.stage.Stage;

public class CreateTodoItemController {
    private final Command createTodoItemCommand;
    private final TodoItem todoItem;

    public CreateTodoItemController(CreateTodoItemView view, TodoItem newTodoItem, Command createTodoItemCommand) {
        setView(view);
        this.createTodoItemCommand = createTodoItemCommand;
        this.todoItem = newTodoItem;
    }

    private void setView(CreateTodoItemView view) {
        view.saveButton.setOnAction(event -> {
            todoItem.setHeader(view.header.getText());
            todoItem.setContent(view.content.getText());
            createTodoItemCommand.execute();
            ((Stage)((Node)(event.getTarget())).getScene().getWindow()).close();
        });
    }

}
