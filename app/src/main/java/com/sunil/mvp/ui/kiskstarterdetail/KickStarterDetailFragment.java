package com.sunil.mvp.ui.kiskstarterdetail;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.sunil.mvp.MainApplication;
import com.sunil.mvp.R;
import com.sunil.mvp.db.model.KickStarter;
import com.sunil.mvp.db.source.KickStarterLocalSource;
import com.sunil.mvp.di.component.ApplicationComponent;
import com.sunil.mvp.di.component.DaggerKickStarterDetailComponent;
import com.sunil.mvp.di.component.DaggerKickStarterListComponent;
import com.sunil.mvp.di.component.KickStarterDetailComponent;
import com.sunil.mvp.di.component.KickStarterListComponent;
import com.sunil.mvp.di.module.KickStarterDetailModule;
import com.sunil.mvp.di.module.KickStarterListModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sunil on 19-08-2017.
 */

public class KickStarterDetailFragment extends Fragment implements KickStarterDetailContract.View {

    public static final String Tag = KickStarterDetailFragment.class.getSimpleName();

    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.pledgedvalue)
    TextView pledgedvalue;
    @BindView(R.id.backers_value)
    TextView backersValue;
    @BindView(R.id.relative)
    RelativeLayout relative;
    @BindView(R.id.main_content)
    CoordinatorLayout mainContent;
    @BindView(R.id.title)
    TextView titleText;
    @BindView(R.id.backers)
    TextView backers;
    @BindView(R.id.backdrop)
    ImageView backdrop;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;

    private String url;
    private String title;

    @Inject
    KickStarterDetailContract.Presenter mPresenter;

    public static KickStarterDetailFragment newInstance(int s_no) {
        KickStarterDetailFragment kickStarterDetailFragment = new KickStarterDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("s_no", s_no);
        kickStarterDetailFragment.setArguments(bundle);
        return kickStarterDetailFragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unSubscribe();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // do things if you want to create only first time when activity created.
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependency();
        mPresenter.attachView(this);
    }

    private void injectDependency() {
        ApplicationComponent applicationComponent = ((MainApplication) getActivity().getApplication()).getApplicationComponent();
        KickStarterDetailComponent kickStarterDetailComponent = DaggerKickStarterDetailComponent.builder()
                .applicationComponent(applicationComponent)
                .kickStarterDetailModule(new KickStarterDetailModule())
                .build();
        kickStarterDetailComponent.inject(this);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_kickstarter_detail, container, false);
        ButterKnife.bind(this, root);

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        collapsingToolbar.setTitle(title);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            int s_n0 = bundle.getInt("s_no");
            mPresenter.loadDetailKickStarter(s_n0);
        }

        return root;
    }

    @Override
    public void onKickStartersOk(KickStarter kickStarter) {
        url = kickStarter.getUrl();
        title = kickStarter.getTitle();
        pledgedvalue.setText(kickStarter.getAmt_pledged());
        backersValue.setText(kickStarter.getNum_backers());
        titleText.setText(title);

        loadBackdrop();
    }

    @Override
    public void showLoadErrorMessage(String errorMsg) {
        Toast.makeText(getActivity(), "Error "+ errorMsg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showEmptyView(boolean isShow) {

    }

    private void loadBackdrop() {
        if (url != null && !url.isEmpty()) {
            Picasso.with(getActivity())
                    .load("https://www.kickstarter.com/" + url)
                    .placeholder(R.drawable.code)
                    .error(R.drawable.code)
                    .into(backdrop);
            //Glide.with(this).load("https://www.kickstarter.com/" + url).into(imageView).onLoadFailed(getDrawable(R.drawable.code));
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
