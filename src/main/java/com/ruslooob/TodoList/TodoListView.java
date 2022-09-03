package com.ruslooob.TodoList;

import com.ruslooob.Controls.IconButton;
import com.ruslooob.FontFamily;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.kordamp.ikonli.fontawesome.FontAwesome;
import org.kordamp.ikonli.javafx.FontIcon;

import static com.ruslooob.Helpers.BackgroundFillHelper.backgroundFill;
import static com.ruslooob.Helpers.BorderStrokeHelper.borderStroke;
import static com.ruslooob.LangLoader.$;

public class TodoListView {
    private final Parent view;
    // todo make builder for GridPane
    GridPane container = new GridPane();
    Label header = new Label();
    //todo disable buttons if not select todos
    //todo move buttons to another class, which will be called ActionButtons. This class will be encapsulate all buttons logic
    Button addButton = new IconButton(new FontIcon(FontAwesome.PLUS));
    Button editButton = new IconButton(new FontIcon(FontAwesome.PENCIL));
    Button deleteButton = new IconButton(new FontIcon(FontAwesome.TRASH));
    /*carry out action buttons to another view*/
    HBox actionButtons = new HBox(10, addButton, editButton, deleteButton);

    ListView<TodoItem> listItems = new ListView<>();


    public TodoListView() {
        this.view = create();
    }

    private Parent create() {
        addButton.setPrefSize(30, 25);
        editButton.setPrefSize(30, 25);
        deleteButton.setPrefSize(30, 25);
        container.setPadding(new Insets(30));
        container.setBackground(new Background(backgroundFill(Color.web("#ddedfa"))));

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
        Font font = Font.font(FontFamily.COMIC_SANS_MS, FontWeight.BOLD, 20);
        header.setFont(font);
        header.setTextFill(Color.web("#2980B9"));
        return header;
    }

    private Node createToolBar() {
        return actionButtons;
    }


    private ListView<TodoItem> createListItems() {
        listItems.setPlaceholder(new Label($("empty_todo_list_text")));
        listItems.setCellFactory(param -> new TodoItemCell());
        listItems.prefWidthProperty().bind(container.widthProperty());
        listItems.setBackground(new Background(backgroundFill(Color.web("#ddedfa"))));
        listItems.setBorder(new Border(borderStroke(BorderStrokeStyle.NONE, new CornerRadii(10))));
        return listItems;
    }

    public Parent get() {
        return view;
    }

}
