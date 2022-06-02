package com.example.tcc_after.uiFragments.company;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.tcc_after.R;
import com.example.tcc_after.UI.event.EventRegisterActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CompanyPerfilFragment#newInstance} factory method to
=======
import com.example.tcc_after.UI.event.EventRegisterActivity;
import com.example.tcc_after.UI.event.EventRegisterAllotmentActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * A simple {@link Fragment} subclass.
 * Use the { testeFragment#newInstance} factory method to
>>>>>>> Stashed changes:app/src/main/java/com/example/tcc_after/testeFragment.java
 * create an instance of this fragment.
 */
public class CompanyPerfilFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CompanyPerfilFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PerfilFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CompanyPerfilFragment newInstance(String param1, String param2) {
        CompanyPerfilFragment fragment = new CompanyPerfilFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    Button btnAddEvento;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        btnAddEvento = getActivity().findViewById(R.id.btnCompanyPerfil_AddEvent);
        int idEmpresa = 2;
        btnAddEvento.setOnClickListener(view -> {

            Intent intent = new Intent(getActivity(), EventRegisterActivity.class);
            intent.putExtra("idEmpresa", idEmpresa);
            startActivity(intent);
        });


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_company_perfil, container, false);
    }


}