package com.example.tcc_after;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.tcc_after.UI.ChoosePerfil;
import com.example.tcc_after.UI.LoginActivity;
import com.example.tcc_after.UI.user.user_register.UserRegisterActivity02;
import com.example.tcc_after.remote.ConectionViaCep;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       button = findViewById(R.id.buttonMain);
       tv = findViewById(R.id.textMain);

       button.setOnClickListener(view -> {

           BringJsonCep bringJsonCep = new BringJsonCep();
           bringJsonCep.execute("https://viacep.com.br/ws/01001000/json/");

       });
    }

    private class BringJsonCep extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {
            String returnConection = ConectionViaCep.getData(strings[0]);
            return returnConection;
        }

        @Override
        protected void onPostExecute(String s) {
            tv.setText(s);
        }
    }

}
