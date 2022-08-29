package com.ruslooob.TodoItem;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TodoItemCell extends ListCell<TodoItem> {

    @Override
    protected void updateItem(TodoItem item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            setText(null);
            setGraphic(null);
        } else {
            setText(null);
            TodoItemView view = new TodoItemView();
            view.header.setText(item.getHeader());
            view.content.textProperty().bind(item.content);
            view.createDate.textProperty().bind(item.createDate.asString());
            view.get().setOnMouseClicked(event -> {
                if (event.getClickCount() == 2) {
                    Stage stage = new Stage();
                    Scene scene = new Scene(new StackPane(new Label("TodoItem view Dialog")), 500, 500);
                    stage.setScene(scene);
                    stage.initOwner(getScene().getWindow());
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.show();
                }
            });
            setPadding(new Insets(0));
            setGraphic(view.get());
        }
    }

}
