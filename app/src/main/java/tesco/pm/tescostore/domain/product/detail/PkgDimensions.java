package tesco.pm.tescostore.domain.product.detail;

/**
 * Created by pmodi4 on 8/13/2017.
 */

public class PkgDimensions
{
    private String volumeUom;

    private String weightUom;

    private String weight;

    private String height;

    private String no;

    private String width;

    private String volume;

    private String depth;

    private String dimensionUom;

    public String getVolumeUom ()
    {
        return volumeUom;
    }

    public void setVolumeUom (String volumeUom)
    {
        this.volumeUom = volumeUom;
    }

    public String getWeightUom ()
    {
        return weightUom;
    }

    public void setWeightUom (String weightUom)
    {
        this.weightUom = weightUom;
    }

    public String getWeight ()
    {
        return weight;
    }

    public void setWeight (String weight)
    {
        this.weight = weight;
    }

    public String getHeight ()
    {
        return height;
    }

    public void setHeight (String height)
    {
        this.height = height;
    }

    public String getNo ()
    {
        return no;
    }

    public void setNo (String no)
    {
        this.no = no;
    }

    public String getWidth ()
    {
        return width;
    }

    public void setWidth (String width)
    {
        this.width = width;
    }

    public String getVolume ()
    {
        return volume;
    }

    public void setVolume (String volume)
    {
        this.volume = volume;
    }

    public String getDepth ()
    {
        return depth;
    }

    public void setDepth (String depth)
    {
        this.depth = depth;
    }

    public String getDimensionUom ()
    {
        return dimensionUom;
    }

    public void setDimensionUom (String dimensionUom)
    {
        this.dimensionUom = dimensionUom;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [volumeUom = "+volumeUom+", weightUom = "+weightUom+", weight = "+weight+", height = "+height+", no = "+no+", width = "+width+", volume = "+volume+", depth = "+depth+", dimensionUom = "+dimensionUom+"]";
    }
}