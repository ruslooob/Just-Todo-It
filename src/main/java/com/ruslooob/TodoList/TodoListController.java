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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import static com.ruslooob.Helpers.StageHelpers.stage;
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
        view.listItems.setPlaceholder(new Label("Create you first todo!"));
        view.listItems.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                showEditTodoItemDialog();
            }
        });
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
                .title("Create Todo")
                .owner(view.get().getScene().getWindow())
                .modality(Modality.WINDOW_MODAL)
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
                .title("Edit Todo")
                .owner(view.get().getScene().getWindow())
                .modality(Modality.WINDOW_MODAL)
                .scene(new Scene(editTodoItemView.get()))
                .build()
                .show();
    }

    private void deleteButtonOnAction(ActionEvent event) {
        /*todo alert builder*/
        Alert alert = new Alert(
                CONFIRMATION,
                "Вы действительно хотите удалить заметку?",
                new ButtonType("Да", ButtonBar.ButtonData.OK_DONE),
                new ButtonType("Нет", ButtonBar.ButtonData.CANCEL_CLOSE)
        );
        alert.setTitle("Удаление заметки");
        alert.setHeaderText("Предупреждение");
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
