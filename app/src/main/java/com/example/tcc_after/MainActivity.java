package com.example.tcc_after;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.tcc_after.UI.FeedActivity;
import com.example.tcc_after.UI.PerfilActivity;
import com.example.tcc_after.UI.user.tickets.UserTicketsArea;
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
                switch (item.getItemId()){
                    case R.id.nav_search:
                       Toast.makeText(MainActivity.this, "Você ainda nao criou essa tela", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_ticket:
                        intent = new Intent(MainActivity.this, UserTicketsArea.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_home:
                        intent = new Intent(MainActivity.this, FeedActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_moments:
//                        intent = new Intent(MainActivity.this, FeedActivity.class);
//                        startActivity(intent);
                        Toast.makeText(MainActivity.this, "Você ainda nao criou essa tela", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_perfil:
                        intent = new Intent(MainActivity.this, PerfilActivity.class);
                        startActivity(intent);
                        break;
                }

                return true;
            }
        });

    }


}
