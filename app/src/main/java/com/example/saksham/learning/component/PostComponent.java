package com.example.saksham.learning.component;

import com.example.saksham.learning.api.APIEndpoints;
import com.example.saksham.learning.ui.adapter.PostAdapter;
import com.example.saksham.learning.module.PostAdapterModule;
import com.example.saksham.learning.module.PostModule;

import dagger.Component;

@Component(modules = {PostModule.class, PostAdapterModule.class})
public interface PostComponent {
    APIEndpoints getAPIEndpoints();
    PostAdapter getPostAdapter();
}
