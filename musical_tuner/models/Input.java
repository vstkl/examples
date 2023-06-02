package models;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Input implements Runnable{

	TargetDataLine tdl;
	
	byte[] buffer;
	
	double[] iBuffer;
	
	boolean stop = false;
	
	public double fq;

	public DoubleProperty fProperty = new SimpleDoubleProperty();
	
	AudioFormat format;	
	
	static int buffersize = setBufferSize(17); 
	
	private static int setBufferSize(int k){
		int val = 1;
		
		for(;k>0;k--){
			val *= 2;
		}

		return val;
	}
	public static int getBufferSize(){
		return buffersize;
	}
	
	public double[] imagBuffer (){
		double[]buffer = new double[getBufferSize()];
		for(int i = 0 ; i<getBufferSize() ; i++){
			buffer[i] = 0;
		}
		return buffer;
	}
	
	public static AudioFormat getAudioFormat(){
		
		float sampleRate = 192000.0F; 
		
		int sampleSizeInBits = 16;

	    int channels = 1; 
	    
	    boolean signed = true;
	    
	    boolean bigEndian = false;
	   
	    return new AudioFormat(sampleRate,sampleSizeInBits,channels,signed,bigEndian);      
	}
	

	public void run(){ 
		
		try {
			stop = false;
			format = getAudioFormat();
			iBuffer = null;
			iBuffer = imagBuffer();
			DataLine.Info inf = new DataLine.Info(TargetDataLine.class, format);
			
			tdl = (TargetDataLine)AudioSystem.getLine(inf);
			tdl.open(format);
			tdl.start();
			
			Calculation calc = new Calculation();
			
			buffer = new byte[getBufferSize()];
			//Read the next chunk of data from the TargetDataLine.
			while(!stop){
				
				System.gc();
				
				tdl.read(buffer, 0, buffer.length);
			
				fq = calc.fft(Calculation.byteToDouble(buffer),imagBuffer());
			//	System.out.println(fq);
				fProperty.set(fq);
				
			}
		}
		catch (LineUnavailableException e) {
			
			e.printStackTrace();
		
		} 
	}
	
}
