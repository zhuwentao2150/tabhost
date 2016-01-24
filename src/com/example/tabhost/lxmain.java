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
		tabhost.setup();	//�õ�TabWidget��FrameLayout
		
		TabSpec tabSpec = tabhost.newTabSpec("page11");	// ����ID�ҵ�ҳ��
		tabSpec.setIndicator(createView("����"));
		tabSpec.setContent(R.id.page11);
		tabhost.addTab(tabSpec);
		
		tabSpec = tabhost.newTabSpec("page22");	// ����ID�ҵ�ҳ��
		tabSpec.setIndicator(createView("İ����"));
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
