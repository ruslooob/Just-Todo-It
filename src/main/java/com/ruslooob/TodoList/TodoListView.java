package com.ruslooob.TodoList;

import com.ruslooob.Controls.IconButton;
import com.ruslooob.FontFamily;
import com.ruslooob.TodoItem;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignP;
import org.kordamp.ikonli.materialdesign2.MaterialDesignT;

import static com.ruslooob.LangLoader.$;

public class TodoListView {

    private final Parent view;
    // todo make builder for GridPane
    GridPane container = new GridPane();
    Label header = new Label();
    //todo disable buttons if not select todos
    //todo move buttons to another class, which will be called ActionButtons. This class will be encapsulate all buttons logic
    Button addButton = new IconButton(new FontIcon(MaterialDesignP.PLUS_THICK));
    Button editButton = new IconButton(new FontIcon(MaterialDesignP.PENCIL));
    Button deleteButton = new IconButton(new FontIcon(MaterialDesignT.TRASH_CAN));
    /*carry out action buttons to another view*/
    HBox actionButtons = new HBox(10, addButton, editButton, deleteButton);

    ListView<TodoItem> listItems = new ListView<>();


    public TodoListView() {
        this.view = create();
        view.getStylesheets().add("/css/todo-list.css");
    }

    private Parent create() {
        addButton.getStyleClass().addAll("button");
        editButton.getStyleClass().add("button");
        deleteButton.getStyleClass().add("button");

        container.getStyleClass().add("container");
        GridPane.setConstraints(header, 0, 0);
        GridPane.setConstraints(actionButtons, 0, 1);
        GridPane.setConstraints(listItems, 0, 2);
        container.getChildren().addAll(createHeader(), createToolBar(), createListItems());
        ScrollPane scrollPane = new ScrollPane(container);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        return scrollPane;
    }

    Label createHeader() {
        header.setText("Все заметки");
        Font font = Font.font(FontFamily.COMIC_SANS_MS, FontWeight.BOLD, 20);
        header.setFont(font);
        header.setTextFill(Color.web("#2980B9"));
        return header;
    }

    Node createToolBar() {
        return actionButtons;
    }


    ListView<TodoItem> createListItems() {
        listItems.setPlaceholder(new Label($("empty_todo_list_text")));
        listItems.setCellFactory(param -> new TodoItemCell());
        /*fix this hardcode*/
        listItems.prefWidthProperty().bind(container.widthProperty());
        listItems.getStylesheets().add("list-items");
        return listItems;
    }

    public Parent get() {
        return view;
    }

}
