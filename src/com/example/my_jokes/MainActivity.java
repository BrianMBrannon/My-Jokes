package com.example.my_jokes;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	public final static String MY_JOKE = "com.example.myjokes.JOKE";
	public final static String MY_JOKE_NUMBER = "com.example.myjokes.JOKENUMBER";
	public final static String MY_FILE = "MyJokes.txt";
	private Button submitJokeButton;
	private FileOutputStream fos;
	private FileInputStream fis;
	EditText mainEditText;
	EditText answerEditText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/*try {
			fos = openFileOutput("MY_FILE", MODE_APPEND);
			Toast.makeText(getApplicationContext(), MY_FILE + " opened", Toast.LENGTH_SHORT).show();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		mainEditText = (EditText) findViewById(R.id.mainEdit);
		answerEditText = (EditText) findViewById(R.id.answerEdit);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/*
	 * WARNING: getJokeNumber will sometimes cause the application to crash.
	 */
	@SuppressWarnings("deprecation")
	public int getJokeNumber(String myFileName) throws IOException {
		fis = openFileInput(myFileName);
		DataInputStream dataIO = new DataInputStream(fis);
		String line = null;
		int potentNum = 0;
		
		if(dataIO.readLine() != null) {
			while ((line = dataIO.readLine()) != null) {
				potentNum = readNumber(line);
			}
		}
		return potentNum + 1;
	}
	
	public int readNumber(String line) {
		//48-57 decimal number ASCII codes
		if (line.length() == 0) return 0;
		
		int index = 0;
		String number = "0";
		
		char currentChar = line.charAt(index);
		
		//The line must begin with a numerical character.  This is ensured elsewhere.
		while (index < line.length() && (int)currentChar > 47 && (int)currentChar < 58) {
			number += line.charAt(index);
			currentChar = line.charAt(index);
			index++;
		}
		
		return Integer.parseInt(number);
	}
	
	public void sendJoke(View v) throws IOException {
		String joke = mainEditText.getText().toString();
		String answer = answerEditText.getText().toString();
		String submission = time() + "\n" + joke + "\n" + answer + "\n";
		//int writeTo = getJokeNumber(MY_FILE);
		//String line = writeTo + ": " + joke;
		fos = openFileOutput(MY_FILE, MODE_APPEND);
		fos.write(submission.getBytes());
		fos.close();
		
		Intent intent = new Intent(this, ShowJoke.class);
		//intent.putExtra(MY_JOKE_NUMBER, Integer.toString(writeTo));
		//intent.putExtra(MY_JOKE, joke);
		startActivity(intent);
	}
	
	public void toJokes(View v) {
		Intent intent = new Intent(this, ShowJoke.class);
		startActivity(intent);
	}
	
	public String time() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy", Locale.US);
		return sdf.format(new Date(System.currentTimeMillis()));
	}

	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		mainEditText.setText((CharSequence) findViewById(R.string.mainEditText));
		answerEditText.setText((CharSequence) findViewById(R.string.answerEditText));
	}
	
	
}
