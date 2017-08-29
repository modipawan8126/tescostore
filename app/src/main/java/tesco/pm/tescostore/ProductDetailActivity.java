package tesco.pm.tescostore;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import tesco.pm.tescostore.adapter.ProductAttributeAdapter;
import tesco.pm.tescostore.adapter.ProductAttributeObject;
import tesco.pm.tescostore.cache.MemoryCache;
import tesco.pm.tescostore.constant.Constants;
import tesco.pm.tescostore.domain.product.detail.ProductDetailResult;
import tesco.pm.tescostore.domain.product.location.ProductLocationResponse;
import tesco.pm.tescostore.identity.IdentityServiceManager;
import tesco.pm.tescostore.manager.ProductLocationManager;
import tesco.pm.tescostore.manager.ProductSearchManager;
import tesco.pm.tescostore.view.ExpandableHeightListView;

/**
 * Created by pmodi4 on 8/13/2017.
 */

public class ProductDetailActivity extends AppCompatActivity {

    private ProductSearchManager searchManager;

    private  String tpnb;

    private ProductLocationManager productLocationManager;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.storeLocator:
                openStoreLocator();
                return true;
            case R.id.about:
                openAbout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void openStoreLocator() {
        Log.d(this.getClass().getSimpleName(), "Opening StoreLocator Activity");
        Intent intent = new Intent(ProductDetailActivity.this, StoreLocatorActivity.class);
        intent.putExtra("tpnb", tpnb);
        startActivity(intent);
    }

    private void openAbout() {
        Log.d(this.getClass().getSimpleName(), "Opening About Activity");
        Intent intent = new Intent(ProductDetailActivity.this, AboutActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdetail);

        Bundle bundle = getIntent().getExtras();
        tpnb = bundle.get(Constants.PRODUCT_TPNB).toString();
        String imgUrl = bundle.get(Constants.PRODUCT_IMAGE_URL).toString();
        String productName = bundle.get(Constants.PRODUCT_NAME).toString();
        String productPrice = bundle.get(Constants.PRODUCT_PRICE).toString();
        final Object storeIdObj = bundle.get(Constants.STORE_ID);

        Button checkProductLocation = (Button) findViewById(R.id.productLocation);

        if (storeIdObj == null) {
            checkProductLocation.setVisibility(View.GONE);
        } else {
            Log.d(this.getClass().getSimpleName(), "StoreID " + storeIdObj.toString());
            checkProductLocation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getProductLocation(storeIdObj.toString());
                }
            });

        }

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

    private void getProductLocation(String storeId) {
        productLocationManager = new ProductLocationManager();
        ProductLocationResponse productLocationResponse = productLocationManager.fetchProductLocation(tpnb, storeId);
        if (productLocationResponse != null) {
            Log.d(this.getClass().getSimpleName(), productLocationResponse.getModuleNumber());
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("Product Location in Store " + storeId);

            alertDialogBuilder.setCancelable(false)
                    .setPositiveButton("close",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            ProductDetailActivity.this.finish();
                        }
                    });
            StringBuilder sb = new StringBuilder();
            sb.append("Aisle:").append(productLocationResponse.getAisle()).append("\n")
              .append("Mod:").append(productLocationResponse.getModuleNumber()).append("\n")
              .append("Shelf:").append(productLocationResponse.getShelfNumber());
            alertDialogBuilder.setMessage(sb.toString());
            /*TextView location = new TextView(this);
            location.setText(sb.toString());
            alertDialogBuilder.setView(location);*/

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
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
