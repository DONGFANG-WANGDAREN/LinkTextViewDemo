package com.qiwang.linktextviewdemo;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.klinker.android.link_builder.Link;
import com.klinker.android.link_builder.LinkBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private static final String m百度网址 = "https://www.baidu.com";
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        mTv = (TextView) findViewById(R.id.tv);
        mTv.setText("点一点我旁边的与我颜色不同的进百度哦---》》》***百度网址***,点我不能进百\n度哦!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        LinkBuilder.on(mTv)
                .addLinks(getLinks())
                .build();
    }

    private List<Link> getLinks() {
        ArrayList<Link> links = new ArrayList<>();
        Link link = new Link(Pattern.compile("百度网址"));//填写需要用于跳转的文字
        link.setTextColor(Color.parseColor("#2ba543"));//文字颜色
        link.setHighlightAlpha(.8f);//用户点击时背景的颜色变化
        link.setUnderlined(false);//是否有下滑线,默认有,true : 有,false : 没有 。
        link.setOnClickListener(new Link.OnClickListener() {
            @Override
            public void onClick(String clickedText) {
                openLink(m百度网址);
            }
        });
        links.add(link);

        return links;
    }

    /**
     * 打开网址的方法哦!
     */
    private void openLink(String link) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
        startActivity(browserIntent);
    }
}
