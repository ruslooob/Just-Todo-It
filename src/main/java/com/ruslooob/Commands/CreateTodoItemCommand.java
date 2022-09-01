package com.ruslooob.Commands;

import com.ruslooob.IdGenerator;
import com.ruslooob.TodoItem;
import javafx.collections.ObservableList;
import javafx.scene.control.SelectionModel;

public class CreateTodoItemCommand implements Command {

    private final ObservableList<TodoItem> todoItems;
    private final TodoItem todoItem;

    public CreateTodoItemCommand(ObservableList<TodoItem> todoItems, TodoItem todoItem) {
        this.todoItems = todoItems;
        this.todoItem = todoItem;
    }

    @Override
    public void execute() {
        // запрос не сервер с получением id
        todoItem.setId(IdGenerator.nextId());
        this.todoItems.add(0, todoItem);
    }

}
