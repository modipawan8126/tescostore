package tesco.pm.tescostore.adapter;

/**
 * Created by pmodi4 on 8/15/2017.
 */

public class ProductAttributeObject {
    private String key;
    private String value;
    private String attributeType;

    public ProductAttributeObject(String k, String v, String at) {
        key = k;
        value = v;
        attributeType = at;
    }

    public ProductAttributeObject() {

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(String attributeType) {
        this.attributeType = attributeType;
    }


}
