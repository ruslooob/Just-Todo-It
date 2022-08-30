package com.ruslooob.TodoList;

import com.ruslooob.Commands.CreateTodoItemCommand;
import com.ruslooob.CreateTodoItem.CreateTodoItemController;
import com.ruslooob.CreateTodoItem.CreateTodoItemView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TodoListController {
    TodoList todoList;

    public TodoListController(TodoListView view) {
        setView(view);
    }

    private void setView(TodoListView view) {
        todoList = new TodoList();
        view.listItems.setItems(todoList.todoItems);
        view.listItems.setPlaceholder(new Label("Create you first todo!"));
        view.addButton.setOnAction(addButtonOnAction(view));
    }

    private EventHandler<ActionEvent> addButtonOnAction(TodoListView todoListView) {
        return event -> {
            Stage stage = new Stage();
            stage.initOwner(todoListView.get().getScene().getWindow());
            stage.initModality(Modality.WINDOW_MODAL);

            CreateTodoItemCommand command = new CreateTodoItemCommand(todoList.getTodoItems());
            CreateTodoItemView createTodoItemView = new CreateTodoItemView();
            CreateTodoItemController controller = new CreateTodoItemController(createTodoItemView, command);

            stage.setScene(new Scene(createTodoItemView.get()));
            stage.show();
        };
    }


}
