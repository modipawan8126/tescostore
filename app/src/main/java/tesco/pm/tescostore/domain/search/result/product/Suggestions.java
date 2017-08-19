package tesco.pm.tescostore.domain.search.result.product;

/**
 * Created by pmodi4 on 8/12/2017.
 */

public class Suggestions
{
    private String text;

    private String freq;

    private String score;

    public String getText ()
    {
        return text;
    }

    public void setText (String text)
    {
        this.text = text;
    }

    public String getFreq ()
    {
        return freq;
    }

    public void setFreq (String freq)
    {
        this.freq = freq;
    }

    public String getScore ()
    {
        return score;
    }

    public void setScore (String score)
    {
        this.score = score;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [text = "+text+", freq = "+freq+", score = "+score+"]";
    }
}

