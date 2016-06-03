package com.example.myplugintest;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends Activity{
TextView tvTitle;
EditText etContent;
Button btnSend;

public static FirstActivity firstActivity ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);
		
		firstActivity = this;
		
		tvTitle = (TextView)findViewById(R.id.tvTitle);
		
		tvTitle.setOnClickListener(new OnClickListener(){
		    
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(FirstActivity.this,MainActivity.class);
						startActivity(intent);
						 
					}
				}
				);
		
		etContent = (EditText)findViewById(R.id.etContent);
		btnSend = (Button)findViewById(R.id.btnSend);
		btnSend.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String text = etContent.getText().toString();
				Intent intent = new Intent(FirstActivity.this,MainActivity.class);
				intent.putExtra("data", text);
				startActivity(intent);
			}});
		
		Intent intent = getIntent();
		if(intent != null){
			String title = intent.getStringExtra("title");
			tvTitle.setText(title);
		}
			
		
	}
	
	public String getMessage()
	{
		return this.etContent.getText().toString();
		
	}
	
	
	public void changeText(String text)
	{
		tvTitle.setText("i'm the first activity , my text change to :"+text);
	}
	
	
}
