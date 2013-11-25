package com.example.my_jokes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class ShowJoke extends Activity {

	private TextView jokeTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_joke);
		
		Intent intent = getIntent();
		String joke = intent.getStringExtra(MainActivity.MY_JOKE);
		
		jokeTextView = (TextView) findViewById(R.id.jokeTextView);
		jokeTextView.setText(joke);
		jokeTextView.setTextSize(32);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_joke, menu);
		return true;
	}

}