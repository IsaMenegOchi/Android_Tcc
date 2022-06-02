package com.example.tcc_after.UI.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tcc_after.R;
import com.example.tcc_after.model.usuarioComum.UsuarioComum;
import com.example.tcc_after.remote.APIUtil;
import com.example.tcc_after.remote.RouterInterface;
import com.example.tcc_after.uiFragments.user.perfil.PerfilUserFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserEditPerfilActivity extends AppCompatActivity {

    private EditText etBiografia, etNickname, etSenha, etEmail, etNome, etDataNasc, etCidade, etCep, etEstado;

    private Button btnSave;
    RouterInterface routerInterface;
    List<UsuarioComum> listUsuarioComum = new ArrayList<UsuarioComum>();
    int idUsuarioComum = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_edit_perfil);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        etBiografia = findViewById(R.id.etUserEditPerfil_UserDescription);
        etNickname = findViewById(R.id.etUserEditPerfil_UserNickname);
        etSenha = findViewById(R.id.etUserEditPerfil_UserPassword);
        etEmail = findViewById(R.id.etUserEditPerfil_UserEmail);
        etNome = findViewById(R.id.etUserEditPerfil_UserName);
        etDataNasc = findViewById(R.id.etUserEditPerfil_UserBirth);
        etCidade = findViewById(R.id.etUserEditPerfil_UserCity);
        etCep = findViewById(R.id.etUserEditPerfil_UserCep);
        etEstado = findViewById(R.id.etUserEditPerfil_UserState);
//        etBiografia = findViewById(R.id.);

        routerInterface = APIUtil.getApiInterface();
        Call<List<UsuarioComum>> getUsuarioComumPorId = routerInterface.getUsuarioComumId(idUsuarioComum);
        getUsuarioComumPorId.enqueue(new Callback<List<UsuarioComum>>() {
            @Override
            public void onResponse(Call<List<UsuarioComum>> call, Response<List<UsuarioComum>> response) {


                if (response.isSuccessful()) {

                    listUsuarioComum = response.body();

                    idUsuarioComum = listUsuarioComum.get(0).getIdUsuario();
                    etNome.setText(listUsuarioComum.get(0).getNomeCompletoUsuario());

                    Log.d("teste", "onResponse: " + idUsuarioComum);
                    etBiografia.setText(listUsuarioComum.get(0).getPerfil().getBiografiaPerfil());
                    etNickname.setText(listUsuarioComum.get(0).getPerfil().getNicknamePerfil());
                    etSenha.setText(listUsuarioComum.get(0).getPerfil().getSenhaPerfil());
                    etEmail.setText(listUsuarioComum.get(0).getPerfil().getEmailPerfil());
//                    etCep.setText(listUsuarioComum.get(0).getEndereco());
                    etCidade.setText(listUsuarioComum.get(0).getEndereco().getCidadeEndereco());
                    etEstado.setText(listUsuarioComum.get(0).getEndereco().getEstadoEndereco());

//                    etBiografia.setText(listUsuarioComum.get(0).getBiografiaUsuario());
//                    etNickname.setText(listUsuarioComum.get(0).getNicknameUsuario());
//                    etSenha.setText(listUsuarioComum.get(0).getSenhaUsuario());
//                    etEmail.setText(listUsuarioComum.get(0).getEmailUsuario());
//                    etCep.setText(listUsuarioComum.get(0).getCepUsuario());
//                    etCidade.setText(listUsuarioComum.get(0).getCidadeUsuario());
//                    etEstado.setText(listUsuarioComum.get(0).getEstadoUsuario());

//                    onDestroy();
                    btnSave.setOnClickListener(view -> {

                        UsuarioComum usuarioComum = new UsuarioComum();
                        usuarioComum.setBiografiaUsuario(etBiografia.getText().toString());
                        usuarioComum.setNomeCompletoUsuario(etNome.getText().toString());
                        usuarioComum.setNicknameUsuario(etNickname.getText().toString());
                        usuarioComum.setSenhaUsuario(etSenha.getText().toString());
                        usuarioComum.setEmailUsuario(etEmail.getText().toString());
                        usuarioComum.setCepUsuario(etCep.getText().toString());
                        usuarioComum.setCidadeUsuario(etCidade.getText().toString());
                        usuarioComum.setEstadoUsuario(etEstado.getText().toString());

                        Call<UsuarioComum> updateUsuarioComum = routerInterface.updateUsuarioComum(idUsuarioComum, usuarioComum);
                        updateUsuarioComum.enqueue(new Callback<UsuarioComum>() {
                            @Override
                            public void onResponse(Call<UsuarioComum> call, Response<UsuarioComum> response) {
                                Toast.makeText(UserEditPerfilActivity.this, "Foi nega, vc alterou o livro", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(UserEditPerfilActivity.this, PerfilUserFragment.class));
                            }

                            @Override
                            public void onFailure(Call<UsuarioComum> call, Throwable t) {
                                Toast.makeText(UserEditPerfilActivity.this, "Não foi possível editar os dados", Toast.LENGTH_SHORT).show();
                            }
                        });
                    });
                }
            }

            @Override
            public void onFailure (Call <List<UsuarioComum >> call, Throwable t){

                Log.d("teste", "onFailure: " + t.getMessage());


            }
        });
    }
}