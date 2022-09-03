package com.ruslooob.Helpers;

import javafx.scene.Node;

public class SplitPane {
    private final javafx.scene.control.SplitPane container = new javafx.scene.control.SplitPane();

    public SplitPane dividerPosition(int dividerIndex, Double position) {
        container.setDividerPosition(dividerIndex, position);
        return this;
    }

    public SplitPane resizableWithParent(Node node, boolean value) {
        javafx.scene.control.SplitPane.setResizableWithParent(node, value);
        return this;
    }

    public SplitPane items(Node... nodes) {
        container.getItems().setAll(nodes);
        return this;
    }

    public javafx.scene.control.SplitPane build() {
        return container;
    }

}
