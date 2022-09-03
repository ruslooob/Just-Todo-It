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
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;

import static com.ruslooob.Helpers.StageHelpers.stage;
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
        Command command = new CreateTodoItemCommand(todoList.getTodoItems(), todoItem);
        CreateTodoItemView createTodoItemView = new CreateTodoItemView();
        CreateTodoItemController controller = new CreateTodoItemController(
                createTodoItemView,
                todoItem,
                command
        );
        stage()
                .title($("create_todo_window_title"))
                .scene(new Scene(createTodoItemView.get()))
                .build()
                .show();
    }

    private void editButtonOnAction(ActionEvent event) {
        showEditTodoItemDialog();
    }

    private void showEditTodoItemDialog() {
        TodoItem itemForReplace = view.listItems.getSelectionModel().getSelectedItem();
        Command command = new EditTodoItemCommand(itemForReplace);
        EditTodoItemView editTodoItemView = new EditTodoItemView();
        EditTodoItemController controller = new EditTodoItemController(
                editTodoItemView,
                itemForReplace,
                command
        );
        controller.start();
        Stage stage = new Stage();
        stage()
                .title($("edit_todo_window_title"))
                .scene(new Scene(editTodoItemView.get()))
                .build()
                .show();
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
