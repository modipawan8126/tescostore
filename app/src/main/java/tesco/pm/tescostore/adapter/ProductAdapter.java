package tesco.pm.tescostore.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
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
import tesco.pm.tescostore.domain.search.result.Results;


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
        Picasso.with(con).load(imageUrl).error(R.drawable.default_product).resize(110, 110).into(productImage);

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
        con.startActivity(intent);
    }

    static class ViewHolder {
        ImageView productImage;
        TextView productName;
    }

}