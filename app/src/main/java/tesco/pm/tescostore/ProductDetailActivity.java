package tesco.pm.tescostore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import tesco.pm.tescostore.constant.Constants;
import tesco.pm.tescostore.domain.product.detail.ProductDetailResult;
import tesco.pm.tescostore.domain.search.result.ProductSearchResult;
import tesco.pm.tescostore.manager.ProductSearchManager;

/**
 * Created by pmodi4 on 8/13/2017.
 */

public class ProductDetailActivity extends AppCompatActivity {

    private ProductSearchManager searchManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdetail);

        Bundle bundle = getIntent().getExtras();
        String tpnb = bundle.get(Constants.PRODUCT_TPNB).toString();
        String imgUrl = bundle.get(Constants.PRODUCT_IMAGE_URL).toString();
        String productName = bundle.get(Constants.PRODUCT_NAME).toString();

        searchManager = new ProductSearchManager();
        ProductDetailResult productDetailResult =  searchManager.fetchProductDetail(tpnb);

        ImageView productDetailImg = (ImageView) findViewById(R.id.productDetailImage);
        String finalImageUrl = imgUrl.replace("http", "https").replace("90x90", "225x225");
        Picasso.with(ProductDetailActivity.this).load(finalImageUrl).error(R.drawable.default_product).resize(225, 225).into(productDetailImg);

        TextView productNameTV = (TextView) findViewById(R.id.productDetailName);
        productNameTV.setText(productName);

    }
}
