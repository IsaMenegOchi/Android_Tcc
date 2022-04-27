package com.example.tcc_after.UI.user.verification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.VerifiedInputEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tcc_after.R;
import com.example.tcc_after.UI.company.company_register.PhotoCompanyRegisterActivity;
import com.example.tcc_after.UI.user.UserPerfilActivity;
import com.example.tcc_after.model.Empresa;
import com.example.tcc_after.model.VerificacaoUsuario;
import com.example.tcc_after.remote.APIUtil;
import com.example.tcc_after.remote.RouterInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestVerificationActivity extends AppCompatActivity {

    private EditText etVerNicknameUsuario, etVerNomeCompletoUsuario, etVerMotivoSolicitacao, ivArquivoDocUsuario;
    private Button btnCadastrarVerificacao;
//    private ImageView ivArquivoDocUsuario;

    RouterInterface routerInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_request_verification);

        etVerNicknameUsuario = findViewById(R.id.etRequestVerification_Nickname);
        etVerNomeCompletoUsuario = findViewById(R.id.etRequestVerification_FullName);
        etVerMotivoSolicitacao = findViewById(R.id.etRequestVerification_Reason);
        ivArquivoDocUsuario = findViewById(R.id.ivRequestVerification_AddFile);
        btnCadastrarVerificacao = findViewById(R.id.btnRequestVerification_Send);


        btnCadastrarVerificacao.setOnClickListener(view -> {

            VerificacaoUsuario verificacaoUsuario = new VerificacaoUsuario();

            verificacaoUsuario.setVerNicknameUsuario(etVerNicknameUsuario.getText().toString());
            verificacaoUsuario.setVerNomeUsuario(etVerNomeCompletoUsuario.getText().toString());
            verificacaoUsuario.setVerJustifivativaSUsuario(etVerMotivoSolicitacao.getText().toString());
            verificacaoUsuario.setVerArquivoDocUsuario(ivArquivoDocUsuario.getText().toString());


            routerInterface = APIUtil.getUsuarioInterface();
            addVerificacaoUsuario(verificacaoUsuario);

            Toast.makeText(this, "Você cadastrou hehe", Toast.LENGTH_SHORT).show();

//            Intent intent = new Intent(RequestVerificationActivity.this, UserPerfilActivity.class);
//            startActivity(intent);
        });
    }


    public void addVerificacaoUsuario(VerificacaoUsuario verificacaoUsuario) {

        //calback - classe do java
        Call<VerificacaoUsuario> call = routerInterface.addVerificacaoUsuario(verificacaoUsuario);
        call.enqueue(new Callback<VerificacaoUsuario>() {
            //o req é feito automaticamente
            @Override
            public void onResponse(Call<VerificacaoUsuario> call, Response<VerificacaoUsuario> response) {
                Toast.makeText(RequestVerificationActivity.this, "Empresa inserida com sucesso", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<VerificacaoUsuario> call, Throwable t) {
                Log.d("Erro_api", t.getMessage());
            }//fim do onFailure
        }); //fim do enqueue e do calback
    }// fim da funcao addEmprea
}