/* Copyright 2017 freecodeformat.com */
package tesco.pm.tescostore.domain.search.result.store;
import java.util.List;

/* Time: 2017-08-19 16:47:34 @author freecodeformat.com @website http://www.freecodeformat.com/json2javabean.php */
public class Address {

    private List<Lines> lines;
    private String town;
    private String postcode;
    public void setLines(List<Lines> lines) {
         this.lines = lines;
     }
     public List<Lines> getLines() {
         return lines;
     }

    public void setTown(String town) {
         this.town = town;
     }
     public String getTown() {
         return town;
     }

    public void setPostcode(String postcode) {
         this.postcode = postcode;
     }
     public String getPostcode() {
         return postcode;
     }

}