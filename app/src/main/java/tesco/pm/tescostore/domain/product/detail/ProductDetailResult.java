package tesco.pm.tescostore.domain.product.detail;

/**
 * Created by pmodi4 on 8/13/2017.
 */

public class ProductDetailResult {
    private Products[] products;

    public Products[] getProducts ()
    {
        return products;
    }

    public void setProducts (Products[] products)
    {
        this.products = products;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [products = "+products+"]";
    }
}
