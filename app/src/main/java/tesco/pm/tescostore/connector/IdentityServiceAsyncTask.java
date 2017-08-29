package tesco.pm.tescostore.connector;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;

import tesco.pm.tescostore.constant.Constants;

/**
 * Created by pmodi4 on 8/12/2017.
 */

public class IdentityServiceAsyncTask extends AsyncTask<Void, Void, String> {

    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APPLICATION_JSON = "application/json; charset=UTF-8";
    //private static final String HTTP_METHOD_GET = "GET";
    private String TAG = IdentityServiceAsyncTask.class.getSimpleName();


    Map<String, String> queryData;

    public IdentityServiceAsyncTask() {

    }

    public IdentityServiceAsyncTask(Map<String, String> qd) {
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
            conn.setRequestProperty(CONTENT_TYPE, APPLICATION_JSON);
            conn.connect();
            OutputStream identityServiceOutputStream = conn.getOutputStream();
            identityServiceOutputStream.write(queryData.get(Constants.REQUEST_BODY).getBytes());
            identityServiceOutputStream.flush();

            StringBuilder identityServiceResponseBuilder = new StringBuilder();

            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                Log.d(TAG, "Identity Service response Code: " + conn.getResponseCode());

                if (conn.getInputStream() != null) {
                    BufferedReader identityServiceReader = new BufferedReader(
                            new InputStreamReader(conn.getInputStream()));
                    String identityServiceResponce;
                    while ((identityServiceResponce = identityServiceReader.readLine()) != null) {
                        identityServiceResponseBuilder.append(identityServiceResponce.trim());
                    }
                }

                Log.d(TAG, "Identity service responce : " + identityServiceResponseBuilder.toString());

                response = identityServiceResponseBuilder.toString();

            } else {
                Log.d(TAG, "Identity service HttpURL Responce fails: " + conn.getResponseCode());

                if (conn.getErrorStream() != null) {
                    BufferedReader identityServiceReader = new BufferedReader(
                            new InputStreamReader(conn.getErrorStream()));
                    String identityServiceResponce;
                    while ((identityServiceResponce = identityServiceReader.readLine()) != null) {
                        identityServiceResponseBuilder.append(identityServiceResponce.trim());
                    }
                }

                Log.d(TAG, "Identity service error responce : " + identityServiceResponseBuilder.toString());
                //response = identityServiceResponseBuilder.toString();
            }

            /*InputStream in = new BufferedInputStream(conn.getInputStream());
            response = convertStreamToString(in);*/
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

   /* private String convertStreamToString(InputStream is) {
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
    }*/

    public Map<String, String> getQueryData() {
        return queryData;
    }

    public void setQueryData(Map<String, String> queryData) {
        this.queryData = queryData;
    }
}
