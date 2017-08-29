package tesco.pm.tescostore.identity;

/**
 * Created by has7 on 8/29/2017.
 */

public class Claims {
    private String claimType;

    private String value;

    public String getClaimType ()
    {
        return claimType;
    }

    public void setClaimType (String claimType)
    {
        this.claimType = claimType;
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
        return "ClassPojo [claimType = "+claimType+", value = "+value+"]";
    }
}
