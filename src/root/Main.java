package root;

import javafx.application.Application;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {

    private double width = 1920;
    private double height = 1080;

    /*
        GameMenu stage
     */
    private Parent mainScreen(){
        Pane root = new Pane();
        root.setPrefSize(width, height);

        //paths to images used(.jar safe)
        String bgImg = "images/dark.jpg";
        String title = "images/logo.png";
        String logo = "images/SteamAgony.png";

        //Creation of resources.
        ResourceCreation background = new ResourceCreation(bgImg);
        ImageView bgImage = background.setImageSize(width, height);

        ResourceCreation titleImage = new ResourceCreation(title);
        titleImage.setImageSize(800,400);
        ImageView imglogo = titleImage.setImageLocation(1000,100);

        ResourceCreation sponsorLogoImage = new ResourceCreation(logo);
        sponsorLogoImage.setImageSize(200, 200);
        ImageView sponsorLogo = sponsorLogoImage.setImageLocation(100,800);
        sponsorLogo.setOpacity(0.6);//slightly reduce opacity to blend into the bg.

        //Creation of MenuItem objects.
        MenuItem newGame = new MenuItem("NEW GAME");
        MenuItem continueGame = new MenuItem("CONTINUE");
        MenuItem friends = new MenuItem("FRIENDS");
        MenuItem settings = new MenuItem("SETTINGS");
        MenuItem store = new MenuItem("STORE");
        MenuItem exit = new MenuItem("EXIT");

        //Adding the MenuItem Objects to an encapsulating MenuBox
        MenuBox menu = new MenuBox(
                newGame,
                continueGame,
                friends,
                settings,
                store,
                exit);

        menu.setTranslateX(width / 3.4);
        menu.setTranslateY(height / 2.5);

        //Open up another stage on settings MenuItem.
        settings.setOnMouseClicked(event -> new SceneCreator().createScene(width,height, "images/settings.jpg"));

        //Close down of the program on selection of the Exit Menuitem
        exit.setOnMouseClicked( event -> Platform.exit());

        //add all elements to the stage.
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


    public static void main(String[] args) {
        launch(args);
    }
}
