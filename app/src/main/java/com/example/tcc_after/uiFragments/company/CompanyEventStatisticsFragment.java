package com.example.tcc_after.uiFragments.company;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tcc_after.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CompanyEventStatisticsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CompanyEventStatisticsFragment extends Fragment {


    public CompanyEventStatisticsFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static CompanyEventStatisticsFragment newInstance(String param1, String param2) {
        CompanyEventStatisticsFragment fragment = new CompanyEventStatisticsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_company_event_statistics, container, false);
    }
}