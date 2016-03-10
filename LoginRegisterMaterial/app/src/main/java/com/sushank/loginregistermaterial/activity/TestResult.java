package com.sushank.loginregistermaterial.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
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
import com.sushank.loginregistermaterial.model.Question;
import com.sushank.loginregistermaterial.model.TestScore;
import com.sushank.loginregistermaterial.model.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import static com.sushank.loginregistermaterial.util.GlobalConstant.HOST_SERVER;

public class TestResult extends AppCompatActivity {

    TextView correctAnswered, wrongAnswered, totalAnswered;
    String testId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_test_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        correctAnswered = (TextView) findViewById(R.id.textCorrectAnswered);
        wrongAnswered = (TextView) findViewById(R.id.textWrongAnswered);
        totalAnswered = (TextView) findViewById(R.id.texTotalAnswered);

        Intent intent = getIntent();
        ArrayList<Question> listQuestions = new ArrayList<Question>();
        listQuestions = (ArrayList<Question>) getIntent().getSerializableExtra("LIST_QUESTIONS");
        testId = intent.getStringExtra("TEST_ID");
        calculateMarks(listQuestions);
    }

    private void calculateMarks(ArrayList<Question> listQuestions) {
        int marks = 0;
        int totalQuestions = listQuestions.size();
        int attemptedQuestions = 0;
        for(Question question : listQuestions){
            if((question.getSelectedAnswer() != null)){
                attemptedQuestions++;
                if(question.getSelectedAnswer().toString().equals(question.getCorrectAnswer().toString())){
                    marks = marks+1;
                }
            }
        }
        totalAnswered.setText(String.valueOf(attemptedQuestions));
        correctAnswered.setText(String.valueOf(marks));
        wrongAnswered.setText(String.valueOf(attemptedQuestions - marks));

        uploadResult(listQuestions, marks);
    }

    private void uploadResult(ArrayList<Question> listQuestions, int marks) {
        FileInputStream fileInputStream = null;

        int c;
        String temp = "";
        try {
            fileInputStream = openFileInput("myData");
            while((c = fileInputStream.read()) != (-1)){
                temp = temp + Character.toString((char)c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String userId = temp;

        TestScore testScore = new TestScore();
        testScore.setUserId(Integer.parseInt(userId));
        testScore.setTotalMarks(listQuestions.size());
        testScore.setScore(marks);
        testScore.setTestId(Integer.parseInt(testId));



        final Gson gson = new Gson();
        String score = gson.toJson(testScore);
        final String URL = HOST_SERVER + "/Score";
        JsonObjectRequest jsonObjectRequest;
        try {
            JSONObject jsonObject = new JSONObject(score);
            Log.i("created Request", jsonObject.toString());
            jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL, jsonObject,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Log.i("Response", response.toString());
                            Toast.makeText(getApplicationContext(), "uploaded Successfully.", Toast.LENGTH_SHORT).show();

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyLog.d("Error", "Error: " + error.getMessage());
                }
            });


            Log.i("generated request : ", jsonObjectRequest.toString());
            jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
                    10000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

            AppController.getInstance().addToRequestQueue(jsonObjectRequest, "Get Test Details");


        } catch (JSONException e) {
            e.printStackTrace();
        }



    }

}
