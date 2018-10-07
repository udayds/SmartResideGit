package com.smartresidesolutions.smartreside;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResidentRegistration extends AppCompatActivity {

    TextView loginHead,regName,phoneNumber,regEmail,regHouseNo,parkingNumber,regOtherResident;
    EditText aadharCheckEdit,panCheckEdit;
    Button regSubmit;
    CheckBox aadharCheck,panCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resident_registration);

        regName = (TextView) findViewById(R.id.regName);
        phoneNumber = (TextView) findViewById(R.id.phoneNumber);
        regEmail = (TextView) findViewById(R.id.regEmail);
        regHouseNo = (TextView) findViewById(R.id.regHouseNo);
        parkingNumber = (TextView) findViewById(R.id.parkingNumber);
        regOtherResident = (TextView) findViewById(R.id.regOtherResident);



        aadharCheck = (CheckBox)findViewById(R.id.aadharCheck);
        panCheck = (CheckBox)findViewById(R.id.panCheck);

        aadharCheckEdit = (EditText)findViewById(R.id.aadharCheckEdit);
        panCheckEdit = (EditText)findViewById(R.id.panCheckEdit);
        aadharCheckEdit.setVisibility(View.GONE);
        panCheckEdit.setVisibility(View.GONE);





        regSubmit = (Button)findViewById(R.id.regSubmit);
        regSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ResidentRegistration.this,"Details submitted",Toast.LENGTH_SHORT).show();
                Intent navigation = new Intent(ResidentRegistration.this,Navigation.class);
                navigation.putExtra("name",regName.getText().toString());
                startActivity(navigation);

            }
        });


        aadharCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(aadharCheck.isChecked()){
                    aadharCheckEdit.setVisibility(View.VISIBLE);
                }else{
                    aadharCheckEdit.setVisibility(View.GONE);

                }
            }
        });

        panCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(panCheck.isChecked()){
                    panCheckEdit.setVisibility(View.VISIBLE);
                }else{
                    panCheckEdit.setVisibility(View.GONE);

                }
            }
        });


    }








}
