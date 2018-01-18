package opsis;


public class NeuroPoint extends Point{

	double[] w;
	double y;
	  
	public NeuroPoint(){
		super();
		w = null;
		y = 0;
	}
	public NeuroPoint(double[] x) {
		super(x);
		w = new double[x.length];
		y = activate();
    }

	//getters
	public double[] getWeight() {
		return w;
    }
	public double getY() {
		return y = activate();
	}
	
	public void generateWeights(double l , double h) {			//generate random weights
		if(w.length != 0) {
			for(int i = 0 ; i < w.length; i++) {
				w[i] = (h-l) * Math.random() + l;
				System.out.println(w[i]);
			}
		}
	}
	
	private double dendritis(int i) {				//each branch/input weighted
		return w[i] * x[i];
	}
	
	private double sum() {				//sum of all branches weighted
		double ytemp=0;
		for(int i = 0 ; i < x.length; i++) {
			ytemp += dendritis(i);
		}
		return ytemp;
	}
	
	private double activate() {				//activation function return to y
		return (sum())/(Math.sqrt(1+sum()*sum()));
	}
	
}
