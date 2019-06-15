package com.example.copa_america;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolderDatos> {

    ArrayList<matches> dataList;

    public AdapterRecyclerView(ArrayList<matches> dataList) {
        this.dataList = dataList;
    }

    //onCreateViewHolder enlaca este adaptador con item_list (XML)
    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ViewHolderDatos(view);
    }

    //obetenemos los datos de la clase matches.java
    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos viewHolderDatos, int i) {
        viewHolderDatos.imgTeamOne.setImageResource(dataList.get(i).getImgTeamOne());
        viewHolderDatos.imgTeamTwo.setImageResource(dataList.get(i).getImgTeamTwo());
        viewHolderDatos.txtTeamOne.setText(dataList.get(i).getTxtTeamOne());
        viewHolderDatos.txtTeamTwo.setText(dataList.get(i).getTxtTeamTwo());
        viewHolderDatos.txtDate.setText(dataList.get(i).getTxtDate());
        viewHolderDatos.txtScore.setText(dataList.get(i).getTxtScore());
        viewHolderDatos.txtGroup.setText(dataList.get(i).getTxtGroup());
    }

    //retorna el tamaño de la lista de partidos
    @Override
    public int getItemCount() {
        return dataList.size();
    }

    //asigancion de la informacion que se mostrara en el RecyclerView
    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        ImageView imgTeamOne;
        ImageView imgTeamTwo;
        TextView txtTeamOne;
        TextView txtTeamTwo;
        TextView txtDate;
        TextView txtScore;
        TextView txtGroup;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            imgTeamOne = (ImageView) itemView.findViewById(R.id.image_team1);
            imgTeamTwo = (ImageView) itemView.findViewById(R.id.image_team2);
            txtTeamOne = (TextView) itemView.findViewById(R.id.text_team_one);
            txtTeamTwo = (TextView) itemView.findViewById(R.id.text_team_two);
            txtDate = (TextView) itemView.findViewById(R.id.text_date);
            txtScore = (TextView) itemView.findViewById(R.id.text_score);
            txtGroup = (TextView) itemView.findViewById(R.id.text_group);
        }
    }
}
