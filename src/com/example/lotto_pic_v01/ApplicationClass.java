package com.example.lotto_pic_v01;

import android.app.Application;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.hardware.Camera;

public class ApplicationClass extends Application{
	 public Camera mCamera;
	  public static Bitmap bitmap;
	    @Override
	    public void onCreate() {
	    	//mCamera=null;
	        super.onCreate();
	    }

	    @Override
	    public void onConfigurationChanged(Configuration newConfig) {
	        super.onConfigurationChanged(newConfig);
	    }
	    public Camera getCamera()
	    {
	    	return mCamera;
	    }


}
