package com.smartresidesolutions.smartreside;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BookFacilityFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BookFacilityFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookFacilityFragment extends Fragment{

    Fragment frag=this;
    private OnFragmentInteractionListener mListener;

    public BookFacilityFragment() {

    }

    // TODO: Rename and change types and number of parameters
    public static BookFacilityFragment newInstance(String param1, String param2) {
        BookFacilityFragment fragment = new BookFacilityFragment();
        return fragment;
    }





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bookfacility, container, false);
    }
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList myFacilities;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FloatingActionButton fab1 = (FloatingActionButton) getView().findViewById(R.id.requestFacilityFloat);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent requestFacilityIntent=new Intent(getContext(),BookFacilityRequest.class);
                frag.startActivityForResult(requestFacilityIntent,1);
            }
        });

        myFacilities=new ArrayList();


        mRecyclerView = (RecyclerView) getView().findViewById(R.id.facilitiesRecyclerView);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new BookFacilityAdapter(myFacilities,myCardClick);
        mRecyclerView.setAdapter(mAdapter);
    }




    private BookFacilityAdapter.ItemClickListner myCardClick = new BookFacilityAdapter.ItemClickListner() {
        @Override
        public void onClick(View v) {

            if (myCardClick != null) {

                Intent acivityOnClick =new Intent(getContext(),FacilityFragment.class);

                BookFacility bf = new BookFacility();
                TextView bookedDate=(TextView)v.findViewById(R.id.bookedDateText);
                bf.setBookedDate(bookedDate.getText().toString());

                TextView requestID=(TextView)v.findViewById(R.id.requestIdText);
                bf.setRequestId(requestID.getText().toString());

                TextView facility=(TextView)v.findViewById(R.id.facilityText);
                bf.setFacilityTitle(facility.getText().toString());

                TextView fromTime=(TextView)v.findViewById(R.id.fromTimeText);
                bf.setBookedFromTime(fromTime.getText().toString());

                TextView toTime=(TextView)v.findViewById(R.id.toTimeText);
                bf.setBookedToTime(toTime.getText().toString());


                acivityOnClick.putExtra("bookfacility",bf);
                frag.startActivity(acivityOnClick);



            }
        }
    };






    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1) {

            BookFacility bookfac=(BookFacility) data.getSerializableExtra("bookfacility");
            myFacilities.add(bookfac);
            mAdapter.notifyDataSetChanged();
        }
    }

    ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN | ItemTouchHelper.UP) {

        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            Toast.makeText(getContext(), "on Move", Toast.LENGTH_SHORT).show();
            return false;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
            Toast.makeText(getContext(), "Booking Removed" +
                    " ", Toast.LENGTH_SHORT).show();
            //Remove swiped item from list and notify the RecyclerView
            int position = viewHolder.getAdapterPosition();
            myFacilities.remove(position);
            mAdapter.notifyDataSetChanged();

        }
    };



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
