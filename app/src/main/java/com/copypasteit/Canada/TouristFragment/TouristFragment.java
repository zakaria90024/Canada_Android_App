package com.copypasteit.Canada.TouristFragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.copypasteit.Canada.R;
import com.copypasteit.Canada.main.data.remote.ApiUtils;
import com.copypasteit.Canada.main.model.Tourist;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TouristFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    com.copypasteit.Canada.TouristFragment.CustomAdapter adapter;
    List<Tourist> modelList = new ArrayList<>();
    TouristFragment touristFragment;
    Context context;
    ImageView imageView;


    public TouristFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View View = inflater.inflate(R.layout.touriest_fragment, container, false);

        //imageView = View.findViewById(R.id.imageView3);

        //start recyclerview =======================================================================
        recyclerView = View.findViewById(R.id.recycler_id_torist);
        //refreshLayout = findViewById(R.id.swipeId);

        recyclerView.setHasFixedSize(true);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(View.getContext(), DividerItemDecoration.VERTICAL));
        adapter = new CustomAdapter( touristFragment, modelList, View.getContext());
        layoutManager = new LinearLayoutManager(View.getContext(), LinearLayoutManager.VERTICAL, false);
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

        Call<List<Tourist>> touristList = ApiUtils.getAPIService().getTouristPlace();

        touristList.enqueue(new Callback<List<Tourist>>() {
            @Override
            public void onResponse(Call<List<Tourist>> call, Response<List<Tourist>> response) {
                List<Tourist> posts = response.body();
                adapter.setData(posts);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Tourist>> call, Throwable t) {

            }
        });


    }


}
