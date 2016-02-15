package com.sushank.loginregistermaterial.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.sushank.loginregistermaterial.R;
import com.sushank.loginregistermaterial.model.Question;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class QuestionActivity extends AppCompatActivity {
    List<Question> listQuestions;
    TextView questionNumber;
    TextView question;
    TextView option1, option2, option3, option4;
    Button btnPrevious, btnNext;
    int questionId = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_question);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        questionNumber = (TextView) findViewById(R.id.textViewQuestionNumber);
        question = (TextView) findViewById(R.id.textViewQuestion);
        option1 = (TextView) findViewById(R.id.radioOption1);
        option2 = (TextView) findViewById(R.id.radioOption2);
        option3 = (TextView) findViewById(R.id.radioOption3);
        option4 = (TextView) findViewById(R.id.radioOption4);

        btnNext = (Button) findViewById(R.id.buttonNext);
        btnPrevious = (Button) findViewById(R.id.buttonPrevious);

        Intent intent = getIntent();

        final String questions = intent.getStringExtra("QUESTION_SET");
        listQuestions = getQuestionList(questions);


        displayQuestions(listQuestions, questionId);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayQuestions(listQuestions, ++questionId);
            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayQuestions(listQuestions, --questionId);
            }
        });
    }

    private void displayQuestions(List<Question> listQuestions, int questionNo) {
        int qNo = questionNo + 1;
        if(questionNo == 0){
            btnPrevious.setVisibility(View.INVISIBLE);
            Toast.makeText(QuestionActivity.this, "This is First Question !", Toast.LENGTH_SHORT).show();
        } else {
            btnPrevious.setVisibility(View.VISIBLE);
        }

        if(qNo == listQuestions.size()){
            btnNext.setText("Commit");
            Toast.makeText(QuestionActivity.this, "This is Last Question !", Toast.LENGTH_SHORT).show();
        }


        if(qNo <= listQuestions.size()){
            questionNumber.setText(String.valueOf(qNo));
            question.setText(listQuestions.get(questionNo).getQuestion().toString());
            option1.setText(listQuestions.get(questionNo).getOption1().toString());
            option2.setText(listQuestions.get(questionNo).getOption2().toString());
            option3.setText(listQuestions.get(questionNo).getOption3().toString());
            option4.setText(listQuestions.get(questionNo).getOption4().toString());
        } else {
            Toast.makeText(QuestionActivity.this, "Test Submitted Successfully !", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }

    }

    private List<Question> getQuestionList(String questions) {
        List<Question> questionList = new ArrayList<>();
        Gson gson = new Gson();
        try {
            JSONObject jsonObject = new JSONObject(questions);
            JSONArray jsonArray = jsonObject.getJSONArray("entries");
            Question question = null;

           for(int i=0  ; i<jsonArray.length() ; i++){
               String jsonString = jsonArray.getJSONObject(i).toString();
               question = gson.fromJson(jsonString, Question.class);
               questionList.add(question);
           }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return questionList;
    }

}
