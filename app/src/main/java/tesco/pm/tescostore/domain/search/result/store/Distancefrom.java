/* Copyright 2017 freecodeformat.com */
package tesco.pm.tescostore.domain.search.result.store;

/* Time: 2017-08-19 16:47:34 @author freecodeformat.com @website http://www.freecodeformat.com/json2javabean.php */
public class Distancefrom {

    private String unit;
    private double value;
    public void setUnit(String unit) {
         this.unit = unit;
     }
     public String getUnit() {
         return unit;
     }

    public void setValue(double value) {
         this.value = value;
     }
     public double getValue() {
         return value;
     }

}