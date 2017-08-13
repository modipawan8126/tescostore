package tesco.pm.tescostore.domain.product.detail;

/**
 * Created by pmodi4 on 8/13/2017.
 */

public class Values
{
    private String percent;

    private String[] values;

    private String name;

    public String getPercent ()
    {
        return percent;
    }

    public void setPercent (String percent)
    {
        this.percent = percent;
    }

    public String[] getValues ()
    {
        return values;
    }

    public void setValues (String[] values)
    {
        this.values = values;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [percent = "+percent+", values = "+values+", name = "+name+"]";
    }
}
