package com.example.sj971.lab3_3_r;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment1 extends Fragment {
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //For fragment1
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_fragment1, container, false);

        return rootView;
    }
}
