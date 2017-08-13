package tesco.pm.tescostore.domain.product.detail;

/**
 * Created by pmodi4 on 8/13/2017.
 */

public class Gda
{
    private GdaRefs[] gdaRefs;

    public GdaRefs[] getGdaRefs ()
    {
        return gdaRefs;
    }

    public void setGdaRefs (GdaRefs[] gdaRefs)
    {
        this.gdaRefs = gdaRefs;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [gdaRefs = "+gdaRefs+"]";
    }
}
