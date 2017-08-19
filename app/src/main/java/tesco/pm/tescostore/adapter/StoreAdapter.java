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

import tesco.pm.tescostore.MapActivity;
import tesco.pm.tescostore.ProductDetailActivity;
import tesco.pm.tescostore.R;
import tesco.pm.tescostore.constant.Constants;
import tesco.pm.tescostore.domain.search.result.store.Results;


/**
 * Created by pmodi4 on 7/29/2017.
 */

public class StoreAdapter extends BaseAdapter {
    Context con;
    Object[] data;


    public StoreAdapter(Context context, Object[] d) {
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
        //ViewHolder holder = null;
        final Results result = ((Results) data[position]);


        LayoutInflater inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.storelist, parent, false);

        TextView storeName = (TextView) convertView.findViewById(R.id.storeNameAdapter);
        storeName.setText(result.getLocation().getName());

        TextView storeAddress1 = (TextView) convertView.findViewById(R.id.storeAddress1);
        storeAddress1.setText(result.getLocation().getContact().getAddress().getLines().get(0).getText());

        TextView storeAddress2 = (TextView) convertView.findViewById(R.id.storeAddress2);
        int size = result.getLocation().getContact().getAddress().getLines().size();
        if (size == 2) {
            storeAddress2.setText(result.getLocation().getContact().getAddress().getLines().get(1).getText());
        } else {
            storeAddress2.setVisibility(View.GONE);
        }

        TextView storeTown = (TextView) convertView.findViewById(R.id.storeTown);
        storeTown.setText(result.getLocation().getContact().getAddress().getTown());

        TextView storePostCode = (TextView) convertView.findViewById(R.id.storePostCode);
        storePostCode.setText(result.getLocation().getContact().getAddress().getPostcode());

        TextView storePhone = (TextView) convertView.findViewById(R.id.storePhone);
        storePhone.setText(result.getLocation().getContact().getPhoneNumbers().get(0).getNumber());

        final double lat = result.getLocation().getGeo().getCoordinates().getLatitude();
        final double lng = result.getLocation().getGeo().getCoordinates().getLongitude();

        ImageView img = (ImageView) convertView.findViewById(R.id.storeMap);
        //img.setClickable(true);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(this.getClass().getSimpleName(), "I am called " + lat + "  " + lng);
                Intent intent = new Intent(con, MapActivity.class);
                intent.putExtra(Constants.LATITUDE, lat);
                intent.putExtra(Constants.LONGITUDE, lng);
                con.startActivity(intent);
            }
        });


        return convertView;
    }

}