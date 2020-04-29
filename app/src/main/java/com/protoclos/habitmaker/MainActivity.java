package com.protoclos.habitmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    LinearLayout habitLayout;
    Button addHabitButton;
    ArrayList<String> habitArray = new ArrayList<String>();
    int habitCounter;

    int GET_NEW_HABIT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        habitLayout = (LinearLayout) findViewById(R.id.habitLayout);
        addHabitButton = (Button) findViewById(R.id.addHabitButton);
        String[] habitArrayTemp = res.getStringArray(R.array.habits);

        habitCounter = 0;
        for (int i = 0; i < habitArrayTemp.length; i++) {
            createNewHabit(habitArrayTemp[i]);
        }

        //OnClickListener for Commit Button
        addHabitButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewHabitActivity.class);
                startActivityForResult(intent, GET_NEW_HABIT);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == GET_NEW_HABIT) {
            createNewHabit(data.getStringExtra("NEW_HABIT_NAME"));
            Toast.makeText(this, "Created a new habit.\n Better keep it up!",
                    Toast.LENGTH_LONG).show();
        }
    }

    protected void createNewHabit(String name) {
        habitArray.add(name);
        CheckBox tv = new CheckBox(this);
        tv.setText(name);
        tv.setId(habitCounter);
        habitCounter++;
        habitLayout.addView(tv);
    }

}
