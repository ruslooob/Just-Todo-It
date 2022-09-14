package com.ruslooob.TodoList;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignS;

import static com.ruslooob.Helpers.BackgroundFillHelper.backgroundFill;
import static com.ruslooob.Helpers.BorderStrokeHelper.borderStroke;
import static com.ruslooob.Helpers.HBoxHelpers.hbox;
import static com.ruslooob.Helpers.VBoxHelper.vbox;

public class TodoItemCellView {

    private final Parent view;
    private Label header;
    private Label content;
    private Label createDate;
    private Button favoriteButton;

    public TodoItemCellView() {
        view = create();
    }

    private Parent create() {
        VBox headerWithContent = vbox(10, getHeader(), getContent());
        HBox container = hbox()
                .background(
                        new Background(backgroundFill(Color.web("#ffffff", 0.5)))
                ).border(
                        new Border(borderStroke(new CornerRadii(10)))
                ).padding(new Insets(5, 10, 5, 10))
                .spacing(20)
                .childrens(
                        headerWithContent,
                        getSeparator(),
                        getCreateDate(),
                        getFavoriteButton()
                ).build();
        return new StackPane(container);
    }

    /*todo remove separator, use borderpane or hbox alignment instead*/
    private Node getSeparator() {
        Pane separator = new Pane();
        HBox.setHgrow(separator, Priority.ALWAYS);
        return separator;
    }

    Labeled getHeader() {
        if (header == null) {
            header = new Label("");
            header.getStyleClass().addAll("todo-item-header", "label");
        }
        return header;
    }

    Labeled getContent() {
        if (content == null) {
            content = new Label("");
            content.setTextOverrun(OverrunStyle.ELLIPSIS);
            content.getStyleClass().addAll("todo-item-content", "label");
        }
        return content;
    }

    Labeled getCreateDate() {
        if (createDate == null) {
            createDate = new Label("");
            createDate.getStyleClass().addAll("todo-item-create-date", "label");
        }
        return createDate;
    }

    ButtonBase getFavoriteButton() {
        if (favoriteButton == null) {
            favoriteButton = new Button("", new FontIcon(MaterialDesignS.STAR_OUTLINE));
            favoriteButton.getStyleClass().add("todo-item-favorite-button");
        }
        return favoriteButton;
    }

    public Parent get() {
        return view;
    }

}
