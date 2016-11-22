package com.twac.tab_demo1;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.app.Activity;

public class MainActivity extends Activity implements OnClickListener {
	// ViewPager
	private ViewPager mViewPager;
	private PagerAdapter mAdapter;
	private List<View> viewList = new ArrayList<View>();

	// Tab
	private LinearLayout mLinearLayout1;
	private LinearLayout mLinearLayout2;
	private LinearLayout mLinearLayout3;
	private LinearLayout mLinearLayout4;
	// ImageButton
	private ImageButton mImageButton1;
	private ImageButton mImageButton2;
	private ImageButton mImageButton3;
	private ImageButton mImageButton4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		initView();
		initEvent();

	}

	private void initEvent() {
		mLinearLayout1.setOnClickListener(this);
		mLinearLayout2.setOnClickListener(this);
		mLinearLayout3.setOnClickListener(this);
		mLinearLayout4.setOnClickListener(this);

		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				int currentItem = mViewPager.getCurrentItem();
				resetImg();
				switch (currentItem) {
				case 0:
					mImageButton1
							.setImageResource(R.drawable.tab_weixin_pressed);
					break;
				case 1:
					mImageButton2
							.setImageResource(R.drawable.tab_find_frd_pressed);
					break;
				case 2:
					mImageButton3
							.setImageResource(R.drawable.tab_address_pressed);
					break;
				case 3:
					mImageButton4
							.setImageResource(R.drawable.tab_settings_pressed);
					break;

				default:
					break;
				}

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});

	}

	private void initView() {
		mViewPager = (ViewPager) findViewById(R.id.viewPager);
		mLinearLayout1 = (LinearLayout) findViewById(R.id.bottom_layout_1);
		mLinearLayout2 = (LinearLayout) findViewById(R.id.bottom_layout_2);
		mLinearLayout3 = (LinearLayout) findViewById(R.id.bottom_layout_3);
		mLinearLayout4 = (LinearLayout) findViewById(R.id.bottom_layout_4);
		mImageButton1 = (ImageButton) findViewById(R.id.img_button1);
		mImageButton2 = (ImageButton) findViewById(R.id.img_button2);
		mImageButton3 = (ImageButton) findViewById(R.id.img_button3);
		mImageButton4 = (ImageButton) findViewById(R.id.img_button4);

		LayoutInflater mInflater = LayoutInflater.from(this);
		View view1 = mInflater.inflate(R.layout.view1, null);
		View view2 = mInflater.inflate(R.layout.view2, null);
		View view3 = mInflater.inflate(R.layout.view3, null);
		View view4 = mInflater.inflate(R.layout.view4, null);

		viewList.add(view1);
		viewList.add(view2);
		viewList.add(view3);
		viewList.add(view4);

		mAdapter = new PagerAdapter() {
			@Override
			public void destroyItem(ViewGroup container, int position,
					Object object) {

				container.removeView(viewList.get(position));
			}

			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				View view = viewList.get(position);
				container.addView(view);
				return view;
			}

			@Override
			public boolean isViewFromObject(View view, Object object) {

				return view == object;
			}

			@Override
			public int getCount() {

				return viewList.size();
			}
		};

		mViewPager.setAdapter(mAdapter);
	}

	@Override
	public void onClick(View v) {

		resetImg();
		switch (v.getId()) {
		case R.id.bottom_layout_1:
			mImageButton1.setImageResource(R.drawable.tab_weixin_pressed);
			mViewPager.setCurrentItem(0);
			break;
		case R.id.bottom_layout_2:
			mImageButton1.setImageResource(R.drawable.tab_find_frd_pressed);
			mViewPager.setCurrentItem(1);
			break;
		case R.id.bottom_layout_3:
			mImageButton1.setImageResource(R.drawable.tab_address_pressed);
			mViewPager.setCurrentItem(2);
			break;
		case R.id.bottom_layout_4:
			mImageButton1.setImageResource(R.drawable.tab_settings_pressed);
			mViewPager.setCurrentItem(3);
			break;

		default:
			break;
		}
	}

	private void resetImg() {
		mImageButton1.setImageResource(R.drawable.tab_weixin_normal);
		mImageButton2.setImageResource(R.drawable.tab_find_frd_normal);
		mImageButton3.setImageResource(R.drawable.tab_address_normal);
		mImageButton4.setImageResource(R.drawable.tab_settings_normal);

	}

}
