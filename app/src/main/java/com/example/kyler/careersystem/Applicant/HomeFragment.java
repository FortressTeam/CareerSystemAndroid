package com.example.kyler.careersystem.Applicant;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.kyler.careersystem.Applicant.Customize.JobListViewAdapterLoadInfinite;
import com.example.kyler.careersystem.Applicant.Customize.JobListViewItem;
import com.example.kyler.careersystem.Applicant.Customize.ViewHolder;
import com.example.kyler.careersystem.R;
import com.example.kyler.careersystem.Utilities;
import com.github.ksoichiro.android.observablescrollview.ObservableListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements AbsListView.OnScrollListener,ListView.OnItemClickListener {
    private ListView home_job_listview;

    private JobListViewAdapterLoadInfinite jobListViewAdapterLoadInfinite;
    private ArrayList<JobListViewItem> jobListViewItems;
    private Handler mHandler;
    private ProgressBar progressBar;

    public HomeFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.applicant_home_fragment,container,false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Home");
        JSONObject jsJob1=null,jsJob2=null;
        try{
            jsJob1= new JSONObject("{\n" +
                    "  \"post_id\": \"1\",\n" +
                    "  \"post_title\": \"Job xxxx\",\n" +
                    "  \"post_title_time\": \"4 days\",\n" +
                    "  \"post_content\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\",\n" +
                    "  \"post_salary\": 300,\n" +
                    "  \"post_image\": \"https://cdn3.iconfinder.com/data/icons/internet-marketing/57/work_job_computer_click_color-128.png\",\n" +
                    "  \"post_date\": \"12/12/2016\",\n" +
                    "  \"post_status\": 1,\n" +
                    "  \"category_name\": \"Information Technology\",\n" +
                    "  \"company_name\": \"Enclave\"\n" +
                    "}");
            jsJob2= new JSONObject("{\n" +
                    "  \"post_id\": \"2\",\n" +
                    "  \"post_title\": \"Job xxxx\",\n" +
                    "  \"post_title_time\": \"2 hours\",\n" +
                    "  \"post_content\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\",\n" +
                    "  \"post_salary\": 300,\n" +
                    "  \"post_image\": \"https://cdn3.iconfinder.com/data/icons/human-resources-management/512/relationship_office_team_work-128.png\",\n" +
                    "  \"post_date\": \"12/12/2016\",\n" +
                    "  \"post_status\": 1,\n" +
                    "  \"category_name\": \"Information Technology\",\n" +
                    "  \"company_name\": \"Enclave\"\n" +
                    "}");
        }catch(JSONException e){e.printStackTrace();}
        mHandler = new Handler();
        home_job_listview = (ListView) rootView.findViewById(R.id.home_job_listview);
        View footer = getActivity().getLayoutInflater().inflate(R.layout.progress_bar_footer, null);
        progressBar = (ProgressBar) footer.findViewById(R.id.progressBar);
        home_job_listview.addFooterView(footer);
        jobListViewItems = new ArrayList<JobListViewItem>();
        for(int i=0;i<30;i++){
            if(i%3==0)
                jobListViewItems.add(Utilities.getJobLVItemfrom(jsJob1));
            else
                jobListViewItems.add(Utilities.getJobLVItemfrom(jsJob2));
        }
        jobListViewAdapterLoadInfinite = new JobListViewAdapterLoadInfinite(getActivity().getApplicationContext(),jobListViewItems,10,5);
        home_job_listview.setAdapter(jobListViewAdapterLoadInfinite);
        home_job_listview.setOnScrollListener(this);
        home_job_listview.setOnItemClickListener(this);
        progressBar.setVisibility((8 < jobListViewItems.size()) ? View.VISIBLE : View.GONE);
        final SwipeRefreshLayout swipeLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.home_swipe);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getActivity().getApplicationContext(), "Hello", Toast.LENGTH_SHORT).show();
//                jobListViewAdapterLoadInfinite.insert(new JobListViewItem("Job " + new Random().nextInt(100) + "xxxx", link1, "500 USD", "ABC", "Information Technology", "You just need to defiview. You just need to defiview. You just need to defiview. You just need to defiview. You just need to defiview. You just need to defiview. You just need to defiview. You just need to defiview. You just need to defiview. You just need to defiview. You just need to defiview. You just need to defiview. You just need to defiview. You just need to defiview. You just need to defiview. You just need to defiview."),0);
                swipeLayout.setRefreshing(false);
            }
        });
        return rootView;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        //Instagram listview
        for(int i=0;i<home_job_listview.getChildCount()-1;i++){
            View child = home_job_listview.getChildAt(i);
            ViewHolder holder = (ViewHolder) child.getTag();
            if(i==0){
                boolean isAtBottom = child.getHeight() <= holder.header.getBottom();
                int offset = holder.previousTop - child.getTop();
                if(!(isAtBottom && offset > 0)){
                    holder.previousTop = child.getTop();
                    holder.header.offsetTopAndBottom(offset);
                    holder.header.invalidate();
                }else{
                    holder.header.invalidate();
                }
            }
            else if (holder.header.getTop() != 0) {
                int offset = -1 * holder.header.getTop();
                holder.header.offsetTopAndBottom(offset);
                holder.previousTop = 0;
                holder.header.invalidate();
            }
        }

        //Load more
        if(firstVisibleItem + visibleItemCount == totalItemCount && !jobListViewAdapterLoadInfinite.endReached() && !hasCallback){ //check if we've reached the bottom
            Toast.makeText(getActivity().getApplicationContext(),"Loading",Toast.LENGTH_SHORT).show();
            mHandler.postDelayed(showMore, 1000);
            hasCallback = true;
        }
    }

    private boolean hasCallback;
    private Runnable showMore = new Runnable(){
        public void run(){
            boolean noMoreToShow = jobListViewAdapterLoadInfinite.showMore(); //show more views and find out if
            hasCallback = false;
            progressBar.setVisibility(noMoreToShow? View.GONE : View.VISIBLE);
        }
    };

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(getActivity(),ChildApplicantActivity.class);
        String sendData=jobListViewItems.get(i).getMajor()+" "+i;
        Bundle bundle = new Bundle();
        bundle.putString("key","jobdetail");
        bundle.putString("sendData",sendData);
        intent.putExtra("sendBundle",bundle);
        getActivity().startActivity(intent);
    }
}
