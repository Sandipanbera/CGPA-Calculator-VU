package com.devsan.stucom;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.view.MenuInflater;
import android.app.Activity;
import android.content.Intent;

//DevSan
//Sandipan Bera

public class MainActivity extends Activity
{
	TextView count,cgres;
	EditText s1,s2,s3,s;
	float cred_sgpa,cgpa,percentage;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		
        setContentView(R.layout.main);
		
		//Get the default actionbar instance
		ActionBar mActionBar = getActionBar();
		mActionBar.setDisplayShowHomeEnabled(false);
		mActionBar.setDisplayShowTitleEnabled(false);

//Initializes the custom action bar layout
		LayoutInflater mInflater = LayoutInflater.from(this);
		View mCustomView = mInflater.inflate(R.layout.actionbar, null);
		mActionBar.setCustomView(mCustomView);
		mActionBar.setDisplayShowCustomEnabled(true);
		
		final Button reset = (Button) findViewById(R.id.resetbutt);
		reset.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					if (v==reset) {
						startActivity(new Intent(MainActivity.this, MainActivity.class));
					}
				}
			});

//Detect the button click event of the home button in the actionbar
		Button btnHome = (Button) findViewById(R.id.cgpa_butt);
		btnHome.setOnClickListener(new View.OnClickListener() {

				public void onClick(View v)  
				{  
					try
					{
						s1 = (EditText)findViewById(R.id.sgpa1); 
						s2 = (EditText)findViewById(R.id.sgpa2);		
						s3 = (EditText)findViewById(R.id.sgpa3);		
						EditText s4 = (EditText)findViewById(R.id.sgpa4);		
						EditText s5 = (EditText)findViewById(R.id.sgpa5);		
						EditText s6 = (EditText)findViewById(R.id.sgpa6);

						EditText c1 = (EditText)findViewById(R.id.crdt1);
						EditText c2 = (EditText)findViewById(R.id.crdt2);
						EditText c3 = (EditText)findViewById(R.id.crdt3);
						EditText c4 = (EditText)findViewById(R.id.crdt4);
						EditText c5 = (EditText)findViewById(R.id.crdt5);	
						EditText c6 = (EditText)findViewById(R.id.crdt6);

						float sgnum1 = Float.parseFloat(s1.getText().toString());
						float sgnum2 = Float.parseFloat(s2.getText().toString());
						float sgnum3 = Float.parseFloat(s3.getText().toString());
						float sgnum4 = Float.parseFloat(s4.getText().toString());
						float sgnum5 = Float.parseFloat(s5.getText().toString());
						float sgnum6 = Float.parseFloat(s6.getText().toString());

						int cnum1 = Integer.parseInt(c1.getText().toString());
						int cnum2 = Integer.parseInt(c2.getText().toString());
						int cnum3 = Integer.parseInt(c3.getText().toString());
						int cnum4 = Integer.parseInt(c4.getText().toString());
						int cnum5 = Integer.parseInt(c5.getText().toString());
						int cnum6 = Integer.parseInt(c6.getText().toString());
						
						int credit_sums = (cnum1+cnum2+cnum3+cnum4+cnum5+cnum6);
						float cred_sgpa = ((cnum1 * sgnum1) + (cnum2 * sgnum2) + (cnum3 * sgnum3) + (cnum4 * sgnum4) + (cnum5 * sgnum5) + (cnum6 * sgnum6));
                        float cgpa =(float) (cred_sgpa / credit_sums);
						
						String cgpa_string = String.format("%.2f", cgpa);
						float cgpa_float = Float.parseFloat(cgpa_string);
						
						float percentage =(float) (cgpa_float *10);
						String per_string = Float.toString(percentage);          
						
					    TextView cgres=(TextView)findViewById(R.id.cgpa_view);
						cgres.setText(cgpa_string);
						
						TextView cgpers=(TextView)findViewById(R.id.pers_view);
						cgpers.setText(per_string+"%");
					}
					catch(Exception e)  
					{  
						/* TextView cgres=(TextView)findViewById(R.id.cgpa_view);
						cgres.setText(""+cgpa);*/
						Toast.makeText(MainActivity.this, 
					    "ERROR!!Enter Data", Toast.LENGTH_LONG).show();
					}  
				}  
			});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) { switch(item.getItemId()) {
				
			case R.id.hiw:
				Intent intent_hiw=new Intent(MainActivity.this,HowIt.class);
				startActivity(intent_hiw);
				return true;

			case R.id.about:
				Intent intent=new Intent(MainActivity.this,About.class);
				startActivity(intent);
				return true;
				
			case R.id.exit:
				finish();
				return(true);

		}
		return(super.onOptionsItemSelected(item));
	}}
