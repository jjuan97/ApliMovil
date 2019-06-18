package com.example.copa_america;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class FragmentEquipos extends Fragment {
    View view;

    //declaration recycler view
    RecyclerView recyclerViewEquipos;
    ArrayList<Teams> listEquipos;
    private OnFragmentInteractionListener mListener;

    public FragmentEquipos(){
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.equipos_fragment, container, false);
        listEquipos = new ArrayList<>();
        recyclerViewEquipos = view.findViewById(R.id.recycler_view_teams);
        recyclerViewEquipos.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerViewEquipos.setHasFixedSize(true);

        AddLista();

        AdapterRecyclerViewEquipos adapterEquipos = new AdapterRecyclerViewEquipos(listEquipos);
        recyclerViewEquipos.setAdapter(adapterEquipos);
        adapterEquipos.setOnItemClickListener(onItemClickListener);



        return view;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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
            //Step 4 of 4: Finally call getTag() on the view.
            // This viewHolder will have all required values.
            //RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
            //int position = viewHolder.getAdapterPosition();
            // viewHolder.getItemId();
            // viewHolder.getItemViewType();
            // viewHolder.itemView;
            //Teams thisItem = Teams.get(position);
            FragmentEquipo fragmentSelectedTeam = new FragmentEquipo();
            FragmentTransaction fragmentTransaction1 = getFragmentManager().beginTransaction();
            fragmentTransaction1.replace(R.id.frame, fragmentSelectedTeam);
            fragmentTransaction1.commit();
            //Toast.makeText(getContext(), "You Clicked: " + listEquipos.get
                    //(recyclerViewEquipos.getChildAdapterPosition(view)).getTxtTeam(), Toast.LENGTH_SHORT).show();
            //Create the intent for navigation purposes; the context is the current Activity, so getActivity() must be called
            //Intent i = new Intent(getActivity(), MainActivity.class);
            //Set information in the intent for the next Activity
            //i.putExtra("nombreLista", thisItem.getTitle());
            //Launch the new Activity
            //startActivity(i);
        }
    };

    private void AddLista() {
        listEquipos.add(new Teams(R.mipmap.argentina, getString(R.string.team_argentina)));
        listEquipos.add(new Teams(R.mipmap.bolivia, getString(R.string.team_bolivia)));
        listEquipos.add(new Teams(R.mipmap.brasil, getString(R.string.team_brasil)));
        listEquipos.add(new Teams(R.mipmap.chile, getString(R.string.team_chile)));
        listEquipos.add(new Teams(R.mipmap.colombia, getString(R.string.team_colombia)));
        listEquipos.add(new Teams(R.mipmap.ecuador, getString(R.string.team_ecuador)));
        listEquipos.add(new Teams(R.mipmap.japan, getString(R.string.team_japan)));
        listEquipos.add(new Teams(R.mipmap.katar, getString(R.string.team_katar)));
        listEquipos.add(new Teams(R.mipmap.paraguay, getString(R.string.team_paraguay)));
        listEquipos.add(new Teams(R.mipmap.peru, getString(R.string.team_peru)));
        listEquipos.add(new Teams(R.mipmap.uruguay, getString(R.string.team_uruguay)));
        listEquipos.add(new Teams(R.mipmap.venezuela, getString(R.string.team_venezuela)));

    }
}
