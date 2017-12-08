package opsis;

import java.util.ArrayList;

//Class that contains an ArrayList of Points with number of Xs' : numOfX and number of Ys' : numOfY
public class Plithos{
  ArrayList<Point> points;
  static int numOfY = -1 , numOfX = -1;

  public Plithos(){
    points = new ArrayList<Point>();
  }
  public Plithos(int n){
    points = new ArrayList<Point>(n);
  }
  
  public int getNumOfY() {
	  return numOfY;
  }
  public int getNumOfX() {
	  return numOfX;
  }
  
  public Point getPoint(int k) {
	  return points.get(k);
  }

  public void newPoint(){		//Function adding a point without parameters : O(0,0)
    if(numOfX == -1 || numOfY == -1){
      numOfY = 1;
      numOfX = 1;
    }
    if(numOfY != 1 || numOfX != 1){
      System.out.println("Error: Data points not compatible");
      return;
    }

    Point temp = new Point();
    points.add(temp);
    points.ensureCapacity(points.size()+1);
  }

  public void newPoint(double[] y , double[] x){		//Function adding a point with X and Y
    if(numOfX == -1 || numOfY == -1){
      numOfY = y.length;
      numOfX = x.length;
    }
    if(y.length != numOfY || x.length != numOfX){
      System.out.println("Error: Data points not compatible");
      return;
    }

    Point temp = new Point(y , x);
    points.add(temp);
    points.ensureCapacity(points.size()+1);
  }

  public void newPoint(String name, double[] y , double[] x){		//Function adding a point with name
    if(numOfX == -1 || numOfY == -1){
      numOfY = y.length;
      numOfX = x.length;
    }
    if(y.length != numOfY || x.length != numOfX){
      System.out.println("Error: Data points not compatible");
      return;
    }

    Point temp = new Point(name , y , x);
    points.add(temp);
    points.ensureCapacity(points.size()+1);
  }
  
  public double[] derOf(int a, int b) {		//Function returning the total derivative of each y
	  int xs = points.get(a).getX().length;
	  int ys = points.get(a).getY().length;
	  
	  double []temp = new double[ys];
	  
	  for(int i = 0 ; i < ys ; i++)		//initialization of temp
		  temp[i] = 0;
	  
	  double[][] ders = new double[ys][xs];		//partial derivatives
	  
	  for(int i = 0 ; i < ys ; i++) {
		  for(int j = 0 ; j < xs ; j++) 
			  ders[i][j] = (double) (points.get(b).getY()[i] - points.get(a).getY()[i]) / (double) (points.get(b).getX()[j] - points.get(a).getX()[j]);		//calculating ders
	  }
	  
	  for(int i = 0 ; i < ys ; i++) {		//partial ders -> total derivative
		  for(int j = 0 ; j < xs ; j++) 
			  temp[i] += ders[i][j];
	  }
	  return temp;
  }
  
  public double xDistance(int a , int b) {		//Fuction returning the distance between two point Xs
	  
	  double temp = 0;
	  
	  for(int i = 0; i < numOfX; i ++) {
		  temp += (points.get(a).getX()[i] - points.get(b).getX()[i]) * (points.get(a).getX()[i] - points.get(b).getX()[i]);
	  }
	  
	  temp = Math.sqrt(temp);
	  
	  return temp;
  }
  
  public double yDistance(int a , int b) {		//Fuction returning the distance between two point Ys
	  
	  double temp = 0;
	  
	  for(int i = 0; i < numOfY; i ++) {
		  temp += (points.get(a).getY()[i] - points.get(b).getY()[i]) * (points.get(a).getY()[i] - points.get(b).getY()[i]);
	  }
	  
	  temp = Math.sqrt(temp);
	  
	  return temp;
  }
  
  public Point average() {
	  double[] avX = new double[numOfX];
	  double[] avY = new double[numOfY];
	  
	  for(int i = 0 ; i < numOfX; i++) {		//Array initialization
		  avX[i] = 0;
	  }
	  for(int i = 0 ; i < numOfY; i++) {
		  avY[i] = 0;
	  }
	  
	  for(int i = 0 ; i < numOfX; i++) {
		  for(int j = 0 ; j < points.size() ; j++)
			  avX[i] += points.get(j).getX()[i];
		  avX[i] /= points.size();
	  }
	  for(int i = 0 ; i < numOfY; i++) {
		  for(int j = 0 ; j < points.size() ; j++)
			  avY[i] += points.get(j).getY()[i];
		  avY[i] /= points.size();
	  }
	 
	  return new Point(avY , avX);
	  }

}

