package com.example.android.musicquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    //default method to set the layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //Starts the quiz by going to the first question after the user clicks the button.
    public void goToQuiz(View view) {
        Intent goToQuiz = new Intent(MainActivity.this, Quiz_Questions.class);
        startActivity(goToQuiz);
    }
}
