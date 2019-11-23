package com.vuabocphet.jav123vn.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;
import com.vuabocphet.jav123vn.R;
import com.vuabocphet.jav123vn.model.JAV;

import java.util.List;

public class GirdAdapter extends BaseAdapter {
    private List<JAV> list;
    private Context context;
    private int wid;
    boolean isLoading = true;
    public static final int LOADING = 2;
    public static final int VIEW = 1;

    public ClickItems clickItems;

    public List<JAV> getList() {
        return list;
    }

    public void setList(List<JAV> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void setClickItems(GirdAdapter.ClickItems clickItems) {
        this.clickItems = clickItems;
    }


    public GirdAdapter(Context context, int wid) {
        this.context = context;
        this.wid = wid;
    }

    @Override
    public int getCount() {

        if (list==null) {
            return 0;
        }
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View view1;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_girdview, viewGroup, false);
            view1 = view;
        } else {
            view1 = view;
        }

        ImageView imageView = view1.findViewById(R.id.img);
        TextView title = view1.findViewById(R.id.txt);
        TextView views = view1.findViewById(R.id.view);
        title.setText(list.get(i).getTitle());
        views.setText("Lượt xem:"+list.get(i).getView());

        final ProgressBar progressBar = view1.findViewById(R.id.spin_kit);


        Picasso.get().load(list.get(i).getUrlimg()).fit().transform(boderIMG(0, 5))
                .centerCrop().error(R.drawable.ic_launcher_background).into(imageView, new Callback() {
            @Override
            public void onSuccess() {
                //code loading
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError(Exception e) {

            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickItems.clickItesm(list.get(i).getLinks());
            }
        });
        return view;
    }

    @Override
    public int getItemViewType(int position) {
        if (isLoading) {
            if (position == list.size() - 1)

                return LOADING;

            else return VIEW;
        } else
            return VIEW;
    }

    private Transformation boderIMG(int boderW, int boderConer) {
        return new RoundedTransformationBuilder()
                .borderColor(Color.BLACK)
                .borderWidthDp(boderW)
                .cornerRadiusDp(boderConer)
                .oval(false)
                .build();

    }

    public interface ClickItems {
        void clickItesm(String url);
    }
}
