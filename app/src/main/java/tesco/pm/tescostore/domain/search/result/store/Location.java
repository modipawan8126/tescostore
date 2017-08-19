/* Copyright 2017 freecodeformat.com */
package tesco.pm.tescostore.domain.search.result.store;
import java.util.List;

/* Time: 2017-08-19 16:47:34 @author freecodeformat.com @website http://www.freecodeformat.com/json2javabean.php */
public class Location {

    private String id;
    private String name;

    private Altids altids;
    private Region region;
    private Contact contact;
    private Geo geo;
    private Classification classification;
    private Status status;

    private List<Openinghours> openinghours;
    private List<Facilities> facilities;
    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setAltids(Altids altids) {
         this.altids = altids;
     }
     public Altids getAltids() {
         return altids;
     }

    public void setRegion(Region region) {
         this.region = region;
     }
     public Region getRegion() {
         return region;
     }

    public void setContact(Contact contact) {
         this.contact = contact;
     }
     public Contact getContact() {
         return contact;
     }

    public void setGeo(Geo geo) {
         this.geo = geo;
     }
     public Geo getGeo() {
         return geo;
     }

    public void setClassification(Classification classification) {
         this.classification = classification;
     }
     public Classification getClassification() {
         return classification;
     }

    public void setStatus(Status status) {
         this.status = status;
     }
     public Status getStatus() {
         return status;
     }

    public void setOpeninghours(List<Openinghours> openinghours) {
         this.openinghours = openinghours;
     }
     public List<Openinghours> getOpeninghours() {
         return openinghours;
     }

    public void setFacilities(List<Facilities> facilities) {
         this.facilities = facilities;
     }
     public List<Facilities> getFacilities() {
         return facilities;
     }

}