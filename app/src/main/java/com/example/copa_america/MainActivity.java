package com.example.copa_america;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declaracion bottonNavView
        BottomNavigationView navView = findViewById(R.id.bot_nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //inicio el fragment
        setTitle("partidos");
        FragmentPartidos fragmentPartidos = new FragmentPartidos();
        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
        fragmentTransaction1.replace(R.id.frame, fragmentPartidos, "Tabla Grupos");
        fragmentTransaction1.commit();
        /*
        //proceso de inflacion de tabLayout, view page para fragments y creacion objeto adapterFragment
        tabLayout = (TabLayout) findViewById(R.id.tabLayout_id);
        viewPagerFragment = (ViewPager) findViewById(R.id.viewPagerFragments_id);
        ViewPagerFragmentAdapter adapterFragment = new ViewPagerFragmentAdapter(getSupportFragmentManager());
        //creado el objeto ViewPagerFragmentAdapter procedemos a adicionar fragments con la funcion addFragment de la clase ViewPagerFragmentAdapter
        adapterFragment.addFragment(new FragmentGrupos(), getString(R.string.btn1tabLayout));
        adapterFragment.addFragment(new FragmentEliminatorias(), getString(R.string.btn2tabLayout));
        //configuracion adapterFragment al content_main(xml)
        viewPagerFragment.setAdapter(adapterFragment);
        tabLayout.setupWithViewPager(viewPagerFragment);
        */
        //inflacion toolbar y habilitacion para este activity
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //configuracion de el DrawerLayout colocando la barra de navegacion lateral NavView
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    /*   crea una opcion de un actionSelection en el toolbar, se puede utilizar para añadir equipos favoritos
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }*/
    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/


    //escuchar que boton del navBar fue presionado para generar la accion
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.



        int id = item.getItemId();

        if(id == R.id.nav_home){
            Toast toast = Toast.makeText(getApplicationContext(), getText(R.string.menu_home), Toast.LENGTH_SHORT);
            toast.show();
        }
        else if(id == R.id.nav_qr) {
            Toast toast = Toast.makeText(getApplicationContext(), getText(R.string.menu_qr), Toast.LENGTH_SHORT);
            toast.show();
        } else if (id == R.id.nav_settings) {
            Toast toast = Toast.makeText(getApplicationContext(), getText(R.string.menu_settings), Toast.LENGTH_SHORT);
            toast.show();
        } else if (id == R.id.nav_help) {
            Toast toast = Toast.makeText(getApplicationContext(), getText(R.string.menu_help), Toast.LENGTH_SHORT);
            toast.show();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //escuchar que boton del botNavBar fue presionando para generar la accion
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_match:
                    setTitle("Partidos");
                    FragmentPartidos fragmentPartidos = new FragmentPartidos();
                    FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.frame, fragmentPartidos, "Partidos");
                    fragmentTransaction1.commit();
                    return true;
                case R.id.navigation_groups:
                    setTitle("Tabla de Grupos");
                    FragmentTablaGrupos fragmentTablaGrupos = new FragmentTablaGrupos();
                    FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.frame, fragmentTablaGrupos, "Tabla Grupos");
                    fragmentTransaction2.commit();
                    return true;
                case R.id.navigation_teams:
                    setTitle("Equipos");
                    FragmentEquipos fragmentEquipos = new FragmentEquipos();
                    FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction3.replace(R.id.frame, fragmentEquipos, "Equipos");
                    fragmentTransaction3.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();   //si crea conflicto con otros layouts agregar finish();
        }
    }

}
