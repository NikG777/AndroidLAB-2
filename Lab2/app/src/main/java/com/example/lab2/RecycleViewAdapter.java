package com.example.lab2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.lab2.R;
public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder>
{
    private Context mcontext;
    private ArrayList<Info> inf;
    RequestOptions option;
    public RecycleViewAdapter(ArrayList<Info> inf,Context mcontext)
    {

        this.inf = inf;
        this.mcontext = mcontext;
        option = new RequestOptions().centerCrop();

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mcontext);
        view = inflater.inflate(R.layout.secondactivity,viewGroup,false);
        final MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mcontext,Main3Activity.class);
                i.putExtra("mas",inf);
                i.putExtra("index",viewHolder.getAdapterPosition());
                mcontext.startActivity(i);
            }
        });
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
    myViewHolder.tv_name.setText(inf.get(i).getName());
    myViewHolder.tv_info.setText(inf.get(i).getHelptext());
    /// load image
        Glide.with(mcontext).load("https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/images/tech/"+inf.get(i).getGraphic()).apply(option).into(myViewHolder.img_thumbnail);

    }

    @Override
    public int getItemCount() {
        return inf.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView tv_name;
        TextView tv_info;
        ImageView img_thumbnail;
        LinearLayout view_container;
        public MyViewHolder(View itemView)
        {
            super(itemView);
            view_container = itemView.findViewById(R.id.linear_container);
            tv_name = itemView.findViewById(R.id.tech_name);
            tv_info = itemView.findViewById(R.id.information);
            img_thumbnail = itemView.findViewById(R.id.thumnail);
        }
    }
}
