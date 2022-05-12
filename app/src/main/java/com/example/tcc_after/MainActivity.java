package com.example.tcc_after;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.tcc_after.uiFragments.FeedFragment;
import com.example.tcc_after.uiFragments.MomentsFragment;
import com.example.tcc_after.uiFragments.PerfilFragment;
import com.example.tcc_after.uiFragments.SearchFragment;
import com.example.tcc_after.uiFragments.user.perfil.UserPerfilFragment;
import com.example.tcc_after.uiFragments.user.tickets.TicketsFragment;
import com.example.tcc_after.uiFragments.user.verification.RequestVerificationFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.content.Intent;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        navigationView = findViewById(R.id.bottom_navigation);

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent = null;
                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.nav_search:
                        fragment = new SearchFragment();
                        break;

                    case R.id.nav_ticket:
                        if (item.isCheckable()){
                            item.setIcon(R.drawable.ic_baseline_local_activity);
                        }
                        else{
                            item.setIcon(R.drawable.ic_outline_local_activity);
                        }

                        fragment = new TicketsFragment();
                        break;

                    case R.id.nav_home:
                        if (item.isCheckable()){
                            item.setIcon(R.drawable.ic_baseline_home);
                        }
                        else{
                            item.setIcon(R.drawable.ic_outline_local_activity);
                        }

                        fragment = new FeedFragment();
                        break;

                    case R.id.nav_moments:
                        if (item.isCheckable()){
                            item.setIcon(R.drawable.ic_baseline_video_library);
                        }
                        else{
                            item.setIcon(R.drawable.ic_outline_local_activity);
                        }
                        fragment = new MomentsFragment();
                        break;

                    case R.id.nav_perfil:
                        if (item.isCheckable()){
                            item.setIcon(R.drawable.ic_baseline_person);
                        }
                        else{
                            item.setIcon(R.drawable.ic_outline_local_activity);
                        }

                        fragment = new UserPerfilFragment();
                        break;
                }
                    getSupportFragmentManager().beginTransaction().replace(R.id.body_container, fragment).commit();
                return true;
            }
        });


    }


}
