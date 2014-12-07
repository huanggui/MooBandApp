package com.moo.utils;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;

public class DoHardwareUtils {

	public static void openCameraLight(Camera camera) {
        Parameters params = camera.getParameters();
        params.setFlashMode(Parameters.FLASH_MODE_TORCH);
        camera.setParameters(params);
        camera.startPreview(); // 开始亮灯
	}
	
	public static void closeCameraLight(Camera camera) {
        camera.stopPreview(); // 关掉亮灯
        //camera.release(); // 关掉照相机
	}
	
	/** A safe way to get an instance of the Camera object. */
	public static Camera getCameraInstance(){
	    Camera c = null;
	    try {
	        c = Camera.open(); // attempt to get a Camera instance
	    }
	    catch (Exception e){
	        // Camera is not available (in use or does not exist)
	    }
	    return c; // returns null if camera is unavailable
	}
}
