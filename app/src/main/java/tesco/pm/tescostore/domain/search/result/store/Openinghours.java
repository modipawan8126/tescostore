/* Copyright 2017 freecodeformat.com */
package tesco.pm.tescostore.domain.search.result.store;

/* Time: 2017-08-19 16:47:34 @author freecodeformat.com @website http://www.freecodeformat.com/json2javabean.php */
public class Openinghours {

    private String type;

    private Standardopeninghours standardopeninghours;
    public void setType(String type) {
         this.type = type;
     }
     public String getType() {
         return type;
     }

    public void setStandardopeninghours(Standardopeninghours standardopeninghours) {
         this.standardopeninghours = standardopeninghours;
     }
     public Standardopeninghours getStandardopeninghours() {
         return standardopeninghours;
     }

}