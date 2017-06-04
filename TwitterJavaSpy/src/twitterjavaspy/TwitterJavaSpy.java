/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitterjavaspy;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Jakub Zarebski
 */
public class TwitterJavaSpy  extends Application  {
  
    /**
     * 
     * 
     * @param primaryStage
     * @throws java.lang.Exception
     */
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
        primaryStage.setTitle("Look at Tweets ");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        
    }
    
    public static void main(String[] args) {
        launch(args);
    
    
    
    
    }




    
 
    
    




    
}

