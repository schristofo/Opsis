package opsis;

import java.util.Arrays;

public class Point{

  String name;
  double []y;
  double []x;
  
  public Point(){
    name = "";
    y = null;
    x = null;
  }
  public Point(double y , double[] x){
    name = "";
    this.y[0] = y;
    this.x = x;
  }
  public Point(double[] y , double[] x){
    name = "";
    this.y = y;
    this.x = x;
  }
  public Point(String name , double[] y , double[] x){
    this.name = name;
    this.x = x;
    this.y = y;
  }
	
  public String getName(){
	  return name;
  }
  public double[] getY() {
	  return y;
  }
  public double[] getX() {
	  return x;
  }
  public double[] getYX(){
      double[] result = Arrays.copyOf(y, y.length + x.length);
      System.arraycopy(x, 0, result, y.length, x.length);
      return result;
  }

  public void setName(String name){
    this.name = name;
  }
  public void setY(double ...y){
    this.y = y;
  }
  public void setX(double ...x){
    this.x = x;
  }

}
