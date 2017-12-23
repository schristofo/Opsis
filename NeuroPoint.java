package opsis;

import java.util.Arrays;

public class NeuroPoint extends Point{

	double[] w;
	  
	public NeuroPoint(){
		super();
		w = null;
	}
	public NeuroPoint(double y , double[] x) {
		super(y,x);
		w = new double[x.length];
    	}
	public NeuroPoint(double[] y , double[] x){
		super(y,x);
		w = new double[x.length];
	}
	public NeuroPoint(String name , double[] y , double[] x){
		super(name,y,x);
		w = new double[x.length];
	}

	public double[] getWeight() {
	  return w;
    }
	
	public void generateWeights(double l , double h) {
		if(w.length != 0) {
			for(int i = 0 ; i < w.length; i++) {
				w[i] = (h-l) * Math.random() + l;
				System.out.println(w[i]);
			}
		}
	}
	
	private double[] dendrites() {

		double[] temp = new double[x.length];
		
		if(x.length != 0) {
			for(int i = 0; i < temp.length; i++) {
				temp[i] = w[i] * x[i];
			}
			return temp;
		}
		else {
			return null;
		}
	}
	
}