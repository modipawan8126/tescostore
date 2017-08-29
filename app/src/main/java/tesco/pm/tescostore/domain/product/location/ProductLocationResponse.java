package tesco.pm.tescostore.domain.product.location;

/**
 * Created by has7 on 8/29/2017.
 */

public class ProductLocationResponse {
    private String productNumber;

    private String shelfNumber;

    private String floorCode;

    private String productPosition;

    private String aisle;

    private String capacity;

    private String facings;

    private String aisleOrientation;

    private String moduleNumber;

    public String getProductNumber ()
    {
        return productNumber;
    }

    public void setProductNumber (String productNumber)
    {
        this.productNumber = productNumber;
    }

    public String getShelfNumber ()
    {
        return shelfNumber;
    }

    public void setShelfNumber (String shelfNumber)
    {
        this.shelfNumber = shelfNumber;
    }

    public String getFloorCode ()
    {
        return floorCode;
    }

    public void setFloorCode (String floorCode)
    {
        this.floorCode = floorCode;
    }

    public String getProductPosition ()
    {
        return productPosition;
    }

    public void setProductPosition (String productPosition)
    {
        this.productPosition = productPosition;
    }

    public String getAisle ()
    {
        return aisle;
    }

    public void setAisle (String aisle)
    {
        this.aisle = aisle;
    }

    public String getCapacity ()
    {
        return capacity;
    }

    public void setCapacity (String capacity)
    {
        this.capacity = capacity;
    }

    public String getFacings ()
    {
        return facings;
    }

    public void setFacings (String facings)
    {
        this.facings = facings;
    }

    public String getAisleOrientation ()
    {
        return aisleOrientation;
    }

    public void setAisleOrientation (String aisleOrientation)
    {
        this.aisleOrientation = aisleOrientation;
    }

    public String getModuleNumber ()
    {
        return moduleNumber;
    }

    public void setModuleNumber (String moduleNumber)
    {
        this.moduleNumber = moduleNumber;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [productNumber = "+productNumber+", shelfNumber = "+shelfNumber+", floorCode = "+floorCode+", productPosition = "+productPosition+", aisle = "+aisle+", capacity = "+capacity+", facings = "+facings+", aisleOrientation = "+aisleOrientation+", moduleNumber = "+moduleNumber+"]";
    }
}
