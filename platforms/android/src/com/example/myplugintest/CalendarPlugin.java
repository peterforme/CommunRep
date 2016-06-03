package com.example.myplugintest;
 
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;


import android.app.Activity; 
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class CalendarPlugin extends CordovaPlugin {
	 public static final String ACTION_FIRST = "action first";
    public static final String ACTION_SECOND = "action second";
    public static final String ACTION_THIRD = "action third";
    public    CallbackContext callbackContext;
    
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        try {
            if (ACTION_SECOND.equals(action)) { 
                this.callbackContext = callbackContext;
            	
                
                
            	JSONObject arg_object = args.getJSONObject(0);
//                Intent calIntent = new Intent(Intent.ACTION_EDIT)
//                    .setType("vnd.android.cursor.item/event")
//                    .putExtra("beginTime", arg_object.getLong("startTimeMillis"))
//                    .putExtra("endTime", arg_object.getLong("endTimeMillis"))
//                    .putExtra("title", arg_object.getString("title"))
//                    .putExtra("description", arg_object.getString("description"))
//                    .putExtra("eventLocation", arg_object.getString("eventLocation"));
//             
//                   this.cordova.getActivity().startActivity(calIntent);
                
                String title = arg_object.getString("title");
                
               
                
                Intent intent = new Intent(cordova.getActivity(), SecondActivity.class);
                intent.putExtra("title",title);
        		cordova.startActivityForResult((CordovaPlugin) this,intent, 200);
              
                   return true; 
            }  
            else if(ACTION_FIRST.equals(action))
            {
				this.callbackContext = callbackContext;
            	JSONObject arg_object = args.getJSONObject(0);
            	  String title = arg_object.getString("title");
                  Intent intent = new Intent(cordova.getActivity(), FirstActivity.class);
                  intent.putExtra("title",title);
          		cordova.startActivityForResult((CordovaPlugin) this,intent, 200);
                     return true; 
            }
            else if(ACTION_THIRD.equals(action))
            {
				this.callbackContext = callbackContext;
            	String message = FirstActivity.firstActivity.getMessage();
            	callbackContext.success(message);
                     return true; 
            }
             
           
            callbackContext.error("Invalid action");
            return false;
        } catch(Exception e) {
            System.err.println("Exception: " + e.getMessage());
            callbackContext.error(e.getMessage());
            return false;
        } 
    }
    
    @Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		
		super.onActivityResult(requestCode, resultCode, intent);
		if(intent == null)  return;
		//传递返回值 给js方法
		String data = intent.getStringExtra("data");
		callbackContext.success(data);
		

	}
    
}