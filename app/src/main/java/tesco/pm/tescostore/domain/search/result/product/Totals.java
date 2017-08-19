package tesco.pm.tescostore.domain.search.result.product;

/**
 * Created by pmodi4 on 8/12/2017.
 */

public class Totals
{
    //private String new;

    private String offer;

    private String all;

    /*public String getNew ()
    {
        return new;
    }

    public void setNew (String new)
    {
        this.new = new;
    }*/

    public String getOffer ()
    {
        return offer;
    }

    public void setOffer (String offer)
    {
        this.offer = offer;
    }

    public String getAll ()
    {
        return all;
    }

    public void setAll (String all)
    {
        this.all = all;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [offer = "+offer+", all = "+all+"]";
    }
}