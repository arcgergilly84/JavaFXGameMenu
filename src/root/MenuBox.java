package root;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class MenuBox extends VBox {

    /*
        Constructor with no set number of MenuItem objects
     */
    public MenuBox(MenuItem... items){
        getChildren().add(createSeparator()); //Initial separator at the top

        for (MenuItem item : items){
            getChildren().addAll(item, createSeparator()); //additional separator after each item added.
        }
    }

    /*
        Separators for menuItems.
     */
    private Line createSeparator(){
        Line sep = new Line();
        sep.setEndX(300); //length of line
        sep.setStroke(Color.DARKGREY); //color of line
        return sep;
    }
}
