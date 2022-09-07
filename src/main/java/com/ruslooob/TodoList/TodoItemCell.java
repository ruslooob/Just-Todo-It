package com.ruslooob.TodoList;

import com.ruslooob.FontFamily;
import com.ruslooob.TodoItem;
import javafx.geometry.Insets;
import javafx.scene.control.ListCell;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import org.kordamp.ikonli.fontawesome.FontAwesome;
import org.kordamp.ikonli.javafx.FontIcon;

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
            view.header.setText(item.getHeader());
            /*todo add constants for ofter use font-sizes*/
            view.header.setFont(Font.font(FontFamily.ARIAL, FontWeight.MEDIUM, FontPosture.ITALIC, 18));
            view.content.setText(item.getContent());
            view.content.setFont(new Font(FontFamily.TIMES_NEW_ROMAN, 16));
            view.createDate.setText(item.getCreateDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
            view.createDate.setFont(Font.font(FontFamily.TIMES_NEW_ROMAN, FontWeight.MEDIUM,15));
            view.favoriteButton.setGraphic(item.isFavorite()
                    ? new FontIcon(FontAwesome.STAR)
                    : new FontIcon(FontAwesome.STAR_O));
            view.favoriteButton.setOnAction(event -> {
                item.setFavorite(!item.isFavorite());
                view.favoriteButton.setGraphic(item.isFavorite()
                        ? new FontIcon(FontAwesome.STAR)
                        : new FontIcon(FontAwesome.STAR_O));
            });
            setPadding(new Insets(0));
            setGraphic(view.get());
        }
    }

}
