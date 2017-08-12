package tesco.pm.tescostore.manager;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import tesco.pm.tescostore.connector.ProductSearchAsyncTask;
import tesco.pm.tescostore.domain.search.result.ProductSearchResult;

/**
 * Created by pmodi4 on 8/12/2017.
 */

public class ProductSearchManager {


    public ProductSearchManager() {

    }

    public ProductSearchResult searchProject(String queryString) {

        ProductSearchResult productResult = null;
        try {
            String jsonStr = (String) new ProductSearchAsyncTask(queryString).execute().get();
            if (jsonStr != null && jsonStr.trim().length() != 0) {
                productResult = convertJsonToObject(jsonStr);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return productResult;
    }

    private ProductSearchResult convertJsonToObject(String jsonResponse) {
        Gson gson = new Gson();


        //List<MobileLocation> locations = (List<MobileLocation>) gson.fromJson(jsonResponse, List<MobileLocation.class>);
        List<ProductSearchResult> productResultList = null;
        ProductSearchResult productResult = gson.fromJson(jsonResponse, ProductSearchResult.class);

        return productResult;

    }
}
