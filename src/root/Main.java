package root;

import javafx.application.Application;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;



public class Main extends Application {

    private double width = 1920;
    private double height = 1080;

    private Parent createContent(){
        Pane root = new Pane();
        root.setPrefSize(width, height); //W:860 H:600

        MenuItem newGame = new MenuItem("NEW GAME");
        MenuItem continueGame = new MenuItem("CONTINUE");
        MenuItem friends = new MenuItem("FRIENDS");
        MenuItem settings = new MenuItem("SETTINGS");
        MenuItem store = new MenuItem("STORE");
        MenuItem exit = new MenuItem("EXIT");

        String bgImg = "root/resources/dark.jpg";
        String title = "root/resources/logo.png";
        String logo = "root/resources/SteamAgony.png";

        URL bgImgPath = Main.class.getClassLoader().getResource(bgImg);
        ImageView img = new ImageView(new Image(bgImgPath.toExternalForm()));
        img.setFitWidth(width);
        img.setFitHeight(height);
        root.getChildren().add(img);

        URL titleImgPath = Main.class.getClassLoader().getResource(title);
        ImageView imgLogo = new ImageView(new Image(titleImgPath.toExternalForm()));
        imgLogo.setX(1000);
        imgLogo.setY(100);
        imgLogo.setFitWidth(600);
        imgLogo.setFitHeight(300);
        root.getChildren().add(imgLogo);

        URL logoImgPath = Main.class.getClassLoader().getResource(logo);
        ImageView bottomlogo = new ImageView(new Image(logoImgPath.toExternalForm()));
        bottomlogo.setX(100);
        bottomlogo.setY(800);
        bottomlogo.setFitHeight(200);
        bottomlogo.setFitWidth(200);
        bottomlogo.setOpacity(0.7);
        root.getChildren().add(bottomlogo);

        MenuBox menu = new MenuBox(
                newGame,
                continueGame,
                friends,
                settings,
                store,
                exit);

        menu.setTranslateX(width / 3.4);
        menu.setTranslateY(height / 2.5);

        settings.setOnMouseClicked(event -> new SceneCreator().createScene(200,300));

        exit.setOnMouseClicked( event -> Platform.exit());

        root.getChildren().add(menu);

        return root;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Scene scene = new Scene(createContent());
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }

    @Override
    public void stop(){
        //TODO
    }

    public static void main(String[] args) {
        launch(args);
    }
}
