package com.darshan.tablayoutissue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.clevertap.android.sdk.CTInboxListener;
import com.clevertap.android.sdk.CTInboxStyleConfig;
import com.clevertap.android.sdk.CleverTapAPI;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CTInboxListener {

    Button inbox;
    CleverTapAPI cleverTapAPI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inbox = findViewById(R.id.inboxButton);
        CleverTapAPI.setDebugLevel(3);
        cleverTapAPI = CleverTapAPI.getDefaultInstance(getApplicationContext());
        cleverTapAPI.setCTNotificationInboxListener(this);
        cleverTapAPI.initializeInbox();
    }

    @Override
    public void inboxDidInitialize() {
        inbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> tabs = new ArrayList<>();
                tabs.add("Promotions");
                tabs.add("Offers");
                tabs.add("Others");//Anything after the first 2 will be ignored
                CTInboxStyleConfig styleConfig = new CTInboxStyleConfig();
                styleConfig.setTabs(tabs);//Do not use this if you don't want to use tabs
//                styleConfig.setTabBackgroundColor("#FF0000");
//                styleConfig.setSelectedTabIndicatorColor("#0000FF");
//                styleConfig.setSelectedTabColor("#000000");
//                styleConfig.setUnselectedTabColor("#FFFFFF");
//                styleConfig.setBackButtonColor("#FF0000");
//                styleConfig.setNavBarTitleColor("#FF0000");
//                styleConfig.setNavBarTitle("MY INBOX");
//                styleConfig.setNavBarColor("#FFFFFF");
//                styleConfig.setInboxBackgroundColor("#00FF00");
                cleverTapAPI.showAppInbox(styleConfig); //With Tabs
                //ct.showAppInbox();//Opens Activity with default style configs
            }
        });
    }

    @Override
    public void inboxMessagesDidUpdate() {

    }
}
