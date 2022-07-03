
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;
import model.User;

/**
 * FXML Controller class
 *
 * @author Reyna Luis, Trujillo Ronald, Guzman Sebastian, Cruz Danna, Gutierrez Ana
 */
public class ViewLoginController implements Initializable {
    private User model = new User();
    
    @FXML
    private TextField txtUser;
    
    @FXML
    private PasswordField txtPassword;
    
    @FXML
    private Button btnLogin;
    
    @FXML
    private void eventKey(KeyEvent event){
        
        Object evt = event.getSource();
        
        if(evt.equals(txtUser)){
            
            if(event.getCharacter().equals(" ")){
                event.consume();
            }
            
        }    
    }
    @FXML
    private void eventAction(ActionEvent event){
        
        Object evt = event.getSource();
        
        if(evt.equals(btnLogin)){
            
            if(!txtUser.getText().isEmpty() && !txtPassword.getText().isEmpty()){
                
                String usert = txtUser.getText();
                String pass = txtPassword.getText();
                
                int state = model.login(usert, pass);
                
                if(state != -1){
                    if(state ==1){
                        JOptionPane.showMessageDialog(null, "Datos correctos, puede ingresar al sistema", 
                                                            "Error exitoso", JOptionPane.ERROR_MESSAGE);
                        
                        loadStage("/view/ViewPrincipalMenu.fxml", event);
                                      
                    }else{
                        JOptionPane.showMessageDialog(null,"Error al iniciar sesion, datos de acceso incorrectos",
                                                            "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                    }
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "Error al iniciar sesión, datos de acceso incorrectos",
                        "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            }
            
        }
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    private void loadStage(String url, Event event){
        try{
            ((Node) (event.getSource())).getScene().getWindow().hide();
            
            Parent root = FXMLLoader.load(getClass().getResource(url));
            Scene scene = new Scene (root);
            Stage newStage = new Stage();
            newStage.setScene(scene);
            newStage.show();
            
            newStage.setOnCloseRequest (new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event){
                    Platform.exit();
                }
            });               
        } catch (IOException ex){
            Logger.getLogger(ViewLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
