package com.example.kyler.careersystem.Applicant.Customize;

import android.widget.ImageView;

/**
 * Created by kyler on 15/03/2016.
 */
public class JobAppliedListViewItem {
    private String companyImage;
    private String companyName;
    private String jobOverview;
    private String status;

    public JobAppliedListViewItem(String companyImage, String companyName, String jobOverview, String status) {
        this.companyImage = companyImage;
        this.companyName = companyName;
        this.jobOverview = jobOverview;
        this.status = status;
    }

    public String getCompanyImage() {
        return companyImage;
    }

    public void setCompanyImage(String companyImage) {
        this.companyImage = companyImage;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobOverview() {
        return jobOverview;
    }

    public void setJobOverview(String jobOverview) {
        this.jobOverview = jobOverview;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
