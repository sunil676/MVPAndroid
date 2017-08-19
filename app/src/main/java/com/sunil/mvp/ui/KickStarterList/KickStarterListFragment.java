package com.sunil.mvp.ui.KickStarterList;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.sunil.mvp.MainApplication;
import com.sunil.mvp.R;
import com.sunil.mvp.adapter.KickStarterAdapter;
import com.sunil.mvp.db.model.KickStarter;
import com.sunil.mvp.di.component.ApplicationComponent;
import com.sunil.mvp.di.component.DaggerKickStarterListComponent;
import com.sunil.mvp.di.component.KickStarterListComponent;
import com.sunil.mvp.di.module.KickStarterListModule;
import com.sunil.mvp.ui.kiskstarterdetail.KickStarterDetailActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.disposables.Disposable;

/**
 * Created by sunil on 12-08-2017.
 */

public class KickStarterListFragment extends Fragment implements KickStarterListContract.View, KickStarterAdapter.onItemClickListener {

    public static final String Tag = KickStarterListFragment.class.getSimpleName();
    private static final int MIN_LENGTH = 2;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.search_input)
    EditText searchInput;
    @BindView(R.id.relative_sort)
    RelativeLayout relativeSort;
    @BindView(R.id.relative_filter)
    RelativeLayout relativeFilter;

    @Inject
    KickStarterListContract.Presenter mPresenter;

    private Disposable searchSubscription;
    private KickStarterAdapter articleAdapter;
    private List<KickStarter> mList;

    public static KickStarterListFragment newInstance() {
        return new KickStarterListFragment();
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
        KickStarterListComponent kickStarterListComponent = DaggerKickStarterListComponent.builder()
                .applicationComponent(applicationComponent)
                .kickStarterListModule(new KickStarterListModule())
                .build();
        kickStarterListComponent.inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_load_kickstarter, container, false);
        ButterKnife.bind(this, root);
       // mPresenter = new KickStarterListPresenter(new KickStarterLocalSource(), this);
        if (mPresenter != null) {
            if (mPresenter.getCountDb() > 0) {
                mPresenter.loadKickStarterDb();
            } else {
                mPresenter.loadKickStartersAPI();
            }
        }
        searchByName();

        return root;
    }

    @OnClick(R.id.relative_sort)
    public void sortClick(){
        List<KickStarter> list = mList;
        Collections.sort(list, new Comparator<KickStarter>() {
            @Override
            public int compare(KickStarter o1, KickStarter o2) {
                return o1.getTitle().compareToIgnoreCase(o2.getTitle());
            }
        });
        mList = list;
        articleAdapter.setSearchResult(mList);
    }

    @OnClick(R.id.relative_filter)
    public void fliterClick(){
       Toast.makeText(getActivity(), "OnProgress", Toast.LENGTH_LONG).show();
    }

    private void searchByName() {
        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {

                // filter your list from your input
                // filter(s.toString());
                //you can use runnable postDelayed like 500 ms to delay search text
                if (s != null && s.toString().length() > MIN_LENGTH) {
                    List<KickStarter> temp = new ArrayList<>();
                    for (KickStarter kickStarter : mList) {
                        //or use .equal(text) with you want equal match
                        //use .toLowerCase() for better matches
                        if (kickStarter.getTitle().toLowerCase().contains(s.toString().toLowerCase())) {
                            temp.add(kickStarter);
                        }
                    }
                    Collections.sort(temp, new Comparator<KickStarter>() {
                        @Override
                        public int compare(KickStarter o1, KickStarter o2) {
                            return o1.getTitle().compareToIgnoreCase(o2.getTitle());
                        }
                    });
                    mList = temp;
                    articleAdapter.setSearchResult(temp);
                }
            }
        });

    }


    @Override
    public void onKickStartersOk(List<KickStarter> kickStarters) {
        mList = kickStarters;
        articleAdapter = new KickStarterAdapter(getActivity(), mList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(articleAdapter);

        /*recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                KickStarter kickStarter = kickStarters.get(position);
                Intent intent = new Intent(getActivity(), KickStarterDetailActivity.class);
                intent.putExtra("s_n0", Integer.valueOf(kickStarter.getS_no()));
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                // ...
            }
        }));*/
    }

    @Override
    public void showProgress(boolean show) {

    }

    @Override
    public void showLoadErrorMessage(String errorMsg) {
        Toast.makeText(getActivity(), errorMsg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showEmptyView(boolean isShow) {

    }

    @Override
    public void itemDetailClick(int position) {
        // call detail activity
        KickStarter kickStarter = mList.get(position);
        int s_no = Integer.valueOf(kickStarter.getS_no());
        Intent intent = new Intent(getActivity(), KickStarterDetailActivity.class);
        intent.putExtra("s_n0", s_no);
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
