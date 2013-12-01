package com.example.my_jokes;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ShowJoke extends Activity {

	public final static String MY_FILE = "MyJokes.txt";
	private TextView jokeTextView;
	private ListView listView;
	private ArrayList<String> listItems;
	private ArrayAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_joke);
		
		listView = (ListView) findViewById(R.id.listView);
		listItems = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(MY_FILE);
			DataInputStream dataIO = new DataInputStream(fis);
			StringBuffer sBuffer = new StringBuffer();
			String line = null;
			Intent intent = getIntent();
			
			//String joke = intent.getStringExtra(MainActivity.MY_JOKE);
			//String jokeNumber = intent.getStringExtra(MainActivity.MY_JOKE_NUMBER);
			
			jokeTextView = (TextView) findViewById(R.id.jokeTextView);
			
			while((line = dataIO.readLine()) != null){
				listItems.add(line);
			}
			
			adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems);
			listView.setAdapter(adapter);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_joke, menu);
		return true;
	}

}