/* Copyright 2017 freecodeformat.com */
package tesco.pm.tescostore.domain.search.result.store;
import java.util.List;
/* Time: 2017-08-19 16:47:34 @author freecodeformat.com @website http://www.freecodeformat.com/json2javabean.php */
public class Facilities {

    private String name;
    private List<String> tags;
    private List<Openinghours> openinghours;
    private String description;
    private Contact contact;
    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setTags(List<String> tags) {
         this.tags = tags;
     }
     public List<String> getTags() {
         return tags;
     }

    public void setOpeninghours(List<Openinghours> openinghours) {
         this.openinghours = openinghours;
     }
     public List<Openinghours> getOpeninghours() {
         return openinghours;
     }

    public void setDescription(String description) {
         this.description = description;
     }
     public String getDescription() {
         return description;
     }

    public void setContact(Contact contact) {
         this.contact = contact;
     }
     public Contact getContact() {
         return contact;
     }

}