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

    /*
        Scene factory
     */
   public void createScene(double width, double height, String bgImg){
       Pane pane = new Pane();
       Scene scene = new Scene(pane);
       Stage stage = new Stage();
       stage.setScene(scene);

       pane.setPrefSize(width,height);

       ResourceCreation rs = new ResourceCreation(bgImg);
       ImageView img = rs.setImageSize(width,height);

       Button button = new Button("X");
       button.setLayoutX(1890);
       button.setLayoutY(15);
       button.setOnAction(event -> stage.close());

       pane.getChildren().addAll(img, button);
       stage.initStyle(StageStyle.UNDECORATED);
       stage.show();
   }



}
