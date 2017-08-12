package tesco.pm.tescostore.domain.search.result;

/**
 * Created by pmodi4 on 8/12/2017.
 */

public class Ghs
{
    private Products products;

    public Products getProducts ()
    {
        return products;
    }

    public void setProducts (Products products)
    {
        this.products = products;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [products = "+products+"]";
    }
}