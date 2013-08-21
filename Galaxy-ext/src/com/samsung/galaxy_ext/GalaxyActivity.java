package com.samsung.galaxy_ext;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.mediatek.telephony.TelephonyManagerEx;


public class GalaxyActivity extends Activity {
//	private  TelephonyManager telManager;
	TelephonyManagerEx mTelephonyManagerEx;
	PackageManager mgr = null;
	private  boolean usedefaut = true;
	//
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		
//		telManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
//		if(isSimOK() && isChineseSim()){
//			usedefaut = false;
//		}
		getWindow().setWindowAnimations(0) ;
		getWindow().getDecorView().setBackgroundColor(0x00000000);
		
		mTelephonyManagerEx =  new TelephonyManagerEx(this);
		mgr =  this.getPackageManager();
		
		init();
		
		Intent it = getIntent();
		String action = null;
		if(it != null){
			action = it.getAction();
		}else{
			it = new Intent();
			it.setAction("android.intent.action.MAIN");
		}
		
		it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
		
//		if(action.equals("android.intent.action.MAIN")){
//			if(usedefaut){
//				it.setClassName("com.android.vending", "com.google.android.finsky.activities.MainActivity" );
//			}else{
//				it.setClassName("sum.app", "com.uucun.android.cms.activity.MarketLoginAndRegisterActivity");
//				if(mgr.queryIntentActivities(it, 0).isEmpty()){
//					it.setClassName("com.android.vending", "com.google.android.finsky.activities.MainActivity" );
//				}
//			}
//			try{
//				this.startActivity(it);
//			}catch(ActivityNotFoundException e){
//				
//			}
//			this.finish();
//		}else{
//			if(usedefaut){
//				it.setClassName("com.android.vending", "com.google.android.finsky.activities.MainActivity" );
//			}else{
//				it.setClassName("sum.app", "com.uucun.android.cms.activity.MarketLoginAndRegisterActivity");
//				if(mgr.queryIntentActivities(it, 0).isEmpty()){
//					it.setClassName("com.android.vending", "com.google.android.finsky.activities.MainActivity" );
//				}
//			}
//			try{
//				this.startActivity(it);
//			}catch(ActivityNotFoundException e){
//				
//			}
//			this.finish();
//		}
		super.onCreate(savedInstanceState);
		
	}
	
    
    void init(){
    	if(mTelephonyManagerEx == null) {
    		return;
    	}
    	if(!getResources().getConfiguration().locale.getCountry().equalsIgnoreCase("cn")) {
    		return;
    	}
    	
    	String MccMnc0 = mTelephonyManagerEx.getSimOperator(0);
    	if(MccMnc0 != null && MccMnc0.startsWith("460")){
    		usedefaut = false;
    		return;
		}
    	String MccMnc1 = mTelephonyManagerEx.getSimOperator(1);
    	if(MccMnc1 != null && MccMnc1.startsWith("460")){
    		usedefaut = false;
    		return;
		}    	
    }
//	
//	boolean isChineseSim(){
//		
//		if (telManager != null){
//			String MccMnc = telManager.getSimOperator();
//			if(MccMnc != null && MccMnc.startsWith("460")){
//				return true;
//			}
//		}
//		return false;	
//	}
//	
//	boolean isSimOK(){
//		if(telManager != null){
//			switch(telManager.getSimState()){ //getSimState()取得sim的状态 有下面6中状态
//			case TelephonyManager.SIM_STATE_ABSENT :
//				return false; 
//			case TelephonyManager.SIM_STATE_UNKNOWN :
//			case TelephonyManager.SIM_STATE_NETWORK_LOCKED :
//			case TelephonyManager.SIM_STATE_PIN_REQUIRED :
//			case TelephonyManager.SIM_STATE_PUK_REQUIRED :
//			case TelephonyManager.SIM_STATE_READY :
//				return true;
//			}
//		}
//		return false;
//		
//	}

}
