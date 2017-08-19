package tesco.pm.tescostore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import tesco.pm.tescostore.adapter.ProductAttributeAdapter;
import tesco.pm.tescostore.adapter.ProductAttributeObject;
import tesco.pm.tescostore.constant.Constants;
import tesco.pm.tescostore.domain.product.detail.ProductDetailResult;
import tesco.pm.tescostore.manager.ProductSearchManager;
import tesco.pm.tescostore.view.ExpandableHeightListView;

/**
 * Created by pmodi4 on 8/13/2017.
 */

public class ProductDetailActivity extends AppCompatActivity {

    private ProductSearchManager searchManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdetail);

        Bundle bundle = getIntent().getExtras();
        String tpnb = bundle.get(Constants.PRODUCT_TPNB).toString();
        String imgUrl = bundle.get(Constants.PRODUCT_IMAGE_URL).toString();
        String productName = bundle.get(Constants.PRODUCT_NAME).toString();
        String productPrice = bundle.get(Constants.PRODUCT_PRICE).toString();

        searchManager = new ProductSearchManager();
        ProductDetailResult productDetailResult =  searchManager.fetchProductDetail(tpnb);
        List<ProductAttributeObject> attributeList = prepareProductAttributeMap(productDetailResult);
        attributeList.add(new ProductAttributeObject(Constants.PRODUCT_PRICE, productPrice, null));

        ImageView productDetailImg = (ImageView) findViewById(R.id.productDetailImage);
        String finalImageUrl = imgUrl.replace("http", "https").replace("90x90", "540x540");
        Picasso.with(ProductDetailActivity.this).load(finalImageUrl).error(R.drawable.default_product).resize(540, 540).into(productDetailImg);

        TextView productNameTV = (TextView) findViewById(R.id.productDetailName);
        productNameTV.setText(productName);



        /*final ListView yourListViewReference = (ListView) findViewById(R.id.productAttributeList);
        ProductAttributeAdapter ad = new ProductAttributeAdapter(ProductDetailActivity.this, attributeList.toArray());
        yourListViewReference.setAdapter(ad);*/

        ExpandableHeightListView listView =(ExpandableHeightListView)findViewById(R.id.productAttributeList);
        ProductAttributeAdapter ad = new ProductAttributeAdapter(ProductDetailActivity.this, attributeList.toArray());
        listView.setAdapter(ad); //set your adaper
        listView.setExpanded(true);



    }

    private List<ProductAttributeObject> prepareProductAttributeMap(ProductDetailResult pdr) {
        /*Map<String, Map<String, String>> attributes = new HashMap<String, Map<String, String>>();*/
        List<ProductAttributeObject> attributeList = new ArrayList<ProductAttributeObject>();

            if (pdr != null) {
                if (pdr.getProducts()[0] != null) {
                    if (pdr.getProducts()[0].getProductCharacteristics() != null) {
                        ProductAttributeObject p1 = new ProductAttributeObject(Constants.IS_DRINK, pdr.getProducts()[0].getProductCharacteristics().getIsDrink(),Constants.PRODUCT_CHARACTERISTIC );
                        ProductAttributeObject p2 = new ProductAttributeObject(Constants.HEALTH_SCORE, pdr.getProducts()[0].getProductCharacteristics().getHealthScore(),Constants.PRODUCT_CHARACTERISTIC );
                        ProductAttributeObject p3 = new ProductAttributeObject(Constants.IS_FOOD, pdr.getProducts()[0].getProductCharacteristics().getIsFood(),Constants.PRODUCT_CHARACTERISTIC );
                        ProductAttributeObject p4 = new ProductAttributeObject(Constants.IS_HAZARDOUS, pdr.getProducts()[0].getProductCharacteristics().getIsHazardous(),Constants.PRODUCT_CHARACTERISTIC );
                        ProductAttributeObject p5 = new ProductAttributeObject(Constants.STOREAGE_TYPE, pdr.getProducts()[0].getProductCharacteristics().getStorageType(),Constants.PRODUCT_CHARACTERISTIC );
                        attributeList.add(p1);
                        attributeList.add(p2);
                        attributeList.add(p3);
                        attributeList.add(p4);
                        attributeList.add(p5);

                    }

                   if (pdr.getProducts()[0].getPkgDimensions() != null) {
                       ProductAttributeObject p1 = new ProductAttributeObject(Constants.DEPTH, pdr.getProducts()[0].getPkgDimensions()[0].getDepth(),Constants.PACKAGE_DIMENSION );
                       ProductAttributeObject p2 = new ProductAttributeObject(Constants.DIMENSIONUOM, pdr.getProducts()[0].getPkgDimensions()[0].getDimensionUom(),Constants.PACKAGE_DIMENSION );
                       ProductAttributeObject p3 = new ProductAttributeObject(Constants.HEIGHT, pdr.getProducts()[0].getPkgDimensions()[0].getHeight(),Constants.PACKAGE_DIMENSION );
                       ProductAttributeObject p4 = new ProductAttributeObject(Constants.NO, pdr.getProducts()[0].getPkgDimensions()[0].getNo(),Constants.PACKAGE_DIMENSION );
                       ProductAttributeObject p5 = new ProductAttributeObject(Constants.VOLUME, pdr.getProducts()[0].getPkgDimensions()[0].getVolume(),Constants.PACKAGE_DIMENSION );
                       ProductAttributeObject p6 = new ProductAttributeObject(Constants.VOLUME_UOM, pdr.getProducts()[0].getPkgDimensions()[0].getVolumeUom(),Constants.PACKAGE_DIMENSION );
                       ProductAttributeObject p7 = new ProductAttributeObject(Constants.WEIGHT, pdr.getProducts()[0].getPkgDimensions()[0].getWeight(),Constants.PACKAGE_DIMENSION );
                       ProductAttributeObject p8 = new ProductAttributeObject(Constants.WEIGHT_UOM, pdr.getProducts()[0].getPkgDimensions()[0].getWeightUom(),Constants.PACKAGE_DIMENSION );
                       ProductAttributeObject p9 = new ProductAttributeObject(Constants.WIDTH, pdr.getProducts()[0].getPkgDimensions()[0].getWidth(),Constants.PACKAGE_DIMENSION );
                       attributeList.add(p1);
                       attributeList.add(p2);
                       attributeList.add(p3);
                       attributeList.add(p4);
                       attributeList.add(p5);
                       attributeList.add(p6);
                       attributeList.add(p7);
                       attributeList.add(p8);
                       attributeList.add(p9);
                    }
                }
            }
        return attributeList;
    }

}
