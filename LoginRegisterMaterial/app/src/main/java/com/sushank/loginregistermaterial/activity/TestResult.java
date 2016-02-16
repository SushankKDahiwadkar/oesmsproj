package com.sushank.loginregistermaterial.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sushank.loginregistermaterial.R;
import com.sushank.loginregistermaterial.model.Question;

import java.util.ArrayList;

public class TestResult extends AppCompatActivity {

    TextView gotMarks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_test_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        gotMarks = (TextView) findViewById(R.id.textViewMarks);

        Intent intent = getIntent();
        ArrayList<Question> listQuestions = new ArrayList<Question>();
        listQuestions = (ArrayList<Question>) getIntent().getSerializableExtra("LIST_QUESTIONS");
        calculateMarks(listQuestions);
    }

    private void calculateMarks(ArrayList<Question> listQuestions) {
        int marks = 0;
        for(Question question : listQuestions){
            if(question.getSelectedAnswer().toString().equals(question.getCorrectAnswer().toString())){
                marks = marks+1;
            }
        }

        gotMarks.setText(String.valueOf(marks));
    }

}
