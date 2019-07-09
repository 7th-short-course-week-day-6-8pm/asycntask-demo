package com.rathana.asksyntaskdemo.utils;

import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

import com.rathana.asksyntaskdemo.R;

public class ProgressAsyncTask extends AsyncTask<Object,Integer,Boolean> {

    private Context context;
    private ProgressBar progressBar;
    private Dialog dialog;

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public ProgressAsyncTask(Context context) {
        this.context = context;
        dialog=createDialog();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog.show();
    }

    @Override
    protected Boolean doInBackground(Object ... args) {
        try{
            for (int i=0;i<100;i++){
                publishProgress(i);
                Thread.sleep(100);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        progressBar.setProgress(values[0]);
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        dialog.hide();
        this.cancel(true);
    }

    private Dialog createDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setTitle("Downloading...");
        View view= LayoutInflater.from(context).
                inflate(
                    R.layout.progress_dialog_layout
                    ,null );

        progressBar=view.findViewById(R.id.progressBar);
        progressBar.setMax(100);
        //progressBar.setProgress(50);
        builder.setView(view);
        return builder.create();
    }

}
