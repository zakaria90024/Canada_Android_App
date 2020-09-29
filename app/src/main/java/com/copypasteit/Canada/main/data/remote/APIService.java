package com.copypasteit.Canada.main.data.remote;

import com.copypasteit.Canada.main.model.History;
import com.copypasteit.Canada.main.model.Post;
import com.copypasteit.Canada.main.model.Slider;
import com.copypasteit.Canada.main.model.Tourist;

import java.util.List;
import retrofit2.Call;

import retrofit2.http.GET;
import retrofit2.http.Query;


public interface APIService {
    @GET("/api/canada/1")
    Call<List<History>> getHistory();

    @GET("/api/canada/2")
    Call<List<Tourist>> getTouristPlace();

    @GET("/api/monako/post")
    Call<List<Post>> getpost();

    @GET("/api/monako/post")
    Call<List<Post>> getUsers(@Query("name") String keyword);

    @GET("/api/monako/slider")
    Call<List<Slider>> getSlider();
}
