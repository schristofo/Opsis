package opsis;

import java.util.Arrays;

public class Point{

  String name;
  double []x;
  double []y;
  
  public Point(){
    name = "";
    x = new double[1];
    y = new double[1];
  }
  public Point(double[] y , double[] x){
    name = "";
    this.x = x;
    this.y = y;
  }
  public Point(String name , double[] y , double[] x){
    this.name = name;
    this.x = x;
    this.y = y;
  }

  public String getName(){
	if(name == "")
		return "n/a";
	else
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
  public void setX(double ...x){
    this.x = x;
  }
  public void setY(double ...y){
    this.y = y;
  }

}
