package root;

import javafx.application.Application;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;



public class Main extends Application {

    private double width = 1920;
    private double height = 1080;

    private Parent mainScreen(){
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


        ResourceCreation background = new ResourceCreation(bgImg,width, height);
        ImageView bgImage = background.setImageSize();

        ResourceCreation titleImage = new ResourceCreation(title,600,300);
        titleImage.setImageSize();
        ImageView imglogo = titleImage.setImageLocation(1000,100);


        ResourceCreation sponsorLogoImage = new ResourceCreation(logo,200,200);
        sponsorLogoImage.setImageSize();
        ImageView sponsorLogo = sponsorLogoImage.setImageLocation(100,800);
        sponsorLogo.setOpacity(0.6);

        MenuBox menu = new MenuBox(
                newGame,
                continueGame,
                friends,
                settings,
                store,
                exit);

        menu.setTranslateX(width / 3.4);
        menu.setTranslateY(height / 2.5);

        settings.setOnMouseClicked(event -> new SceneCreator().createScene(width,height, "root/resources/settings.jpg"));

        exit.setOnMouseClicked( event -> Platform.exit());

        root.getChildren().addAll(bgImage, imglogo, sponsorLogo, menu);


        return root;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Scene scene = new Scene(mainScreen());
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
