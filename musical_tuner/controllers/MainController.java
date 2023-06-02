package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import models.Input;
import models.NoteLog;
import javafx.fxml.Initializable;


public class MainController implements Initializable{

	 @FXML
	    private Rectangle r2;

	    @FXML
	    private Rectangle r3;

	    @FXML
	    private Rectangle r4;

	    @FXML
	    private Rectangle r5;

	    @FXML
	    private Rectangle r6;

	    @FXML
	    private Rectangle r7;

	    @FXML
	    private Rectangle r8;

	    @FXML
	    private Rectangle r9;

	    @FXML
	    private Rectangle r90;

	    @FXML
	    private Rectangle r92;

	    @FXML
	    private Rectangle r91;

	    @FXML
	    private Rectangle r94;

	    @FXML
	    private Rectangle r93;

	    @FXML
	    private Rectangle r96;

	    @FXML
	    private Rectangle r95;

	    @FXML
	    private Rectangle r10;

	    @FXML
	    private Rectangle r98;

	    @FXML
	    private Rectangle r97;

	    @FXML
	    private Rectangle r12;

	    @FXML
	    private Rectangle r11;

	    @FXML
	    private Rectangle r99;

	    @FXML
	    private Rectangle r14;

	    @FXML
	    private Rectangle r13;

	    @FXML
	    private Rectangle r16;

	    @FXML
	    private Rectangle r15;

	    @FXML
	    private Rectangle r18;

	    @FXML
	    private Rectangle r17;

	    @FXML
	    private Rectangle r19;

	    @FXML
	    private Rectangle r21;

	    @FXML
	    private Rectangle r20;

	    @FXML
	    private Rectangle r23;

	    @FXML
	    private Rectangle r22;

	    @FXML
	    private Rectangle r25;

	    @FXML
	    private Rectangle r24;

	    @FXML
	    private Rectangle r27;

	    @FXML
	    private Rectangle r26;

	    @FXML
	    private Rectangle r29;

	    @FXML
	    private Rectangle r28;

	    @FXML
	    private Rectangle r30;

	    @FXML
	    private Rectangle r32;

	    @FXML
	    private Rectangle r31;

	    @FXML
	    private Rectangle r34;

	    @FXML
	    private Rectangle r33;

	    @FXML
	    private Rectangle r36;

	    @FXML
	    private Rectangle r35;

	    @FXML
	    private Rectangle r38;

	    @FXML
	    private Rectangle r37;

	    @FXML
	    private Rectangle r39;

	    @FXML
	    private Rectangle r41;

	    @FXML
	    private Rectangle r40;

	    @FXML
	    private Rectangle r43;

	    @FXML
	    private Rectangle r42;

	    @FXML
	    private Rectangle r45;

	    @FXML
	    private Rectangle r44;

	    @FXML
	    private Rectangle r47;

	    @FXML
	    private Rectangle r46;

	    @FXML
	    private Rectangle r49;

	    @FXML
	    private Rectangle r48;

	    @FXML
	    private Rectangle r50;

	    @FXML
	    private Rectangle r52;

	    @FXML
	    private Rectangle r51;

	    @FXML
	    private Rectangle r54;

	    @FXML
	    private Rectangle r53;

	    @FXML
	    private Rectangle r56;

	    @FXML
	    private Rectangle r55;

	    @FXML
	    private Rectangle r58;

	    @FXML
	    private Rectangle r57;

	    @FXML
	    private Rectangle r59;

	    @FXML
	    private Rectangle r61;

	    @FXML
	    private Rectangle r60;

	    @FXML
	    private Rectangle r63;

	    @FXML
	    private Rectangle r62;

	    @FXML
	    private Rectangle r65;

	    @FXML
	    private Rectangle r64;

	    @FXML
	    private Rectangle r67;

	    @FXML
	    private Rectangle r66;

	    @FXML
	    private Rectangle r69;

	    @FXML
	    private Rectangle r68;

	    @FXML
	    private Rectangle r70;

	    @FXML
	    private Rectangle r72;

	    @FXML
	    private Rectangle r71;

	    @FXML
	    private Rectangle r74;

	    @FXML
	    private Rectangle r73;

	    @FXML
	    private Rectangle r76;

	    @FXML
	    private Rectangle r75;

	    @FXML
	    private Rectangle r78;

	    @FXML
	    private Rectangle r77;

	    @FXML
	    private Rectangle r79;

	    @FXML
	    private Rectangle r81;

	    @FXML
	    private Rectangle r80;

	    @FXML
	    private Rectangle r83;

	    @FXML
	    private Rectangle r82;

	    @FXML
	    private Rectangle r85;

	    @FXML
	    private Rectangle r84;

	    @FXML
	    private Rectangle r87;

	    @FXML
	    private Rectangle r86;

	    @FXML
	    private Rectangle r89;

	    @FXML
	    private Rectangle r88;

	    @FXML
	    private Rectangle r1;
	    
	    @FXML
	    private Text frequency;
	    
	    @FXML
	    private Text label;
	    
	    @FXML
	    private Text octave;
	    
	    NoteLog note = new NoteLog();

	    @Override
		public void initialize(URL location, ResourceBundle resources){
			
			Input input = new Input();
						
			input.fProperty.addListener(new ChangeListener<Number>(){
					
				
					@Override
					public void changed(ObservableValue<? extends Number> observable, Number oldValue,Number newValue){ 
							
						frequency.setText(
								String.valueOf(
										newValue.doubleValue()
										)
								);
						note.setNote(NoteLog.getDifference(newValue.doubleValue()));
							
						
						label.textProperty().set(note.getNoteName());
						octave.setText(String.valueOf(note.getOctave()));
						
						
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
			System.gc();
	    }
}
