package com.example.lotto_pic_v01;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ButtonActivity extends Fragment implements android.view.View.OnClickListener {

	Button albumbutton;
	Button smilebutton;
	View view;
	ApplicationClass ac;

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.buttonframe, container, false);
		albumbutton = (Button) view.findViewById(R.id.albumbtn);
		albumbutton.setOnClickListener(this);
		smilebutton = (Button) view.findViewById(R.id.smilebtn);
		smilebutton.setOnClickListener(this);
		return view;
	}

	public void onClick(View v)
	{
		switch(v.getId())
		{
		case R.id.albumbtn:
			//access to the album code
			Intent intent=new Intent(Intent.ACTION_PICK);
			intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);
			startActivityForResult(intent,1);
			break;
		case R.id.smilebtn:
			//take a picture 
			ac=(ApplicationClass)getActivity().getApplicationContext();	
			Intent algorithm=new Intent(getActivity(),AlgorithmActivity.class);
			startActivity(algorithm);
			break;
		}
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		super.onActivityResult(requestCode, resultCode, intent);

	}

}
