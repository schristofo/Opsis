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

  public Point(String fileString) {
    String fileLoc = fileString;
    BufferedReader buf = null;
    String line = "";
    String cvsSplitBy = ",";
	  
    try {

      buf = new BufferedReader(new FileReader(fileLoc));
      line = buf.readLine();

          // use comma as separator
      String[] ingre = line.split(cvsSplitBy);
          
      int numOfY = Integer.parseInt(ingre[0]);
      double[] ys = new double[numOfY];
      double[] xs = new double[ingre.length-numOfY];
          
      for(int i = 0 ; i < numOfY; i++) {
          ys[i] = Double.parseDouble(ingre[i+1]);
      }
      for(int i = numOfY ; i < ingre.length; i++) {
          xs[i-numOfY] = Double.parseDouble(ingre[i]);
      }
          
      y = ys;
      x = xs;

  } catch (FileNotFoundException e) {
     e.printStackTrace();
  } catch (IOException e) {
     e.printStackTrace();
  } finally {
      if (buf != null) {
          try {
              buf.close();
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
  }
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
