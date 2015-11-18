package com.roman.jsonparsing.jsonparsingexample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by roman on 01/11/2015.
 */
public class myAdapter extends RecyclerView.Adapter<myAdapter.CustomViewHolder> {

    ArrayList<Movie> list;

    public myAdapter(ArrayList<Movie> list){
        this.list = list;
    }

    @Override
    public myAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Movie movie = list.get(position);
        holder.title.setText(movie.getTitle());
        holder.release.setText(movie.getRelease());
        holder.overview.setText(movie.getOverview());
        holder.poster.setImageResource(R.drawable.android);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        protected TextView title,release,overview;
        protected ImageView poster;

        public CustomViewHolder(View itemView) {
            super(itemView);
            this.title = (TextView)itemView.findViewById(R.id.tv_title);
            this.release = (TextView)itemView.findViewById(R.id.tv_release);
            this.overview = (TextView)itemView.findViewById(R.id.tv_overview);
            this.poster = (ImageView)itemView.findViewById(R.id.iv_poster);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
        }
    }


}
