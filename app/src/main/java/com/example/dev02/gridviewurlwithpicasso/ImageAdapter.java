package com.example.dev02.gridviewurlwithpicasso;

/**
 * Created by Dev02 on 01/06/2016.
 */
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    int imageTotal = 12;
    public static String[] mThumbIds = {
            "http://192.168.0.102/Products/images/image1.jpg",
            "http://192.168.0.102/Products/images/image2.jpg",
            "http://192.168.0.102/Products/images/image3.jpg",
            "http://192.168.0.102/Products/images/image4.jpg",
            "http://192.168.0.102/Products/images/image5.jpg",
            "http://192.168.0.102/Products/images/image6.jpg",
            "http://192.168.0.102/Products/images/image7.jpg",
            "http://192.168.0.102/Products/images/image8.jpg",
            "http://192.168.0.102/Products/images/image9.jpg",
            "http://192.168.0.102/Products/images/image10.jpg",
            "http://192.168.0.102/Products/images/image11.jpg",
            "http://192.168.0.102/Products/images/image12.jpg"
    };

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return imageTotal;
    }

    @Override
    public String getItem(int position) {
        return mThumbIds[position];
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 200,200));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(5, 5, 5, 5);
        } else {
            imageView = (ImageView) convertView;
        }
        String url = getItem(position);
        Picasso.with(mContext)
                .load(url)
                .placeholder(R.drawable.loader)
                .fit()
                .centerCrop().into(imageView);
        return imageView;
    }
}
