package tesco.pm.tescostore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import tesco.pm.tescostore.adapter.StoreAdapter;
import tesco.pm.tescostore.cache.MemoryCache;
import tesco.pm.tescostore.domain.search.result.store.StoreSearchResult;
import tesco.pm.tescostore.manager.ProductSearchManager;
import tesco.pm.tescostore.manager.StoreSearchManager;

public class StoreLocatorActivity extends AppCompatActivity {

    private StoreSearchManager searchManager;

    TextView totalCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storelocator);
        searchManager = new StoreSearchManager();

        final TextView next = (TextView) findViewById(R.id.next);
        next.setVisibility(View.GONE);
        final TextView prev = (TextView) findViewById(R.id.prev);
        prev.setVisibility(View.GONE);
        totalCount = (TextView) findViewById(R.id.totalCount);
        totalCount.setVisibility(View.GONE);

        final SearchView sv = (SearchView) findViewById(R.id.searchQuery);

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String finalQuery = query.replaceAll(" ", "+").toLowerCase();
                MemoryCache.getInstance().setStoreSearchQuery(finalQuery);
                sv.clearFocus();
                next.setVisibility(View.VISIBLE);
                prev.setVisibility(View.VISIBLE);
                getStores(finalQuery, MemoryCache.getInstance().getSearchOffset());

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //adapter.getFilter().filter(newText);
                return true;
            }
        });



        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int offset = MemoryCache.getInstance().getSearchOffset();
                if (offset == 0) {
                    offset = 0;
                    prev.setEnabled(false);
                } else {
                    offset = offset - 1;
                    MemoryCache.getInstance().setSearchOffset(offset);
                    getStores(MemoryCache.getInstance().getStoreSearchQuery(), offset);
                    next.setEnabled(true);
                }

            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int offset = MemoryCache.getInstance().getSearchOffset();
                offset = offset + 1;
                int totalProductCount = MemoryCache.getInstance().getTotalResultCount();
                int limit = BuildConfig.limit;
                if (limit * offset < totalProductCount) {
                    MemoryCache.getInstance().setSearchOffset(offset);
                    getStores(MemoryCache.getInstance().getStoreSearchQuery(), offset);
                    prev.setEnabled(true);
                } else {
                    next.setEnabled(false);
                    Log.d(this.getClass().getSimpleName(), "Reached the final last page of pagination");
                }
            }
        });


    }

    private void getStores(String query, int offset) {
        MemoryCache.getInstance().setStoreSearchQuery(query);
        Log.d(this.getClass().getSimpleName(), "Searching Store " + query);

        StoreSearchResult storeResult = searchManager.searchStore(query, offset);
        int totalStoreCount = 0;
        if (storeResult != null && storeResult.getResults() != null) {
            totalStoreCount = storeResult.getResults().size();
            ListView yourListViewReference = (ListView) findViewById(R.id.storeList);
            StoreAdapter ad = new StoreAdapter(StoreLocatorActivity.this, storeResult.getResults().toArray());
            yourListViewReference.setAdapter(ad);
        }

        if (totalCount != null) {
            MemoryCache.getInstance().setStoreResultCount(totalStoreCount);
            totalCount.setText("Result Count " + totalStoreCount);
            totalCount.setVisibility(View.VISIBLE);
        }

    }
}
