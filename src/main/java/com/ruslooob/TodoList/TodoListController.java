package com.ruslooob.TodoList;

import com.ruslooob.Commands.Command;
import com.ruslooob.Commands.CreateTodoItemCommand;
import com.ruslooob.Commands.DeleteTodoItemCommand;
import com.ruslooob.Commands.EditTodoItemCommand;
import com.ruslooob.CreateTodoItem.CreateTodoItemController;
import com.ruslooob.CreateTodoItem.CreateTodoItemView;
import com.ruslooob.EditTodoItem.EditTodoItemController;
import com.ruslooob.EditTodoItem.EditTodoItemView;
import com.ruslooob.TodoItem;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TodoListController {

    private TodoList todoList;

    public TodoListController(TodoListView view) {
        setView(view);
    }

    private void setView(TodoListView view) {
        todoList = new TodoList();
        view.listItems.setItems(todoList.getTodoItems());
        view.listItems.setPlaceholder(new Label("Create you first todo!"));
        view.addButton.setOnAction(addButtonOnAction(view));
        view.editButton.setOnAction(editButtonOnAction(view));
        view.deleteButton.setOnAction(deleteButtonOnAction(view));
    }

    private EventHandler<ActionEvent> addButtonOnAction(TodoListView todoListView) {
        return event -> {
            Stage stage = new Stage();
            stage.initOwner(todoListView.get().getScene().getWindow());
            stage.initModality(Modality.WINDOW_MODAL);

            TodoItem todoItem = new TodoItem();
            Command command = new CreateTodoItemCommand(todoList.getTodoItems(), todoItem);
            CreateTodoItemView createTodoItemView = new CreateTodoItemView();
            CreateTodoItemController controller = new CreateTodoItemController(
                    createTodoItemView,
                    todoItem,
                    command
            );

            stage.setScene(new Scene(createTodoItemView.get()));
            stage.setTitle("Create Todo");
            stage.show();
        };
    }

    private EventHandler<ActionEvent> editButtonOnAction(TodoListView todoListView) {
        return event -> {
            Stage stage = new Stage();
            stage.initOwner(todoListView.get().getScene().getWindow());
            stage.initModality(Modality.WINDOW_MODAL);

            TodoItem itemForReplace = todoListView.listItems.getSelectionModel().getSelectedItem();
            EditTodoItemCommand command = new EditTodoItemCommand(itemForReplace);
            EditTodoItemView editTodoItemView = new EditTodoItemView();
            EditTodoItemController controller = new EditTodoItemController(
                    editTodoItemView,
                    itemForReplace,
                    command);

            stage.setScene(new Scene(editTodoItemView.get()));
            stage.setTitle("Edit Todo");
            stage.show();
        };
    }

    private EventHandler<ActionEvent> deleteButtonOnAction(TodoListView todoListView) {
        return event -> {
            // todo confirmation alert
            DeleteTodoItemCommand deleteTodoItemCommand = new DeleteTodoItemCommand(
                    todoList.getTodoItems(),
                    todoListView.listItems.getSelectionModel().getSelectedItem()
            );
            deleteTodoItemCommand.execute();
        };
    }


}
