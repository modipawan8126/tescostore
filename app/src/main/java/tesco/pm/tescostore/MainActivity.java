package tesco.pm.tescostore;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SearchView sv = (SearchView) findViewById(R.id.searchQuery);

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //String query = sv.getQuery().toString();

                sv.clearFocus();
                getProducts(query, MemoryCache.getInstance().getSearchOffset());

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //adapter.getFilter().filter(newText);
                return true;
            }
        });


       /* View footerView = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.activity_productlist_footer, null, false);*/

       TextView prev = (TextView) findViewById(R.id.prev);
       /* ImageButton prev = (ImageButton) footerView.findViewById(R.id.prev);*/
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int offset = MemoryCache.getInstance().getSearchOffset();
                if (offset == 0) {
                    offset = 0;
                } else {
                    offset = offset - 1;
                }
                getProducts(MemoryCache.getInstance().getQueryString(),offset );
            }
        });

       TextView next = (TextView) findViewById(R.id.next);
      /*  ImageButton next = (ImageButton) footerView.findViewById(R.id.next);*/
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int offset = MemoryCache.getInstance().getSearchOffset();
                offset = offset + 1;
                getProducts(MemoryCache.getInstance().getQueryString(),offset);
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
            ListView yourListViewReference = (ListView) findViewById(R.id.productList);
            ProductAdapter ad = new ProductAdapter(MainActivity.this, productSearchResult.getUk().getGhs().getProducts().getResults());
            yourListViewReference.setAdapter(ad);

            /*View footerView = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.activity_productlist_footer, null, false);

            yourListViewReference.addFooterView(footerView, null, false);*/
        }

    }
}
