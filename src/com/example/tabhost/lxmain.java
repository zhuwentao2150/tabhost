package com.example.tabhost;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class lxmain extends Activity {
	private TabHost tabhost;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lxmainlayout);
		
		tabhost = (TabHost) findViewById(R.id.tabhostother);
		tabhost.setup();	//得到TabWidget和FrameLayout
		
		TabSpec tabSpec = tabhost.newTabSpec("page11");	// 根据ID找到页面
		tabSpec.setIndicator(createView("好友"));
		tabSpec.setContent(R.id.page11);
		tabhost.addTab(tabSpec);
		
		tabSpec = tabhost.newTabSpec("page22");	// 根据ID找到页面
		tabSpec.setIndicator(createView("陌生人"));
		tabSpec.setContent(R.id.page22);
		tabhost.addTab(tabSpec);
		
		tabhost.setCurrentTab(0);
	}
	private View createView(String name) {
		View view = getLayoutInflater().inflate(R.layout.lx, null);
		TextView textview = (TextView) view.findViewById(R.id.othertext);
		textview.setText(name);
		return view;
	}
}
