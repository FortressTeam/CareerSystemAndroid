package com.example.kyler.careersystem.Applicant;

import android.app.Fragment;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.kyler.careersystem.Applicant.ChildFragments.JobDetailFragment;
import com.example.kyler.careersystem.ApplicantMainActivity;
import com.example.kyler.careersystem.R;
import com.example.kyler.careersystem.Utilities;

public class ChildApplicantActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    ListView navigationViewMenu;
    String receiveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_applicant);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        navigationViewMenu = (ListView) findViewById(R.id.navigation_view_menu);
        View navigationViewHeader = getLayoutInflater().inflate(R.layout.nav_header_applicant_main, null);
        navigationViewMenu.addHeaderView(navigationViewHeader);
        Utilities.loadNavigationView(this, navigationViewMenu);
        navigationViewMenu.setOnItemClickListener(this);
        Bundle bundle = getIntent().getBundleExtra("sendBundle");
        String key = bundle.getString("key");
        receiveData = bundle.getString("sendData");
        startFragment(key);
    }

    private void startFragment(String key){
        switch (key){
            case "jobdetail":
                Fragment fragment = new JobDetailFragment();
                Bundle bundle = new Bundle();
                bundle.putString("sendData",receiveData);
                fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_main, fragment).commit();
        }
    }

    private void startActivity(int id){
        Intent intent = new Intent(this, ApplicantMainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Bundle bundle = new Bundle();
        bundle.putInt("itemID",id);
        intent.putExtra("back", bundle);
        startActivity(intent);
        this.finish();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        startActivity(i);
    }
}
