package com.example.tcc_after;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tcc_after.UI.event.EventRegisterActivity;
import com.example.tcc_after.UI.event.EventRegisterAllotmentActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * A simple {@link Fragment} subclass.
 * Use the { testeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class testeFragment extends Fragment {

    public testeFragment() {
        // Required empty public constructor
    }

    BottomNavigationView navigationView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_teste, container, false);
    }
}