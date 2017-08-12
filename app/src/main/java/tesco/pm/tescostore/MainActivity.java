package tesco.pm.tescostore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ListView;
import android.widget.SearchView;

import java.util.List;

import tesco.pm.tescostore.adapter.ProductAdapter;
import tesco.pm.tescostore.domain.search.result.ProductSearchResult;
import tesco.pm.tescostore.manager.ProductSearchManager;

public class MainActivity extends AppCompatActivity {

    private ProductSearchManager searchManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SearchView sv = (SearchView) findViewById(R.id.searchQuery);


        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //String query = sv.getQuery().toString();

                searchManager = new ProductSearchManager();
                ProductSearchResult productSearchResult =  searchManager.searchProject(query);


                ListView yourListViewReference = (ListView) findViewById(R.id.productList);
                ProductAdapter ad = new ProductAdapter(MainActivity.this, productSearchResult.getUk().getGhs().getProducts().getResults());
                yourListViewReference.setAdapter(ad);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //adapter.getFilter().filter(newText);
                return true;
            }
        });


    }
}
