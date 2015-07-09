package com.example.lotto_pic_v01;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class PreviewActivity extends Fragment {
	 protected Preview mPreview;
	 SurfaceView sv;
	 RelativeLayout layout;
	 //ApplicationClass ac;
	 
	 public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		 
		 	mPreview = new Preview(getActivity(),(ApplicationClass)getActivity().getApplicationContext());
	      //  return inflater.inflate(R.layout.preview, container, false); 
		 // you need to return view!	
		 return mPreview; 
	    }
}
