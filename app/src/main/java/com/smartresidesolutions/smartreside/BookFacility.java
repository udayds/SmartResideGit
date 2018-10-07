package com.smartresidesolutions.smartreside;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.EditText;

import java.io.Serializable;

class BookFacility implements Serializable {

    String facilityTitle;
    String requestId;
    String bookedDate;
    String bookedFromTime;
    String bookedToTime;
    String contactNameFacility;
    String contactNumberFacility;

    public BookFacility(){}

    //public Complaint(String random, String title, String fromDate, String under_review, String prioritylevel, String probDesc, String name, String phoneNumber) {
    public BookFacility(String random, String title, String fromDate, String fromTime, String toTime) {
        this.requestId = random;
        this.facilityTitle = title;
        this.bookedDate = fromDate;
        this.bookedFromTime = fromTime;
        this.bookedToTime = toTime;
    }



    public void setFacilityTitle(String facilityTitle) {
        this.facilityTitle = facilityTitle;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public void setBookedDate(String bookedDate) {
        this.bookedDate = bookedDate;
    }

    public void setBookedFromTime(String bookedFromTime) {
        this.bookedFromTime = bookedFromTime;
    }

    public void setBookedToTime(String bookedToTime) {
        this.bookedToTime = bookedToTime;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getBookedDate() {
        return bookedDate;
    }

    public String getFacilityTitle() {
        return facilityTitle;
    }

    public String getBookedFromTime() {
        return bookedFromTime;
    }

    public String getBookedToTime() {
        return bookedToTime;
    }

}
