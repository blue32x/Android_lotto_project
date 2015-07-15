package com.example.lotto_pic_v01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Environment;
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
	boolean inProgress = false;

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
			ac.mCamera.takePicture(null, null, takepic);
			inProgress = true;
			Intent algorithm=new Intent(getActivity(),AlgorithmActivity.class);
			startActivity(algorithm);
			break;
		}
	}
	public Camera.PictureCallback takepic = new Camera.PictureCallback() 
    {    
        @Override
        public void onPictureTaken(byte[] data, Camera camera) 
        {
            Log.d("1", "=== takePicture ===");

            if (data != null)
            {
                Log.v("1", "takePicture JPEG »çÁø ÂïÀ½");

                Bitmap bitmap = BitmapFactory.decodeByteArray(data,  0,  data.length);
               // iv_preview.setImageBitmap(bitmap);
                saveBitmaptoJpeg(bitmap,"history1","1");
                camera.startPreview();
                inProgress = false; 
            }
            else
            {
                Log.e("1", "takePicture data null");
            }
        }
    };


	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		super.onActivityResult(requestCode, resultCode, intent);

	}
	/*
	 *  save Bitmap Image to Jpeg Image
	 *  
	 */
	public static void saveBitmaptoJpeg(Bitmap bitmap,String folder, String name)
	{
		String ex_storage = Environment.getExternalStorageDirectory().getAbsolutePath();
		String file_name = name+".jpg";
		String string_path = ex_storage+"/"+folder;
		
		File file_path;
		try
		{
			file_path= new File(string_path);
			if(!file_path.isDirectory())
			{
				file_path.mkdirs();
			}
			FileOutputStream out= new FileOutputStream(string_path+"/"+file_name);
			bitmap.compress(Bitmap.CompressFormat.JPEG,100, out);
			out.close();
		}catch(FileNotFoundException exception){
			Log.e("FileNotFoundException", exception.getMessage());
			
		}catch(IOException exception){
			Log.e("IOException", exception.getMessage());
		}
	}

}
