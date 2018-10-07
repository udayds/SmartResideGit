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

public class AddComplaint extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    EditText fromDate;
    Spinner spinner,prioiritySpinner;
    DatePickerDialog datePickerDialog;
    EditText problemDescription,contactNametext,phoneNumText;
    Button chooseFile;
    Switch provideContactDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_complaint);

        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayList concerns=new ArrayList();
        concerns.add("Water Issue");
        concerns.add("Sewage");
        concerns.add("Lift not working");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,concerns);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);




        datePickerDialog = new DatePickerDialog(
                this, this,2018,1, 1);
        fromDate=findViewById(R.id.fromDateLabel);
        fromDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });




        prioiritySpinner = (Spinner)findViewById(R.id.prioritySpinner);
        ArrayList priorityLevel=new ArrayList();
        priorityLevel.add("High");
        priorityLevel.add("Medium");
        priorityLevel.add("Low");
        ArrayAdapter<String> adapterPriority = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,priorityLevel);
        adapterPriority.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        prioiritySpinner.setAdapter(adapterPriority);


        problemDescription = (EditText) findViewById(R.id.probdesctext);

        chooseFile=(Button)findViewById(R.id.chooseFile);
    ///To be added here for choose file

        provideContactDetails = (Switch) findViewById(R.id.toggleContact);
        Boolean switchState = provideContactDetails.isChecked();
        provideContactDetails.setChecked(false);
        contactNametext = (EditText)findViewById(R.id.contactNametext);
        phoneNumText = (EditText)findViewById(R.id.phoneNumText);
        contactNametext.setVisibility(View.GONE);
        phoneNumText.setVisibility(View.GONE);

        provideContactDetails.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(provideContactDetails.isChecked()){
                    contactNametext.setVisibility(View.VISIBLE);
                    phoneNumText.setVisibility(View.VISIBLE);
                }else{
                    contactNametext.setVisibility(View.GONE);
                    phoneNumText.setVisibility(View.GONE);
                }
            }
        });




        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title=((Spinner) findViewById(R.id.spinner)).getSelectedItem().toString();
                String plevel=((Spinner) findViewById(R.id.prioritySpinner)).getSelectedItem().toString();
                String problemDesc = problemDescription.getText().toString();
                String contactName = ((EditText) findViewById(R.id.contactNametext)).getText().toString();
                String contactNumber = ((EditText) findViewById(R.id.phoneNumText)).getText().toString();
                Intent intent=new Intent();

               //intent.putExtra("complaint",new Complaint("232343",title,fromDate.getText().toString(),"Under Review",plevel,problemDesc,contactName,contactNumber));
                intent.putExtra("complaint",new Complaint("232343",title,fromDate.getText().toString(),"Under Review"));
                setResult(1,intent);
                finish();//finishing activity


            }
        });
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

        fromDate.setText(i+"/"+(i1+1)+"/"+i2);

    }
}
