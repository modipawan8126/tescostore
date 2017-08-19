package tesco.pm.tescostore.domain.search.result.product;

/**
 * Created by pmodi4 on 8/12/2017.
 */

public class Uk
{
    private Ghs ghs;

    public Ghs getGhs ()
    {
        return ghs;
    }

    public void setGhs (Ghs ghs)
    {
        this.ghs = ghs;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ghs = "+ghs+"]";
    }
}