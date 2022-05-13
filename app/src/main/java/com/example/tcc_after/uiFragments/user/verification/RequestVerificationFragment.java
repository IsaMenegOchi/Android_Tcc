package com.example.tcc_after.uiFragments.user.verification;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tcc_after.R;
import com.example.tcc_after.model.usuarioComum.VerificacaoUsuario;
import com.example.tcc_after.remote.APIUtil;
import com.example.tcc_after.remote.RouterInterface;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the { testeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RequestVerificationFragment extends Fragment {

    private EditText etVerNicknameUsuario, etVerNomeCompletoUsuario, etVerMotivoSolicitacao, ivArquivoDocUsuario;
    private Button btnCadastrarVerificacao;
//    private ImageView ivArquivoDocUsuario;

    RouterInterface routerInterface;

    public RequestVerificationFragment() {
        // Required empty public constructor
    }

    BottomNavigationView navigationView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public void addVerificacaoUsuario(VerificacaoUsuario verificacaoUsuario) {

        //! ARRUMAR ID DO USUARIO COMUM
        //calback - classe do java
        Call<VerificacaoUsuario> call = routerInterface.addVerificacaoUsuario(1, verificacaoUsuario);
        call.enqueue(new Callback<VerificacaoUsuario>() {
            //o req é feito automaticamente
            @Override
            public void onResponse(Call<VerificacaoUsuario> call, Response<VerificacaoUsuario> response) {
                Toast.makeText(getActivity(), "Verificacao inserida com sucesso", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<VerificacaoUsuario> call, Throwable t) {
                Log.d("Erro_api", t.getMessage());
            }//fim do onFailure
        }); //fim do enqueue e do calback
    }// fim da funcao addEmprea




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_request_verification, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etVerNicknameUsuario = view.findViewById(R.id.etRequestVerification_Nickname);
        etVerNomeCompletoUsuario = view.findViewById(R.id.etRequestVerification_FullName);
        etVerMotivoSolicitacao = view.findViewById(R.id.etRequestVerification_Reason);
        ivArquivoDocUsuario = view.findViewById(R.id.ivRequestVerification_AddFile);
        btnCadastrarVerificacao = view.findViewById(R.id.btnRequestVerification_Send);


        btnCadastrarVerificacao.setOnClickListener(view1-> {

            VerificacaoUsuario verificacaoUsuario = new VerificacaoUsuario();

            verificacaoUsuario.setVerNicknameUsuario(etVerNicknameUsuario.getText().toString());
            verificacaoUsuario.setVerNomeUsuario(etVerNomeCompletoUsuario.getText().toString());
            verificacaoUsuario.setVerJustifivativaSUsuario(etVerMotivoSolicitacao.getText().toString());
            verificacaoUsuario.setVerArquivoDocUsuario(ivArquivoDocUsuario.getText().toString());


            routerInterface = APIUtil.getApiInterface();
            addVerificacaoUsuario(verificacaoUsuario);

            Toast.makeText(getActivity(), "Você cadastrou hehe", Toast.LENGTH_SHORT).show();

//            Intent intent = new Intent(RequestVerificationActivity.this, UserPerfilActivity.class);
//            startActivity(intent);
        });
    }
}