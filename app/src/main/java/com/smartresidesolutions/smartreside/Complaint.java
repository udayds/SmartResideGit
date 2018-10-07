package com.smartresidesolutions.smartreside;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.EditText;

import java.io.Serializable;

class Complaint implements Serializable {

    String complaintTitle;
    String status;
    String complaintId;
    String date;
    String plevel;
    String problemDescription;
    String contactName;
    String contactNumber;

    public Complaint(){}

    //public Complaint(String random, String title, String fromDate, String under_review, String prioritylevel, String probDesc, String name, String phoneNumber) {
         public Complaint(String random, String title, String fromDate, String under_review) {
        this.complaintId = random;
        this.complaintTitle = title;
        this.date = fromDate;
        this.status = under_review;
        //this.plevel = prioritylevel;
        //this.problemDescription = probDesc;
        //this.contactName = name;
        //this.contactNumber = phoneNumber;
    }



    public void setComplaintTitle(String complaintTitle) {
        this.complaintTitle = complaintTitle;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setComplaintId(String complaintId) {
        this.complaintId = complaintId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {

        return status;
    }

    public String getComplaintId() {
        return complaintId;
    }

    public String getDate() {
        return date;
    }



    public String getComplaintTitle() {
        return complaintTitle;
    }
}
