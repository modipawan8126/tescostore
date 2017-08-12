package tesco.pm.tescostore.domain.search.result;

/**
 * Created by pmodi4 on 8/12/2017.
 */

public class Products
{
    private Results[] results;

    private Totals totals;

    private Suggestions[] suggestions;

    private String queryPhase;

    public Results[] getResults ()
    {
        return results;
    }

    public void setResults (Results[] results)
    {
        this.results = results;
    }

    public Totals getTotals ()
    {
        return totals;
    }

    public void setTotals (Totals totals)
    {
        this.totals = totals;
    }

    public Suggestions[] getSuggestions ()
    {
        return suggestions;
    }

    public void setSuggestions (Suggestions[] suggestions)
    {
        this.suggestions = suggestions;
    }

    public String getQueryPhase ()
    {
        return queryPhase;
    }

    public void setQueryPhase (String queryPhase)
    {
        this.queryPhase = queryPhase;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [results = "+results+", totals = "+totals+", suggestions = "+suggestions+", queryPhase = "+queryPhase+"]";
    }
}