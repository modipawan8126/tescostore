package tesco.pm.tescostore.identity;

import android.util.Log;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import tesco.pm.tescostore.BuildConfig;
import tesco.pm.tescostore.cache.MemoryCache;
import tesco.pm.tescostore.connector.IdentityServiceAsyncTask;
import tesco.pm.tescostore.constant.Constants;

/**
 * Created by has7 on 8/29/2017.
 */

public class IdentityServiceManager {

    private static final String TAG = IdentityServiceManager.class.getSimpleName();

    public String callIdentityServiceToGetAccessToken() {

        String token = null;
        String requestBody = getIdentityServiceRequestBody();
        Map<String, String> queryData = new HashMap<String, String>();
        queryData.put(Constants.SERVICE_URL, BuildConfig.TESCO_IDENTITY_SERVICE_URL);
        queryData.put(Constants.HTTP_METHOD, "POST");
        queryData.put(Constants.REQUEST_BODY, requestBody);

        String jsonStr = null;
        try {
            jsonStr = (String) new IdentityServiceAsyncTask(queryData).execute().get();
            Log.d(TAG, "Service Response - " + jsonStr);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        if (jsonStr != null) {
            Gson gson = new Gson();
            IdentityServiceResponse plannedProductIdentityServiceResponse = gson.fromJson(jsonStr.toString(), IdentityServiceResponse.class);
            token = plannedProductIdentityServiceResponse.getAccess_token();
            MemoryCache.getInstance().setIdentityAccessToken(token);
        }
        return token;
    }


    private String getIdentityServiceRequestBody() {
        IdentityServiceRequest request = new IdentityServiceRequest(BuildConfig.TESCO_IDENTITY_SERVICE_CLIENTID, BuildConfig.TESCO_IDENTITY_SERVICE_GRANTTYPE, BuildConfig.TESCO_IDENTITY_SERVICE_USERNAME, BuildConfig.TESCO_IDENTITY_SERVICE_PASSWORD);
        Gson gson = new Gson();
        String requestBody = gson.toJson(request);
        Log.d(TAG, "IdenityService Body: " + requestBody);
        return requestBody;
    }


}
