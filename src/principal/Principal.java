
package principal;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Principal extends Application{
   
    @Override
    public void start (Stage primaryStage) throws IOException{
        
        Parent root = FXMLLoader.load(getClass().getResource("/view/ViewLogin.fxml"));
        
        Scene scene = new Scene (root);   
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }
    
    public static void main(String[] args) {
        launch(args);
        
    }
    
    
}
