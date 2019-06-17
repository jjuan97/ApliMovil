package com.example.copa_america;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterRecyclerViewEquipos extends RecyclerView.Adapter<AdapterRecyclerViewEquipos.ViewHolderEquipos> {

    ArrayList<Teams> dataList;

    public AdapterRecyclerViewEquipos(ArrayList<Teams> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolderEquipos onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_equipos,parent,false);
        return new ViewHolderEquipos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderEquipos viewHolderEquipos, int i) {
        viewHolderEquipos.imgTeam.setImageResource(dataList.get(i).getImgTeam());
        viewHolderEquipos.txtTeam.setText(dataList.get(i).getTxtTeam());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolderEquipos extends RecyclerView.ViewHolder {

        ImageView imgTeam;
        TextView txtTeam;

        public ViewHolderEquipos(@NonNull View itemView) {
            super(itemView);

            imgTeam = (ImageView) itemView.findViewById(R.id.image_team);
            txtTeam = (TextView) itemView.findViewById(R.id.text_name_team);
        }
    }
}
