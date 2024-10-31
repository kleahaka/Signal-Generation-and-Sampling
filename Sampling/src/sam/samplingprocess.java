package sam;

		
		public class samplingprocess {

		    public static void main(String[] args) {
		        int frequency = 10;
		        int samples = 50; 
		        
		        
		        double[] sineSignal = generateSineSignal(frequency, samples);
		        double[] triangularSignal = generateTriangularSignal(frequency, samples);
		        double[] squareSignal = generateSquareSignal(frequency, samples);
		        
		        
		        double[] sampledSine = zeroOrderHoldSampling(sineSignal);
		        double[] sampledTriangular = zeroOrderHoldSampling(triangularSignal);
		        double[] sampledSquare = zeroOrderHoldSampling(squareSignal);
		        
	
		        System.out.println("Sampled Sine Signal:");
		        printSignal(sampledSine);
		        System.out.println("Mean Squared Error for Sine Signal: " + calculateMSE(sineSignal, sampledSine));
		        
		        System.out.println("\nSampled Triangular Signal:");
		        printSignal(sampledTriangular);
		        System.out.println("Mean Squared Error for Triangular Signal: " + calculateMSE(triangularSignal, sampledTriangular));
		        
		        System.out.println("\nSampled Square Signal:");
		        printSignal(sampledSquare);
		        System.out.println("Mean Squared Error for Square Signal: " + calculateMSE(squareSignal, sampledSquare));
		    }

		    
		    public static double[] generateSineSignal(int frequency, int samples) {
		        double[] signal = new double[samples];
		        double samplingInterval = 1.0 / samples;
		        
		        for (int i = 0; i < samples; i++) {
		            signal[i] = Math.sin(2 * Math.PI * frequency * i * samplingInterval);
		        }
		        return signal;
		    }

		    
		    public static double[] generateTriangularSignal(int frequency, int samples) {
		        double[] signal = new double[samples];
		        double samplingInterval = 1.0 / samples;
		        
		        for (int i = 0; i < samples; i++) {
		            signal[i] = 2 * Math.abs(2 * (i * samplingInterval * frequency - Math.floor(i * samplingInterval * frequency + 0.5))) - 1;
		        }
		        return signal;
		    }

		  
		    public static double[] generateSquareSignal(int frequency, int samples) {
		        double[] signal = new double[samples];
		        double samplingInterval = 1.0 / samples;
		        
		        for (int i = 0; i < samples; i++) {
		            signal[i] = Math.signum(Math.sin(2 * Math.PI * frequency * i * samplingInterval));
		        }
		        return signal;
		    }

		   
		    public static double[] zeroOrderHoldSampling(double[] signal) {
		        double[] sampledSignal = new double[signal.length];
		        
		        for (int i = 0; i < signal.length; i++) {
		            sampledSignal[i] = signal[i]; 
		        }
		        
		        return sampledSignal;
		    }

		 
		    public static double calculateMSE(double[] original, double[] sampled) {
		        double sum = 0.0;
		        for (int i = 0; i < original.length; i++) {
		            double error = original[i] - sampled[i];
		            sum += error * error;
		        }
		        return sum / original.length;
		    }

		
		    public static void printSignal(double[] signal) {
		        for (double value : signal) {
		            System.out.printf("%.2f ", value);
		        }
		        System.out.println();
		    }
		

	
	
	}


