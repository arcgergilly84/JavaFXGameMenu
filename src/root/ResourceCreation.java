package root;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;

public class ResourceCreation {

    String location = "";
    ImageView img;
    double width, height;


    public ResourceCreation(String location,double width,double height){
        this.location = location;
        URL bgImgPath = Main.class.getClassLoader().getResource(location);
        img = new ImageView(new Image(bgImgPath.toExternalForm()));
        this.width = width;
        this.height = height;
    }

    public ImageView setImageSize() {
        img.setFitWidth(width);
        img.setFitHeight(height);
        return img;
    }

    public ImageView setImageLocation(double x, double y){
        img.setX(x);
        img.setY(y);
        return img;
    }


}
