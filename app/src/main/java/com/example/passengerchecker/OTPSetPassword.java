package com.example.passengerchecker;

/**
 * Created by jeevansai on 30/10/2016.
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

public class OTPSetPassword extends AsyncTask<String, Void , String>{
    private Context context;
    ProgressDialog loading;

    public OTPSetPassword(Context cxt) {
        // TODO Auto-generated constructor stub
        context=cxt;
    }


    private static final String REGISTER_URL="http://jeevan123.net46.net/login/otp.php";


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
        String newp=arg0[1];
        String realotp=arg0[2];
        String enteredotp=arg0[3];
        String result="Please enter Correct OTP";
        if(realotp.equals(enteredotp)) {
            String url_combine = "?userid=" + s + "&newpassword=" + newp;

            BufferedReader br = null;
            try {
                URL url = new URL(REGISTER_URL + url_combine);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));

                result = br.readLine();


            } catch (Exception e) {
                return e.toString();
            }
        }
        return result;
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


