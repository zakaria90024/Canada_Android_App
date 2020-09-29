package com.copypasteit.Canada.TouristFragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.copypasteit.Canada.R;

import org.sufficientlysecure.htmltextview.HtmlTextView;


public class ViewHolder extends RecyclerView.ViewHolder {
    TextView post_name, post_slug;
    HtmlTextView post_detils;
    ImageView post_image;
    View mView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        mView = itemView;
        post_name = itemView.findViewById(R.id.txt_title_id_torist);
        post_slug = itemView.findViewById(R.id.txt_details_id_torist);
        post_detils = itemView.findViewById(R.id.html_text_torist);
        post_image = itemView.findViewById(R.id.imageViewtorist);

       itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               mClickListener.onItemClick(v, getAdapterPosition());
           }
       });
    }
    private ViewHolder.ClickListener mClickListener;

    public interface ClickListener{
        void  onItemClick(View view, int position);
    }

    public void setOnClickListener(ViewHolder.ClickListener clickListener){
        mClickListener = clickListener;
    }


}
