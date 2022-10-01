package com.ruslooob.TodoList;

import com.ruslooob.TodoItem;
import javafx.geometry.Insets;
import javafx.scene.control.ListCell;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignS;

import java.time.format.DateTimeFormatter;

public class TodoItemCell extends ListCell<TodoItem> {

    @Override
    protected void updateItem(TodoItem item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            setText(null);
            setGraphic(null);
        } else {
            setText(null);
            TodoItemCellView view = new TodoItemCellView();
            view.getHeader().setText(item.getHeader());
            view.getContent().setText(item.getContent());
            view.getCreateDate().setText(item.getCreateDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
            view.getFavoriteButton().setGraphic(item.isFavorite()
                    ? new FontIcon(MaterialDesignS.STAR)
                    : new FontIcon(MaterialDesignS.STAR_OUTLINE));
            view.getFavoriteButton().setOnAction(event -> {
                item.setFavorite(!item.isFavorite());
                view.getFavoriteButton().setGraphic(item.isFavorite()
                        ? new FontIcon(MaterialDesignS.STAR)
                        : new FontIcon(MaterialDesignS.STAR_OUTLINE));
            });
            setGraphic(view.get());
            setPadding(new Insets(0));
        }
    }

}
