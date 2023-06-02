package models;

public class Note{
	int octave;
	double pitch;
	String name;
	double off;
	static int octaveRange = 20;
	static double baseFrequency = 110;
	
	public Note(double pitch, String name){
		this.pitch = pitch;
		this.name = name;
		
		System.out.println("Note "+ name +" with "+pitch+" Hz");
	}
	public Note(double pitch){
		
		System.out.println(
				getDifference(pitch));
	}

	
	
	public static void setBaseFrequency(double UserBaseFQ){
		@SuppressWarnings("unused")
		double baseFrequency = UserBaseFQ;
	}
	public String getNoteName(){
		try{
			return this.name;
		}
		catch(Exception e){
			e.printStackTrace();
			return "_";
		}
	}
	public int offKey(){

		return (int)this.off;
				
	}
	public int getOctave(){
		return this.octave;
	}
	public static Note getNote(double pitch){
		Note n = new Note(pitch);
		return n;
	}
/*	public static Note getNote(double pitch){


		Note centerFq = Note.No;
		try{
			for(int i = 1; i < octaveRange; i++) {
				
				if((pitch>Note.C.pitch*i)&&(Note.D.pitch*i>pitch)){
					centerFq = Cs;
					centerFq.octave = i;
					break;}
				else if((pitch>Note.Cs.pitch*i)&&(Note.Ds.pitch*i>pitch)){
					centerFq = D;
					centerFq.octave = i;
					break;}
				else if((pitch>Note.D.pitch*i)&&(Note.E.pitch*i>pitch)){
					centerFq = Ds;
					centerFq.octave = i;
					break;}
				else if((pitch>Note.Ds.pitch*i)&&(Note.F.pitch*i>pitch)){
					centerFq = E;
					centerFq.octave = i;
					break;}
				else if((pitch>Note.E.pitch*i)&&(Note.Fs.pitch*i>pitch)){
					centerFq = F;
					centerFq.octave = i;
					break;}
				else if((pitch>Note.F.pitch*i)&&(Note.G.pitch*i>pitch)){
					centerFq = Fs;
					centerFq.octave = i;
					break;}
				else if((pitch>Note.Fs.pitch*i)&&(Note.Gs.pitch*i>pitch)){
					centerFq = G;
					centerFq.octave = i;
					break;}
				else if((pitch>Note.G.pitch*i)&&(Note.A.pitch*i>pitch)){
					centerFq = Gs;
					centerFq.octave = i;
					break;}
				else if((pitch>Note.Gs.pitch*i)&&(Note.As.pitch*i>pitch)){
					centerFq = A;
					centerFq.octave = i;
					break;}
				else if((pitch>Note.A.pitch*i)&&(Note.B.pitch*i>pitch)){
					centerFq = As;
					centerFq.octave = i;
					break;}
				else if((pitch>Note.As.pitch*i)&&(Note.C.pitch*i>pitch)){
					centerFq = B;
					centerFq.octave = i;
					break;}
				else if((pitch>Note.B.pitch*i)&&((Note.Cs.pitch*i)>pitch)){
					centerFq = C;
					centerFq.octave = i;
					
					break;}
			}
			
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
		centerFq.off = centerFq.getDifference(pitch, centerFq);
		
		return centerFq;
	}
	*/
	
	
	public static double getDifference(double fq){
		

		double val;
		double difference ;
		
		difference =  1200*Math.log10(fq/baseFrequency)/Math.log(2);
		System.out.print(difference);
		val = difference/100*13;
			


		System.out.println("cents, val"+val);
		return val;
		
	}
}
