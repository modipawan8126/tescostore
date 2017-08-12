package tesco.pm.tescostore.connector;

import android.os.AsyncTask;
import android.util.Log;
import android.util.StringBuilderPrinter;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by pmodi4 on 8/12/2017.
 */

public class ProductSearchAsyncTask extends AsyncTask<Void, Void, String> {

    private static final String SERVICE_URL = "https://dev.tescolabs.com/grocery/products/?";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APPLICATION_JSON = "application/json; charset=UTF-8";
    private static final String HTTP_METHOD_GET = "GET";
    private String TAG = ProductSearchAsyncTask.class.getSimpleName();

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    private String query;

    public ProductSearchAsyncTask() {

    }

    public ProductSearchAsyncTask(String q) {
        query = q;
    }

    @Override
    protected String doInBackground(Void... params) {
        Log.d(TAG, "---begin doInBackground---");
        //HttpConnector connector = new HttpConnector();
        String jsonStr = makeServiceCall(HTTP_METHOD_GET, query);

        if (jsonStr != null) {
            Log.d(TAG, "Service Response - " + jsonStr);
        } else {
            Log.d(TAG, "Empty Response from Service Call. Updating location is not successfull");
        }

        return jsonStr;
    }

    public String makeServiceCall(String method, String query) {
        String response = null;
        try {
            Log.d(TAG, "Base Url: " + SERVICE_URL);

            StringBuilder sb = new StringBuilder();
            sb.append(SERVICE_URL).append("query=").append(query).append("&offset=0&limit=10");
            Log.d(TAG, "final Url: " + sb.toString());
            URL url = new URL(sb.toString());

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(method);
            //conn.setRequestProperty(CONTENT_TYPE, APPLICATION_JSON);
            conn.setRequestProperty("Ocp-Apim-Subscription-Key", "6ca323f879bd4893bcb961480a0c618f");
           /* DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            wr.writeBytes(query);
            wr.flush();
            wr.close();*/
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
}
