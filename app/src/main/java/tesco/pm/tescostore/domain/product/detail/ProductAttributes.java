package tesco.pm.tescostore.domain.product.detail;

/**
 * Created by pmodi4 on 8/13/2017.
 */

public class ProductAttributes
{
    private Category[] category;

    public Category[] getCategory ()
    {
        return category;
    }

    public void setCategory (Category[] category)
    {
        this.category = category;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [category = "+category+"]";
    }
}
