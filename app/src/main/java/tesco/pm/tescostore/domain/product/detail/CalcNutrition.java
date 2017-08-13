package tesco.pm.tescostore.domain.product.detail;

/**
 * Created by pmodi4 on 8/13/2017.
 */

public class CalcNutrition
{
    private String per100Header;

    private String perServingHeader;

    private CalcNutrients[] calcNutrients;

    public String getPer100Header ()
    {
        return per100Header;
    }

    public void setPer100Header (String per100Header)
    {
        this.per100Header = per100Header;
    }

    public String getPerServingHeader ()
    {
        return perServingHeader;
    }

    public void setPerServingHeader (String perServingHeader)
    {
        this.perServingHeader = perServingHeader;
    }

    public CalcNutrients[] getCalcNutrients ()
    {
        return calcNutrients;
    }

    public void setCalcNutrients (CalcNutrients[] calcNutrients)
    {
        this.calcNutrients = calcNutrients;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [per100Header = "+per100Header+", perServingHeader = "+perServingHeader+", calcNutrients = "+calcNutrients+"]";
    }
}
