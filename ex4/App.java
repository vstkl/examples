import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import views.ViewFactory;


public class App extends Application{
	public static void main (String []args){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		ViewFactory viewer = new ViewFactory();
		Scene scene = viewer.setScene();
		
		primaryStage.setMinWidth(600);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Tuner v3.6");
		primaryStage.show();
	
	}
}
