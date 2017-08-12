package tesco.pm.tescostore.domain.search.result;

/**
 * Created by pmodi4 on 8/12/2017.
 */

public class Results
{
    private String ContentsMeasureType;

    private String unitprice;

    private String price;

    private String UnitQuantity;

    private String[] description;

    private String AverageSellingUnitWeight;

    private String name;

    private String UnitOfSale;

    private String image;

    private String ContentsQuantity;

    private String tpnb;

    public String getContentsMeasureType ()
    {
        return ContentsMeasureType;
    }

    public void setContentsMeasureType (String ContentsMeasureType)
    {
        this.ContentsMeasureType = ContentsMeasureType;
    }

    public String getUnitprice ()
    {
        return unitprice;
    }

    public void setUnitprice (String unitprice)
    {
        this.unitprice = unitprice;
    }

    public String getPrice ()
    {
        return price;
    }

    public void setPrice (String price)
    {
        this.price = price;
    }

    public String getUnitQuantity ()
    {
        return UnitQuantity;
    }

    public void setUnitQuantity (String UnitQuantity)
    {
        this.UnitQuantity = UnitQuantity;
    }

    public String[] getDescription ()
    {
        return description;
    }

    public void setDescription (String[] description)
    {
        this.description = description;
    }

    public String getAverageSellingUnitWeight ()
    {
        return AverageSellingUnitWeight;
    }

    public void setAverageSellingUnitWeight (String AverageSellingUnitWeight)
    {
        this.AverageSellingUnitWeight = AverageSellingUnitWeight;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getUnitOfSale ()
    {
        return UnitOfSale;
    }

    public void setUnitOfSale (String UnitOfSale)
    {
        this.UnitOfSale = UnitOfSale;
    }

    public String getImage ()
    {
        return image;
    }

    public void setImage (String image)
    {
        this.image = image;
    }

    public String getContentsQuantity ()
    {
        return ContentsQuantity;
    }

    public void setContentsQuantity (String ContentsQuantity)
    {
        this.ContentsQuantity = ContentsQuantity;
    }

    public String getTpnb ()
    {
        return tpnb;
    }

    public void setTpnb (String tpnb)
    {
        this.tpnb = tpnb;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ContentsMeasureType = "+ContentsMeasureType+", unitprice = "+unitprice+", price = "+price+", UnitQuantity = "+UnitQuantity+", description = "+description+", AverageSellingUnitWeight = "+AverageSellingUnitWeight+", name = "+name+", UnitOfSale = "+UnitOfSale+", image = "+image+", ContentsQuantity = "+ContentsQuantity+", tpnb = "+tpnb+"]";
    }
}


