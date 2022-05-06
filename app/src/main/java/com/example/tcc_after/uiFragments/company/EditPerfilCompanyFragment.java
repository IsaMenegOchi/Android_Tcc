package com.example.tcc_after.uiFragments.company;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.tcc_after.R;
import com.example.tcc_after.remote.RouterInterface;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditPerfilCompanyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditPerfilCompanyFragment extends Fragment {

    EditText nickname, biografia, cnpj, email, senha, contaBancaria;

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


        return inflater.inflate(R.layout.fragment_edit_perfil_company, container, false);
    }
}