package com.smartresidesolutions.smartreside;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements ComplaintsFragment.OnFragmentInteractionListener{

    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent activityChangeIntent = new Intent(v.getContext(),Navigation.class);
                startActivity(activityChangeIntent);


            }
        });
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
