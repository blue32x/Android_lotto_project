package com.example.lotto_pic_v01;

import java.io.FileInputStream;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class AlgorithmActivity extends ActionBarActivity {

	Bitmap bitmap;
	ImageView imgview;
	ApplicationClass ac;
	byte[] byteArray;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.algorithm);
		
		String filename = getIntent().getStringExtra("image");
		try {
		    FileInputStream is = this.openFileInput(filename);
		    bitmap = BitmapFactory.decodeStream(is);
		    is.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		imgview=(ImageView)findViewById(R.id.BitmapImageView);
		imgview.setImageBitmap(bitmap);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.algorithm, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
