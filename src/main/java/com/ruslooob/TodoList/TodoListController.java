package com.ruslooob.TodoList;

import com.ruslooob.Commands.Command;
import com.ruslooob.Commands.CreateTodoItemCommand;
import com.ruslooob.Commands.DeleteTodoItemCommand;
import com.ruslooob.Commands.EditTodoItemCommand;
import com.ruslooob.TodoItemDialog.TodoItemDialogController;
import com.ruslooob.TodoItemDialog.TodoItemDialog;
import com.ruslooob.TodoItem;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import static com.ruslooob.LangLoader.$;
import static javafx.scene.control.Alert.AlertType.CONFIRMATION;

public class TodoListController {

    private final TodoList todoList;
    private final TodoListView view;

    /*todo think about map with command injection*/
    public TodoListController(TodoListView view, TodoList initialState) {
        this.todoList = initialState;
        this.view = view;
        setView(view);
    }

    private void setView(TodoListView view) {
        view.listItems.setItems(todoList.getTodoItems());
        view.listItems.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                showEditTodoItemDialog();
            }
        });
        view.editButton.disableProperty().bind(Bindings.isEmpty(view.listItems.getSelectionModel().getSelectedItems()));
        view.deleteButton.disableProperty().bind(Bindings.isEmpty(view.listItems.getSelectionModel().getSelectedItems()));
        view.addButton.setOnAction(this::addButtonOnAction);
        view.editButton.setOnAction(this::editButtonOnAction);
        view.deleteButton.setOnAction(this::deleteButtonOnAction);
    }

    private void addButtonOnAction(ActionEvent event) {
        TodoItem todoItem = new TodoItem();
        todoItem.setHeader("Новая заметка");
        TodoItemDialog todoItemDialog = new TodoItemDialog();
        CreateTodoItemCommand createTodoItemCommand = new CreateTodoItemCommand(todoList.getTodoItems(), todoItem);
        TodoItemDialogController controller = new TodoItemDialogController(
                todoItemDialog,
                todoItem,
                createTodoItemCommand
        );
        controller.start();
        todoItemDialog.show();
    }

    private void editButtonOnAction(ActionEvent event) {
        showEditTodoItemDialog();
    }

    private void showEditTodoItemDialog() {
        TodoItem itemForReplace = view.listItems.getSelectionModel().getSelectedItem();
        Command command = new EditTodoItemCommand(itemForReplace);
        TodoItemDialog todoItemDialog = new TodoItemDialog();
        TodoItemDialogController controller = new TodoItemDialogController(
                todoItemDialog,
                itemForReplace,
                command
        );
        controller.start();
        todoItemDialog.show();
    }

    private void deleteButtonOnAction(ActionEvent event) {
        /*todo alert builder*/
        Alert alert = new Alert(
                CONFIRMATION,
                $("delete_todo_confirmation_alert_content"),
                new ButtonType($("yes"), ButtonBar.ButtonData.OK_DONE),
                new ButtonType($("no"), ButtonBar.ButtonData.CANCEL_CLOSE)
        );
        alert.setTitle($("delete_todo_confirmation_alert_title"));
        alert.setHeaderText($("delete_todo_confirmation_alert_header"));
        alert.showAndWait().ifPresent(response -> {
            if (response.getButtonData() == ButtonBar.ButtonData.OK_DONE) {
                Command deleteTodoItemCommand = new DeleteTodoItemCommand(
                        todoList.getTodoItems(),
                        view.listItems.getSelectionModel().getSelectedItem()
                );
                deleteTodoItemCommand.execute();
            }
        });
    }

    public TodoList getTodoList() {
        return todoList;
    }

}
