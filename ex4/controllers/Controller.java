package controllers;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import models.Input;
import models.NoteLog;


public class Controller implements Initializable{

	@FXML
	private Text hz;
	
	@FXML
    private Text frequency;
	
    @FXML
    private Text centerFq;
    
    @FXML
    private Text octave;

    @FXML
    private Rectangle sharp6;

    @FXML
    private Rectangle sharp5;

    @FXML
    private Rectangle sharp4;

    @FXML
    private Rectangle sharp3;

    @FXML
    private Rectangle sharp2;
    
    @FXML
    private Rectangle sharp1;

    @FXML
    private Rectangle ok;
    @FXML
    private Rectangle flat1;

    @FXML
    private Rectangle flat2;
    
    @FXML
    private Rectangle flat3;

    @FXML
    private Rectangle flat4;

    @FXML
    private Rectangle flat5;

    @FXML
    private Rectangle flat6;

    NoteLog note = new NoteLog();

	@Override
	public void initialize(URL location, ResourceBundle resources){
		
		Input input = new Input();
		
		
		
		input.fProperty.addListener(new ChangeListener<Number>(){
				
			
				@Override
				public void changed(ObservableValue<? extends Number> observable, Number oldValue,Number newValue){ 
					
					flat6.setOpacity(0.3);
					flat5.setOpacity(0.3);
					flat4.setOpacity(0.3);
					flat3.setOpacity(0.3);
					flat2.setOpacity(0.3);
					flat1.setOpacity(0.3);
					ok.setOpacity(0.3);
					sharp1.setOpacity(0.3);
					sharp2.setOpacity(0.3);
					sharp3.setOpacity(0.3);
					sharp4.setOpacity(0.3);
					sharp5.setOpacity(0.3);
					sharp6.setOpacity(0.3);
					
					
					if(0!=newValue.intValue()){
						note.setNote(NoteLog.getDifference(newValue.doubleValue()));
							
						centerFq.setText(note.getNoteName());
						octave.setText(String.valueOf(note.getOctave()));
						
						if(newValue.doubleValue()>1000){
							frequency.textProperty().set(
									String.valueOf(
										newValue.doubleValue()/1000
										)
									);
							hz.textProperty().set("kHz");
						}
						else{
						frequency.textProperty().set(
								String.valueOf(
									newValue.doubleValue()
									)
								);
						hz.textProperty().set("Hz");
						}
			
						switch(note.offGraphic()){
						
							case 0:
								flat6.setOpacity(1);
								break;
							case 1:
								flat5.setOpacity(1);
								break;
							case 2:
								flat4.setOpacity(1);
								break;
							case 3:
								flat3.setOpacity(1);
								break;
							case 4:
								flat2.setOpacity(1);
								break;
							case 5: 
								flat1.setOpacity(1);
							case 6:
								ok.setOpacity(1);
								break;
							case 7:
								sharp1.setOpacity(1);
								break;
							case 8:
								sharp2.setOpacity(1);
								break;
							case 9:
								sharp3.setOpacity(1);
								break;
							case 10:
								sharp4.setOpacity(1);
								break;
							case 11:
								sharp5.setOpacity(1);
								break;
							case 12:
								sharp6.setOpacity(1);
							default:
								flat6.setOpacity(0.3);
								flat5.setOpacity(0.3);
								flat4.setOpacity(0.3);
								flat3.setOpacity(0.3);
								flat2.setOpacity(0.3);
								flat1.setOpacity(0.3);
								ok.setOpacity(0.3);
								sharp1.setOpacity(0.3);
								sharp2.setOpacity(0.3);
								sharp3.setOpacity(0.3);
								sharp4.setOpacity(0.3);
								sharp5.setOpacity(0.3);
								sharp6.setOpacity(0.3);
								
						
							
						}
					
					}
					else {	
						centerFq.setText("_");
						octave.setText(" ");
						frequency.setText(" ");
						hz.setText(" ");
					}
				}	
			}
		);
	    
	    Service<Void> inputUpdater = new Service<Void>(){
			
			@Override
			protected Task<Void> createTask() {
				return new Task<Void>(){
					
					@Override
					protected Void call() throws Exception {
						
							input.run();
							System.out.println("void error");
							return null;					
					}
				};	
			}
			
		};
		inputUpdater.start();
		
		
		
	}
	

}
