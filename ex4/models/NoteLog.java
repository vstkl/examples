package models;

public class NoteLog {
	private static double baseFrequency = 27.5;
	private static int range=6;
	private int oct;
	private double offset;
	private int nameIndex;
	boolean stop = false;
	public void setBaseFrequency(int base){

		baseFrequency = (double)base;
	}
	public String getNoteName(){
		String val;
		switch(nameIndex){
		
		case 0:
			val = "A";
			break;
		case 1:
			val = "A#";
			break;
		case 2:
			val = "B";
			break;
		case 3:
			val = "C";
			break;
		case 4:
			val = "C#";
			break;
		case 5:
			val = "D";
			break;
		case 6:
			val = "D#";
			break;
		case 7:
			val = "E";
			break;
		case 8:
			val = "F";
			break;
		case 9:
			val = "F#";
			break;
		case 10:
			val = "G";
			break;
		case 11:
			val = "G#";
			break;
		default:
			val = "lol";
			break;
		}
		return val;
	}
	public static double getNoteRange(){
		int val=1;
		for(int i = 0; i<range;i++){
			val*=2;
		}
		return baseFrequency*val;
	}
	public void setNote(double difference){
		oct = 0;
		offset = 0;
		int k = 0;

	if(0!=difference){
	/*		do{
				difference-=100;
				k+=1;
				
				if(12==k){
					k=0;
					oct++;
					}
				System.out.print(k+"_");
				}while(difference>100);
			k++;
			offset = difference-50;
			System.out.println();
			System.out.println(nameIndex+"/note @"+oct+" %"+offset);
			nameIndex = k;
		}
	*/	difference+=50;
		int counter = 0;
		while(difference>100){
			difference-=100;
			counter++;
			k++;
			if(12==k){
				k=0;
				oct++;
				}
		}
		offset = difference;
		nameIndex = k;
		
		}
	}
	public int getOctave(){
		return oct;
	}
	public static double getDifference(double fq){


		double difference = 0 ;

		if(0!=fq){
			System.out.print("fq "+fq+"  ");
			difference =1200*(Math.log10(fq/baseFrequency))/Math.log10(2);
		}

		 return difference;
	}
	public int offGraphic(){
		
		int val = 7;
		val = (int) Math.round((offset*13/100));
		
		return val;
	}
}
