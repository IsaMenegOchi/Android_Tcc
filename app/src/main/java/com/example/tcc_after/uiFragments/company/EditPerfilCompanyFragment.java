package com.example.tcc_after.uiFragments.company;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tcc_after.MainActivity;
import com.example.tcc_after.R;
import com.example.tcc_after.model.Empresa;
import com.example.tcc_after.model.UsuarioComum;
import com.example.tcc_after.remote.APIUtil;
import com.example.tcc_after.remote.RouterInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditPerfilCompanyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditPerfilCompanyFragment extends Fragment {

    EditText nickname, biografia, cnpj, email, senha, contaBancaria;

    Button salvar, cancelar;
    List<Empresa> list = new ArrayList<Empresa>();
    RouterInterface routerInterface;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EditPerfilCompanyFragment() {
        // Required empty public constructor
    }
    public static EditPerfilCompanyFragment newInstance(String param1, String param2) {
        EditPerfilCompanyFragment fragment = new EditPerfilCompanyFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        nickname = getActivity().findViewById(R.id.etCompanyEditPerfil_Nickname);
        biografia = getActivity().findViewById(R.id.etCompanyEditPerfil_Description);
        cnpj = getActivity().findViewById(R.id.etCompanyRegister_Cnpj);
        email = getActivity().findViewById(R.id.tvCompanyEditPerfil_Email);
        senha = getActivity().findViewById(R.id.etCompanyEditPerfil_Password);
        contaBancaria = getActivity().findViewById(R.id.etCompanyEditPerfil_RegularAccount);

        routerInterface = APIUtil.getApiInterface();
        Call<List<Empresa>> updateEmpresa = routerInterface.getEmpresa();
        updateEmpresa.enqueue(new Callback<List<Empresa>>() {
            @Override
            public void onResponse(Call<List<Empresa>> call, Response<List<Empresa>> response) {

                if (response.isSuccessful()){
                    list = response.body();

                    nickname.setText(list.get(0).getNicknameEmpresa());
                    biografia.setText(list.get(0).getBiografiaEmpresa());
                    cnpj.setText(list.get(0).getCnpjEmpresa());
                    email.setText(list.get(0).getEmailEmpresa());
                    senha.setText(list.get(0).getSenhaEmpresa());

                    salvar.setOnClickListener(view -> {
                        Empresa empresa = new Empresa();
                        empresa.setNicknameEmpresa(nickname.getText().toString());
                        empresa.setBiografiaEmpresa(biografia.getText().toString());
                        empresa.setCnpjEmpresa(cnpj.getText().toString());
                        empresa.setEmailEmpresa(email.getText().toString());
                        empresa.setSenhaEmpresa(senha.getText().toString());

                        Call<Empresa> updateEmpresa = routerInterface.updateEmpresa(1, empresa);
                        updateEmpresa.enqueue(new Callback<Empresa>() {
                            @Override
                            public void onResponse(Call<Empresa> call, Response<Empresa> response) {
                                if (response.isSuccessful()){
                                    Toast.makeText(getActivity(), "Você editou seu perfil", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<Empresa> call, Throwable t) {
                                Toast.makeText(getActivity(), "Não foi possivel editar seu perfil", Toast.LENGTH_SHORT).show();
                            }
                        });
                    });
                }
            }

            @Override
            public void onFailure(Call<List<Empresa>> call, Throwable t) {
                Log.d("ErrorEmpresa", "onFailure: nao estamos listando os dados de empresaa");
            }
        });

        return inflater.inflate(R.layout.fragment_edit_perfil_company, container, false);
    }
}