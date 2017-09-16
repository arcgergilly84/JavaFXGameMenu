package root;

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main extends Application {

    private double width = 1920;
    private double height = 1080;

    /*
        Holds all selectable menu items. For Example, Exit.
     */
    private static class MenuItem extends StackPane{
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

    private static class MenuBox extends VBox{
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

    private Parent createContent(){
        Pane root = new Pane();
        root.setPrefSize(width, height); //W:860 H:600
        ImageView imgLogo = null;
        ImageView bottomlogo = null;
        MenuItem newGame = new MenuItem("NEW GAME");
        MenuItem continueGame = new MenuItem("CONTINUE");
        MenuItem friends = new MenuItem("FRIENDS");
        MenuItem settings = new MenuItem("SETTINGS");
        MenuItem store = new MenuItem("STORE");
        MenuItem exit = new MenuItem("EXIT");

        try(InputStream is = Files.newInputStream(Paths.get("src/resources/Images/dark.jpg"))) {
            ImageView img = new ImageView(new Image(is));
            img.setFitWidth(width);
            img.setFitHeight(height);
            root.getChildren().add(img);
        } catch (IOException e){
            System.out.println("Couldn't Load Image");
        }

        try(InputStream is = Files.newInputStream(Paths.get("src/resources/Images/logo.png"))) {
            imgLogo = new ImageView(new Image(is));
            imgLogo.setX(1000);
            imgLogo.setY(100);
            imgLogo.setFitWidth(600);
            imgLogo.setFitHeight(300);
        } catch (IOException e){
            System.out.println("Couldn't Load Image");
        }

        try(InputStream is = Files.newInputStream(Paths.get("src/resources/Images/SteamAgony.png"))) {
            bottomlogo = new ImageView(new Image(is));
            bottomlogo.setX(100);
            bottomlogo.setY(800);
            bottomlogo.setFitHeight(200);
            bottomlogo.setFitWidth(200);
            bottomlogo.setOpacity(0.7);
        } catch (IOException e){
            System.out.println("Couldn't Load Image");
        }

        MenuBox menu = new MenuBox(
                newGame,
                continueGame,
                friends,
                settings,
                store,
                exit);

        menu.setTranslateX(width / 3.4);
        menu.setTranslateY(height / 2.5);

        exit.setOnMouseClicked( event -> System.exit(0) );

        root.getChildren().addAll(menu , imgLogo, bottomlogo);

        return root;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Scene scene = new Scene(createContent());
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
