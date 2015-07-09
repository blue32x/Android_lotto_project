package com.example.lotto_pic_v01;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Preview extends SurfaceView implements SurfaceHolder.Callback{

	SurfaceHolder mHolder;
	Camera mCamera;
	ApplicationClass ac;
	public Preview(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		mHolder = getHolder();
        mHolder.addCallback(this);
        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
       // ac=(ApplicationClass)getApplicationContext();
	}
	
	public Preview(Context context,ApplicationClass pac) {
		super(context);
		// TODO Auto-generated constructor stub
		mHolder = getHolder();
        mHolder.addCallback(this);
        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        ac=(ApplicationClass)pac;
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		 ac.mCamera = Camera.open();
	        try {
	        	ac.mCamera.setPreviewDisplay(holder);
	        } catch (Exception exception) {
	        	ac.mCamera.release();
	        	ac.mCamera = null;
	            
	// TODO: add more exception handling logic here
	        }
		
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		// TODO Auto-generated method stub
		 Camera.Parameters parameters = ac.mCamera.getParameters();
	        parameters.setPreviewSize(width, height);
	        parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE); // automatically auto-focus!
	        ac.mCamera.setParameters(parameters);
	        ac.mCamera.startPreview();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		ac.mCamera.stopPreview();
		ac.mCamera = null;
	}
	
}
