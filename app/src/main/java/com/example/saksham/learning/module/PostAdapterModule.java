package com.example.saksham.learning.module;

import android.content.Context;

import com.example.saksham.learning.ui.adapter.PostAdapter;

import dagger.Module;
import dagger.Provides;

@Module(includes = ContextModule.class)
public class PostAdapterModule {

    @Provides
    PostAdapter postAdapter(Context context) {
        return new PostAdapter(context);
    }

}
