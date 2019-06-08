package com.example.copa_america;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private TabLayout tabLayout;
    private ViewPager viewPagerFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //botones de botton navbar
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //proceso tabLayout para adicionar los fragments
        tabLayout = (TabLayout) findViewById(R.id.tabLayout_id);
        viewPagerFragment = (ViewPager) findViewById(R.id.viewPagerFragments_id);
        ViewPagerFragmentAdapter adapter = new ViewPagerFragmentAdapter(getSupportFragmentManager());
        //creado el objeto ViewPagerFragmentAdapter procedemos a adicionar fragments con la funcion de la clase ViewPagerFragmentAdapter
        adapter.AddFragment(new FragmentGrupos(), "Grupos");
        adapter.AddFragment(new FragmentEliminatorias(), "Eliminatorias");
        //configuracion adapter
        viewPagerFragment.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPagerFragment);
    }

}
