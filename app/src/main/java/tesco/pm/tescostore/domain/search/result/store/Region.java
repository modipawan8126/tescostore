/* Copyright 2017 freecodeformat.com */
package tesco.pm.tescostore.domain.search.result.store;

/* Time: 2017-08-19 16:47:34 @author freecodeformat.com @website http://www.freecodeformat.com/json2javabean.php */
public class Region {


    private String isocountrycode;

    private String isosubdivision;
    public void setIsocountrycode(String isocountrycode) {
         this.isocountrycode = isocountrycode;
     }
     public String getIsocountrycode() {
         return isocountrycode;
     }

    public void setIsosubdivision(String isosubdivision) {
         this.isosubdivision = isosubdivision;
     }
     public String getIsosubdivision() {
         return isosubdivision;
     }

}