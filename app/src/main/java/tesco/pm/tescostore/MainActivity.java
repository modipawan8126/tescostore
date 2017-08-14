package tesco.pm.tescostore;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import tesco.pm.tescostore.adapter.ProductAdapter;

import tesco.pm.tescostore.cache.MemoryCache;
import tesco.pm.tescostore.domain.search.result.ProductSearchResult;
import tesco.pm.tescostore.manager.ProductSearchManager;

public class MainActivity extends AppCompatActivity {

    private ProductSearchManager searchManager;

    TextView totalCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                //String query = sv.getQuery().toString();

                String finalQuery = query.replaceAll(" ", "+").toLowerCase();
                MemoryCache.getInstance().setQueryString(finalQuery);
                sv.clearFocus();
                next.setVisibility(View.VISIBLE);
                prev.setVisibility(View.VISIBLE);
                getProducts(finalQuery, MemoryCache.getInstance().getSearchOffset());

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //adapter.getFilter().filter(newText);
                return true;
            }
        });


       /* View footerView = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.activity_productlist_footer, null, false);*/

       /* final ImageButton next = (ImageButton) findViewById(R.id.next);
       final ImageButton prev = (ImageButton) findViewById(R.id.prev);*/
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
                    getProducts(MemoryCache.getInstance().getQueryString(),offset );
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
                    getProducts(MemoryCache.getInstance().getQueryString(), offset);
                    prev.setEnabled(true);
                } else {
                    next.setEnabled(false);
                    Log.d(this.getClass().getSimpleName(), "Reached the final last page of pagination");
                }
            }
        });


    }

    private void getProducts(String query, int offset) {
        MemoryCache.getInstance().setQueryString(query);
        searchManager = new ProductSearchManager();
        ProductSearchResult productSearchResult =  searchManager.searchProduct(query, offset);
        ImageView storeImage = (ImageView) findViewById(R.id.tescostoreimage);
        storeImage.setVisibility(View.GONE);

        if (productSearchResult != null) {
            String totalProductCount = productSearchResult.getUk().getGhs().getProducts().getTotals().getAll();
            if (totalCount != null) {
                totalCount.setText("Result Count " + totalProductCount);
                totalCount.setVisibility(View.VISIBLE);
            }
            if (totalProductCount != null && totalProductCount.length() != 0) {
                MemoryCache.getInstance().setTotalResultCount(Integer.parseInt(totalProductCount));
            }

            ListView yourListViewReference = (ListView) findViewById(R.id.productList);
            ProductAdapter ad = new ProductAdapter(MainActivity.this, productSearchResult.getUk().getGhs().getProducts().getResults());
            yourListViewReference.setAdapter(ad);

            /*View footerView = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.activity_productlist_footer, null, false);

            yourListViewReference.addFooterView(footerView, null, false);*/
        }

    }
}
