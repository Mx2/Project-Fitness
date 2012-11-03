package com.android.projectfitness;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MenuActivity extends Activity {
	
	Button list = null;
	Button diary = null;
	Button exercise = null;

	private OnClickListener listListener = new OnClickListener() {
		public void onClick(View v) {

			Intent myIntent = new Intent(v.getContext(), FoodListActivity.class);
		       startActivityForResult(myIntent, 0);
			
		}
	};
	
	private OnClickListener diaryListener = new OnClickListener() {
		public void onClick(View v) {

			Intent myIntent = new Intent(v.getContext(), DiaryViewActivity.class);
		       startActivityForResult(myIntent, 0);
			
		}
	};
	
//	private OnClickListener exerciseListener = new OnClickListener() {
//		public void onClick(View v) {
//			
//			Intent myIntent = new Intent(v.getContext(), ExerciseActivity.class);
//		       startActivityForResult(myIntent, 0);
//			
//		}
//	};
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        
        list = (Button) findViewById(R.id.list_button);
        diary = (Button) findViewById(R.id.diary_menu_button);
        exercise = (Button) findViewById(R.id.exercise_button);
        

       list.setOnClickListener(listListener);
       diary.setOnClickListener(diaryListener);
       //exercise.setOnClickListener(exerciseListener);
       
    }
}