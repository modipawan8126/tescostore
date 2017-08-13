package tesco.pm.tescostore.cache;

import java.io.Serializable;
import java.util.List;


/**
 * Created by pmodi4 on 7/23/2017.
 */

public class MemoryCache implements Serializable {


    int searchOffset;



    String queryString;


    private static final MemoryCache cache = new MemoryCache();

    private MemoryCache() {

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

}
