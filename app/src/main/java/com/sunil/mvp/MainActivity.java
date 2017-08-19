package com.sunil.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sunil.mvp.ui.KickStarterList.KickStarterListFragment;
import com.sunil.mvp.util.ActivityUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null){
            // create the fragment here
            ActivityUtil.addFragmentToActivity(getFragmentManager(), KickStarterListFragment.newInstance(), R.id.frame_content, "KickStarterListFragment");
        }

    }
}
