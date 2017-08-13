package tesco.pm.tescostore.domain.product.detail;

/**
 * Created by pmodi4 on 8/13/2017.
 */

public class AllergenAdvice
{
    private String allergenText;

    private Allergens[] allergens;

    public String getAllergenText ()
    {
        return allergenText;
    }

    public void setAllergenText (String allergenText)
    {
        this.allergenText = allergenText;
    }

    public Allergens[] getAllergens ()
    {
        return allergens;
    }

    public void setAllergens (Allergens[] allergens)
    {
        this.allergens = allergens;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [allergenText = "+allergenText+", allergens = "+allergens+"]";
    }
}
