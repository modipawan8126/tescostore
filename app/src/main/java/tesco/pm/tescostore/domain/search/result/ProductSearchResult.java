package tesco.pm.tescostore.domain.search.result;

/**
 * Created by pmodi4 on 8/12/2017.
 */

public class ProductSearchResult {
    private Uk uk;

    public Uk getUk ()
    {
        return uk;
    }

    public void setUk (Uk uk)
    {
        this.uk = uk;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [uk = "+uk+"]";
    }
}
