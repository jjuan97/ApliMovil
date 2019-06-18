package com.example.copa_america;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

public class FragmentGrupos extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener{

    View view;
    //declaration recycler view
    RecyclerView recyclerViewGroups;
    ArrayList<matches> listPartidos;
    private FragmentGrupos.OnFragmentInteractionListener mListener;
    JsonObjectRequest jsonObjectRequest;

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

        //AdapterRecyclerView adapterMatches = new AdapterRecyclerView(listPartidos);
        //recyclerViewGroups.setAdapter(adapterMatches);
        //llenarLista();
        loadWebService();

        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void loadWebService(){
        String url = getResources().getString(R.string.urlWebService);
        url = url + "GroupMatches.json";
        System.out.println("URL: "+url);
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        VolleySingleton.getIntanciaVolley(getContext()).addToRequestQueue(jsonObjectRequest);
    }

    @Override
    public void onResponse(JSONObject response) {
        matches match = null;
        JSONArray json = response.optJSONArray("matches");
        try{
            for (int i=0;i<json.length();i++){
                match = new matches();
                JSONObject jsonObject=null;
                jsonObject=json.getJSONObject(i);

                match.setTxtTeamOne(jsonObject.optString("local"));
                System.out.println("local: "+match.getTxtTeamOne());
                match.setTxtTeamTwo(jsonObject.optString("visitor"));
                System.out.println("visitante: "+match.getTxtTeamTwo());
                match.setTxtGroup("GRUPO "+jsonObject.optString("group")+"\n"+jsonObject.optString("estadio"));
                System.out.println("grupo: "+match.getTxtGroup());
                match.setTxtDate(jsonObject.optString("date"));
                System.out.println("fecha: "+match.getTxtDate());
                match.setState(jsonObject.optString("state"));
                System.out.println("estado: "+match.getState());
                match.setTime(jsonObject.optString("time"));
                System.out.println("tiempo: "+match.getTime());
                match.setTxtScore(jsonObject.optString("score"));
                System.out.println("marcador: "+match.getTxtScore());
                match.setHour(jsonObject.optString("hour"));
                System.out.println("hora: "+match.getHour());

                listPartidos.add(match);
            }
            AdapterRecyclerView adapterMatches = new AdapterRecyclerView(listPartidos, getContext());
            recyclerViewGroups.setAdapter(adapterMatches);
            adapterMatches.setOnItemClickListener(onItemClickListener);

        }catch(JSONException e){
            e.printStackTrace();
            Toast.makeText(getContext(), "No se ha podido descargar la informacion" +
                    " "+response, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getContext(), "NO SE PUDO CONECTAR "+ error.toString(), Toast.LENGTH_LONG).show();
        System.out.println();
        //dialog.hide();
        Log.d("ERROR: ", error.toString());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentGrupos.OnFragmentInteractionListener) {
            mListener = (FragmentGrupos.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            //FragmentEquipo fragmentSelectedTeam = new FragmentEquipo();
/*
            //enviar datos referencia de que equipo se quiere mostrar el fragment
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
            int position = viewHolder.getAdapterPosition();
            Bundle args = new Bundle();
            args.putInt("position", position);
            fragmentSelectedTeam.setArguments(args);
            //System.out.println(position);

            //transactiones para pasar a el siguiente fragment de descripcion del equipo
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, fragmentSelectedTeam);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();*/
            System.out.println("aquitoy");
            Toast.makeText(getContext(), "You Clicked: " + listPartidos.get
            (recyclerViewGroups.getChildAdapterPosition(view)).getTxtTeamOne(), Toast.LENGTH_SHORT).show();
        }
    };


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
