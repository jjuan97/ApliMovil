package com.example.copa_america;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentTablaGrupos extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener{
    View view;

    private ArrayList<Teams> groupA;
    private ArrayList<Teams> groupB;
    private ArrayList<Teams> groupC;
    private JsonObjectRequest jsonObjectRequest;
    ProgressDialog dialog;

    ImageView imagen;
    TextView datos;
    public FragmentTablaGrupos(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tabla_grupos_fragment, container, false);
        groupA = new ArrayList<>();
        groupB = new ArrayList<>();
        groupC = new ArrayList<>();

        loadWebservice();
        return view;
    }

    private void loadWebservice() {
        dialog=new ProgressDialog(getContext());
        dialog.setMessage("Cargando informacion");
        dialog.show();

        String url = getResources().getString(R.string.urlWebService);
        url = url + "clasification.json";
        System.out.println(url);
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        VolleySingleton.getIntanciaVolley(getContext()).addToRequestQueue(jsonObjectRequest);
    }

    @Override
    public void onResponse(JSONObject response) {
        JSONArray json = response.optJSONArray("clasification");
        try{
            for (int i=0;i<json.length();i++){
                Teams team = null;
                JSONObject jsonObject = null;
                jsonObject = json.getJSONObject(i);

                String group =jsonObject.optString("group");

                JSONArray jsonTeams = jsonObject.getJSONArray("teams");

                for (int j=0; j<jsonTeams.length();j++){
                    team = new Teams();
                    JSONObject teamObject = jsonTeams.getJSONObject(j);
                    team.setPosition(teamObject.optString("position"));
                    System.out.println(team.getPosition());
                    team.setTxtTeam(teamObject.optString("team"));
                    System.out.println(team.getTxtTeam());
                    team.setP(teamObject.optString("P"));
                    System.out.println(team.getP());
                    team.setPj(teamObject.optString("J"));
                    System.out.println(team.getPj());
                    team.setDg(teamObject.optString("DG"));
                    System.out.println(team.getDg());

                    if (group.equals("A")) {
                        System.out.println("A");
                        groupA.add(team);
                    }
                    else if (group.equals("B")) {
                        groupB.add(team);
                        System.out.println("B");
                    }
                    else {
                        groupC.add(team);
                        System.out.println("C");
                    }
                }
            }

            imagen = (ImageView) view.findViewById(R.id.teamImageOneA);
            imagen.setImageResource(selectImg(groupA.get(0).getTxtTeam()));
            datos = (TextView) view.findViewById(R.id.teamNameOneA);
            datos.setText(groupA.get(0).getTxtTeam());
            datos = (TextView) view.findViewById(R.id.scoreOneA);
            datos.setText(groupA.get(0).getP());
            datos = (TextView) view.findViewById(R.id.pjOneA);
            datos.setText(groupA.get(0).getPj());
            datos = (TextView) view.findViewById(R.id.dgOneA);
            datos.setText(groupA.get(0).getDg());

            imagen = (ImageView) view.findViewById(R.id.teamImageSecondA);
            imagen.setImageResource(selectImg(groupA.get(1).getTxtTeam()));
            datos = (TextView) view.findViewById(R.id.teamNameSecondA);
            datos.setText(groupA.get(1).getTxtTeam());
            datos = (TextView) view.findViewById(R.id.scoreSecondA);
            datos.setText(groupA.get(1).getP());
            datos = (TextView) view.findViewById(R.id.pjSecondA);
            datos.setText(groupA.get(1).getPj());
            datos = (TextView) view.findViewById(R.id.dgSecondA);
            datos.setText(groupA.get(1).getDg());

            imagen = (ImageView) view.findViewById(R.id.teamImageThirdA);
            imagen.setImageResource(selectImg(groupA.get(2).getTxtTeam()));
            datos = (TextView) view.findViewById(R.id.teamNameThirdA);
            datos.setText(groupA.get(2).getTxtTeam());
            datos = (TextView) view.findViewById(R.id.scoreThirdA);
            datos.setText(groupA.get(2).getP());
            datos = (TextView) view.findViewById(R.id.pjThirdA);
            datos.setText(groupA.get(2).getPj());
            datos = (TextView) view.findViewById(R.id.dgThirdA);
            datos.setText(groupA.get(2).getDg());

            imagen = (ImageView) view.findViewById(R.id.teamImageFourthA);
            imagen.setImageResource(selectImg(groupA.get(3).getTxtTeam()));
            datos = (TextView) view.findViewById(R.id.teamNameFourthA);
            datos.setText(groupA.get(3).getTxtTeam());
            datos = (TextView) view.findViewById(R.id.scoreFourthA);
            datos.setText(groupA.get(3).getP());
            datos = (TextView) view.findViewById(R.id.pjFourthA);
            datos.setText(groupA.get(3).getPj());
            datos = (TextView) view.findViewById(R.id.dgFourthA);
            datos.setText(groupA.get(3).getDg());

            //GRUPO B
            imagen = (ImageView) view.findViewById(R.id.teamImageOneB);
            imagen.setImageResource(selectImg(groupB.get(0).getTxtTeam()));
            datos = (TextView) view.findViewById(R.id.teamNameOneB);
            datos.setText(groupB.get(0).getTxtTeam());
            datos = (TextView) view.findViewById(R.id.scoreOneB);
            datos.setText(groupB.get(0).getP());
            datos = (TextView) view.findViewById(R.id.pjOneB);
            datos.setText(groupB.get(0).getPj());
            datos = (TextView) view.findViewById(R.id.dgOneB);
            datos.setText(groupB.get(0).getDg());

            imagen = (ImageView) view.findViewById(R.id.teamImageSecondB);
            imagen.setImageResource(selectImg(groupB.get(1).getTxtTeam()));
            datos = (TextView) view.findViewById(R.id.teamNameSecondB);
            datos.setText(groupB.get(1).getTxtTeam());
            datos = (TextView) view.findViewById(R.id.scoreSecondB);
            datos.setText(groupB.get(1).getP());
            datos = (TextView) view.findViewById(R.id.pjSecondB);
            datos.setText(groupB.get(1).getPj());
            datos = (TextView) view.findViewById(R.id.dgSecondB);
            datos.setText(groupB.get(1).getDg());

            imagen = (ImageView) view.findViewById(R.id.teamImageThirdB);
            imagen.setImageResource(selectImg(groupB.get(2).getTxtTeam()));
            datos = (TextView) view.findViewById(R.id.teamNameThirdB);
            datos.setText(groupB.get(2).getTxtTeam());
            datos = (TextView) view.findViewById(R.id.scoreThirdB);
            datos.setText(groupB.get(2).getP());
            datos = (TextView) view.findViewById(R.id.pjThirdB);
            datos.setText(groupB.get(2).getPj());
            datos = (TextView) view.findViewById(R.id.dgThirdB);
            datos.setText(groupB.get(2).getDg());

            imagen = (ImageView) view.findViewById(R.id.teamImageFourthB);
            imagen.setImageResource(selectImg(groupB.get(3).getTxtTeam()));
            datos = (TextView) view.findViewById(R.id.teamNameFourthB);
            datos.setText(groupB.get(3).getTxtTeam());
            datos = (TextView) view.findViewById(R.id.scoreFourthB);
            datos.setText(groupB.get(3).getP());
            datos = (TextView) view.findViewById(R.id.pjFourthB);
            datos.setText(groupB.get(3).getPj());
            datos = (TextView) view.findViewById(R.id.dgFourthB);
            datos.setText(groupB.get(3).getDg());

            //GRUPO C
            imagen = (ImageView) view.findViewById(R.id.teamImageOneC);
            imagen.setImageResource(selectImg(groupC.get(0).getTxtTeam()));
            datos = (TextView) view.findViewById(R.id.teamNameOneC);
            datos.setText(groupC.get(0).getTxtTeam());
            datos = (TextView) view.findViewById(R.id.scoreOneC);
            datos.setText(groupC.get(0).getP());
            datos = (TextView) view.findViewById(R.id.pjOneC);
            datos.setText(groupC.get(0).getPj());
            datos = (TextView) view.findViewById(R.id.dgOneC);
            datos.setText(groupC.get(0).getDg());

            imagen = (ImageView) view.findViewById(R.id.teamImageSecondC);
            imagen.setImageResource(selectImg(groupC.get(1).getTxtTeam()));
            datos = (TextView) view.findViewById(R.id.teamNameSecondC);
            datos.setText(groupC.get(1).getTxtTeam());
            datos = (TextView) view.findViewById(R.id.scoreSecondC);
            datos.setText(groupC.get(1).getP());
            datos = (TextView) view.findViewById(R.id.pjSecondC);
            datos.setText(groupC.get(1).getPj());
            datos = (TextView) view.findViewById(R.id.dgSecondC);
            datos.setText(groupC.get(1).getDg());

            imagen = (ImageView) view.findViewById(R.id.teamImageThirdC);
            imagen.setImageResource(selectImg(groupC.get(2).getTxtTeam()));
            datos = (TextView) view.findViewById(R.id.teamNameThirdC);
            datos.setText(groupC.get(2).getTxtTeam());
            datos = (TextView) view.findViewById(R.id.scoreThirdC);
            datos.setText(groupC.get(2).getP());
            datos = (TextView) view.findViewById(R.id.pjThirdC);
            datos.setText(groupC.get(2).getPj());
            datos = (TextView) view.findViewById(R.id.dgThirdC);
            datos.setText(groupC.get(2).getDg());

            imagen = (ImageView) view.findViewById(R.id.teamImageFourthC);
            imagen.setImageResource(selectImg(groupC.get(3).getTxtTeam()));
            datos = (TextView) view.findViewById(R.id.teamNameFourthC);
            datos.setText(groupC.get(3).getTxtTeam());
            datos = (TextView) view.findViewById(R.id.scoreFourthC);
            datos.setText(groupC.get(3).getP());
            datos = (TextView) view.findViewById(R.id.pjFourthC);
            datos.setText(groupC.get(3).getPj());
            datos = (TextView) view.findViewById(R.id.dgFourthC);
            datos.setText(groupC.get(3).getDg());
            dialog.hide();


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

    private int selectImg(String team) {
        if(team.equals("Argentina"))
            return R.mipmap.argentina;
        else if(team.equals("Bolivia"))
            return R.mipmap.bolivia;
        else if(team.equals("Brasil"))
            return R.mipmap.brasil;
        else if(team.equals("Chile"))
            return R.mipmap.chile;
        else if(team.equals("Colombia"))
            return R.mipmap.colombia;
        else if(team.equals("Ecuador"))
            return R.mipmap.ecuador;
        else if(team.equals("Japón"))
            return R.mipmap.japan;
        else if(team.equals("Catar"))
            return R.mipmap.katar;
        else if(team.equals("Paraguay"))
            return R.mipmap.paraguay;
        else if(team.equals("Perú"))
            return R.mipmap.peru;
        else if(team.equals("Uruguay"))
            return R.mipmap.uruguay;
        else if(team.equals("Venezuela"))
            return R.mipmap.venezuela;
        else
            return R.mipmap.ninguno;
    }
}
