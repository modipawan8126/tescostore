package tesco.pm.tescostore.cache;

import java.io.Serializable;
import java.util.List;


/**
 * Created by pmodi4 on 7/23/2017.
 */

public class MemoryCache implements Serializable {


    int searchOffset;

    int totalResultCount;

    String queryString;


    String storeSearchQuery;
    int storeSearchOffset;
    int storeResultCount;

    private static final MemoryCache cache = new MemoryCache();

    private MemoryCache() {

    }

    public int getStoreSearchOffset() {
        return storeSearchOffset;
    }

    public void setStoreSearchOffset(int storeSearchOffset) {
        this.storeSearchOffset = storeSearchOffset;
    }

    public int getStoreResultCount() {
        return storeResultCount;
    }

    public void setStoreResultCount(int storeResultCount) {
        this.storeResultCount = storeResultCount;
    }

    public static MemoryCache getInstance() {
        return cache;
    }


    public int getSearchOffset() {
        return searchOffset;
    }

    public void setSearchOffset(int searchOffset) {
        this.searchOffset = searchOffset;
    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public int getTotalResultCount() {
        return totalResultCount;
    }

    public void setTotalResultCount(int totalResultCount) {
        this.totalResultCount = totalResultCount;
    }

    public String getStoreSearchQuery() {
        return storeSearchQuery;
    }

    public void setStoreSearchQuery(String storeSearchQuery) {
        this.storeSearchQuery = storeSearchQuery;
    }

}
