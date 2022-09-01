package com.ruslooob.TodoList;

import com.ruslooob.TodoItem;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import org.kordamp.ikonli.fontawesome.FontAwesome;
import org.kordamp.ikonli.javafx.FontIcon;

public class TodoListView {

    private final Parent view;
    GridPane container = new GridPane();
    Label header = new Label();
    //todo disable buttons if not select todos
    //todo move buttons to another class, which will be called ActionButtons. This class will be encapsulate all buttons logic
    Button addButton = new Button("", new FontIcon(FontAwesome.PLUS));
    Button editButton = new Button("", new FontIcon(FontAwesome.PENCIL));
    Button deleteButton = new Button("", new FontIcon(FontAwesome.TRASH));
    HBox actionButtons = new HBox(10, addButton, editButton, deleteButton);

    ListView<TodoItem> listItems = new ListView<>();


    public TodoListView() {
        this.view = create();
    }

    private Parent create() {
        actionButtons.setPrefWidth(Double.MIN_VALUE);
        actionButtons.setMaxWidth(100);
        container.setPadding(new Insets(30));
        container.setBackground(new Background(new BackgroundFill(Color.web("#ddedfa"), CornerRadii.EMPTY, null)));

        GridPane.setConstraints(header, 0, 0);
        GridPane.setConstraints(actionButtons, 0, 1);
        GridPane.setConstraints(listItems, 0, 2);
        container.setVgap(20);
        container.getChildren().addAll(createHeader(), createToolBar(), createListItems());
        ScrollPane scrollPane = new ScrollPane(container);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        return scrollPane;
    }

    private Label createHeader() {
        header.setText("Все заметки");
        return header;
    }

    private Node createToolBar() {
        return actionButtons;
    }


    private ListView<TodoItem> createListItems() {
        listItems.setCellFactory(param -> new TodoItemCell());
        listItems.prefWidthProperty().bind(container.widthProperty());
        listItems.setBackground(new Background(new BackgroundFill(Color.web("#ddedfa"), null, null)));
        listItems.setBorder(new Border(new BorderStroke(null, BorderStrokeStyle.NONE, new CornerRadii(10), null)));
        return listItems;
    }

    public Parent get() {
        return view;
    }

}
