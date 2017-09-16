package root;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class MenuItem extends StackPane {

    public MenuItem(String name){

            /*
                Adds a gradient to the items with purple endings.
             */
        LinearGradient gradient = new LinearGradient(0,0,1,0,true, CycleMethod.NO_CYCLE, new Stop[]{
                new Stop(0, Color.DARKRED),
                new Stop(0.1, Color.BLACK),
                new Stop(0.9, Color.BLACK),
                new Stop(1,Color.DARKRED)

        });

            /*
                Border around the items.
             */
        Rectangle bg = new Rectangle(300, 50);
        bg.setOpacity(0.5);

            /*
                Text properties of the items.
             */
        Text text = new Text(name);
        text.setFill(Color.DARKGREY);
        text.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD,40));

        setAlignment(Pos.CENTER);
        getChildren().addAll(bg, text);

            /*
                Events via Mouse...additional keyboard keys to be added later.
             */
        setOnMouseEntered(event -> {
            bg.setFill(gradient);
            text.setFill(Color.WHITE);
        });

        setOnMouseExited(event -> {
            bg.setFill(Color.BLACK);
            text.setFill(Color.DARKGREY);
        });

        setOnMousePressed(event -> {
            bg.setFill(Color.DARKRED);
        });

        setOnMouseReleased(event -> {
            bg.setFill(gradient);
        });
    }
}
