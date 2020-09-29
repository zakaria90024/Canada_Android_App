package com.copypasteit.Canada.HomeActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.copypasteit.Canada.R;
import com.copypasteit.Canada.SliderFragment.HistoryFragment;
import com.copypasteit.Canada.ViewActivity.ViewActivity;
import com.copypasteit.Canada.main.model.History;


import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<ViewHolder> {

    Context mContext;
    HistoryFragment historyFragment;
    //HomeActivity homeActivity;
    public List<History> posts;

    public CustomAdapter( HistoryFragment historyFragment, List<History> posts, Context mContext) {

        //this.homeActivity = homeActivity;
        this.posts = posts;
        this.historyFragment = historyFragment;
        this.mContext = mContext;
    }

    public void setData(List<History> posts){
        this.posts = posts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_homerecycler, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemView);

        viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String dress_name = posts.get(position).getPostTitle();
                String dress_model_no = posts.get(position).getPostSlug();
                String dress_size = posts.get(position).getCategoryId();
                String dress_details = posts.get(position).getPostDetails();
                String dress_image_url = posts.get(position).getPostImageUrl();


                //Intent to start activity
                Intent intent = new Intent(mContext, ViewActivity.class);
                //put data in intent
                intent.putExtra("dress_name", dress_name);
                intent.putExtra("dress_model_no", dress_model_no);
                intent.putExtra("dress_size", dress_size);
                intent.putExtra("dress_image_url", dress_image_url);
                intent.putExtra("dress_details", dress_details);
                //start activity

                mContext .startActivity(intent);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        History post = posts.get(position);
        String dress_name = post.getPostTitle();
        String dress_model_no = post.getPostSlug();
        String monako_details = post.getPostDetails();
        String dress_image_url = post.getPostImageUrl();

        holder.monako_name.setText(dress_name);
        holder.monako_slug.setText(dress_model_no);
        //holder.monako_detils.setText(monako_details);
//
        Glide
                .with(mContext)
                .load(dress_image_url)
                .override(320, 200)
                .centerCrop()
                //.placeholder(R.drawable.ic_spinner)
                .into(holder.monako_image);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }


}
