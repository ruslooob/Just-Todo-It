package com.ruslooob.TodoList;

import com.ruslooob.TodoItem.TodoItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.List;

public class TodoList {
    ObservableList<TodoItem> todoItems = FXCollections.observableArrayList(
            new TodoItem("1 header", "Lorem Ipsum - это текст-\"рыба\", часто используемый в печати и вэб-дизайне. Lorem Ipsum является стандартной \"рыбой\" для текстов на латинице с начала XVI века.", LocalDate.now()),
            new TodoItem("2 header", "2 content", LocalDate.now()),
            new TodoItem("3 header", "3 content", LocalDate.now()),
            new TodoItem("4 header", "4 content", LocalDate.now()),
            new TodoItem("4 header", "4 content", LocalDate.now()),
            new TodoItem("4 header", "4 content", LocalDate.now()),
            new TodoItem("4 header", "4 content", LocalDate.now()),
            new TodoItem("4 header", "4 content", LocalDate.now()),
            new TodoItem("4 header", "4 content", LocalDate.now()),
            new TodoItem("4 header", "4 content", LocalDate.now()),
            new TodoItem("4 header", "4 content", LocalDate.now()),
            new TodoItem("4 header", "4 content", LocalDate.now()),
            new TodoItem("4 header", "4 content", LocalDate.now()),
            new TodoItem("4 header", "4 content", LocalDate.now())
    );

    public void setTodoItems(List<TodoItem> todoItems) {
        this.todoItems.setAll(todoItems);
    }

}
