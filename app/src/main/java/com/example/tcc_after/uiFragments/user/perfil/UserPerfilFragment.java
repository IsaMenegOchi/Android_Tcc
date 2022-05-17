package com.example.tcc_after.uiFragments.user.perfil;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.tcc_after.R;
import com.example.tcc_after.UI.event.EventRegisterActivity;
import com.example.tcc_after.model.VerificacaoUsuario;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserPerfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserPerfilFragment extends Fragment {

    private Spinner spConfiguracoes;

    public UserPerfilFragment() {
        // Required empty public constructor
    }

    public static UserPerfilFragment newInstance(String param1, String param2) {
        UserPerfilFragment fragment = new UserPerfilFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//
//        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.settingsArray, android.R.layout.simple_spinner_item);
//        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spConfiguracoes.setAdapter(arrayAdapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        spConfiguracoes = getActivity().findViewById(R.id.spUserPerfil_Settings);

        String[] config = getResources().getStringArray(R.array.settingsArray);
        spConfiguracoes.setAdapter(new ArrayAdapter<String>(getContext(),  android.R.layout.simple_spinner_item, config));

//


        spConfiguracoes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (spConfiguracoes.getSelectedItemId() == 0){
                    Fragment fragment = new UserEditPerfilFragment();
                }
                if (spConfiguracoes.getSelectedItemId() == 1){
                    startActivity(new Intent(getActivity(), VerificacaoUsuario.class));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_perfil, container, false);
    }
}