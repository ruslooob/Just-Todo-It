module com.ruslooob {
    requires javafx.controls;
    requires java.desktop;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.materialdesign2;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires org.jetbrains.annotations;

    opens com.ruslooob.TodoList;

    exports com.ruslooob;
}