/*
 * @author
 * 
 * Harish Fulara(2014143)
 * Anant Mittal(2014015)
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class AdminMain extends Application {
    
    @Override
    public void start(Stage primaryStage) 
    {   
        try {
	       primaryStage.setTitle("IIIT-Delhi PhD Admissions Admin");
	       Parent root = FXMLLoader.load(getClass().getResource("project.fxml"));
	       Scene scene = new Scene(root);

	       primaryStage.setScene(scene);
               primaryStage.show();
              
	   } catch(Exception e) 
           {
			e.printStackTrace();
                        
           }
       
        
        
        
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
