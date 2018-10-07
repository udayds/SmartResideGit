package com.smartresidesolutions.smartreside;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewBookedRequests extends AppCompatActivity {

    TextView complaintIdText,concernViewText,dateViewText,priorityViewText,probDescViewText,contactNameViewText,contactNumViewText, statusViewtext;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_booked_requests);

        Complaint c = (Complaint)getIntent().getSerializableExtra("complaint");
        complaintIdText=(TextView)findViewById(R.id.complaintIdText);
        complaintIdText.setText(c.getComplaintId());

        concernViewText = (TextView)findViewById(R.id.concernViewText);
        concernViewText.setText(c.getComplaintTitle());

        dateViewText=(TextView)findViewById(R.id.dateViewText);
        dateViewText.setText(c.getDate());

        statusViewtext =(TextView)findViewById(R.id.priorityViewText);
        statusViewtext.setText(c.getStatus());

        back = (Button)findViewById(R.id.backView);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }


}
