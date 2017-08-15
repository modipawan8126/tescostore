package tesco.pm.tescostore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import tesco.pm.tescostore.R;

/**
 * Created by pmodi4 on 8/15/2017.
 */

public class ProductAttributeAdapter extends BaseAdapter {
    Context con;
    Object[] data;


    public ProductAttributeAdapter(Context context, Object[] d) {
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

        final ProductAttributeObject productAttributeObject = ((ProductAttributeObject) data[position]);


        LayoutInflater inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.activity_productattributelist, parent, false);

        TextView productAttributeName = (TextView) convertView.findViewById(R.id.productAttributeName);
        productAttributeName.setText(productAttributeObject.getKey());

        TextView productAttributeValue = (TextView) convertView.findViewById(R.id.productAttributeValue);
        productAttributeValue.setText(productAttributeObject.getValue());

        return convertView;
    }
}
