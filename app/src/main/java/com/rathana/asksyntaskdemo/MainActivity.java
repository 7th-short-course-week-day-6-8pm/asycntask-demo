package com.rathana.asksyntaskdemo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.rathana.asksyntaskdemo.utils.ProgressAsyncTask;

public class MainActivity extends AppCompatActivity {

    AsyncTask progressAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onDownloadFile(View view){
        progressAsyncTask= new ProgressAsyncTask(this);
        progressAsyncTask.execute("args","args");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        progressAsyncTask=null;
    }
}
