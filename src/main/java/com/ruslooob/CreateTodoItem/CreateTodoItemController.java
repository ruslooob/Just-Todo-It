package com.ruslooob.CreateTodoItem;

import com.ruslooob.Commands.CreateTodoItemCommand;
import com.ruslooob.TodoItem;

public class CreateTodoItemController {
    TodoItem todoItem = new TodoItem();
    CreateTodoItemCommand createTodoItemCommand;

    public CreateTodoItemController(CreateTodoItemView view, CreateTodoItemCommand createTodoItemCommand) {
        setView(view);
        this.createTodoItemCommand = createTodoItemCommand;
    }

    private void setView(CreateTodoItemView view) {
        todoItem.header.bind(view.header.textProperty());
        todoItem.content.bind(view.content.textProperty());
        view.saveButton.setOnAction((event) -> createTodoItemCommand.execute(todoItem));
        //fixme NPE
//        ((Stage) view.get().getScene().getWindow()).close();
    }

}
