package com.protoclos.habitmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NewHabitActivity extends AppCompatActivity {

    EditText newHabitName;
    Button commitNewHabitButton;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_habbit);

        intent = getIntent();

        commitNewHabitButton = (Button) findViewById(R.id.commitNewHabitButton);
        newHabitName = (EditText) findViewById(R.id.newHabitNameText);

        commitNewHabitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("NEW_HABIT_NAME", newHabitName.getText().toString());
                setResult(2,intent);
                finish();
            }
        });
    }

}
