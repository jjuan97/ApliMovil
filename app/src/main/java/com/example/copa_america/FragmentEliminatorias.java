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

public class FragmentEliminatorias extends Fragment {

    View view;
    //declaration recycler view
    RecyclerView recyclerViewCuartos;
    RecyclerView recyclerViewSemis;
    RecyclerView recyclerViewTercerPlace;
    RecyclerView recyclerViewFinal;
    ArrayList<matches> listPartidosCuartos;
    ArrayList<matches> listPartidosSemis;
    ArrayList<matches> listPartidosTercerPlace;
    ArrayList<matches> listPartidosFinal;

    public FragmentEliminatorias() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.eliminatorias_fragment, container, false);

        //adapter para cuartos de final
        listPartidosCuartos = new ArrayList<>();
        recyclerViewCuartos = view.findViewById(R.id.recycler_view_eliminatorias_cuartos);
        recyclerViewCuartos.setLayoutManager(new LinearLayoutManager(getContext()));
        AdapterRecyclerView adapterMatches1 = new AdapterRecyclerView(listPartidosCuartos);
        recyclerViewCuartos.setAdapter(adapterMatches1);
        llenarListaCuartos();
        //adapter para semifinales
        listPartidosSemis = new ArrayList<>();
        recyclerViewSemis = view.findViewById(R.id.recycler_view_eliminatorias_semifinales);
        recyclerViewSemis.setLayoutManager(new LinearLayoutManager(getContext()));
        AdapterRecyclerView adapterMatches2 = new AdapterRecyclerView(listPartidosSemis);
        recyclerViewSemis.setAdapter(adapterMatches2);
        llenarListaSemis();
        //adapter para tercer lugar
        listPartidosTercerPlace = new ArrayList<>();
        recyclerViewTercerPlace = view.findViewById(R.id.recycler_view_eliminatorias_tercerlugar);
        recyclerViewTercerPlace.setLayoutManager(new LinearLayoutManager(getContext()));
        AdapterRecyclerView adapterMatches3 = new AdapterRecyclerView(listPartidosTercerPlace);
        recyclerViewTercerPlace.setAdapter(adapterMatches3);
        llenarListaTercer();
        //adapter para final
        listPartidosFinal = new ArrayList<>();
        recyclerViewFinal = view.findViewById(R.id.recycler_view_eliminatorias_final);
        recyclerViewFinal.setLayoutManager(new LinearLayoutManager(getContext()));
        AdapterRecyclerView adapterMatches4 = new AdapterRecyclerView(listPartidosFinal);
        recyclerViewFinal.setAdapter(adapterMatches4);
        llenarListaFinal();

        return view;
    }

    private void llenarListaFinal() {
        listPartidosFinal.add(new matches(R.mipmap.ninguno, R.mipmap.ninguno, getString(R.string.ninguno),getString(R.string.ninguno),getString(R.string.item_date),getString(R.string.item_score_eliminatorias),getString(R.string.num_llave)));
    }
    private void llenarListaTercer() {
        listPartidosTercerPlace.add(new matches(R.mipmap.ninguno, R.mipmap.ninguno, getString(R.string.ninguno),getString(R.string.ninguno),getString(R.string.item_date),getString(R.string.item_score_eliminatorias),getString(R.string.num_llave)));
    }
    private void llenarListaSemis() {
        listPartidosSemis.add(new matches(R.mipmap.ninguno, R.mipmap.ninguno, getString(R.string.ninguno),getString(R.string.ninguno),getString(R.string.item_date),getString(R.string.item_score_eliminatorias),getString(R.string.num_llave)));
        listPartidosSemis.add(new matches(R.mipmap.ninguno, R.mipmap.ninguno, getString(R.string.ninguno),getString(R.string.ninguno),getString(R.string.item_date),getString(R.string.item_score_eliminatorias),getString(R.string.num_llave)));
    }
    private void llenarListaCuartos() {
        listPartidosCuartos.add(new matches(R.mipmap.ninguno, R.mipmap.ninguno, getString(R.string.ninguno),getString(R.string.ninguno),getString(R.string.item_date),getString(R.string.item_score_eliminatorias),getString(R.string.num_llave)));
        listPartidosCuartos.add(new matches(R.mipmap.ninguno, R.mipmap.ninguno, getString(R.string.ninguno),getString(R.string.ninguno),getString(R.string.item_date),getString(R.string.item_score_eliminatorias),getString(R.string.num_llave)));
        listPartidosCuartos.add(new matches(R.mipmap.ninguno, R.mipmap.ninguno, getString(R.string.ninguno),getString(R.string.ninguno),getString(R.string.item_date),getString(R.string.item_score_eliminatorias),getString(R.string.num_llave)));
        listPartidosCuartos.add(new matches(R.mipmap.ninguno, R.mipmap.ninguno, getString(R.string.ninguno),getString(R.string.ninguno),getString(R.string.item_date),getString(R.string.item_score_eliminatorias),getString(R.string.num_llave)));
    }
}
