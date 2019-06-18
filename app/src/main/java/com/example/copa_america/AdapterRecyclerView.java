package com.example.copa_america;

import android.content.Context;
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
    private View.OnClickListener listenerForMatches;
    Context context;

    public AdapterRecyclerView(ArrayList<matches> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
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
        //viewHolderDatos.imgTeamOne.setImageResource(dataList.get(i).getImgTeamOne());
        //viewHolderDatos.imgTeamTwo.setImageResource(dataList.get(i).getImgTeamTwo());
        viewHolderDatos.txtTeamOne.setText(dataList.get(i).getTxtTeamOne());
        viewHolderDatos.txtTeamTwo.setText(dataList.get(i).getTxtTeamTwo());
        viewHolderDatos.txtGroup.setText(dataList.get(i).getTxtGroup());
        if(dataList.get(i).getState().equals("Live")){
            viewHolderDatos.txtScore.setText(dataList.get(i).getTxtScore());
            viewHolderDatos.txtDate.setText(dataList.get(i).getTime());
            viewHolderDatos.txtDate.setTextColor(context.getResources().getColor(R.color.colorSecondary));
        }
        else if (dataList.get(i).getState().equals("Finalizado")){
            viewHolderDatos.txtScore.setText(dataList.get(i).getTxtScore());
            viewHolderDatos.txtDate.setText(dataList.get(i).getState());
            viewHolderDatos.txtDate.setTextColor(context.getResources().getColor(R.color.finalizado));
        }
        else {
            viewHolderDatos.txtScore.setText(dataList.get(i).getHour());
            viewHolderDatos.txtDate.setText(dataList.get(i).getTxtDate());
            viewHolderDatos.txtDate.setTextColor(context.getResources().getColor(R.color.colorBlackLight));
        }

        viewHolderDatos.imgTeamOne.setImageResource(selectImg(dataList.get(i).getTxtTeamOne()));
        viewHolderDatos.imgTeamTwo.setImageResource(selectImg(dataList.get(i).getTxtTeamTwo()));



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

    //retorna el tamaño de la lista de partidos
    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void setOnItemClickListener(View.OnClickListener listenerForMatches){

        this.listenerForMatches = listenerForMatches;

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
            itemView.setTag(this);
            itemView.setOnClickListener(listenerForMatches);
        }
    }
}
