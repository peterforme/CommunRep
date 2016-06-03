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

public class SecondActivity extends Activity{
TextView tvTitle;
EditText etContent;
Button btnSend;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		tvTitle = (TextView)findViewById(R.id.tvTitle);
		
		String title = getIntent().getStringExtra("title");
		tvTitle.setText(title);
		
		etContent = (EditText)findViewById(R.id.etContent);
		btnSend = (Button)findViewById(R.id.btnSend);
		btnSend.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String text = etContent.getText().toString();
				Intent intent = new Intent ();
				intent.putExtra("data", text);
				setResult(200,intent);
				finish();
			}});
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Intent intent = new Intent ();
			intent.putExtra("data", "data from second activity");
//			Toast.makeText(this, "onkeydown", 0).show();
			setResult(200,intent);
			finish();
		}
		
		return super.onKeyDown(keyCode, event);
	}
	
}
