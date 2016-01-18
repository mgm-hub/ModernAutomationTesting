package MainController.RunCore;


import MainController.Utilities.Log;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class MainGUI extends Application{

    @Override
    public void start(Stage primaryStage)  {
        try {
            //Scene File Location
            String myFileLocation = MainController.ValueCore.Constants.VIEW_CONTROLLER_FILE_NAME;
            URL myViewObjectResource = MainGUI.class.getResource(myFileLocation);

            //Scene Properties
            Parent myParent = FXMLLoader.load(myViewObjectResource);
            primaryStage.setTitle(MainController.ValueCore.Constants.VIEW_CONTROLLER_SCREEN_TITLE);
            primaryStage.setScene(new Scene(myParent, MainController.ValueCore.Constants.VIEW_WIDTH, MainController.ValueCore.Constants.VIEW_HEIGHT));

            //Build
            primaryStage.show();
        }
        catch (Exception e){
            String myError = "Could Not Load GUI\n" +e ;
            Log.log(myError);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
