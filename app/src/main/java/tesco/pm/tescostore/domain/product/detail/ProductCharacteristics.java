package tesco.pm.tescostore.domain.product.detail;

/**
 * Created by pmodi4 on 8/13/2017.
 */

public class ProductCharacteristics
{
    private String storageType;

    private String isDrink;

    private String healthScore;

    private String isHazardous;

    private String isFood;

    public String getStorageType ()
    {
        return storageType;
    }

    public void setStorageType (String storageType)
    {
        this.storageType = storageType;
    }

    public String getIsDrink ()
    {
        return isDrink;
    }

    public void setIsDrink (String isDrink)
    {
        this.isDrink = isDrink;
    }

    public String getHealthScore ()
    {
        return healthScore;
    }

    public void setHealthScore (String healthScore)
    {
        this.healthScore = healthScore;
    }

    public String getIsHazardous ()
    {
        return isHazardous;
    }

    public void setIsHazardous (String isHazardous)
    {
        this.isHazardous = isHazardous;
    }

    public String getIsFood ()
    {
        return isFood;
    }

    public void setIsFood (String isFood)
    {
        this.isFood = isFood;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [storageType = "+storageType+", isDrink = "+isDrink+", healthScore = "+healthScore+", isHazardous = "+isHazardous+", isFood = "+isFood+"]";
    }
}