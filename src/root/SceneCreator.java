package root;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SceneCreator{

   public void createScene(double width, double height){
       Pane pane = new Pane();
       Scene scene = new Scene(pane);
       Stage stage = new Stage();
       stage.setScene(scene);
       pane.setPrefSize(width,height);
       stage.show();
   }



}
