package tesco.pm.tescostore.domain.product.detail;

/**
 * Created by pmodi4 on 8/13/2017.
 */

public class Category
{
    private Cooking_instructions[] cooking_instructions;

    private Lifestyle[] lifestyle;

    private Recipe_info recipe_info;

    public Cooking_instructions[] getCooking_instructions ()
    {
        return cooking_instructions;
    }

    public void setCooking_instructions (Cooking_instructions[] cooking_instructions)
    {
        this.cooking_instructions = cooking_instructions;
    }

    public Lifestyle[] getLifestyle ()
    {
        return lifestyle;
    }

    public void setLifestyle (Lifestyle[] lifestyle)
    {
        this.lifestyle = lifestyle;
    }

    public Recipe_info getRecipe_info ()
    {
        return recipe_info;
    }

    public void setRecipe_info (Recipe_info recipe_info)
    {
        this.recipe_info = recipe_info;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [cooking_instructions = "+cooking_instructions+", lifestyle = "+lifestyle+", recipe_info = "+recipe_info+"]";
    }
}
