package com.sunil.mvp.ui.kiskstarterdetail;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.sunil.mvp.R;
import com.sunil.mvp.db.model.KickStarter;
import com.sunil.mvp.db.source.KickStarterLocalSource;
import com.sunil.mvp.ui.KickStarterList.KickStarterListFragment;
import com.sunil.mvp.util.ActivityUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Created by sunil on 12-08-2017.
 */

public class KickStarterDetailActivity extends AppCompatActivity {

    private int s_n0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kickstarter_detail);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
             s_n0 = bundle.getInt("s_n0");
        }

        if (savedInstanceState == null){
            // create the fragment here
            ActivityUtil.addFragmentToActivity(getFragmentManager(), KickStarterDetailFragment.newInstance(s_n0), R.id.frame_content_detail, "KickStarterDetailFragment");
        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
