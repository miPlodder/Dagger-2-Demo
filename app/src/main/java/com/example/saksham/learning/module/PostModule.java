package com.example.saksham.learning.module;

import android.content.Context;

import com.example.saksham.learning.R;
import com.example.saksham.learning.api.APIEndpoints;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = ContextModule.class)
public class PostModule {

    @Provides
    Retrofit retrofit(Context context, GsonConverterFactory gsonConverterFactory) {
        return new Retrofit.Builder()
                .baseUrl(context.getString(R.string.base_url))
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
