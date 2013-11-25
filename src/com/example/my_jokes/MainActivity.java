package com.example.my_jokes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	public final static String MY_JOKE = "com.example.myjokes.JOKE";
	private Button submitJokeButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void sendJoke(View v) {
		Intent intent = new Intent(this, ShowJoke.class);
		EditText mainEditText = (EditText) findViewById(R.id.mainEdit);
		String joke = mainEditText.getText().toString();
		intent.putExtra(MY_JOKE, joke);
		startActivity(intent);
	}
}
