package com.example.copa_america;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FragmentGrupos extends Fragment {

    View view;
    //declaration recycler view
    RecyclerView recyclerViewGroups;
    ArrayList<matches> listPartidos;

    /*private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;*/

    public FragmentGrupos() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.grupos_fragment, container, false);
        listPartidos = new ArrayList<>();
        recyclerViewGroups = view.findViewById(R.id.recycler_view_groups);
        recyclerViewGroups.setLayoutManager(new LinearLayoutManager(getContext()));

        AdapterRecyclerView adapterMatches = new AdapterRecyclerView(listPartidos);
        recyclerViewGroups.setAdapter(adapterMatches);

        llenarLista();

        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void llenarLista() {
        listPartidos.add(new matches(R.mipmap.brasil, R.mipmap.bolivia, getString(R.string.team_brasil),getString(R.string.team_bolivia),getString(R.string.item_date),getString(R.string.item_score),getString(R.string.item_group)));
        listPartidos.add(new matches(R.mipmap.venezuela, R.mipmap.peru, getString(R.string.team_venezuela),getString(R.string.team_peru),getString(R.string.item_date),getString(R.string.item_score),getString(R.string.item_group)));
        listPartidos.add(new matches(R.mipmap.argentina, R.mipmap.colombia, getString(R.string.team_argentina),getString(R.string.team_colombia),getString(R.string.item_date),getString(R.string.item_score),getString(R.string.item_group)));
        listPartidos.add(new matches(R.mipmap.paraguay, R.mipmap.katar, getString(R.string.team_paraguay),getString(R.string.team_katar),getString(R.string.item_date),getString(R.string.item_score),getString(R.string.item_group)));
        listPartidos.add(new matches(R.mipmap.uruguay, R.mipmap.ecuador, getString(R.string.team_uruguay),getString(R.string.team_ecuador),getString(R.string.item_date),getString(R.string.item_score),getString(R.string.item_group)));
        listPartidos.add(new matches(R.mipmap.japan, R.mipmap.chile, getString(R.string.team_japan),getString(R.string.team_chile),getString(R.string.item_date),getString(R.string.item_score),getString(R.string.item_group)));
        listPartidos.add(new matches(R.mipmap.bolivia, R.mipmap.peru, getString(R.string.team_bolivia),getString(R.string.team_peru),getString(R.string.item_date),getString(R.string.item_score),getString(R.string.item_group)));
        listPartidos.add(new matches(R.mipmap.brasil, R.mipmap.venezuela, getString(R.string.team_brasil),getString(R.string.team_venezuela),getString(R.string.item_date),getString(R.string.item_score),getString(R.string.item_group)));
        listPartidos.add(new matches(R.mipmap.colombia, R.mipmap.katar, getString(R.string.team_colombia),getString(R.string.team_katar),getString(R.string.item_date),getString(R.string.item_score),getString(R.string.item_group)));
        listPartidos.add(new matches(R.mipmap.argentina, R.mipmap.paraguay, getString(R.string.team_argentina),getString(R.string.team_paraguay),getString(R.string.item_date),getString(R.string.item_score),getString(R.string.item_group)));
        listPartidos.add(new matches(R.mipmap.uruguay, R.mipmap.japan, getString(R.string.team_uruguay),getString(R.string.team_japan),getString(R.string.item_date),getString(R.string.item_score),getString(R.string.item_group)));
        listPartidos.add(new matches(R.mipmap.ecuador, R.mipmap.chile, getString(R.string.team_ecuador),getString(R.string.team_chile),getString(R.string.item_date),getString(R.string.item_score),getString(R.string.item_group)));
        listPartidos.add(new matches(R.mipmap.bolivia, R.mipmap.venezuela, getString(R.string.team_bolivia),getString(R.string.team_venezuela),getString(R.string.item_date),getString(R.string.item_score),getString(R.string.item_group)));
        listPartidos.add(new matches(R.mipmap.peru, R.mipmap.brasil, getString(R.string.team_peru),getString(R.string.team_brasil),getString(R.string.item_date),getString(R.string.item_score),getString(R.string.item_group)));
        listPartidos.add(new matches(R.mipmap.katar, R.mipmap.argentina, getString(R.string.team_katar),getString(R.string.team_argentina),getString(R.string.item_date),getString(R.string.item_score),getString(R.string.item_group)));
        listPartidos.add(new matches(R.mipmap.colombia, R.mipmap.paraguay, getString(R.string.team_colombia),getString(R.string.team_paraguay),getString(R.string.item_date),getString(R.string.item_score),getString(R.string.item_group)));
        listPartidos.add(new matches(R.mipmap.chile, R.mipmap.uruguay, getString(R.string.team_chile),getString(R.string.team_uruguay),getString(R.string.item_date),getString(R.string.item_score),getString(R.string.item_group)));
        listPartidos.add(new matches(R.mipmap.ecuador, R.mipmap.japan, getString(R.string.team_ecuador),getString(R.string.team_japan),getString(R.string.item_date),getString(R.string.item_score),getString(R.string.item_group)));
    }
}
