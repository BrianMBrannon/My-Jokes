package com.example.my_jokes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

public class Splash extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		Thread timeout = new Thread() {
			public void run() {
				try {
					sleep(1000);
				}
				catch (InterruptedException e){
					e.printStackTrace();
				}
				finally {
					Intent openHomeScreen = new Intent("com.example.my_jokes.HOME");
					startActivity(openHomeScreen);
				}
			}
		};
		timeout.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash, menu);
		return true;
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
