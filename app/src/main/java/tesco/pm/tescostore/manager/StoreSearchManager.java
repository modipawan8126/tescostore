package tesco.pm.tescostore.manager;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import tesco.pm.tescostore.BuildConfig;
import tesco.pm.tescostore.connector.SearchAsyncTask;
import tesco.pm.tescostore.constant.Constants;
import tesco.pm.tescostore.domain.product.detail.ProductDetailResult;
import tesco.pm.tescostore.domain.search.result.product.ProductSearchResult;
import tesco.pm.tescostore.domain.search.result.store.StoreSearchResult;

/**
 * Created by pmodi4 on 8/12/2017.
 */

public class StoreSearchManager {


    public StoreSearchManager() {

    }

    public StoreSearchResult searchStore(String queryString, int offset) {

        StoreSearchResult storeResult = null;
        try {
            StringBuilder urlSb = new StringBuilder();
            urlSb.append(BuildConfig.STORE_SEARCH_SERVICE_URL).append("sort=near:").append(queryString).append("&offset=").append(offset);
                    //.append("&limit=").append(5);

            Map<String, String> queryData = new HashMap<String, String>();
            queryData.put(Constants.SEARCH_QUERY, queryString);
            queryData.put(Constants.SERVICE_URL, urlSb.toString());
            queryData.put(Constants.HTTP_METHOD, "GET");

            String jsonStr = (String) new SearchAsyncTask(queryData).execute().get();
            if (jsonStr != null && jsonStr.trim().length() != 0) {
                storeResult = convertStoreSearchResultJsonToObject(jsonStr);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return storeResult;
    }


    private StoreSearchResult convertStoreSearchResultJsonToObject(String jsonResponse) {
        Gson gson = new Gson();
        StoreSearchResult storeResult = gson.fromJson(jsonResponse, StoreSearchResult.class);
        return storeResult;

    }


}
