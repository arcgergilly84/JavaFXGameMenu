package root;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class MenuBox extends VBox {

    public MenuBox(MenuItem... items){
        getChildren().add(createSeparator()); //Initial separator at the top

        for (MenuItem item : items){
            getChildren().addAll(item, createSeparator()); //additional separator after each item added.
        }
    }

    private Line createSeparator(){
        Line sep = new Line();
        sep.setEndX(300); //length of line
        sep.setStroke(Color.DARKGREY); //color of line
        return sep;
    }
}
