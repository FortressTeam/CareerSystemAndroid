package com.example.kyler.careersystem.Applicant.Customize;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kyler.careersystem.ApplicantMainActivity;
import com.example.kyler.careersystem.R;
import com.example.kyler.careersystem.Utilities;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by kyler on 15/03/2016.
 */
public class JobAppliedListViewAdapterLoadInfinite  extends ArrayAdapter<JobAppliedListViewItem>{
    final private Context context;
    private ArrayList<JobAppliedListViewItem> jobAppliedListViewItems;
    private int count;
    private int stepNumber;
    private int startCount;
    private Handler mHandler;
    private int jobID;

    public JobAppliedListViewAdapterLoadInfinite(Context context, ArrayList<JobAppliedListViewItem> jobAppliedListViewItems, int startCount, int stepNumber) {
        super(context, R.layout.applicant_jobapplied_listviewitem,jobAppliedListViewItems);
        this.context = context;
        this.jobAppliedListViewItems = jobAppliedListViewItems;
        this.startCount = Math.min(startCount, jobAppliedListViewItems.size()); //don't try to show more views than we have
        this.count = this.startCount;
        this.stepNumber = stepNumber;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.applicant_jobapplied_listviewitem,null);
        }
        ImageView job_applied_companyicon = (ImageView) view.findViewById(R.id.job_applied_companyicon);
        TextView job_applied_listviewitem_companyname = (TextView) view.findViewById(R.id.job_applied_listviewitem_companyname);
        TextView job_applied_listviewitem_content = (TextView) view.findViewById(R.id.job_applied_listviewitem_content);
        TextView job_applied_listviewitem_status = (TextView) view.findViewById(R.id.job_applied_listviewitem_status);
        Picasso.with(context).load(jobAppliedListViewItems.get(i).getCompanyImage()).into(job_applied_companyicon);
        job_applied_listviewitem_companyname.setText(jobAppliedListViewItems.get(i).getCompanyName());
        job_applied_listviewitem_content.setText(jobAppliedListViewItems.get(i).getJobOverview());
        job_applied_listviewitem_status.setText(jobAppliedListViewItems.get(i).getStatus());
        ImageView jobappliedDelete = (ImageView) view.findViewById(R.id.jobapplied_delete);
        mHandler = new Handler();
        jobappliedDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jobAppliedListViewItems.remove(i);
                notifyDataSetChanged();
                count--;
            }
        });
        return view;
    }
    private View.OnClickListener deleteJob = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            jobAppliedListViewItems.remove(jobID);
            notifyDataSetChanged();
            count--;
        }
    };

    public boolean showMore(){
        if(count == jobAppliedListViewItems.size()) {
            return true;
        }else{
            count = Math.min(count + stepNumber, jobAppliedListViewItems.size()); //don't go past the end
            notifyDataSetChanged(); //the count size has changed, so notify the super of the change
            return endReached();
        }
    }

    public boolean endReached(){
        return count == jobAppliedListViewItems.size();
    }
}
