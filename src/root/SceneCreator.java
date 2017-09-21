package root;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;

public class SceneCreator{

   public void createScene(double width, double height, String bgImg){
       Pane pane = new Pane();
       Scene scene = new Scene(pane);
       Stage stage = new Stage();
       stage.setScene(scene);
       pane.setPrefSize(width,height);
       URL bgImgPath = Main.class.getClassLoader().getResource(bgImg);
       ImageView img = new ImageView(new Image(bgImgPath.toExternalForm()));
       img.setFitWidth(width);
       img.setFitHeight(height);

       Button button = new Button("Exit");
       button.setLayoutX(0);

       button.setOnAction(event -> stage.close());

       pane.getChildren().addAll(img,button);
       stage.initStyle(StageStyle.UNDECORATED);
       stage.show();
   }



}
