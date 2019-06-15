package com.example.copa_america;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentPartidos extends Fragment{

    View view;
    private TabLayout tabLayout;
    private ViewPager viewPagerFragment;

    public FragmentPartidos(){
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.partidos_fragment, container, false);

        //proceso de inflacion de tabLayout, view page para fragments y creacion objeto adapterFragment
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout_id);
        viewPagerFragment = (ViewPager) view.findViewById(R.id.viewPagerFragments_id);
        viewPagerFragment.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener());
        ViewPagerFragmentAdapter adapterFragment = new ViewPagerFragmentAdapter(getChildFragmentManager());
        //creado el objeto ViewPagerFragmentAdapter procedemos a adicionar fragments con la funcion addFragment de la clase ViewPagerFragmentAdapter
        adapterFragment.addFragment(new FragmentGrupos(), getString(R.string.btn1tabLayout));
        adapterFragment.addFragment(new FragmentEliminatorias(), getString(R.string.btn2tabLayout));
        //configuracion adapterFragment al content_main(xml)
        viewPagerFragment.setAdapter(adapterFragment);
        tabLayout.setupWithViewPager(viewPagerFragment);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
