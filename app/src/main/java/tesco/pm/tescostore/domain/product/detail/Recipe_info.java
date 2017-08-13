package tesco.pm.tescostore.domain.product.detail;

/**
 * Created by pmodi4 on 8/13/2017.
 */

public class Recipe_info
{
    private Recipes recipes;

    public Recipes getRecipes ()
    {
        return recipes;
    }

    public void setRecipes (Recipes recipes)
    {
        this.recipes = recipes;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [recipes = "+recipes+"]";
    }
}