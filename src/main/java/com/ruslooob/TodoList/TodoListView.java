package com.ruslooob.TodoList;

import com.ruslooob.Controls.IconButton;
import com.ruslooob.FontFamily;
import com.ruslooob.TodoItem;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignP;
import org.kordamp.ikonli.materialdesign2.MaterialDesignT;

import static com.ruslooob.LangLoader.$;

public class TodoListView {

    final Parent view;
    // todo make builder for GridPane
    VBox container = new VBox(20);
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

    Parent create() {
        addButton.getStyleClass().addAll("button");
        editButton.getStyleClass().add("button");
        deleteButton.getStyleClass().add("button");

        container.getStyleClass().add("container");
        container.getChildren().addAll(createHeader(), createToolBar(), createListItems());
        return container;
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
        listItems.getStylesheets().add("list-items");
        return listItems;
    }

    public Parent get() {
        return view;
    }

}
