package com.devsan.stucom;
import android.app.*;
import android.os.*;
import android.widget.*;
import com.devsan.stucom.BuildConfig;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class HowIt extends Activity 
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workmethod);
		
		TextView textView = findViewById(R.id.vu_link);
		textView.setMovementMethod(LinkMovementMethod.getInstance());
	}
	
	
}
