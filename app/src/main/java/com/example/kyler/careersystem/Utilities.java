package com.example.kyler.careersystem;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.kyler.careersystem.Applicant.ChildApplicantActivity;
import com.example.kyler.careersystem.Applicant.ChildFragments.JobDetailFragment;
import com.example.kyler.careersystem.Applicant.Customize.JobListViewItem;
import com.example.kyler.careersystem.Applicant.FindFragment;
import com.example.kyler.careersystem.Applicant.HomeFragment;
import com.example.kyler.careersystem.Applicant.MyResumeFragment;
import com.example.kyler.careersystem.Applicant.NavigationListViewAdapter;
import com.example.kyler.careersystem.Applicant.NavigationListViewItem;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Duck_Ky on 3/5/2016.
 */
public class Utilities {
    public static void loadNavigationView(Context context,ListView lv){
        ArrayList<NavigationListViewItem> listItem = new ArrayList<>();
        listItem.add(new NavigationListViewItem(R.drawable.navhomeicon,"Home"));
        listItem.add(new NavigationListViewItem(R.drawable.navmyresumeicon,"My Resume"));
        listItem.add(new NavigationListViewItem(R.drawable.navfindicon,"Find"));
        listItem.add(new NavigationListViewItem(R.drawable.navfavoriteicon,"Favorite"));
        listItem.add(new NavigationListViewItem(R.drawable.navjobappliedicon,"Job Applied"));
        listItem.add(new NavigationListViewItem(R.drawable.navnotificationicon,"Notifications",15,true));
        NavigationListViewAdapter adapter = new NavigationListViewAdapter(context.getApplicationContext(),listItem);
        lv.setAdapter(adapter);
    }

    public static JobListViewItem getJobLVItemfrom(JSONObject jsonObject){
        JobListViewItem jobListViewItem=null;
        String title=null;
        String titleTime=null;
        String image=null;
        String salary=null;
        String company=null;
        String major=null;
        String description=null;
        try {
            if(jsonObject.has("post_title"))
                title=jsonObject.getString("post_title");
            if(jsonObject.has("post_title_time"))
                titleTime=jsonObject.getString("post_title_time");
            if(jsonObject.has("post_image"))
                image=jsonObject.getString("post_image");
            if(jsonObject.has("post_salary"))
                salary=jsonObject.getString("post_salary");
            if(jsonObject.has("company_name"))
                company=jsonObject.getString("company_name");
            if(jsonObject.has("category_name"))
                major=jsonObject.getString("category_name");
            if(jsonObject.has("post_content"))
                description=jsonObject.getString("post_content");
            jobListViewItem = new JobListViewItem(title,titleTime,image,salary,company,major,description);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jobListViewItem;
    }

    public static void displayView(Activity context,int position){
        Fragment fragment = null;
        switch (position){
            case 1://home
                fragment = new HomeFragment();
                break;
            case 2://myresume
                fragment = new MyResumeFragment();
                break;
            case 3://find
                fragment = new FindFragment();
                break;
            case 4://favorite
                fragment = new HomeFragment();
                break;
            case 5://jobapplied
                break;
            case 6://notifications
                break;
            default:
                break;
        }
        if(fragment != null){
            FragmentManager fragmentManager = context.getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame_main,fragment).commit();
        } else{
            Log.e("Applicant MainActivity", "Error in creating fragment");
        }
        DrawerLayout drawer = (DrawerLayout) context.findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }
}
