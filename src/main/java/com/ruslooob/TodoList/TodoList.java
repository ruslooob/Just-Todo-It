package com.ruslooob.TodoList;

import com.ruslooob.TodoItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class TodoList {
    ObservableList<TodoItem> todoItems = FXCollections.observableArrayList();

    public ObservableList<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void setTodoItems(List<TodoItem> todoItems) {
        this.todoItems.setAll(todoItems);
    }

}
