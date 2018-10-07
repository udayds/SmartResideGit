package com.smartresidesolutions.smartreside;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BookFacilityAdapter extends RecyclerView.Adapter<BookFacilityAdapter.MyViewHolder>{


    ArrayList<BookFacility> facilityArrayList;
    private static ItemClickListner itemListner;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView requestIdText,facilityText,bookedDateText,fromTimeText,toTimeText;

        public MyViewHolder(View v) {
            super(v);
            requestIdText =(TextView)(v.findViewById(R.id.bookFacilityCard).findViewById(R.id.requestIdText));
            facilityText =(TextView)(v.findViewById(R.id.bookFacilityCard).findViewById(R.id.facilityText));
            bookedDateText =(TextView)(v.findViewById(R.id.bookFacilityCard).findViewById(R.id.bookedDateText));
            fromTimeText=(TextView)(v.findViewById(R.id.bookFacilityCard).findViewById(R.id.fromTimeText));
            toTimeText=(TextView)(v.findViewById(R.id.bookFacilityCard).findViewById(R.id.toTimeText));
            v.setOnClickListener(cardClickListner);
        }

        private View.OnClickListener cardClickListner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemListner.onClick(v);
            }
        };
    }

    public BookFacilityAdapter(ArrayList facilities,ItemClickListner listner) {
        facilityArrayList = facilities;
        itemListner=listner;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = (View) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.bookfacility_card_layout, viewGroup, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {


        BookFacility bookfacility = facilityArrayList.get(i);

        myViewHolder.requestIdText.setText(bookfacility.getRequestId());
        myViewHolder.facilityText.setText(bookfacility.getFacilityTitle());
        myViewHolder.bookedDateText.setText(bookfacility.getBookedDate());
        myViewHolder.fromTimeText.setText(bookfacility.getBookedFromTime());
        myViewHolder.toTimeText.setText(bookfacility.getBookedToTime());

    }

    @Override
    public int getItemCount() {
        return facilityArrayList.size();
    }

    public interface ItemClickListner {
        // TODO: Update argument type and name
        void onClick(View v);
    }

    public void setClickListner(BookFacilityAdapter.ItemClickListner itemClickListner){
        this.itemListner=itemClickListner;
    }


}
