package com.ruslooob.TodoList;

import com.ruslooob.Controls.IconButton;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignS;

import static com.ruslooob.Helpers.BackgroundFillHelper.backgroundFill;
import static com.ruslooob.Helpers.BorderStrokeHelper.borderStroke;
import static com.ruslooob.Helpers.HBoxHelpers.hbox;
import static com.ruslooob.Helpers.VBoxHelper.vbox;

public class TodoItemCellView {

    private final Parent view;
    Label header = new Label("");
    Label content = new Label("");
    Label createDate = new Label("");
    Button favoriteButton = new Button("", new FontIcon(MaterialDesignS.STAR_OUTLINE));

    public TodoItemCellView() {
        view = create();
        view.getStylesheets().add("/css/todo-item.css");
    }

    private Parent create() {
        VBox headerWithContent = vbox(10, header, content);
        favoriteButton.getStyleClass().add("favorite-button");
        HBox container = hbox()
                .maxWidth(671.)
                .background(
                        new Background(backgroundFill(Color.web("#ffffff", 0.5)))
                ).border(
                        new Border(borderStroke(new CornerRadii(10)))
                ).padding(new Insets(5, 10, 5, 10))
                .spacing(20)
                .childrens(
                        headerWithContent,
                        getSeparator(),
                        createDate,
                        favoriteButton
                ).build();
        content.setTextOverrun(OverrunStyle.ELLIPSIS);
        createDate.setMinWidth(80);
        return new StackPane(container);
    }

    private Node getSeparator() {
        Pane separator = new Pane();
        HBox.setHgrow(separator, Priority.ALWAYS);
        return separator;
    }

    public Parent get() {
        return view;
    }

}
