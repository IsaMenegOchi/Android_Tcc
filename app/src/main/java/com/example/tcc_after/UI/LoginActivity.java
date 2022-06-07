package com.example.tcc_after.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tcc_after.R;
import com.example.tcc_after.model.Perfil;
import com.example.tcc_after.model.usuarioComum.UsuarioComum;
import com.example.tcc_after.remote.APIUtil;
import com.example.tcc_after.remote.RouterInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private TextView tvLoginRegisterNow;

    private EditText etSenha, etEmail;

    private ImageView ivVerSenha;

    private Button btnLogar;

    private int contador = 0;

    int i;

    RouterInterface routerInterface;

    public static int idPerfil;
    public static int idEmpresa;
    public static int idUsuario;

    List<Perfil> listPerfil = new ArrayList<Perfil>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_both_login);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        routerInterface = APIUtil.getApiInterface();

        tvLoginRegisterNow = findViewById(R.id.tvLogin_RegisterNow);
        etEmail = findViewById(R.id.etLogin_Email);
        etSenha = findViewById(R.id.etLogin_Passaword);
        ivVerSenha = findViewById(R.id.ivLogin_SeePassaword);
        btnLogar = findViewById(R.id.btnLogin);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        ivVerSenha.setOnClickListener(view -> {
            contador++;
            if (contador % 2 == 0) {
                etSenha.setTransformationMethod(PasswordTransformationMethod.getInstance());
                ivVerSenha.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_visibility_off));
            }
            if (contador % 2 != 0) {
                //mostrar
                etSenha.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                ivVerSenha.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_visibility));
            }
        });

        btnLogar.setOnClickListener(view -> {
            Call<List<Perfil>> callPerfils = routerInterface.getPerfils();
            callPerfils.enqueue(new Callback<List<Perfil>>() {
                @Override
                public void onResponse(Call<List<Perfil>> call, Response<List<Perfil>> response) {
                    listPerfil = response.body();

                    for (i = 0; i < listPerfil.size(); i++) {

                        if (listPerfil.get(i).getEmailPerfil().equals(etEmail.getText().toString()) && listPerfil.get(i).getSenhaPerfil().equals(etSenha.getText().toString())) {

                            idPerfil = listPerfil.get(i).getIdPerfil();

                            if (listPerfil.get(i).getUsuarioComum().size() != 0 && listPerfil.get(i).getEmpresa().size() == 0){
                                idUsuario = listPerfil.get(i).getUsuarioComum().get(0).getIdUsuario();
                                Intent intent = new Intent(LoginActivity.this, MainUserActivity.class);
                                intent.putExtra("idPerfil", idPerfil);
                                intent.putExtra("idUsuario", idUsuario);
                                startActivity(intent);
                            }
                            if (listPerfil.get(i).getEmpresa().size() != 0 && listPerfil.get(i).getUsuarioComum().size() == 0){
                                idEmpresa = listPerfil.get(i).getEmpresa().get(0).getIdEmpresa();
                                Intent intent = new Intent(LoginActivity.this, MainCompanyActivity.class);
                                intent.putExtra("idPerfil", idPerfil);
                                intent.putExtra("idEmpresa", idEmpresa);
                                startActivity(intent);
                            }
                        }
                        else{
                            Toast.makeText(LoginActivity.this, "Email ou senha estão incorretos", Toast.LENGTH_LONG).show();
                        }
                    }
                }

            @Override
            public void onFailure (Call <List<Perfil>> call, Throwable t){
                Log.d("teste", "onFailure: " + t.getMessage());
            }

            });
        });



        tvLoginRegisterNow.setOnClickListener(view->{
            startActivity(new Intent(
                    LoginActivity.this, ChoosePerfil.class
            ));
        });
    }
}