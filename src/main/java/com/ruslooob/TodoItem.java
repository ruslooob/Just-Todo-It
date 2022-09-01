package com.ruslooob;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;
import java.time.Month;
import java.util.Objects;


public class TodoItem {
    // todo что делать с id
    private Long id;
    private StringProperty header = new SimpleStringProperty("");
    private StringProperty content = new SimpleStringProperty("");
    private final SimpleObjectProperty<LocalDate> createDate = new SimpleObjectProperty<>(LocalDate.of(2022, Month.APRIL, 10));

    public TodoItem(String header, String content) {
        setHeader(header);
        setContent(content);
    }

    public TodoItem() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItem todoItem = (TodoItem) o;
        return header.equals(todoItem.header) && content.equals(todoItem.content) && createDate.equals(todoItem.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(header, content, createDate);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StringProperty headerProperty() {
        return header;
    }

    public String getHeader() {
        return header.get();
    }

    public void setHeader(String header) {
        this.header.set(header);
    }

    public StringProperty contentProperty() {
        return content;
    }

    public String getContent() {
        return content.get();
    }


    public void setContent(String content) {
        this.content.set(content);
    }

    public LocalDate getCreateDate() {
        return createDate.get();
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate.set(createDate);
    }

}
