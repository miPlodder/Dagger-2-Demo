package com.example.saksham.learning.module;

import com.example.saksham.learning.api.APIEndpoints;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class PostModule {

    @Provides
    Retrofit retrofit(GsonConverterFactory gsonConverterFactory) {
        return new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(gsonConverterFactory)
                .build();
    }

    @Provides
    GsonConverterFactory gsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    APIEndpoints apiEndpoints(Retrofit retrofit) {
        return retrofit.create(APIEndpoints.class);
    }
}
