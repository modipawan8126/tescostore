package tesco.pm.tescostore.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import tesco.pm.tescostore.ProductDetailActivity;
import tesco.pm.tescostore.R;
import tesco.pm.tescostore.constant.Constants;
import tesco.pm.tescostore.domain.search.result.product.Results;


/**
 * Created by pmodi4 on 7/29/2017.
 */

public class ProductAdapter extends BaseAdapter {
    Context con;
    Object[] data;


    public ProductAdapter(Context context, Object[] d) {
        this.con = context;
        this.data = d;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //this method will be called for every item of your listview
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        final Results result = ((Results) data[position]);


        LayoutInflater inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.activity_productlist, parent, false);

        TextView productName = (TextView) convertView.findViewById(R.id.productNameAdapter);
        productName.setText(result.getName());

        TextView productPrice = (TextView) convertView.findViewById(R.id.productPriceAdapter);
        productPrice.setText("£ " + result.getPrice());

        String promotionDescription = result.getPromotionDescription();
        if (promotionDescription != null && promotionDescription.trim().length() != 0) {
            TextView promotionTV = (TextView) convertView.findViewById(R.id.productPromotionAdapter);
            promotionTV.setText(promotionDescription);
        }

        productName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProductDetailActivity(result);
            }
        });

        //Log.d(this.getClass().getSimpleName(), result.getImage());
        ImageView productImage = (ImageView) convertView.findViewById(R.id.productImage);
        Picasso.with(con).cancelRequest(productImage);
        String imageUrl = result.getImage().replace("http", "https");
        imageUrl = imageUrl.replace("90x90", "540x540");
        //Log.d(this.getClass().getSimpleName(), imageUrl);
        Picasso.with(con).load(imageUrl).error(R.drawable.default_product).resize(620,540).into(productImage);

        productImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProductDetailActivity(result);
            }
        });


        return convertView;
    }

    private void openProductDetailActivity(Results result) {
        Intent intent = new Intent(con, ProductDetailActivity.class);
        intent.putExtra(Constants.PRODUCT_TPNB, result.getTpnb());
        intent.putExtra(Constants.PRODUCT_IMAGE_URL, result.getImage());
        intent.putExtra(Constants.PRODUCT_NAME, result.getName());
        intent.putExtra(Constants.PRODUCT_PRICE, result.getPrice());
        con.startActivity(intent);
    }

    static class ViewHolder {
        ImageView productImage;
        TextView productName;
    }

}