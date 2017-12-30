package opsis;

import java.util.ArrayList;

//Class that contains an ArrayList of Points with number of Xs' : numOfX and number of Ys' : numOfY
public class Plithos{
  ArrayList<Point> points;
  int numOfX = -1;

  public Plithos(){
    points = new ArrayList<Point>();
  }
  public Plithos(int n){
    points = new ArrayList<Point>(n);
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
		  for(int j = 0 ; j < numOfX ; j++)
			  System.out.print("x" + j + "=" + points.get(i).getX()[j] + "  ");
		  System.out.print("} ");
		
		  if(points.get(i).getName() != "") 
			  System.out.println(points.get(i).getName());
		  else
			  System.out.println();
	  }
	  
  }

  public void newPoint(){		//Function adding a point without parameters : O(0,0)
    if(numOfX == -1){
      numOfX = 1;
    }
    if(numOfX != 1){
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
  public void newPoint(double[] x){		//Function adding a point with X and Y
    if(numOfX == -1){
      numOfX = x.length;
    }
    if(x.length != numOfX){
      System.out.println("Error: Data points not compatible");
      return;
    }

    Point temp = new Point(x);
    points.add(temp);
    points.ensureCapacity(points.size()+1);
  }
  public void newPoint(String name, double[] y , double[] x){		//Function adding a point with name
    if(numOfX == -1){
      numOfX = x.length;
    }
    if(x.length != numOfX){
      System.out.println("Error: Data points not compatible");
      return;
    }

    Point temp = new Point(name , x);
    points.add(temp);
    points.ensureCapacity(points.size()+1);
  }
  
  public double xDistance(int a , int b) {		//Function returning the distance between two point Xs
	  
	  double temp = 0;
	  
	  for(int i = 0; i < numOfX; i ++) {
		  temp += (points.get(a).getX()[i] - points.get(b).getX()[i]) * (points.get(a).getX()[i] - points.get(b).getX()[i]);
	  }
	  
	  temp = Math.sqrt(temp);
	  
	  return temp;
  }
  public double xDistance(int a , Point p) {		//Function returning the distance between two point Xs
	  
	  double temp = 0;
	  if(p.getX().length != numOfX) {
		  return -1;  
	  }
	  else{
		  for(int i = 0; i < numOfX; i ++) {
			  temp += (points.get(a).getX()[i] - p.getX()[i]) * (points.get(a).getX()[i] - p.getX()[i]);
	  	  }
	  	  temp = Math.sqrt(temp);
	  	  return temp;
  	  }
  }
  
  public Point average() {		//Function calculating the average point
	  double[] avX = new double[numOfX];
	  
	  for(int i = 0 ; i < numOfX; i++) {		//Array initialization
		  avX[i] = 0;
	  }
	  
	  for(int i = 0 ; i < numOfX; i++) {
		  for(int j = 0 ; j < points.size() ; j++)
			  avX[i] += points.get(j).getX()[i];
		  avX[i] /= points.size();
	  }
	 
	  return new Point(avX);
  }
  
  public void defineSphere(String s, Point p, double radius) {
	  for(int i = 0 ; i < points.size(); i++) {
		  if(xDistance(i,p) < radius && xDistance(i,p) >= 0)
			 points.get(i).setName(s); 
	  }
  }

}
