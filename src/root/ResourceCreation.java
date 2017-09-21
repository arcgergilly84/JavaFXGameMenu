package root;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;

/*
   Resource factory
 */
public class ResourceCreation {

    String location = "";
    ImageView img;

    /*
       get the resource from the specified location.
     */
    public ResourceCreation(String location){
        this.location = location;
        URL bgImgPath = Main.class.getClassLoader().getResource(location);
        img = new ImageView(new Image(bgImgPath.toExternalForm()));

    }

    /*
        Set the size of the image.
    */
    public ImageView setImageSize(double width, double height) {
        img.setFitWidth(width);
        img.setFitHeight(height);
        return img;
    }

    /*
        Set the position of the image
    */
    public ImageView setImageLocation(double x, double y){
        img.setX(x);
        img.setY(y);
        return img;
    }


}
