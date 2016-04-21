package com.sushank.loginregistermaterial.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
    TextView questionNumber, seconds, minutes;
    TextView question;
    TextView option1, option2, option3, option4;
    Button btnPrevious, btnNext;
    RadioGroup radioGroupOptions;
    String testid;
    RadioButton radioOption;
    int questionId = 0;
    CountDownTimer countDownTimer;
    private long startTime = 180 * 1000;
    private final long interval = 1 * 1000;
    private boolean timerHasStarted = false;
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
        //seconds = (TextView) findViewById(R.id.textViewClockSeconds);
        minutes = (TextView) findViewById(R.id.textViewClockMinutes);
        btnNext = (Button) findViewById(R.id.buttonNext);
        btnPrevious = (Button) findViewById(R.id.buttonPrevious);

        radioGroupOptions = (RadioGroup) findViewById(R.id.radioGroupOptions);
        countDownTimer = new MyCountDownTimer(startTime, interval);

        Intent intent = getIntent();

        final String questions = intent.getStringExtra("QUESTION_SET");

        testid = intent.getStringExtra("TEST_ID");

        startTime = Integer.parseInt(intent.getStringExtra("TIME")) * 60 * 1000;

        minutes.setText(String.valueOf((startTime/1000)/60));
        if(!timerHasStarted){
            countDownTimer.start();
            timerHasStarted = true;
        }else{
            countDownTimer.cancel();
            timerHasStarted = false;
        }



        listQuestions = getQuestionList(questions);


        displayQuestions(listQuestions, questionId);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnNext.getText().equals("Next")) {
                    radioGroupOptions.clearCheck();
                    displayQuestions(listQuestions, ++questionId);
                } else if (btnNext.getText().equals("Commit")) {
                    submitTest(listQuestions);
                }
            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioGroupOptions.clearCheck();
                displayQuestions(listQuestions, --questionId);
            }
        });

        radioGroupOptions.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                setSelectedOption(group, checkedId, questionId);
            }
        });
    }

    public class MyCountDownTimer extends CountDownTimer{
        public MyCountDownTimer(long startTime, long interval){
            super(startTime, interval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            //minutes.setText("" + (millisUntilFinished / 1000)/60);
            //seconds.setText("" + (millisUntilFinished / 1000)%60);
            int minutesLeft = (int) ((millisUntilFinished / 1000)/60);
            int secondsLeft = (int) ((millisUntilFinished / 1000)%60);
            minutes.setText("" + minutesLeft + ":" + secondsLeft);
            if(((millisUntilFinished / 1000)/60) == 0){
                minutes.setTextColor(Color.RED);
                //Fsecondsseconds.setTextColor(Color.RED);
            }
        }

        @Override
        public void onFinish() {
            Toast.makeText(QuestionActivity.this, "Test Submitted Successfully !", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), TestResult.class);
            ArrayList<Question> questionss = new ArrayList<Question>();
            questionss.addAll(listQuestions);
            intent.putExtra("LIST_QUESTIONS", questionss);
            intent.putExtra("TEST_ID", testid);
            startActivity(intent);
        }
    }

    private void submitTest(final List<Question> listQuestions){
        final AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);

        alertBuilder.setMessage("Are you sure, You want to commit test");

        alertBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(QuestionActivity.this, "Test Submitted Successfully !", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), TestResult.class);
                ArrayList<Question> questionss = new ArrayList<Question>();
                questionss.addAll(listQuestions);
                intent.putExtra("LIST_QUESTIONS", questionss);
                intent.putExtra("TEST_ID", testid);
                startActivity(intent);
            }
        });

        alertBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = alertBuilder.create();
        alertDialog.show();
    }

    private void setSelectedOption(RadioGroup group, int checkedId, int questionId) {
        switch (checkedId) {
            case R.id.radioOption1 :
                radioOption = (RadioButton) findViewById(checkedId);
                if(listQuestions.get(questionId).getSelectedAnswer() != null){
                }else{
                    if(radioOption.getText().equals(listQuestions.get(questionId).getOption1())){
                        listQuestions.get(questionId).setSelectedAnswer(radioOption.getText().toString());
                    }
                }
                break;
            case R.id.radioOption2 :
                radioOption = (RadioButton) findViewById(checkedId);
                if(listQuestions.get(questionId).getSelectedAnswer() != null){
                    /*int count = radioGroupOptions.getChildCount();
                    ArrayList<RadioButton> listRadioButtons = new ArrayList<RadioButton>();
                    for(int i=0; i<count; i++){
                        View view = radioGroupOptions.getChildAt(i);
                        if(view instanceof RadioButton){
                            if(((RadioButton) view).getText().toString() == listQuestions.get(questionId).getSelectedAnswer()){
                                ((RadioButton) view).setChecked(true);
                            }
                        }
                    }*/
                }else{
                    if(radioOption.getText().equals(listQuestions.get(questionId).getOption2())){
                        listQuestions.get(questionId).setSelectedAnswer(radioOption.getText().toString());
                    }
                }
                break;
            case R.id.radioOption3 :
                radioOption = (RadioButton) findViewById(checkedId);
                if(listQuestions.get(questionId).getSelectedAnswer() != null){
                    /*int count = radioGroupOptions.getChildCount();
                    ArrayList<RadioButton> listRadioButtons = new ArrayList<RadioButton>();
                    for(int i=0; i<count; i++){
                        View view = radioGroupOptions.getChildAt(i);
                        if(view instanceof RadioButton){
                            if(((RadioButton) view).getText().toString() == listQuestions.get(questionId).getSelectedAnswer()){
                                ((RadioButton) view).setChecked(true);
                            }
                        }
                    }*/
                }else{
                    if(radioOption.getText().equals(listQuestions.get(questionId).getOption3())){
                        listQuestions.get(questionId).setSelectedAnswer(radioOption.getText().toString());
                    }
                }
                break;
            case R.id.radioOption4 :
                radioOption = (RadioButton) findViewById(checkedId);
                if(listQuestions.get(questionId).getSelectedAnswer() != null){
                    /*int count = radioGroupOptions.getChildCount();
                    ArrayList<RadioButton> listRadioButtons = new ArrayList<RadioButton>();
                    for(int i=0; i<count; i++){
                        View view = radioGroupOptions.getChildAt(i);
                        if(view instanceof RadioButton){
                            if(((RadioButton) view).getText().toString() == listQuestions.get(questionId).getSelectedAnswer()){
                                ((RadioButton) view).setChecked(true);
                            }
                        }
                    }*/
                }else{
                    if(radioOption.getText().equals(listQuestions.get(questionId).getOption4())){
                        listQuestions.get(questionId).setSelectedAnswer(radioOption.getText().toString());
                    }
                }
                break;
        }
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
        if(qNo < listQuestions.size()){
            btnNext.setText("Next");
        }



        if(qNo <= listQuestions.size()){

            questionNumber.setText(String.valueOf(qNo));
            question.setText(listQuestions.get(questionNo).getQuestion().toString());
            option1.setText(listQuestions.get(questionNo).getOption1().toString());
            option2.setText(listQuestions.get(questionNo).getOption2().toString());
            option3.setText(listQuestions.get(questionNo).getOption3().toString());
            option4.setText(listQuestions.get(questionNo).getOption4().toString());

            markSelectedOption(listQuestions, questionNo);
        }

    }

    private void markSelectedOption(List<Question> listQuestions, int questionNo) {

        if(listQuestions.get(questionNo).getSelectedAnswer() != null){
            int count = radioGroupOptions.getChildCount();
            ArrayList<RadioButton> listRadioButtons = new ArrayList<RadioButton>();
            for(int i=0; i<count; i++){
                View view = radioGroupOptions.getChildAt(i);
                if(view instanceof RadioButton){
                    if(((RadioButton) view).getText().toString() == listQuestions.get(questionNo).getSelectedAnswer()){
                        ((RadioButton) view).setChecked(true);
                    }
                }
            }
        }else{
            radioGroupOptions.clearCheck();
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
