/* Copyright 2017 freecodeformat.com */
package tesco.pm.tescostore.domain.search.result.store;

/* Time: 2017-08-19 16:47:34 @author freecodeformat.com @website http://www.freecodeformat.com/json2javabean.php */
public class Results {

    private Location location;
    //@JsonProperty("distanceFrom")
    private Distancefrom distancefrom;
    public void setLocation(Location location) {
         this.location = location;
     }
     public Location getLocation() {
         return location;
     }

    public void setDistancefrom(Distancefrom distancefrom) {
         this.distancefrom = distancefrom;
     }
     public Distancefrom getDistancefrom() {
         return distancefrom;
     }

}