package ailgorithm;

import opsis.Point;
import java.util.ArrayList;

public class PointNN {
	
	int numOfInput;
	int numOfOutput;
	int numOfLayers;
	int[] neuronsPerLayer;
	ArrayList<Point>[] neurons;
	
	public PointNN() {
		numOfInput=0;
		numOfOutput=0;
		numOfLayers=0;
		neuronsPerLayer=null;
		for(int i = 0; i < numOfLayers; i++)	
		 neurons[i]=new ArrayList<Point>();
	}
	public PointNN(int out, int in, int ...l) {
		numOfOutput= out;
		numOfInput= in;
		numOfLayers= l.length;
		neuronsPerLayer= l;
		for(int i = 0; i < numOfLayers; i++)	
		 neurons[i]=new ArrayList<Point>(neuronsPerLayer[i]);
	}
}
