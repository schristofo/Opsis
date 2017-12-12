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
  public int size() {
	  if(!points.isEmpty())
		  return points.size();
	  else return 0;
  }
  
  public void status() {
	  for(int i = 0 ; i < this.size(); i++) {
		  System.out.print("point " + i + ": {  ");
		  for(int j = 0 ; j < numOfY ; j++)
			  System.out.print("y" + j + "=" + points.get(i).getY()[j] + "  ");
		  System.out.print(" } , {  ");
		  for(int j = 0 ; j < numOfX ; j++)
			  System.out.print("x" + j + "=" + points.get(i).getX()[j] + "  ");
		  System.out.println("}");
	  }
	  
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
  public void newPoint(Point p) {
	  points.add(p);
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
