package com.example.saksham.learning.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.saksham.learning.R;
import com.example.saksham.learning.model.Post;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    ArrayList<Post> list = new ArrayList<>();
    Context context;

    public PostAdapter(Context context){

        this.context = context;
    }

    public ArrayList<Post> getList() {
        return list;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.row_post, parent, false);

        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.tvPostId.setText(String.valueOf(list.get(position).getId()));
        holder.tvPostTitle.setText(list.get(position).getTitle());
        holder.tvPostBody.setText(list.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder{

        TextView tvPostId, tvPostTitle, tvPostBody;

        public PostViewHolder(View itemView) {
            super(itemView);

            tvPostId = itemView.findViewById(R.id.tv_post_id);
            tvPostTitle = itemView.findViewById(R.id.tv_post_title);
            tvPostBody = itemView.findViewById(R.id.tv_post_body);
        }
    }
}
