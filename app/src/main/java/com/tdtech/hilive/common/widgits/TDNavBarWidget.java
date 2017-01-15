package com.tdtech.hilive.common.widgits;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tdtech.hilive.R;

public class TDNavBarWidget extends RelativeLayout implements  OnClickListener {

	private ImageView backView;
    private ImageView rightView;
    private TextView titleView;

    private String titleTextStr; 
    private int titleTextSize ;
    private int  titleTextColor ;
 
    private Drawable leftImage ;
    private Drawable rightImage ;
    
    public TDNavBarWidget(Context context){
        this(context, null);
    }


    public TDNavBarWidget(Context context, AttributeSet attrs) {
        this(context, attrs, R.style.AppTheme);


    }

    public TDNavBarWidget(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		getConfig(context, attrs);
        initView(context);
	}

    /**
     * 从xml中获取配置信息
     */
    private void getConfig(Context context, AttributeSet attrs) {
        //TypedArray是一个数组容器用于存放属性值
        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.Navbar);

        int count = ta.getIndexCount();
        for(int i = 0;i<count;i++)
        {
            int attr = ta.getIndex(i);
            switch (attr)
            {
            case R.styleable.Navbar_titleText:
            	titleTextStr = ta.getString(R.styleable.Navbar_titleText);
                break;
            case R.styleable.Navbar_titleColor:
                // 默认颜色设置为黑色
            	titleTextColor = ta.getColor(attr, Color.BLACK);
                break;
            case R.styleable.Navbar_titleSize:
                // 默认设置为16sp，TypeValue也可以把sp转化为px
                titleTextSize = ta.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
                break;

            case R.styleable.Navbar_leftBtn:

            	leftImage = ta.getDrawable(R.styleable.Navbar_leftBtn);
                break;
            case R.styleable.Navbar_rightBtn:
            	rightImage = ta.getDrawable(R.styleable.Navbar_rightBtn);
                break;
            }
        }

        //用完务必回收容器
        ta.recycle();
	}

    private void initView(Context context)
    {
		View layout = LayoutInflater.from(context).inflate(R.layout.widget_nav_bar,
				this,true);

        backView = (ImageView) layout.findViewById(R.id.back_image);
        titleView = (TextView) layout.findViewById(R.id.text_title);
        rightView = (ImageView) layout.findViewById(R.id.right_image);
        backView.setOnClickListener(this);
        rightView.setOnClickListener(this);

        if(null != leftImage)
        backView.setImageDrawable(leftImage);
        if(null != rightImage)
        rightView.setImageDrawable(rightImage);
        if(null != titleTextStr)
        {
        	titleView.setText(titleTextStr);
        	titleView.setTextSize(titleTextSize);
        	titleView.setTextColor(titleTextColor);
        }
    }

    public ImageView getBackView() {
        return backView;
    }

    public TextView getTitleView() {
        return titleView;
    }

    public void setTitle(String title){
        titleView.setText(title);
    }

    public ImageView getRightView() {
        return rightView;
    }

    private onTitleBarClickListener onMyClickListener;

    /**
     * 设置按钮点击监听接口
     * @param callback
     */
    public void setClickListener(onTitleBarClickListener listener) {
        this.onMyClickListener = listener;
    }

    /**
     * 导航栏点击监听接口
     */
    public static interface onTitleBarClickListener{
        void onBackClick();

        void onRightClick();
    }

	@Override
	public void onClick(View v) {
//         int id = v.getId();
//         switch(id)
//         {
//         case R.id.back_image:
//             if(null != onMyClickListener)
//             onMyClickListener.onBackClick();
//             break;
//         case R.id.right_image:
//             if(null != onMyClickListener)
//             onMyClickListener.onRightClick();
//             break;
//         }
	}
}