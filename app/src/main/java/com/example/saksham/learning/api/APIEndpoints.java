package com.example.saksham.learning.api;

import com.example.saksham.learning.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIEndpoints {

    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("albums")
    Call<List<Post>> getAlbums();

}
