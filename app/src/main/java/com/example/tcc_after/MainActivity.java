package com.example.tcc_after;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.tcc_after.UI.ChoosePerfil;
import com.example.tcc_after.UI.LoginActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize and assign variable
//        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        // Set Home selected
//        bottomNavigationView.setSelectedItemId(R.id.home);

        // Perform item selected listener
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

//                switch(item.getItemId())
//                {
//                    case R.id.searchMenu:
//                        startActivity(new Intent(getApplicationContext(), ChoosePerfil.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                    case R.id.ticketMenu:
//                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                    case R.id.homeMenu:
//
//                        return true;
//                }
//                return false;
//            }
//        });

    }
}
