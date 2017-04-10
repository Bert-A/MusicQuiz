package com.example.android.musicquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Quiz_Questions extends AppCompatActivity {

    //Global variable for further use
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_questions);
    }


    public void questionOne(View view) {
        //Checking combinations of checkboxes so we can only check two at the same time.
        //If any combination of two checkboxes are checked, it disables the other two, if one is then unchecked, all are enabled again.
        CheckBox cb1 = (CheckBox) findViewById(R.id.question_one_checkbox_1);
        CheckBox cb2 = (CheckBox) findViewById(R.id.question_one_checkbox_2);
        CheckBox cb3 = (CheckBox) findViewById(R.id.question_one_checkbox_3);
        CheckBox cb4 = (CheckBox) findViewById(R.id.question_one_checkbox_4);
        if (cb1.isChecked() && cb2.isChecked()) {
            cb1.setEnabled(true);
            cb2.setEnabled(true);
            cb3.setEnabled(false);
            cb4.setEnabled(false);
        } else if (cb1.isChecked() && cb3.isChecked()) {
            cb1.setEnabled(true);
            cb2.setEnabled(false);
            cb3.setEnabled(true);
            cb4.setEnabled(false);
        } else if (cb1.isChecked() && cb4.isChecked()) {
            cb1.setEnabled(true);
            cb2.setEnabled(false);
            cb3.setEnabled(false);
            cb4.setEnabled(true);
        } else if (cb2.isChecked() && cb3.isChecked()) {
            cb1.setEnabled(false);
            cb2.setEnabled(true);
            cb3.setEnabled(true);
            cb4.setEnabled(false);
        } else if (cb2.isChecked() && cb4.isChecked()) {
            cb1.setEnabled(false);
            cb2.setEnabled(true);
            cb3.setEnabled(false);
            cb4.setEnabled(true);
        } else if (cb3.isChecked() && cb4.isChecked()) {
            cb1.setEnabled(false);
            cb2.setEnabled(false);
            cb3.setEnabled(true);
            cb4.setEnabled(true);
        } else {
            cb1.setEnabled(true);
            cb2.setEnabled(true);
            cb3.setEnabled(true);
            cb4.setEnabled(true);
        }


    }

    public void quizScore(View view) {
        //Resetting the score, as changing answers and retrying needs to start from 0
        score = 0;

        //Getting the values of checkboxes 2 and 3 only as the others are always incorrect.
        CheckBox cb2 = (CheckBox) findViewById(R.id.question_one_checkbox_2);
        CheckBox cb3 = (CheckBox) findViewById(R.id.question_one_checkbox_3);
        if (cb2.isChecked() && cb3.isChecked()) {
            score++;
        }

        //Only getting the state of the correct radiobutton as only one can be checked at the same time due to the radiogroup.
        RadioButton radio1 = (RadioButton) findViewById(R.id.question_two_radio_3);
        if (radio1.isChecked()) {
            score++;
        }
        //Getting the text value, and comparing it to the correct answer, converting to lowercase to prevent caps or no caps from counting as incorrect.
        EditText textAnswer1 = (EditText) findViewById(R.id.question_three_edit_text);
        String answer = "";
        answer = textAnswer1.getText().toString();
        answer = answer.toLowerCase();

        if (answer.equals("pink floyd")) {
            score++;
        }
        //Only getting the state of the correct radiobutton as only one can be checked at the same time due to the radiogroup.
        RadioButton radio2 = (RadioButton) findViewById(R.id.question_four_radio_3);
        if (radio2.isChecked()) {
            score++;
        }


        //Gets the player name for the toast message.
        EditText name = (EditText) findViewById(R.id.name_edit_text);

        //Toast message for the score.
        Toast.makeText(this, "You scored " + score + " out of 4! Thanks for playing, " + name.getText() + "!", Toast.LENGTH_SHORT).show();
    }


}