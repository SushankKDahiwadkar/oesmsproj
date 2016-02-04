package com.sushank.loginregistermaterial.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;


import com.google.gson.Gson;
import com.sushank.loginregistermaterial.R;
import com.sushank.loginregistermaterial.model.TestDetail;

import org.json.JSONException;
import org.json.JSONObject;


public class TestDetails extends AppCompatActivity {
    TextView txtViewTestId;
    TextView txtViewTestName;
    TextView txtViewSubject;
    TextView txtViewTotalQuestions;
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

        Intent intent = getIntent();
        String testDetails = intent.getStringExtra("TEST_DETAILS");
        
        showTestDetails(testDetails);
    }

    private void showTestDetails(String test_details) {
        Gson gson = new Gson();
        TestDetail testDetail = gson.fromJson(test_details, TestDetail.class);
        Toast.makeText(getApplicationContext(), String.valueOf(testDetail.getTestId()), Toast.LENGTH_LONG).show();
        txtViewTestId.setText(String.valueOf(testDetail.getTestId()));
        txtViewTestName.setText(testDetail.getTestName());
        txtViewSubject.setText(testDetail.getSubject());
        txtViewTotalQuestions.setText(String.valueOf(testDetail.getTotalQuestions()));
    }

}
