package com.example.tcc_after.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.tcc_after.R;
import com.example.tcc_after.uiFragments.FeedFragment;
import com.example.tcc_after.uiFragments.MomentsFragment;
import com.example.tcc_after.uiFragments.SearchFragment;
import com.example.tcc_after.uiFragments.user.perfil.UserPerfilFragment;
import com.example.tcc_after.uiFragments.user.tickets.TicketsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.view.WindowManager;

public class MainUserActivity extends AppCompatActivity {

    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        navigationView = findViewById(R.id.user_bottom_navigation);

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.nav_search:
                        fragment = new SearchFragment();
                        break;

                    case R.id.nav_ticket:

                        fragment = new TicketsFragment();

                        if (fragment.equals(TicketsFragment.class)){
                            item.setIcon(R.drawable.ic_baseline_local_activity);
                        }
                        else {
                            item.setIcon(R.drawable.ic_outline_local_activity);
                        }
                        break;

                    case R.id.nav_home:

                        fragment = new FeedFragment();

                        if (fragment.equals(FeedFragment.class)){
                            item.setIcon(R.drawable.ic_baseline_home);
                        }
                        else{
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

                        fragment = new UserPerfilFragment();


                        break;
                }
                    getSupportFragmentManager().beginTransaction().replace(R.id.body_container, fragment).commit();

                return true;
            }
        });


    }


}