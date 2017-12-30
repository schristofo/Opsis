package opsis;

import java.util.Arrays;

public class NeuroPoint extends Point{

	double[] w;
	double y;
	  
	public NeuroPoint(){
		super();
		w = null;
		y = 0;
	}
	public NeuroPoint(double y , double[] x) {
		super(x);
		this.y = y;
		w = new double[x.length];
    	}
	public NeuroPoint(String name , double y , double[] x){
		super(name,x);
		w = new double[x.length];
		this.y = y;
	}

	public double[] getWeight() {
		return w;
    }
	public double getY() {
		return y;
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
