package ailgorithm;

import opsis.Point;

public class HillClimb {
	
	static int cl = 10;
	
	//Climax setter
	public static void climax(int c) {
		if(c > 0)
			cl = c;
	}

	//Evolve to a new point according to a particular y
	public static void evolveStatus(Point a , int indexOfY, Point ...b) {
		
		double[] f = new double[b.length];
		int i = 0;
		
		for(Point p : b) {
			
			f[i] = Math.exp(((double)p.getY()[indexOfY] - (double)a.getY()[indexOfY]) / cl );
			if(f[i] >= 1) 
				f[i] = 1;		
			i++;
		}
		
		for(i = 0 ; i < f.length ; i++)
			System.out.println("Point " + i + ": " + f[i] + " possibility of evolving");
	}
	
}
