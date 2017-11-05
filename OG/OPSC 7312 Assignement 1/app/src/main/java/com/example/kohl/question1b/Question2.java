package com.example.kohl.question1b;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.suraj.androidgpstracker.R;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;


public class Question2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        Button btnSend;
        final EditText txtNum, txtText;


        if(ContextCompat.checkSelfPermission(Question2.this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED)
        {
            if(ActivityCompat.shouldShowRequestPermissionRationale(Question2.this, Manifest.permission.READ_SMS))
            {
                ActivityCompat.requestPermissions(Question2.this, new String[]{Manifest.permission.READ_SMS}, 1);
            }else{

            }

            btnSend = (Button)findViewById(R.id.btnSend);
            txtNum = (EditText)findViewById(R.id.txtNum);
            txtText = (EditText)findViewById(R.id.txtText);

            btnSend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String num = txtNum.getText().toString();
                    String sms = txtText.getText().toString();

                    try
                    {
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(num, null, sms, null, null);
                        Toast.makeText(Question2.this, "SMS sent", Toast.LENGTH_LONG).show();
                    }
                    catch (Exception e)
                    {
                        Toast.makeText(Question2.this, "SMS failed", Toast.LENGTH_LONG).show();
                    }



                }
            });



        }

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,int[] grantResults)
    {
        switch (requestCode){
            case 1 :{
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    if(ContextCompat.checkSelfPermission(Question2.this, Manifest.permission.READ_SMS) == PackageManager.PERMISSION_GRANTED)
                    {
                        Toast.makeText(this,"Permission is yours", Toast.LENGTH_SHORT).show();
                    }
                }else
                {
                    Toast.makeText(this,"Permission is not yours", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


}
