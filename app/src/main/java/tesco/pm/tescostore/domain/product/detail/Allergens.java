package tesco.pm.tescostore.domain.product.detail;

/**
 * Created by pmodi4 on 8/13/2017.
 */

public class Allergens
{
    private String[] allergenValues;

    private String allergenName;

    public String[] getAllergenValues ()
    {
        return allergenValues;
    }

    public void setAllergenValues (String[] allergenValues)
    {
        this.allergenValues = allergenValues;
    }

    public String getAllergenName ()
    {
        return allergenName;
    }

    public void setAllergenName (String allergenName)
    {
        this.allergenName = allergenName;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [allergenValues = "+allergenValues+", allergenName = "+allergenName+"]";
    }
}
