package com.vuabocphet.jav123vn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.GridView;
import android.widget.Toast;

import com.vuabocphet.jav123vn.adapter.GirdAdapter;
import com.vuabocphet.jav123vn.listen.Load;
import com.vuabocphet.jav123vn.model.JAV;
import com.vuabocphet.jav123vn.tanks.DownloadTask;
import com.vuabocphet.jav123vn.tanks.DownloadTaskVideo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Load {
    private GirdAdapter girdAdapter;
    private GridView gridView;
    private List<JAV> javList;
    private static String URL_BD = "http://jav321.net/jav-hd/phim-sex-ko-che/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.girdview);
        javList = new ArrayList<>();
        girdAdapter = new GirdAdapter( this, getwidth());
        gridView.setAdapter(girdAdapter);
        girdAdapter.setClickItems(new GirdAdapter.ClickItems() {
            @Override
            public void clickItesm(String url) {
                new DownloadTaskVideo(MainActivity.this).execute(url);
            }
        });
         new DownloadTask(MainActivity.this).execute(URL_BD);
    }

    private int getwidth() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.widthPixels;
    }

    @Override
    public void Success(List<JAV> javList) {
        javList.addAll(javList);;
        girdAdapter.setList(javList);
    }

    @Override
    public void Failure() {
        Toast.makeText(this, "Lỗi", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void SuccessLoadingVideo(String path) {
        Intent intent=new Intent(this,PlayVideo.class);
        intent.putExtra("path",path);
        startActivity(intent);

    }

    @Override
    public void FailureVideo() {

    }
}
