package com.smartresidesolutions.smartreside;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FacilityFragment extends AppCompatActivity {

    TextView requestIdText,facilityViewText,bookedDateViewText,bookedTimeFromText,bookedTimeToText,contactNameViewText,contactNumViewText, statusViewtext;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facility_fragment);

        BookFacility bf = (BookFacility)getIntent().getSerializableExtra("bookfacility");
        requestIdText=(TextView)findViewById(R.id.requestIdText);
        requestIdText.setText(bf.getRequestId());

        facilityViewText = (TextView)findViewById(R.id.facilityViewText);
        facilityViewText.setText(bf.getFacilityTitle());

        bookedDateViewText=(TextView)findViewById(R.id.bookedDateViewText);
        bookedDateViewText.setText(bf.getBookedDate());

        bookedTimeFromText =(TextView)findViewById(R.id.bookedTimeFromText);
        bookedTimeFromText.setText(bf.getBookedFromTime());

        bookedTimeToText =(TextView)findViewById(R.id.bookedTimeToText);
        bookedTimeToText.setText(bf.getBookedToTime());


        back = (Button)findViewById(R.id.backView);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }


}
