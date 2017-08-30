package tesco.pm.tescostore.manager;

import android.util.Log;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import tesco.pm.tescostore.BuildConfig;
import tesco.pm.tescostore.cache.MemoryCache;
import tesco.pm.tescostore.connector.ProductLocationAsyncTask;
import tesco.pm.tescostore.constant.Constants;
import tesco.pm.tescostore.domain.product.location.ProductLocationResponse;
import tesco.pm.tescostore.identity.IdentityServiceManager;

/**
 * Created by pmodi4 on 8/12/2017.
 */

public class ProductLocationManager {

    private static final String TAG = ProductLocationManager.class.getSimpleName();
    IdentityServiceManager identityServiceManager;

    public ProductLocationManager() {

    }

    public ProductLocationResponse fetchProductLocation(String productId,String storeId) {

        ProductLocationResponse productLocationResponse = null;
        try {
            identityServiceManager = new IdentityServiceManager();
            if (MemoryCache.getInstance().getIdentityAccessToken() == null) {
                MemoryCache.getInstance().setIdentityAccessToken(identityServiceManager.callIdentityServiceToGetAccessToken());
            }
            StringBuilder urlSb = new StringBuilder();
            urlSb.append(BuildConfig.TESCO_PRODUCT_ACTUAL_LOCATION_URL).append("2843?productID=").append(productId);
            //urlSb.append(BuildConfig.TESCO_PRODUCT_ACTUAL_LOCATION_URL).append(storeId).append("?productID=").append(productId);

            Map<String, String> queryData = new HashMap<String, String>();
            queryData.put(Constants.SERVICE_URL, urlSb.toString());
            queryData.put(Constants.HTTP_METHOD, "GET");
            queryData.put(Constants.ACCESS_TOKEN, MemoryCache.getInstance().getIdentityAccessToken());
            String jsonStr = (String) new ProductLocationAsyncTask(queryData).execute().get();
            Log.d(TAG, "Product Location Response - " + jsonStr);
            if (jsonStr != null && jsonStr.trim().length() != 0) {
                if (jsonStr.contains(Constants.INVALID_TOKEN)) {
                    Log.d(TAG, "Invalid Token, hence calling identity service to get fresh token");
                    MemoryCache.getInstance().setIdentityAccessToken(identityServiceManager.callIdentityServiceToGetAccessToken());
                    fetchProductLocation(productId, storeId);
                } else {
                    productLocationResponse = convertProductLocationResponseJsonToObject(jsonStr, productId);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return productLocationResponse;
    }


    private ProductLocationResponse convertProductLocationResponseJsonToObject(String jsonResponse, String tpnb) {
        Gson gson = new Gson();
        ProductLocationResponse productLocationResponse = gson.fromJson(dummyProductLocation(), ProductLocationResponse.class);
//        ProductLocationResponse productLocationResponse = null;
//        List<ProductLocationResponse> locations = (List<ProductLocationResponse>) gson.fromJson(jsonResponse, ProductLocationResponse.class);
//        for (ProductLocationResponse res : locations) {
//            if (res.getProductNumber().equalsIgnoreCase(tpnb)) {
//                productLocationResponse = res;
//            }
//        }
        return productLocationResponse;

    }

    private String dummyProductLocation() {
        String json = "{\"moduleNumber\": \"9\",\"aisleOrientation\": \"L\",\"shelfNumber\": \"A\",\"productPosition\": \"2\",\"productNumber\": \"072032780\",\"aisle\": \"06\",\t\"floorCode\": \"1.0\",\"capacity\": \"8\",\"facings\": \"1\"}";

        return json;
    }

}
