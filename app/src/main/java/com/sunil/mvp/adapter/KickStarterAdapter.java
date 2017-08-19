package com.sunil.mvp.adapter;

import android.app.Fragment;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sunil.mvp.R;
import com.sunil.mvp.db.model.KickStarter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sunil on 12-08-2017.
 */

public class KickStarterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<KickStarter> itemModels;
    private Context context;
    private onItemClickListener listener;

    public KickStarterAdapter(Context context, List<KickStarter> kickStarters, Fragment fragment) {
        this.itemModels = kickStarters;
        this.context = context;
        this.listener = (onItemClickListener) fragment;
    }

    @Override
    public int getItemCount() {
        return itemModels.size();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        KickStarter model = itemModels.get(position);
        initializeViews(model, holder, position);
    }


    private void initializeViews(final KickStarter model, final RecyclerView.ViewHolder holder, final int position) {
        ((ItemViewHolder)holder).title.setText(model.getTitle());
        ((ItemViewHolder)holder).pledgedvalue.setText(model.getAmt_pledged());
        ((ItemViewHolder)holder).backers_value.setText(model.getNum_backers());
        ((ItemViewHolder)holder).relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.itemDetailClick(position+1);
            }
        });
    }


    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.pledgedvalue)
        TextView pledgedvalue;
        @BindView(R.id.backers_value)
        TextView backers_value;
        @BindView(R.id.relative)
        RelativeLayout relativeLayout;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface onItemClickListener{
        public void itemDetailClick(int position);
    }

    public void setSearchResult(List<KickStarter> result) {
        itemModels = result;
        notifyDataSetChanged();
    }
}
