/* Copyright 2017 freecodeformat.com */
package tesco.pm.tescostore.domain.search.result.store;
import java.util.ArrayList;
import java.util.List;

/* Time: 2017-08-19 16:47:34 @author freecodeformat.com @website http://www.freecodeformat.com/json2javabean.php */
public class Contact {


    private Address address;

    public Address getAddress() { return this.address; }

    public void setAddress(Address address) { this.address = address; }

    private ArrayList<PhoneNumber> phoneNumbers;

    public ArrayList<PhoneNumber> getPhoneNumbers() { return this.phoneNumbers; }

    public void setPhoneNumbers(ArrayList<PhoneNumber> phoneNumbers) { this.phoneNumbers = phoneNumbers; }

    private CommunityChampion communityChampion;

    public CommunityChampion getCommunityChampion() { return this.communityChampion; }

    public void setCommunityChampion(CommunityChampion communityChampion) { this.communityChampion = communityChampion; }

}