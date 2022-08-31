package com.ruslooob.CreateTodoItem;

import com.ruslooob.Commands.CreateTodoItemCommand;
import com.ruslooob.TodoItem;

public class CreateTodoItemController {
    private final TodoItem todoItem = new TodoItem();
    private final CreateTodoItemCommand createTodoItemCommand;

    public CreateTodoItemController(CreateTodoItemView view, CreateTodoItemCommand createTodoItemCommand) {
        setView(view);
        this.createTodoItemCommand = createTodoItemCommand;
    }

    private void setView(CreateTodoItemView view) {
        view.saveButton.setOnAction((event) -> {
            todoItem.setHeader(view.header.getText());
            todoItem.setContent(view.content.getText());
            createTodoItemCommand.execute(todoItem);
            // todo think about recreate or clear model
        });
        //fixme NPE
//        ((Stage) view.get().getScene().getWindow()).close();
    }

}
