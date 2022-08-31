package com.ruslooob.TodoList;

import com.ruslooob.TodoItem;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class TodoList {
    private final ObservableList<TodoItem> todoItems = FXCollections.observableArrayList(cb -> new Observable[] {
            cb.headerProperty(), cb.contentProperty()
    });

    public ObservableList<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void setTodoItems(List<TodoItem> todoItems) {
        this.todoItems.setAll(todoItems);
    }

}
