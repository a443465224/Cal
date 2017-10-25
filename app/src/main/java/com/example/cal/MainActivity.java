package com.example.cal;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	EditText qianJiao;
	EditText zhongLian;
	TextView jieGuo;
	private EditText mCurTx;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		 qianJiao = (EditText) findViewById(R.id.qianJiao);
		 zhongLian = (EditText) findViewById(R.id.zhongLian);
		 jieGuo = (TextView) findViewById(R.id.jieGuo);
		 
		 
		 qianJiao.setOnClickListener(this);
		 zhongLian.setOnClickListener(this);
			
			findViewById(R.id.key1).setOnClickListener(this);
			findViewById(R.id.key2).setOnClickListener(this);
			findViewById(R.id.key3).setOnClickListener(this);
			findViewById(R.id.key4).setOnClickListener(this);
			findViewById(R.id.key5).setOnClickListener(this);
			findViewById(R.id.key6).setOnClickListener(this);
			findViewById(R.id.key7).setOnClickListener(this);
			findViewById(R.id.key8).setOnClickListener(this);
			findViewById(R.id.key9).setOnClickListener(this);
			findViewById(R.id.keyDel).setOnClickListener(this);
			findViewById(R.id.key0).setOnClickListener(this);
			findViewById(R.id.keySwitch).setOnClickListener(this);
			findViewById(R.id.okBtn).setOnClickListener(this);
			findViewById(R.id.reset).setOnClickListener(this);
		 
			mCurTx = qianJiao;
			mCurTx.requestFocus();
		
			//设置点击不弹出键盘
			qianJiao.setOnTouchListener(new OnTouchListener() {

				@Override
				public boolean onTouch(View v, MotionEvent event) {
					int inType = qianJiao.getInputType(); 
					qianJiao.setInputType(InputType.TYPE_NULL);  
					qianJiao.onTouchEvent(event); 
					qianJiao.setInputType(inType);
	                return false;   
				}                    
	        });
			//设置输入后，光标位置后移。
			qianJiao.addTextChangedListener(new TextWatcher() {
				
				@Override
				public void onTextChanged(CharSequence s, int start, int before, int count) {
					
				}
				
				@Override
				public void beforeTextChanged(CharSequence s, int start, int count,
						int after) {
					
				}
				
				@Override
				public void afterTextChanged(Editable s) {
					qianJiao.setSelection(qianJiao.getText().length());
				}
			});
			zhongLian.setOnTouchListener(new OnTouchListener() {

				@Override
				public boolean onTouch(View v, MotionEvent event) {
					int inType = qianJiao.getInputType(); 
					zhongLian.setInputType(InputType.TYPE_NULL);  
					zhongLian.onTouchEvent(event); 
					zhongLian.setInputType(inType);
	                return false;   
				}                    
	        });
			zhongLian.addTextChangedListener(new TextWatcher() {
				
				@Override
				public void onTextChanged(CharSequence s, int start, int before, int count) {
					
				}
				
				@Override
				public void beforeTextChanged(CharSequence s, int start, int count,
						int after) {
					
				}
				
				@Override
				public void afterTextChanged(Editable s) {
					zhongLian.setSelection(zhongLian.getText().length());
				}
			});
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.qianJiao:
			setCurFocus(1);
			break;
		case R.id.zhongLian:
			setCurFocus(2);
			break;
		case R.id.key0:
		case R.id.key1:
		case R.id.key2:
		case R.id.key3:
		case R.id.key4:
		case R.id.key5:
		case R.id.key6:
		case R.id.key7:
		case R.id.key8:
		case R.id.key9:
			String input = ((Button)v).getText().toString();
			mCurTx.append(input);
			break;
		case R.id.keySwitch:
			setCurFocus(2);
			break;
		case R.id.keyDel:
			mCurTx.setText("");
			break;
		case R.id.reset:
			qianJiao.setText("");
			zhongLian.setText("");
			jieGuo.setText("");
			setCurFocus(1);
			break;
		case R.id.okBtn:
			String qian = qianJiao.getText().toString();
			String zhong = zhongLian.getText().toString();
			if (qian.equals("") || zhong.equals("")) {
				Toast.makeText(getApplicationContext(), "输入参数", Toast.LENGTH_SHORT).show();
			} else {
				float meiKeQian = ITools.divide(Integer.valueOf(qian), 100, 3).floatValue();
				float zhongQian = ITools.multiply(Integer.valueOf(zhong), meiKeQian).floatValue();
				int intValue = ITools.divide(zhongQian, 4.184f, 0).intValue();
				jieGuo.setText("总共有" + intValue +"卡路里");
			}
			break;
		default:
			break;
		}
		if (mCurTx == qianJiao && qianJiao.getText().length() >= 4) {
			setCurFocus(2);
		}
	}
	
	private void setCurFocus(int i) {
		if (i == 1){
			qianJiao.requestFocus();
			mCurTx = qianJiao;
		} else {
			zhongLian.requestFocus();
			mCurTx = zhongLian;
		}
	}

}
