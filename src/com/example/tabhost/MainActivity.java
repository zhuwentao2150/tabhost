package com.example.tabhost;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TabHost tabHost;
	private Button button;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button button = (Button) findViewById(R.id.otherbutton);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, lxmain.class);
				startActivity(intent);
			}
		});
		
		tabHost = (TabHost) this.findViewById(R.id.tabhost);
		tabHost.setup(); // 找到内部的TabWidget和FrameLayout，其中的控件id是由android已经定义好了的
		
		TabSpec tabSpec = tabHost.newTabSpec("page1");	// 根据标识找到标签页
		tabSpec.setIndicator("首页", getResources().getDrawable(R.drawable.ic_launcher));
		/*tabSpec.setIndicator(createTabView("首页"));*/
		tabSpec.setContent(R.id.page1);	// 根据页面的ID找到相应的页面
		tabHost.addTab(tabSpec);
		
		tabSpec = tabHost.newTabSpec("page2");	// 根据标识找到标签页
		tabSpec.setIndicator("第二页", getResources().getDrawable(R.drawable.mainwenzhang));
		/*tabSpec.setIndicator(createTabView("分类"));*/
		tabSpec.setContent(R.id.page2);	// 设置标签对应的界面内容
		tabHost.addTab(tabSpec);
		
		tabSpec = tabHost.newTabSpec("page3");	// 根据标识找到标签页
		tabSpec.setIndicator("第三页", getResources().getDrawable(R.drawable.mainxiewz));
		/*tabSpec.setIndicator(createTabView("专栏"));*/
		tabSpec.setContent(R.id.page3);
		tabHost.addTab(tabSpec);
		
		tabHost.setCurrentTab(0);	// 选择项初始停留的页面，不写则默认在第一个页面，数值超过页面数时并不会报错，会默认显示第一个页面
	}
	private View createTabView(String name) {
		View tabView = getLayoutInflater().inflate(R.layout.tab, null);
		TextView textView = (TextView) tabView.findViewById(R.id.name);
		textView.setText(name);
		return tabView;
	}


}
