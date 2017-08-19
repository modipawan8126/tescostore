/* Copyright 2017 freecodeformat.com */
package tesco.pm.tescostore.domain.search.result.store;

/* Time: 2017-08-19 16:47:34 @author freecodeformat.com @website http://www.freecodeformat.com/json2javabean.php */
public class Coordinates {

    private double longitude;
    private double latitude;
    public void setLongitude(double longitude) {
         this.longitude = longitude;
     }
     public double getLongitude() {
         return longitude;
     }

    public void setLatitude(double latitude) {
         this.latitude = latitude;
     }
     public double getLatitude() {
         return latitude;
     }

}