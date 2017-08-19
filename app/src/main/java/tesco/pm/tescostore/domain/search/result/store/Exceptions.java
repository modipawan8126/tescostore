/* Copyright 2017 freecodeformat.com */
package tesco.pm.tescostore.domain.search.result.store;
import java.util.Date;

/* Time: 2017-08-19 16:47:34 @author freecodeformat.com @website http://www.freecodeformat.com/json2javabean.php */
public class Exceptions {

    private Date date;
    private Hours hours;
    public void setDate(Date date) {
         this.date = date;
     }
     public Date getDate() {
         return date;
     }

    public void setHours(Hours hours) {
         this.hours = hours;
     }
     public Hours getHours() {
         return hours;
     }

}