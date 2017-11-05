package com.example.kohl.question1b;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuNav extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_nav);
    }

    public void Q1(View v)
    {
        Intent q1 = new Intent(this,Question1.class);
        startActivity(q1);
    }

    public void Q1b(View v)
    {
        Intent q1b = new Intent(this,MapsActivity.class);
        startActivity(q1b);
    }

    public void Q2(View v)
    {
       Intent q2 = new Intent(this,Question2.class);
        startActivity(q2);
    }


}
