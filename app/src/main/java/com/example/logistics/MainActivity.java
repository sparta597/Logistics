package com.example.logistics;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView topBar;
    private TextView tapMy;
    private TextView tapOrder;
    private TextView tapMain;

    private FrameLayout ly_content;
    private MainFragment f1;
    private MyFragment f2;
    private OrderFragment f3;
    private FragmentManager fragmentManager;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        bindView();
    }

    /**
     * UI组件初始化与事件绑定
     */
    private void bindView(){
        topBar = (TextView)this.findViewById(R.id.txt_top);
        tapMy = (TextView)this.findViewById(R.id.tv_my);
        tapOrder = (TextView)this.findViewById(R.id.tv_order);
        tapMain = (TextView)this.findViewById(R.id.tv_main);
        ly_content = (FrameLayout) findViewById(R.id.fragment_container);

        tapMy.setOnClickListener(this);
        tapOrder.setOnClickListener(this);
        tapMain.setOnClickListener(this);
    }

    /**
     * 重置所有文本的选中状态
     */
    public void selected(){
        tapMain.setSelected(false);
        tapMy.setSelected(false);
        tapOrder.setSelected(false);
    }

    /**
     * 隐藏所有Fragment
     */
    public void hideAllFragment(FragmentTransaction transaction){
        if (f1 != null){
            transaction.hide(f1);
        }
        if (f2 != null){
            transaction.hide(f2);
        }
        if (f3 != null){
            transaction.hide(f3);
        }
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideAllFragment(transaction);
        switch (view.getId()) {
            case R.id.tv_main:
                selected();
                tapMain.setSelected(true);
                if (f1 == null){
                    f1 = new MainFragment("主界面");
                    transaction.add(R.id.fragment_container,f1);
                }else{
                    transaction.show(f1);
                }
                break;
            case R.id.tv_my:
                selected();
                tapMy.setSelected(true);
                if (f2 == null){
                    f2 = new MyFragment();
                    transaction.add(R.id.fragment_container,f2);
                }else{
                    transaction.show(f2);
                }
                break;
            case R.id.tv_order:
                selected();
                tapOrder.setSelected(true);
                if (f3 == null){
                    f3 = new OrderFragment();
                    transaction.add(R.id.fragment_container,f3);
                }else{
                    transaction.show(f3);
                }
                break;
        }
        transaction.commit();
    }
}
