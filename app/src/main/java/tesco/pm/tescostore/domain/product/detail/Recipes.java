package tesco.pm.tescostore.domain.product.detail;

/**
 * Created by pmodi4 on 8/13/2017.
 */

public class Recipes
{
    private String name;

    private String value;

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getValue ()
    {
        return value;
    }

    public void setValue (String value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [name = "+name+", value = "+value+"]";
    }
}


