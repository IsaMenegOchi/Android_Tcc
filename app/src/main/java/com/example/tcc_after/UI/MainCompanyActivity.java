package com.example.tcc_after.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.example.tcc_after.R;
import com.example.tcc_after.uiFragments.FeedFragment;
import com.example.tcc_after.uiFragments.MomentsFragment;
import com.example.tcc_after.uiFragments.company.CompanyPerfilFragment;
import com.example.tcc_after.uiFragments.SearchFragment;
import com.example.tcc_after.uiFragments.company.CompanyEventStatisticsFragment;
import com.example.tcc_after.uiFragments.user.perfil.PerfilUserFragment;
import com.example.tcc_after.uiFragments.user.tickets.TicketsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainCompanyActivity extends AppCompatActivity {

    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_company);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        navigationView = findViewById(R.id.company_bottom_navigation);

        navigationView.setOnNavigationItemSelectedListener(navListner);

        getSupportFragmentManager().beginTransaction().replace(R.id.body_container_company, new FeedFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListner = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;


            switch (item.getItemId()) {
                case R.id.nav_search:
                    fragment = new SearchFragment();
                    break;

                case R.id.nav_ticket:

                    fragment = new CompanyEventStatisticsFragment();

//                    if (fragment.equals(TicketsFragment.class)) {
//                        item.setIcon(R.drawable.ic_baseline_local_activity);
//                    } else {
//                        item.setIcon(R.drawable.ic_outline_local_activity);
//                    }
                    break;

                case R.id.nav_home:

                    fragment = new FeedFragment();

                    if (fragment.equals(FeedFragment.class)) {
                        item.setIcon(R.drawable.ic_baseline_home);
                    } else {
                        item.setIcon(R.drawable.ic_outline_home);
                    }

                    break;

                case R.id.nav_moments:

                    fragment = new MomentsFragment();

                    if (fragment.equals(MomentsFragment.class)){
                        item.setIcon(R.drawable.ic_baseline_video_library);
                    }
                    else{
                        item.setIcon(R.drawable.ic_outline_video_library);
                    }

                    break;

                case R.id.nav_perfil:

                    fragment = new CompanyPerfilFragment();


                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.body_container_company, fragment).commit();

            return true;
        }
    };

}