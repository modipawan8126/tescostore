package tesco.pm.tescostore.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.Settings;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import tesco.pm.tescostore.R;
import tesco.pm.tescostore.adapter.image.loader.ImageLoader;
import tesco.pm.tescostore.connector.ImageDownloaderTask;
import tesco.pm.tescostore.domain.search.result.ProductSearchResult;
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
        Results result = ((Results) data[position]);


        LayoutInflater inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.activity_productlist, parent, false);

        TextView productName = (TextView) convertView.findViewById(R.id.productNameAdapter);
        productName.setText(result.getName());

        Log.d(this.getClass().getSimpleName(), result.getImage());
        ImageView productImage = (ImageView) convertView.findViewById(R.id.productImage);
        Picasso.with(con).cancelRequest(productImage);
        String imageUrl = result.getImage().replace("http", "https");
        Picasso.with(con).load(imageUrl).error(R.drawable.default_product).resize(110,110).into(productImage);

        /*if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_productlist, parent, false);

            holder = new ViewHolder();
            holder.productImage = (ImageView)convertView.findViewById(R.id.productImage);
            holder.productName = (TextView)convertView.findViewById(R.id.productNameAdapter);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Log.d(this.getClass().getSimpleName(), result.getImage());
        holder.productName.setText(result.getName());
        Picasso.with(con).cancelRequest(holder.productImage);
        Picasso.with(con).load("http://img.tesco.com/Groceries/pi/672/5054268870672/IDShot_90x90.jpg").into(holder.productImage);

*/
        return convertView;
    }


        static class ViewHolder
        {
            ImageView productImage;
            TextView productName;
        }

}