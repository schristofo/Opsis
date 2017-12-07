package mainpack;

import ailgorithm.HillClimb;
import opsis.Plithos;

public class Main {


	public static void main(String[] args) {
		Plithos humans = new Plithos();
		double[] x0 = {-1 , 1};
		double[] x1 = {0 , 5};
		double[] x2 = {7 , 3};
		double[] y0 = {3 , -4};
		double[] y1 = {9 , 0};
		double[] y2 = {0 , -2};

		humans.newPoint(y0 , x0);

		humans.newPoint(y1 , x1);
		
		humans.newPoint(y2 , x2);
		
		System.out.println("Average point: { " + humans.average().getY()[0] + ", " + humans.average().getY()[1] + "} , { " +  humans.average().getX()[0] + ", " + humans.average().getX()[1] + "}");
		
		HillClimb.climax(-3);
		HillClimb.evolveStatus(humans.getPoint(0), 0, humans.getPoint(1), humans.getPoint(2));
		
		

	}

}
