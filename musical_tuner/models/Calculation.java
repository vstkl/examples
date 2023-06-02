package models;

public class Calculation{

	public double fft(double[] real, double[] imag) {
		
		int n = real.length;
		double mag = 15000;
		double currentMag;
		double fq = 0;
		
		if(real.length!=imag.length)
			System.out.println("arrays mismatch!");
		
		int levels = 31 - Integer.numberOfLeadingZeros(n);  
			if (1 << levels != n)
				throw new IllegalArgumentException("Length is not a power of 2");
		double[] cosTable = new double[n / 2];
		double[] sinTable = new double[n / 2];
		
		for (int i = 0; i < n / 2; i++) {
				cosTable[i] = Math.cos(2 * Math.PI * i / n);
				sinTable[i] = Math.sin(2 * Math.PI * i / n);
			}
			
			// Bit-reversed addressing permutation
		for (int i = 0; i < n; i++) {
			int j = Integer.reverse(i) >>> (32 - levels);
			if (j > i) {
				double temp = real[i];
					real[i] = real[j];
					real[j] = temp;
					temp = imag[i];
					imag[i] = imag[j];
					imag[j] = temp;
				}
			}
			
			// Cooley-Tukey decimation-in-time radix-2 FFT
		for (int size = 2; size <= n; size *= 2) {
			int halfsize = size / 2;
			int tablestep = n / size;
			for (int i = 0; i < n; i += size) {
				for (int j = i, k = 0; j < i + halfsize; j++, k += tablestep) {
					double tpre =  real[j+halfsize] * cosTable[k] + imag[j+halfsize] * sinTable[k];
					double tpim = -real[j+halfsize] * sinTable[k] + imag[j+halfsize] * cosTable[k];
					real[j + halfsize] = real[j] - tpre;
					imag[j + halfsize] = imag[j] - tpim;
					real[j] += tpre;
					imag[j] += tpim;
						
					currentMag = pythagorian(real[j],imag[j]);
					if(j<NoteLog.getNoteRange()){
						if(currentMag>mag){
							mag = currentMag;
							fq =Input.getAudioFormat().getSampleRate()/Input.getBufferSize()*j*2;
						}
					}
				}
				
			}
			if (size == n)  // Prevent overflow in 'size *= 2'
				break;
		}
		return fq;
	}

	public static double[] byteToDouble(byte[] buffer) {
		
		double[]arr = new double[buffer.length];
		for(int i = 0; i < buffer.length;i++){
			arr[i] = buffer[i];
		}
		return arr;
	}

	public static double pythagorian(double r, double i){
		return Math.sqrt(((r*r)+(i*i)));
		
	}
}