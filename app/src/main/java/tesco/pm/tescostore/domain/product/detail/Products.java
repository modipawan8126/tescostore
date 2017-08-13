package tesco.pm.tescostore.domain.product.detail;

/**
 * Created by pmodi4 on 8/13/2017.
 */

public class Products
{
    private String gtin;

    private ProductAttributes[] productAttributes;

    private String tpnb;

    private String tpnc;

    private String[] ingredients;

    private PkgDimensions[] pkgDimensions;

    private Gda gda;

    private String description;

    private String brand;

    private ProductCharacteristics productCharacteristics;

    private AllergenAdvice allergenAdvice;

    private CalcNutrition calcNutrition;

    private QtyContents qtyContents;

    private String[] storage;

    public String getGtin ()
    {
        return gtin;
    }

    public void setGtin (String gtin)
    {
        this.gtin = gtin;
    }

    public ProductAttributes[] getProductAttributes ()
    {
        return productAttributes;
    }

    public void setProductAttributes (ProductAttributes[] productAttributes)
    {
        this.productAttributes = productAttributes;
    }

    public String getTpnb ()
    {
        return tpnb;
    }

    public void setTpnb (String tpnb)
    {
        this.tpnb = tpnb;
    }

    public String getTpnc ()
    {
        return tpnc;
    }

    public void setTpnc (String tpnc)
    {
        this.tpnc = tpnc;
    }

    public String[] getIngredients ()
    {
        return ingredients;
    }

    public void setIngredients (String[] ingredients)
    {
        this.ingredients = ingredients;
    }

    public PkgDimensions[] getPkgDimensions ()
    {
        return pkgDimensions;
    }

    public void setPkgDimensions (PkgDimensions[] pkgDimensions)
    {
        this.pkgDimensions = pkgDimensions;
    }

    public Gda getGda ()
    {
        return gda;
    }

    public void setGda (Gda gda)
    {
        this.gda = gda;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getBrand ()
    {
        return brand;
    }

    public void setBrand (String brand)
    {
        this.brand = brand;
    }

    public ProductCharacteristics getProductCharacteristics ()
    {
        return productCharacteristics;
    }

    public void setProductCharacteristics (ProductCharacteristics productCharacteristics)
    {
        this.productCharacteristics = productCharacteristics;
    }

    public AllergenAdvice getAllergenAdvice ()
    {
        return allergenAdvice;
    }

    public void setAllergenAdvice (AllergenAdvice allergenAdvice)
    {
        this.allergenAdvice = allergenAdvice;
    }

    public CalcNutrition getCalcNutrition ()
    {
        return calcNutrition;
    }

    public void setCalcNutrition (CalcNutrition calcNutrition)
    {
        this.calcNutrition = calcNutrition;
    }

    public QtyContents getQtyContents ()
    {
        return qtyContents;
    }

    public void setQtyContents (QtyContents qtyContents)
    {
        this.qtyContents = qtyContents;
    }

    public String[] getStorage ()
    {
        return storage;
    }

    public void setStorage (String[] storage)
    {
        this.storage = storage;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [gtin = "+gtin+", productAttributes = "+productAttributes+", tpnb = "+tpnb+", tpnc = "+tpnc+", ingredients = "+ingredients+", pkgDimensions = "+pkgDimensions+", gda = "+gda+", description = "+description+", brand = "+brand+", productCharacteristics = "+productCharacteristics+", allergenAdvice = "+allergenAdvice+", calcNutrition = "+calcNutrition+", qtyContents = "+qtyContents+", storage = "+storage+"]";
    }
}
