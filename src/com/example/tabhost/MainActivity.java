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
		tabHost.setup(); // �ҵ��ڲ���TabWidget��FrameLayout�����еĿؼ�id����android�Ѿ�������˵�
		
		TabSpec tabSpec = tabHost.newTabSpec("page1");	// ���ݱ�ʶ�ҵ���ǩҳ
		tabSpec.setIndicator("��ҳ", getResources().getDrawable(R.drawable.ic_launcher));
		/*tabSpec.setIndicator(createTabView("��ҳ"));*/
		tabSpec.setContent(R.id.page1);	// ����ҳ���ID�ҵ���Ӧ��ҳ��
		tabHost.addTab(tabSpec);
		
		tabSpec = tabHost.newTabSpec("page2");	// ���ݱ�ʶ�ҵ���ǩҳ
		tabSpec.setIndicator("�ڶ�ҳ", getResources().getDrawable(R.drawable.mainwenzhang));
		/*tabSpec.setIndicator(createTabView("����"));*/
		tabSpec.setContent(R.id.page2);	// ���ñ�ǩ��Ӧ�Ľ�������
		tabHost.addTab(tabSpec);
		
		tabSpec = tabHost.newTabSpec("page3");	// ���ݱ�ʶ�ҵ���ǩҳ
		tabSpec.setIndicator("����ҳ", getResources().getDrawable(R.drawable.mainxiewz));
		/*tabSpec.setIndicator(createTabView("ר��"));*/
		tabSpec.setContent(R.id.page3);
		tabHost.addTab(tabSpec);
		
		tabHost.setCurrentTab(0);	// ѡ�����ʼͣ����ҳ�棬��д��Ĭ���ڵ�һ��ҳ�棬��ֵ����ҳ����ʱ�����ᱨ����Ĭ����ʾ��һ��ҳ��
	}
	private View createTabView(String name) {
		View tabView = getLayoutInflater().inflate(R.layout.tab, null);
		TextView textView = (TextView) tabView.findViewById(R.id.name);
		textView.setText(name);
		return tabView;
	}


}
