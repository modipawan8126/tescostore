package tesco.pm.tescostore.connector;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;

import tesco.pm.tescostore.BuildConfig;
import tesco.pm.tescostore.constant.Constants;

/**
 * Created by pmodi4 on 8/12/2017.
 */

public class ProductLocationAsyncTask extends AsyncTask<Void, Void, String> {


    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APPLICATION_JSON = "application/json; charset=UTF-8";
    private static final String HTTP_METHOD_GET = "GET";
    private String TAG = ProductLocationAsyncTask.class.getSimpleName();


    Map<String, String> queryData;

    public ProductLocationAsyncTask() {

    }

    public ProductLocationAsyncTask(Map<String, String> qd) {
        queryData = qd;
    }

    @Override
    protected String doInBackground(Void... params) {
        Log.d(TAG, "---begin doInBackground---");
        String jsonStr = makeServiceCall();
        if (jsonStr != null) {
            Log.d(TAG, "Service Response - " + jsonStr);
        } else {
            Log.d(TAG, "Empty Response from Service Call. Updating location is not successfull");
        }

        return jsonStr;
    }

    public String makeServiceCall() {
        String response = null;
        try {

            String serviceUrl = queryData.get(Constants.SERVICE_URL);
            Log.d(TAG, "service Url: " + queryData.get(Constants.SERVICE_URL));

            URL url = new URL(serviceUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(queryData.get(Constants.HTTP_METHOD));
            //conn.setRequestProperty(BuildConfig.tescoSubscriptionKey, BuildConfig.tescoSubscriptionValue);
            conn.setRequestProperty(Constants.ACCESS_TOKEN, queryData.get(Constants.ACCESS_TOKEN));
            InputStream in = new BufferedInputStream(conn.getInputStream());
            response = convertStreamToString(in);
        } catch (MalformedURLException e) {
            Log.e(TAG, "MalformedURLException: " + e.getMessage());
        } catch (ProtocolException e) {
            Log.e(TAG, "ProtocolException: " + e.getMessage());
        } catch (IOException e) {
            Log.e(TAG, "IOException: " + e.getMessage());
        } catch (Exception e) {
            Log.e(TAG, "Exception: " + e.getMessage());
        }
        return response;
    }

    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public Map<String, String> getQueryData() {
        return queryData;
    }

    public void setQueryData(Map<String, String> queryData) {
        this.queryData = queryData;
    }
}
