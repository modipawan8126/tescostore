/* Copyright 2017 freecodeformat.com */
package tesco.pm.tescostore.domain.search.result.store;

/* Time: 2017-08-19 16:47:34 @author freecodeformat.com @website http://www.freecodeformat.com/json2javabean.php */
public class Lines {


    private int linenumber;
    private String text;
    public void setLinenumber(int linenumber) {
         this.linenumber = linenumber;
     }
     public int getLinenumber() {
         return linenumber;
     }

    public void setText(String text) {
         this.text = text;
     }
     public String getText() {
         return text;
     }

}