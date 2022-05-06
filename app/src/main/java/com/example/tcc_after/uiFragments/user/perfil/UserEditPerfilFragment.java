package com.example.tcc_after.uiFragments.user.perfil;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tcc_after.MainActivity;
import com.example.tcc_after.R;
import com.example.tcc_after.UI.PerfilActivity;
import com.example.tcc_after.model.UsuarioComum;
import com.example.tcc_after.remote.APIUtil;
import com.example.tcc_after.remote.RouterInterface;
import com.example.tcc_after.util.DateConvert;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserEditPerfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserEditPerfilFragment extends Fragment {

    private EditText nickname, nomeCompleto, biografia, email, senha, dataNascimento, CEP, cidade, estado;
    private Button salvar, cancelar;

    RouterInterface routerInterface;
    List<UsuarioComum> list = new ArrayList<UsuarioComum>();

    public UserEditPerfilFragment() {
        // Required empty public constructor
    }

    public static UserEditPerfilFragment newInstance(String param1, String param2) {
        UserEditPerfilFragment fragment = new UserEditPerfilFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        nickname = getActivity().findViewById(R.id.etEditPerfil_UserNickname);
        biografia = getActivity().findViewById(R.id.etEditPerfil_UserNickname);
        email = getActivity().findViewById(R.id.etEditPerfil_UserNickname);
        nomeCompleto = getActivity().findViewById(R.id.etEditPerfil_UserNickname);
        senha = getActivity().findViewById(R.id.etEditPerfil_UserNickname);
        CEP = getActivity().findViewById(R.id.etEditPerfil_UserNickname);
        estado = getActivity().findViewById(R.id.etEditPerfil_UserNickname);
        cidade = getActivity().findViewById(R.id.etEditPerfil_UserNickname);
        dataNascimento = getActivity().findViewById(R.id.etEditPerfil_UserNickname);



        //!Trocar id
        routerInterface = APIUtil.getApiInterface();
        Call<List<UsuarioComum>> getUsuarioComum= routerInterface.getUsuarioComumId(1);
        getUsuarioComum.enqueue(new Callback<List<UsuarioComum>>() {
            @Override
            public void onResponse(Call<List<UsuarioComum>> call, Response<List<UsuarioComum>> response) {

                if (response.isSuccessful()){
                    list = response.body();

                    nomeCompleto.setText(list.get(0).getNomeCompletoUsuario());
                    nickname.setText(list.get(0).getNicknameUsuario());
                    biografia.setText(list.get(0).getBiografia());
                    email.setText(list.get(0).getEmailUsuario());
                    senha.setText(list.get(0).getSenhaUsuario());
                    dataNascimento.setText(list.get(0).getDataNascUsuario().toString());
                    CEP.setText(list.get(0).getCep());
                    estado.setText(list.get(0).getEstado());
                    cidade.setText(list.get(0).getCidade());

                    salvar.setOnClickListener(view -> {
                        UsuarioComum usuarioComum = new UsuarioComum();
                        usuarioComum.setNomeCompletoUsuario(nomeCompleto.getText().toString());
                        usuarioComum.setBiografia(biografia.getText().toString());
                        usuarioComum.setEmailUsuario(email.getText().toString());
                        usuarioComum.setSenhaUsuario(senha.getText().toString());
//                        usuarioComum.getDataNascUsuario(DateConvert.format(dataNascimento.getText().toString()));
                        usuarioComum.setCep(CEP.getText().toString());
                        usuarioComum.setEstado(estado.getText().toString());
                        usuarioComum.setCidade(cidade.getText().toString());

                        Call<UsuarioComum> updateUsuarioComum = routerInterface.updateUsuarioComum(1, usuarioComum);

                        updateUsuarioComum.enqueue(new Callback<UsuarioComum>() {
                            @Override
                            public void onResponse(Call<UsuarioComum> call, Response<UsuarioComum> response) {
//                                Toast.makeText(MainA, "foi nega, vc alterou o livro", Toast.LENGTH_SHORT).show();

//                                startActivity(new Intent(UserEditPerfilFragment.this, PerfilActivity.class));
                            }

                            @Override
                            public void onFailure(Call<UsuarioComum> call, Throwable t) {

                            }
                        });
                    });
                }
            }

            @Override
            public void onFailure(Call<List<UsuarioComum>> call, Throwable t) {

            }
        });
        return inflater.inflate(R.layout.fragment_user_edit_perfil, container, false);
    }
}