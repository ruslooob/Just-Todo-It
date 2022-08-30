package com.ruslooob;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;
import java.time.Month;

public class TodoItem {
    public StringProperty header = new SimpleStringProperty("");
    public StringProperty content = new SimpleStringProperty("");
    public SimpleObjectProperty<LocalDate> createDate = new SimpleObjectProperty<>(LocalDate.of(2022, Month.APRIL, 10));

    public TodoItem(String header, String content, LocalDate createDate) {
        setHeader(header);
        setContent(content);
        setCreateDate(createDate);
    }

    public TodoItem() {
    }

    public String getHeader() {
        return header.get();
    }

    public void setHeader(String header) {
        this.header.set(header);
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
