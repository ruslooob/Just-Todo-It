package com.ruslooob.SideBar;

import com.ruslooob.TodoItem;
import com.ruslooob.TodoList.TodoList;

public class SidebarController {

    SidebarView view;
    TodoList todoList;

    public SidebarController(SidebarView view, TodoList todoList) {
        this.view = view;
        bindModel();
        TodoList todoList1 = new TodoList();
        todoList1.setTodoItems(todoList.getTodoItems().stream().filter(TodoItem::isFavorite).toList());
        this.todoList = todoList1;
    }

    private void bindModel() {
        //        view
    }

}
