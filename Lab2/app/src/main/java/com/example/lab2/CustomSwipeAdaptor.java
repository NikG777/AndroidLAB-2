package com.example.lab2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CustomSwipeAdaptor extends PagerAdapter
{
    private ArrayList<Info> infoss;
    private Context ctx;
    private LayoutInflater layoutInflater;
    private RequestOptions option;
    private int pos;

    public CustomSwipeAdaptor(Context ctx, ArrayList<Info> infoss)
    {
        this.ctx = ctx;
        this.infoss = infoss;
        option = new RequestOptions().centerCrop();
    }
    @Override
    public int getCount() {
        return infoss.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {

        return (view == (LinearLayout)o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.swipe_layout,container,false);
        ImageView imageView = (ImageView)item_view.findViewById(R.id.image_view);
        TextView textview = (TextView)item_view.findViewById(R.id.info);
        TextView textview2 = (TextView)item_view.findViewById(R.id.text);
        Glide.with(ctx).load("https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/images/tech/"+infoss.get(position).getGraphic()).into(imageView);
        textview.setText(infoss.get(position).getName());
        textview2.setText(infoss.get(position).getHelptext());
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}

