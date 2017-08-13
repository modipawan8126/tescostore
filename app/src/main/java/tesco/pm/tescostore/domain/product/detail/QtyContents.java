package tesco.pm.tescostore.domain.product.detail;

/**
 * Created by pmodi4 on 8/13/2017.
 */

public class QtyContents
{
    private String totalQuantity;

    private String quantityUom;

    private String quantity;

    private String netContents;

    public String getTotalQuantity ()
    {
        return totalQuantity;
    }

    public void setTotalQuantity (String totalQuantity)
    {
        this.totalQuantity = totalQuantity;
    }

    public String getQuantityUom ()
    {
        return quantityUom;
    }

    public void setQuantityUom (String quantityUom)
    {
        this.quantityUom = quantityUom;
    }

    public String getQuantity ()
    {
        return quantity;
    }

    public void setQuantity (String quantity)
    {
        this.quantity = quantity;
    }

    public String getNetContents ()
    {
        return netContents;
    }

    public void setNetContents (String netContents)
    {
        this.netContents = netContents;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [totalQuantity = "+totalQuantity+", quantityUom = "+quantityUom+", quantity = "+quantity+", netContents = "+netContents+"]";
    }
}