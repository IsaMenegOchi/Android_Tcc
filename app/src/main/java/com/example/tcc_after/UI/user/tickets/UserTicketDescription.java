package com.example.tcc_after.UI.user.tickets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tcc_after.R;

public class UserTicketDescription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_ticket_description);
    }

    public static class TicketDescriptionActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_user_ticket_description);
        }
    }
}