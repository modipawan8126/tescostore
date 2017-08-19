/* Copyright 2017 freecodeformat.com */
package tesco.pm.tescostore.domain.search.result.store;
import java.util.List;

/* Time: 2017-08-19 16:47:34 @author freecodeformat.com @website http://www.freecodeformat.com/json2javabean.php */
public class StoreSearchResult {

    private List<Results> results;
    public void setResults(List<Results> results) {
         this.results = results;
     }
     public List<Results> getResults() {
         return results;
     }

}