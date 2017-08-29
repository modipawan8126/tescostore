package tesco.pm.tescostore.manager;

import android.util.Log;

import com.google.gson.Gson;

import java.util.HashMap;
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

    public ProductLocationResponse fetchProductLocation(String productId) {

        ProductLocationResponse productLocationResponse = null;
        try {
            StringBuilder urlSb = new StringBuilder();
            urlSb.append(BuildConfig.TESCO_PRODUCT_ACTUAL_LOCATION_URL).append("2843?productID=").append(productId);

            Map<String, String> queryData = new HashMap<String, String>();
            //queryData.put(Constants.SEARCH_QUERY, queryString);
            queryData.put(Constants.SERVICE_URL, urlSb.toString());
            queryData.put(Constants.HTTP_METHOD, "GET");
            queryData.put(Constants.ACCESS_TOKEN, MemoryCache.getInstance().getIdentityAccessToken());
            String jsonStr = (String) new ProductLocationAsyncTask(queryData).execute().get();
            Log.d(TAG, "Product Location Response - " + jsonStr);
            if (jsonStr != null && jsonStr.trim().length() != 0) {
                if (jsonStr.contains(Constants.INVALID_TOKEN)) {
                    Log.d(TAG, "Invalid Token, hence calling identity service to get fresh token");
                    identityServiceManager = new IdentityServiceManager();
                    MemoryCache.getInstance().setIdentityAccessToken(identityServiceManager.callIdentityServiceToGetAccessToken());
                    fetchProductLocation(productId);
                } else {
                    productLocationResponse = convertProductLocationResponseJsonToObject(jsonStr);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return productLocationResponse;
    }


    private ProductLocationResponse convertProductLocationResponseJsonToObject(String jsonResponse) {
        Gson gson = new Gson();
        ProductLocationResponse productLocationResponse = gson.fromJson(jsonResponse, ProductLocationResponse.class);
        return productLocationResponse;

    }


}
