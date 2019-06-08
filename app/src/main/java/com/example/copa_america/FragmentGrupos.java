package com.example.copa_america;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentGrupos extends Fragment {

    View view;

    public FragmentGrupos() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.grupos_fragment, container, false);
        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
