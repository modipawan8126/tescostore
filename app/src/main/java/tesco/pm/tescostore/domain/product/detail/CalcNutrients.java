package tesco.pm.tescostore.domain.product.detail;

/**
 * Created by pmodi4 on 8/13/2017.
 */

public class CalcNutrients
{
    private String valuePer100;

    private String valuePerServing;

    private String name;

    public String getValuePer100 ()
    {
        return valuePer100;
    }

    public void setValuePer100 (String valuePer100)
    {
        this.valuePer100 = valuePer100;
    }

    public String getValuePerServing ()
    {
        return valuePerServing;
    }

    public void setValuePerServing (String valuePerServing)
    {
        this.valuePerServing = valuePerServing;
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
        return "ClassPojo [valuePer100 = "+valuePer100+", valuePerServing = "+valuePerServing+", name = "+name+"]";
    }
}