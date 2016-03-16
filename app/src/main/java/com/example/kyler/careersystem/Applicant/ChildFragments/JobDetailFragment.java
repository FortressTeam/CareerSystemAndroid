package com.example.kyler.careersystem.Applicant.ChildFragments;

import android.app.Fragment;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kyler.careersystem.R;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

/**
 * Created by kyler on 09/03/2016.
 */
public class JobDetailFragment extends Fragment implements ObservableScrollViewCallbacks,Button.OnClickListener {
    private ObservableScrollView scrollView;
    private TextView jobDetailCompanyInfo,jobDetailTitle,jobDetailSalary,jobDetailRequired,jobDetailOverview,jobDetailMoreInfo;
    private Button btApply;
    private ImageView postImage;
    private FloatingActionButton jobDetailFloatactionbuttonFavorite;

    private JSONObject jsJob1;

    public JobDetailFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.applicant_job_detail_fragment, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Job Detail");
        Bundle bundle = getArguments();
        Toast.makeText(getActivity().getApplicationContext(),bundle.getString("sendData"),Toast.LENGTH_LONG).show();
        postImage = (ImageView) rootView.findViewById(R.id.job_detail_image);
        btApply = (Button) rootView.findViewById(R.id.job_detail_btapply);
        jobDetailFloatactionbuttonFavorite = (FloatingActionButton) rootView.findViewById(R.id.job_detail_floatactionbutton_favorite);
        jobDetailFloatactionbuttonFavorite.setOnClickListener(this);
//        if(bundle.getBoolean("applied")) {
            btApply.setVisibility(View.VISIBLE);
            btApply.setOnClickListener(this);
//        }else{
//            btApply.setVisibility(View.GONE);
//        }
        jobDetailCompanyInfo = (TextView) rootView.findViewById(R.id.job_detail_companyinfo);
        jobDetailTitle = (TextView) rootView.findViewById(R.id.job_detail_title);
        jobDetailSalary = (TextView) rootView.findViewById(R.id.job_detail_salary);
        jobDetailRequired = (TextView) rootView.findViewById(R.id.job_detail_required);
        jobDetailOverview = (TextView) rootView.findViewById(R.id.job_detail_overview);
        jobDetailMoreInfo = (TextView) rootView.findViewById(R.id.job_detail_moreinfo);
        try {
            jsJob1= new JSONObject("{ \"post_id\": \"1\"," +
                    " \"post_title\": \"Job xxxx\"," +
                    " \"post_required\": \"5 years experience\"," +
                    " \"post_moreinfo\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\"," +
                    "  \"post_content\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\",\n" +
                    " \"post_salary\": 300," +
                    " \"post_image\": \"https://cdn1.iconfinder.com/data/icons/avatar-3/512/Pilot-128.png\"," +
                    " \"post_date\": \"12/12/2016\"," +
                    " \"post_status\": 1," +
                    " \"category_name\": \"Information Technology\"," +
                    " \"company_overview\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\"," +
                    " \"company_name\": \"Enclave\" }");
            if(jsJob1.has("post_image"))
                Picasso.with(getActivity().getApplicationContext()).load((jsJob1.getString("post_image"))).into(postImage);
            if(jsJob1.has("company_overview"))
                jobDetailCompanyInfo.setText(jsJob1.getString("company_overview"));
            if(jsJob1.has("post_title"))
                jobDetailTitle.setText(jsJob1.getString("post_title"));
            if(jsJob1.has("post_salary"))
                jobDetailSalary.setText(jsJob1.getString("post_salary"));
            if(jsJob1.has("post_required"))
                jobDetailRequired.setText(jsJob1.getString("post_required"));
            if(jsJob1.has("post_content"))
                jobDetailOverview.setText(jsJob1.getString("post_content"));
            if(jsJob1.has("post_moreinfo"))
                jobDetailMoreInfo.setText(jsJob1.getString("post_moreinfo"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        scrollView = (ObservableScrollView) rootView.findViewById(R.id.job_detail_scrollview);
        scrollView.setScrollViewCallbacks(this);
        return rootView;
    }

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {

    }

    @Override
    public void onDownMotionEvent() {

    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {
        ActionBar ab = ((AppCompatActivity)getActivity()).getSupportActionBar();
        if (ab == null) {
            return;
        }
        if (scrollState == ScrollState.UP) {
            if (ab.isShowing()) {
                ab.hide();
            }
        } else if (scrollState == ScrollState.DOWN) {
            if (!ab.isShowing()) {
                ab.show();
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.job_detail_btapply:
                Toast.makeText(getActivity().getApplicationContext(), "You applied this job successfull!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.job_detail_floatactionbutton_favorite:
                Toast.makeText(getActivity().getApplicationContext(), "FloatActionButton!", Toast.LENGTH_SHORT).show();
                jobDetailFloatactionbuttonFavorite.setImageResource(R.drawable.star_follow);
                break;
            default:
                break;
        }
    }
}
