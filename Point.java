package opsis;

import java.util.Arrays;

public class Point {

  String name;
  double[] x;
  
  public Point(){
      name = "";
      x = null;
  }
  public Point(double[] x) {
      name = "";
      this.x = x;
  }
  public Point(String name, double[] x){
      this.name = name;
      this.x = x;
  }


  public String getName(){
	  return name;
  }
  public double[] getX() {
	  return x;
  }
  public double getXNumber(int n){
	  if(n >= 0 && n < x.length)
		  return x[n];
	  else {
		  System.out.println("Element out of array length");
		  return 0;
	  }
  }
  
  public void setName(String name){
      this.name = name;
  }
  public void setX(double ...x){
      this.x = x;
  }
  public void setXNumber(int n, double d) {
	  if(n >= 0 && n < x.length)
		  x[n] = d;
  }
  
  public double distance(Point p) {
	  double temp = 0;
	  
	  if(p.getX().length != x.length) {
		  return -1;  
	  }
	  else{
		  for(int i = 0; i < x.length; i ++) {
			  temp += (x[i] - p.getX()[i]) * (x[i] - p.getX()[i]);
	  	  }
	  	  temp = Math.sqrt(temp);
	  	  return temp;
  	  }
  }

}
