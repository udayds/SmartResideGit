package com.smartresidesolutions.smartreside;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;


import java.util.ArrayList;

public class BookFacilityRequest extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    EditText fromDateLabelFacility;
    Spinner spinnerFacility,fromTimeTextFacility,toTimeTextFacility;
    DatePickerDialog datePickerDialogFacility;
    EditText contactNametextFacility,phoneNumTextFacility;
    Button requestFacility;
    Switch toggleContactFacility;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_facility_request);

        spinnerFacility = (Spinner)findViewById(R.id.spinnerFacility);
        ArrayList facilities=new ArrayList();
        facilities.add("Tennis Court");
        facilities.add("Badminton court");
        facilities.add("Swimming Pool");
        facilities.add("Children Park");
        facilities.add("Gym");
        facilities.add("Theatre");
        ArrayAdapter<String> adapterFacilities = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,facilities);
        adapterFacilities.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFacility.setAdapter(adapterFacilities);

        requestFacility=(Button)findViewById(R.id.requestFacility);


        datePickerDialogFacility = new DatePickerDialog(
                this, this,2018,1, 1);
        fromDateLabelFacility=findViewById(R.id.fromDateLabelFacility);
        fromDateLabelFacility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialogFacility.show();
            }
        });




        fromTimeTextFacility = (Spinner)findViewById(R.id.fromTimeTextFacility);
        ArrayList fromTime=new ArrayList();
        fromTime.add("5:00AM");
        fromTime.add("6:00AM");
        fromTime.add("7:00AM");
        fromTime.add("8:00AM");
        fromTime.add("9:00AM");
        fromTime.add("10:00AM");
        fromTime.add("11:00AM");
        fromTime.add("12:00PM");
        fromTime.add("1:00PM");
        fromTime.add("2:00PM");
        fromTime.add("3:00PM");
        fromTime.add("4:00PM");
        fromTime.add("5:00PM");
        fromTime.add("6:00PM");
        fromTime.add("7:00PM");
        fromTime.add("8:00PM");
        fromTime.add("9:00PM");
        fromTime.add("10:00PM");
        ArrayAdapter<String> adapterFromTime = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,fromTime);
        adapterFromTime.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromTimeTextFacility.setAdapter(adapterFromTime);



        toTimeTextFacility = (Spinner)findViewById(R.id.toTimeTextFacility);
        ArrayList toTime=new ArrayList();
        toTime.add("5:00AM");
        toTime.add("6:00AM");
        toTime.add("7:00AM");
        toTime.add("8:00AM");
        toTime.add("9:00AM");
        toTime.add("10:00AM");
        toTime.add("11:00AM");
        toTime.add("12:00PM");
        toTime.add("1:00PM");
        toTime.add("2:00PM");
        toTime.add("3:00PM");
        toTime.add("4:00PM");
        toTime.add("5:00PM");
        toTime.add("6:00PM");
        toTime.add("7:00PM");
        toTime.add("8:00PM");
        toTime.add("9:00PM");
        toTime.add("10:00PM");
        ArrayAdapter<String> adapterToTime = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,toTime);
        adapterToTime.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        toTimeTextFacility.setAdapter(adapterToTime);


        toggleContactFacility = (Switch) findViewById(R.id.toggleContactFacility);
        Boolean switchState = toggleContactFacility.isChecked();
        toggleContactFacility.setChecked(false);
        contactNametextFacility = (EditText)findViewById(R.id.contactNametextFacility);
        phoneNumTextFacility = (EditText)findViewById(R.id.phoneNumTextFacility);
        contactNametextFacility.setVisibility(View.GONE);
        phoneNumTextFacility.setVisibility(View.GONE);

        toggleContactFacility.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(toggleContactFacility.isChecked()){
                    contactNametextFacility.setVisibility(View.VISIBLE);
                    phoneNumTextFacility.setVisibility(View.VISIBLE);
                }else{
                    contactNametextFacility.setVisibility(View.GONE);
                    phoneNumTextFacility.setVisibility(View.GONE);
                }
            }
        });




        findViewById(R.id.requestFacility).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title=((Spinner) findViewById(R.id.spinnerFacility)).getSelectedItem().toString();
                String fromTime=((Spinner) findViewById(R.id.fromTimeTextFacility)).getSelectedItem().toString();
                String toTime=((Spinner) findViewById(R.id.toTimeTextFacility)).getSelectedItem().toString();
                String contactName = ((EditText) findViewById(R.id.contactNametextFacility)).getText().toString();
                String contactNumber = ((EditText) findViewById(R.id.phoneNumTextFacility)).getText().toString();
                Intent intent=new Intent();

                //intent.putExtra("complaint",new Complaint("232343",title,fromDate.getText().toString(),"Under Review",plevel,problemDesc,contactName,contactNumber));
                intent.putExtra("bookfacility",new BookFacility("232343",title,fromDateLabelFacility.getText().toString(),fromTime,toTime));
                setResult(1,intent);
                finish();//finishing activity


            }
        });

    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

        fromDateLabelFacility.setText(i+"/"+(i1+1)+"/"+i2);

    }


}
