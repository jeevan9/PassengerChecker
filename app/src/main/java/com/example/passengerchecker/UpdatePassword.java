package com.example.passengerchecker;

/**
 * Created by jeevansai on 05/10/2016.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.widget.Toast;

public class UpdatePassword extends AsyncTask<String, Void , String>{
    private Context context;
    ProgressDialog loading;

    public UpdatePassword(Context cxt) {
        // TODO Auto-generated constructor stub
        context=cxt;
    }


    private static final String REGISTER_URL="http://jeevan123.net46.net/login/changepassword.php";


    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub
        super.onPreExecute();
        loading=ProgressDialog.show(context,"Please Wait","Loading",true,true);

    }
    @Override
    protected String doInBackground(String... arg0) {
        // TODO Auto-generated method stub
        String s = arg0[0];
        String result = null;
        BufferedReader br = null;
        try {
            URL url = new URL(REGISTER_URL + s);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            result = br.readLine();
            return result;

        } catch (Exception e) {
            return e.toString();
        }

    }

    protected void onProgressUpdate(Void... values) {
        // TODO Auto-generated method stub
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        // TODO Auto-generated method stub
        super.onPostExecute(result);
        loading.dismiss();
        Toast.makeText(context,result,Toast.LENGTH_LONG).show();

    }
}
