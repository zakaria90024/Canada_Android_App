package com.copypasteit.Canada.SliderFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.copypasteit.Canada.R;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;


public class SliderFragment extends Fragment {


    ImageSlider imageSlider;
    public SliderFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View View = inflater.inflate(R.layout.layout_slider, container, false);

        List<SlideModel> imageList = new ArrayList<>();
        imageSlider = View.findViewById(R.id.imege_slider);


        imageList.add(new SlideModel("https://apps.bncodeing.com/public/frontend/monako_slider/1679144321097442.jpg", "Canadian Museum for Human Rights."));
        imageList.add(new SlideModel("https://apps.bncodeing.com/public/frontend/monako_slider/1679144288666801.jpg", "Gros Morne National Park."));
        imageList.add(new SlideModel("https://apps.bncodeing.com/public/frontend/monako_slider/1679144267522975.png", "Banff National Park Canada's"));
        imageList.add(new SlideModel("https://apps.bncodeing.com/public/frontend/monako_slider/1679144244442718.jpg", "Vancouver's Stanley Park"));
        imageList.add(new SlideModel("https://apps.bncodeing.com/public/frontend/monako_slider/1679144873238229.jpg", "Old Montreal in Canada"));
        imageList.add(new SlideModel("https://apps.bncodeing.com/public/frontend/monako_slider/1679144614177342.jpg", "Ottawa's Parliament Hill"));
        imageList.add(new SlideModel("https://apps.bncodeing.com/public/frontend/monako_slider/1679144187486341.jpg", "Vancouver Island Canada's"));


        imageSlider.setImageList(imageList, true);

        return View;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



}
