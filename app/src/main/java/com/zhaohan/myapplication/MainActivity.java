package com.zhaohan.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1.获取控件
        LinearLayout boxView = findViewById(R.id.box);
        //2.生成模拟数据
        List<Bean> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Bean bean = new Bean();
            bean.setName("TNT" + i);
            switch (i % 10) {
                case 0:
                    bean.setColor("#ffbd21");
                    break;
                case 1:
                    bean.setColor("#99cc00");
                    break;
                case 2:
                    bean.setColor("#ff002a");
                    break;
                case 3:
                    bean.setColor("#57C5E8");
                    break;
                case 4:
                    bean.setColor("#B0B0B0");
                    break;
                case 5:
                    bean.setColor("#59B29C");
                    break;
                case 6:
                    bean.setColor("#ff6b29");
                    break;
                case 7:
                    bean.setColor("#00a0e9");
                    break;
                case 8:
                    bean.setColor("#f0f66e");
                    break;
                case 9:
                    bean.setColor("#FFA4A9");
                    break;
            }
            list.add(bean);
        }
        //3.根据数据生成界面
        final List<RecyclerView> syncRecyclerViews = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            RecyclerView syncRecyclerView = new RecyclerView(this);
            Adapter adapter = new Adapter(list);
            LinearLayoutManager ms = new LinearLayoutManager(this);
            ms.setOrientation(LinearLayoutManager.HORIZONTAL);
            syncRecyclerView.setLayoutManager(ms);
            syncRecyclerView.setAdapter(adapter);
            syncRecyclerViews.add(syncRecyclerView);
            syncRecyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);//取消边缘波浪样式
            boxView.addView(syncRecyclerView);
            //添加监听，使所有的RecyclerView保持同步
            RecyclerView.OnScrollListener listener = new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    for (RecyclerView item : syncRecyclerViews) {
                        if (recyclerView == item) {
                            continue;
                        }
                        item.clearOnScrollListeners();
                        item.scrollBy(dx, dy);
                        item.addOnScrollListener(this);
                    }
                }
            };
            syncRecyclerView.addOnScrollListener(listener);
        }
    }
}