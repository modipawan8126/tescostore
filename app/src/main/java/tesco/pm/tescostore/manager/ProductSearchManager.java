package tesco.pm.tescostore.manager;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import tesco.pm.tescostore.BuildConfig;
import tesco.pm.tescostore.constant.Constants;
import tesco.pm.tescostore.connector.SearchAsyncTask;
import tesco.pm.tescostore.domain.product.detail.ProductDetailResult;
import tesco.pm.tescostore.domain.search.result.product.ProductSearchResult;

/**
 * Created by pmodi4 on 8/12/2017.
 */

public class ProductSearchManager {

    /*private static final String GROCERY_SEARCH_SERVICE_URL = "https://dev.tescolabs.com/grocery/products/?";
    private static final String PRODUCT_DETAIL_SERVICE_URL = "https://dev.tescolabs.com/product/?tpnb=";
    private static final int limit = 10;*/


    public ProductSearchManager() {

    }

    public ProductSearchResult searchProduct(String queryString, int offset) {

        ProductSearchResult productResult = null;
        try {
            StringBuilder urlSb = new StringBuilder();
            urlSb.append(BuildConfig.GROCERY_SEARCH_SERVICE_URL).append("query=").append(queryString).append("&offset=").append(offset).append("&limit=").append(BuildConfig.limit);

            Map<String, String> queryData = new HashMap<String, String>();
            queryData.put(Constants.SEARCH_QUERY, queryString);
            queryData.put(Constants.SERVICE_URL, urlSb.toString());
            queryData.put(Constants.HTTP_METHOD, "GET");

            String jsonStr = (String) new SearchAsyncTask(queryData).execute().get();
            if (jsonStr != null && jsonStr.trim().length() != 0) {
                productResult = convertProductSearchResultJsonToObject(jsonStr);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return productResult;
    }

    public ProductDetailResult fetchProductDetail(String tpnb) {

        ProductDetailResult productDetailResult = null;
        try {
            StringBuilder urlSb = new StringBuilder();
            urlSb.append(BuildConfig.PRODUCT_DETAIL_SERVICE_URL).append(tpnb);

            Map<String, String> queryData = new HashMap<String, String>();
            queryData.put(Constants.SERVICE_URL, urlSb.toString());
            queryData.put(Constants.HTTP_METHOD, "GET");

            String jsonStr = (String) new SearchAsyncTask(queryData).execute().get();
            if (jsonStr != null && jsonStr.trim().length() != 0) {
                productDetailResult = convertProductDetailResultJsonToObject(jsonStr);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return productDetailResult;
    }

    private ProductSearchResult convertProductSearchResultJsonToObject(String jsonResponse) {
        Gson gson = new Gson();
        ProductSearchResult productResult = gson.fromJson(jsonResponse, ProductSearchResult.class);
        return productResult;

    }

    private ProductDetailResult convertProductDetailResultJsonToObject(String jsonResponse) {
        Gson gson = new Gson();
        ProductDetailResult productDetailResult = gson.fromJson(jsonResponse, ProductDetailResult.class);
        return productDetailResult;

    }
}
