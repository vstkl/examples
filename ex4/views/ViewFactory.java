package views;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
public class ViewFactory {
	
	
	public Scene setScene() {
		Pane p;
		FXMLLoader loader = new FXMLLoader(
		        getClass().getResource("GUI.fxml")
		);
		try {
			
			p = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			p = null;
			e.printStackTrace();
		}
		 
		Scene scn = new Scene(p);
		
	//	scn.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		
		return scn;
	}

}
