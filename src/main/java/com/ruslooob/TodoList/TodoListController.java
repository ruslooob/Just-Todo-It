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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import static com.ruslooob.Helpers.StageHelpers.stage;
import static javafx.scene.control.Alert.AlertType.CONFIRMATION;

public class TodoListController {

    private TodoList todoList;

    public TodoListController(TodoListView view, TodoList initialState) {
        this.todoList = initialState;
        setView(view);
    }

    private void setView(TodoListView view) {
        view.listItems.setItems(todoList.getTodoItems());
        view.listItems.setPlaceholder(new Label("Create you first todo!"));
        view.listItems.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                showEditTodoItemDialog(view);
            }
        });
        view.addButton.setOnAction(addButtonOnAction(view));
        view.editButton.setOnAction(editButtonOnAction(view));
        view.deleteButton.setOnAction(deleteButtonOnAction(view));
    }

    private EventHandler<ActionEvent> addButtonOnAction(TodoListView todoListView) {
        return event -> {
            TodoItem todoItem = new TodoItem();
            Command command = new CreateTodoItemCommand(todoList.getTodoItems(), todoItem);
            CreateTodoItemView createTodoItemView = new CreateTodoItemView();
            CreateTodoItemController controller = new CreateTodoItemController(
                    createTodoItemView,
                    todoItem,
                    command
            );
            stage(
               "CreateTodo",
                    todoListView.get().getScene().getWindow(),
                    Modality.WINDOW_MODAL,
                    new Scene(createTodoItemView.get())
            ).show();
        };
    }

    private EventHandler<ActionEvent> editButtonOnAction(TodoListView todoListView) {
        return event -> {
            showEditTodoItemDialog(todoListView);
        };
    }

    private void showEditTodoItemDialog(TodoListView todoListView) {
        Stage stage = new Stage();
        stage.initOwner(todoListView.get().getScene().getWindow());
        stage.initModality(Modality.WINDOW_MODAL);

        TodoItem itemForReplace = todoListView.listItems.getSelectionModel().getSelectedItem();
        Command command = new EditTodoItemCommand(itemForReplace);
        EditTodoItemView editTodoItemView = new EditTodoItemView();
        EditTodoItemController controller = new EditTodoItemController(
                editTodoItemView,
                itemForReplace,
                command
        );
        controller.start();
        stage.setScene(new Scene(editTodoItemView.get()));
        stage.setTitle("Edit Todo");
        stage.show();
    }

    private EventHandler<ActionEvent> deleteButtonOnAction(TodoListView todoListView) {
        return event -> {
            /*todo alert localization*/
            Alert alert = new Alert(CONFIRMATION, "Вы действительно хотите удалить заметку?");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.APPLY) {
                DeleteTodoItemCommand deleteTodoItemCommand = new DeleteTodoItemCommand(
                        todoList.getTodoItems(),
                        todoListView.listItems.getSelectionModel().getSelectedItem()
                );
                deleteTodoItemCommand.execute();
            }
        };
    }

    public TodoList getTodoList() {
        return todoList;
    }
}
