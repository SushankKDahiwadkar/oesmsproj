package com.sushank.loginregistermaterial.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.sushank.loginregistermaterial.R;
import com.sushank.loginregistermaterial.adapter.AppController;
import com.sushank.loginregistermaterial.model.TestDetail;

import org.json.JSONException;
import org.json.JSONObject;

import static com.sushank.loginregistermaterial.util.GlobalConstant.HOST_SERVER;


public class TestDetails extends AppCompatActivity {
    TextView txtViewTestId;
    TextView txtViewTestName;
    TextView txtViewSubject;
    TextView txtViewTotalQuestions;
    Button btnStartTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_test_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtViewTestId = (TextView) findViewById(R.id.textViewTestId);
        txtViewTestName = (TextView) findViewById(R.id.textViewTestName);
        txtViewSubject = (TextView) findViewById(R.id.textViewSubject);
        txtViewTotalQuestions = (TextView) findViewById(R.id.textViewTotalQuestions);
        btnStartTest = (Button) findViewById(R.id.btnStartTest);

        Intent intent = getIntent();
        final String testDetails = intent.getStringExtra("TEST_DETAILS");
        
        showTestDetails(testDetails);

        btnStartTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuestionActivity(testDetails);
            }
        });
    }

    private void openQuestionActivity(String testDetails) {
        Gson gson = new Gson();
        TestDetail testDetail = gson.fromJson(testDetails, TestDetail.class);

        String url = HOST_SERVER + "/Question/Test/" + testDetail.getTestId();

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Fetching Test Details...");
        progressDialog.show();

        JSONObject param = null;
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url,param ,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("response", response.toString());

                        Intent intent = new Intent(getApplicationContext(), QuestionActivity.class);
                        intent.putExtra("QUESTION_SET", response.toString());
                        progressDialog.hide();
                        startActivity(intent);
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Error", "Error: " + error.getMessage());
                Log.e("Error" , error.getMessage());
                progressDialog.hide();
                Intent intent = new Intent(getApplicationContext(), QuestionActivity.class);
                startActivity(intent);
            }
        });

        Log.i("generated request : ", jsonObjReq.getUrl());
        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(
                10000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        AppController.getInstance().addToRequestQueue(jsonObjReq, "Get Question Set");
    }


    private void showTestDetails(String test_details) {
        Gson gson = new Gson();
        TestDetail testDetail = gson.fromJson(test_details, TestDetail.class);
        txtViewTestId.setText(String.valueOf(testDetail.getTestId()));
        txtViewTestName.setText(testDetail.getTestName());
        txtViewSubject.setText(testDetail.getSubject());
        txtViewTotalQuestions.setText(String.valueOf(testDetail.getTotalQuestions()));
    }

}
