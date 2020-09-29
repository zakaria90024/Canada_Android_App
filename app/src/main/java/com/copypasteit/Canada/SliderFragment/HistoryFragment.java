package com.copypasteit.Canada.SliderFragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.copypasteit.Canada.HomeActivity.CustomAdapter;
import com.copypasteit.Canada.HomeActivity.HomeActivity;
import com.copypasteit.Canada.R;
import com.copypasteit.Canada.main.data.remote.ApiUtils;
import com.copypasteit.Canada.main.model.History;
import com.copypasteit.Canada.main.model.Post;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HistoryFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    CustomAdapter adapter;
    List<History> modelList = new ArrayList<>();
    HomeActivity homeActivity;
    HistoryFragment historyFragment;
    Context context;
    ImageView imageView;


    public HistoryFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View View = inflater.inflate(R.layout.history_fragment, container, false);

        //imageView = View.findViewById(R.id.imageView3);

        //start recyclerview =======================================================================
        recyclerView = View.findViewById(R.id.recycler_id_home);
        //refreshLayout = findViewById(R.id.swipeId);

        recyclerView.setHasFixedSize(true);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(View.getContext(), DividerItemDecoration.HORIZONTAL));
        adapter = new CustomAdapter( historyFragment, modelList, View.getContext());
        layoutManager = new LinearLayoutManager(View.getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        //End recyclerview =========================================================================

        return View;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getData();
    }

    private void getData() {

        Call<List<History>> historyList = ApiUtils.getAPIService().getHistory();

        historyList.enqueue(new Callback<List<History>>() {
            @Override
            public void onResponse(Call<List<History>> call, Response<List<History>> response) {
                List<History> posts = response.body();
                adapter.setData(posts);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<History>> call, Throwable t) {

            }
        });

    }


}
