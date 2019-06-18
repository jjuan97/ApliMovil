package com.example.copa_america;

import android.app.ProgressDialog;
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
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
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
    ProgressDialog dialog;

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
        dialog=new ProgressDialog(getContext());
        dialog.setMessage("Cargando informacion");
        dialog.show();

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
                //System.out.println("local: "+match.getTxtTeamOne());
                match.setTxtTeamTwo(jsonObject.optString("visitor"));
                //System.out.println("visitante: "+match.getTxtTeamTwo());
                match.setTxtGroup("GRUPO "+jsonObject.optString("group")+"\n"+jsonObject.optString("estadio"));
                //System.out.println("grupo: "+match.getTxtGroup());
                match.setTxtDate(jsonObject.optString("date"));
                //System.out.println("fecha: "+match.getTxtDate());
                match.setState(jsonObject.optString("state"));
                //System.out.println("estado: "+match.getState());
                match.setTime(jsonObject.optString("time"));
                //System.out.println("tiempo: "+match.getTime());
                match.setTxtScore(jsonObject.optString("score"));
                //System.out.println("marcador: "+match.getTxtScore());
                match.setHour(jsonObject.optString("hour"));
                //System.out.println("hora: "+match.getHour());

                listPartidos.add(match);
            }
            AdapterRecyclerView adapterMatches = new AdapterRecyclerView(listPartidos, getContext());
            recyclerViewGroups.setAdapter(adapterMatches);
            dialog.hide();
            adapterMatches.setOnItemClickListener(onItemClickListener);

        }catch(JSONException e){
            dialog.hide();
            e.printStackTrace();
            Toast.makeText(getContext(), "No se ha podido descargar la informacion" +
                    " "+response, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        dialog.hide();
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

            PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
            getActivity().getMenuInflater().inflate(R.menu.menu_ctx_etiqueta, popupMenu.getMenu());

            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.CtxLblOpc1:
                            System.out.println("aquitoy1");
                            return true;
                        case R.id.CtxLblOpc2:
                            System.out.println("aquitoy2");
                            return true;
                        default:
                            return false;
                    }
                }
            });
            popupMenu.show();
            //System.out.println("aquitoy");
            //Toast.makeText(getContext(), "You Clicked: " + listPartidos.get
            //(recyclerViewGroups.getChildAdapterPosition(view)).getTxtTeamOne(), Toast.LENGTH_SHORT).show();
        }
    };

}
