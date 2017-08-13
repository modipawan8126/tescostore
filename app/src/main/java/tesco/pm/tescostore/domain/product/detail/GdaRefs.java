package tesco.pm.tescostore.domain.product.detail;

/**
 * Created by pmodi4 on 8/13/2017.
 */

public class GdaRefs
{
    private String[] headers;

    private Values[] values;

    private String[] footers;

    private String gdaDescription;

    public String[] getHeaders ()
    {
        return headers;
    }

    public void setHeaders (String[] headers)
    {
        this.headers = headers;
    }

    public Values[] getValues ()
    {
        return values;
    }

    public void setValues (Values[] values)
    {
        this.values = values;
    }

    public String[] getFooters ()
    {
        return footers;
    }

    public void setFooters (String[] footers)
    {
        this.footers = footers;
    }

    public String getGdaDescription ()
    {
        return gdaDescription;
    }

    public void setGdaDescription (String gdaDescription)
    {
        this.gdaDescription = gdaDescription;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [headers = "+headers+", values = "+values+", footers = "+footers+", gdaDescription = "+gdaDescription+"]";
    }
}
