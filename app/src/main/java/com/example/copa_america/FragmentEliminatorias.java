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
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentEliminatorias extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener{

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
    private JsonObjectRequest jsonObjectRequest;

    public FragmentEliminatorias() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.eliminatorias_fragment, container, false);

        listPartidosCuartos = new ArrayList<>();
        listPartidosSemis = new ArrayList<>();
        listPartidosTercerPlace = new ArrayList<>();
        listPartidosFinal = new ArrayList<>();

        recyclerViewCuartos = view.findViewById(R.id.recycler_view_eliminatorias_cuartos);
        recyclerViewCuartos.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerViewSemis = view.findViewById(R.id.recycler_view_eliminatorias_semifinales);
        recyclerViewSemis.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerViewTercerPlace = view.findViewById(R.id.recycler_view_eliminatorias_tercerlugar);
        recyclerViewTercerPlace.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerViewFinal = view.findViewById(R.id.recycler_view_eliminatorias_final);
        recyclerViewFinal.setLayoutManager(new LinearLayoutManager(getContext()));

        loadWebService();

        return view;
    }

    private void loadWebService() {
        String url = getResources().getString(R.string.urlWebService);
        url = url + "playOffs.json";
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        VolleySingleton.getIntanciaVolley(getContext()).addToRequestQueue(jsonObjectRequest);

    }

    @Override
    public void onResponse(JSONObject response) {
        matches match = null;
        JSONArray json = response.optJSONArray("matches");
        try{
            for(int i=0; i<json.length();i++){
                match = new matches();
                JSONObject jsonObject=null;
                jsonObject= json.getJSONObject(i);

                match.setTxtTeamOne(jsonObject.optString("local"));
                System.out.println("local: "+match.getTxtTeamOne());
                match.setTxtTeamTwo(jsonObject.optString("visitor"));
                System.out.println("visitante: "+match.getTxtTeamTwo());
                match.setTxtDate(jsonObject.optString("date"));
                System.out.println("fecha: "+match.getTxtDate());
                match.setTxtGroup(jsonObject.optString("stage")+"\n"+jsonObject.optString("estadio"));
                System.out.println("grupo: "+match.getTxtGroup());
                match.setState(jsonObject.optString("state"));
                System.out.println("estado: "+match.getState());
                match.setTime(jsonObject.optString("time"));
                System.out.println("tiempo: "+match.getTime());
                match.setTxtScore(jsonObject.optString("score"));
                System.out.println("marcador: "+match.getTxtScore());
                match.setHour(jsonObject.optString("hour"));
                System.out.println("hora: "+match.getHour());

                String stage = jsonObject.optString("stage");
                if (stage.equals("Cuartos de final"))
                    listPartidosCuartos.add(match);
                else if (stage.equals("Semifinal"))
                    listPartidosSemis.add(match);
                else if (stage.equals("Tercer lugar"))
                    listPartidosTercerPlace.add(match);
                else
                    listPartidosFinal.add(match);
            }
            AdapterRecyclerView adapterMatches1 = new AdapterRecyclerView(listPartidosCuartos, getContext());
            recyclerViewCuartos.setAdapter(adapterMatches1);

            AdapterRecyclerView adapterMatches2 = new AdapterRecyclerView(listPartidosSemis, getContext());
            recyclerViewSemis.setAdapter(adapterMatches2);

            AdapterRecyclerView adapterMatches3 = new AdapterRecyclerView(listPartidosTercerPlace, getContext());
            recyclerViewTercerPlace.setAdapter(adapterMatches3);

            AdapterRecyclerView adapterMatches4 = new AdapterRecyclerView(listPartidosFinal, getContext());
            recyclerViewFinal.setAdapter(adapterMatches4);

        }catch(JSONException e){
            e.printStackTrace();
            Toast.makeText(getContext(), "No se ha podido descargar la informacion" +
                    " "+response, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {

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
