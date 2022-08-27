package com.ruslooob.TodoList;

public class TodoListController {
    TodoList todoList;

    public TodoListController(TodoListView view) {
        setView(view);
    }

    private void setView(TodoListView view) {
        todoList = new TodoList();
        view.listItems.setItems(todoList.todoItems);
    }

}
