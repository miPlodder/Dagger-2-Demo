package com.example.saksham.learning.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.saksham.learning.component.DaggerPostComponent;
import com.example.saksham.learning.R;
import com.example.saksham.learning.api.APIEndpoints;
import com.example.saksham.learning.component.PostComponent;
import com.example.saksham.learning.model.Post;
import com.example.saksham.learning.module.ContextModule;
import com.example.saksham.learning.ui.adapter.PostAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostActivity extends AppCompatActivity {

    @BindView(R.id.rv_posts)
    RecyclerView rvPosts;

    PostAdapter postAdapter;

    ArrayList<Post> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        ButterKnife.bind(this);

        //if i have added a constructor to module, it must be called below like 'ContextModule'
        PostComponent postComponent = DaggerPostComponent.builder().contextModule(new ContextModule(this)).build();
        APIEndpoints apiEndpoints = postComponent.getAPIEndpoints();


        Call<List<Post>> request = apiEndpoints.getPosts();

        postAdapter = postComponent.getPostAdapter();
        //postAdapter = new PostAdapter(this);

        list = postAdapter.getList();
        request.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                for (Post item : response.body()) {
                    list.add(item);
                }
                postAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(PostActivity.this, "Failed To Fetch", Toast.LENGTH_SHORT).show();
            }
        });

        rvPosts.setLayoutManager(new LinearLayoutManager(this));
        rvPosts.setAdapter(postAdapter);
    }
}