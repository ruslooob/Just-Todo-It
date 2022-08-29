package com.ruslooob.TodoList;

import com.ruslooob.TodoItem.TodoItem;
import com.ruslooob.TodoItem.TodoItemCell;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import org.kordamp.ikonli.fontawesome.FontAwesome;
import org.kordamp.ikonli.javafx.FontIcon;

public class TodoListView {

    Parent view;
    GridPane container = new GridPane();
    Label header = new Label();
    ToolBar actionButtons = new ToolBar();
    ListView<TodoItem> listItems = new ListView<>();


    public TodoListView() {
        this.view = create();
    }

    private Parent create() {
        container.setPadding(new Insets(30));
        container.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.web("#ddedfa"),
                                CornerRadii.EMPTY,
                                null
                        )
                )
        );

        GridPane.setConstraints(header, 0, 0);
        GridPane.setConstraints(actionButtons, 0, 1);
        GridPane.setConstraints(listItems,0, 2);
        container.setVgap(20);
        container.getChildren().addAll(
                createHeader(),
                createToolBar(),
                createListItems()
        );
        ScrollPane scrollPane = new ScrollPane(container);
        scrollPane.setFitToWidth(true);
        return scrollPane;
    }

    private Label createHeader() {
        header.setText("Все заметки");
        return header;
    }

    private ToolBar createToolBar() {
        actionButtons.getItems().setAll(new Button("", new FontIcon(FontAwesome.PLUS)),
                new Button("", new FontIcon(FontAwesome.PENCIL)),
                new Button("", new FontIcon(FontAwesome.TRASH))
        );
        return actionButtons;
    }



    private ListView<TodoItem> createListItems() {
        listItems.setCellFactory(param -> new TodoItemCell());
        listItems.prefWidthProperty().bind(container.widthProperty());
        listItems.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.web("#ddedfa"),
                                null,
                                null
                        )
                )
        );
        listItems.setBorder(
                new Border(
                        new BorderStroke(
                                null,
                                BorderStrokeStyle.NONE,
                                new CornerRadii(10),
                                null
                        )
                )
        );
        return listItems;
    }

    public Parent get() {
        return view;
    }

}
