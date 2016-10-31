package com.example.passengerchecker;

/**
 * Created by jeevansai on 30/10/2016.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

public class  DateVerification extends AsyncTask<String,Void,String>{
    private Context context;
    String cdate;
    public static String trainnumber="",trainname="";
    Login in1=new Login();
    ProgressDialog loading;
    public DateVerification()
    {

    }
    public DateVerification(Context cxt)
    {
        context=cxt;
    }
    private static final String dateverify_URL="http://jeevan123.net46.net/login/dateverify.php";

    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub
        super.onPreExecute();
        loading=ProgressDialog.show(context, "Please Wait","Loading", true, true);

    }
    @Override
    protected String doInBackground(String... arg0) {
        // TODO Auto-generated method stub
        BufferedReader br=null;
        StringBuffer sb;
        String ss=arg0[0];
        String sss=arg0[1];
        //Toast.makeText(context,ss, Toast.LENGTH_SHORT).show();
        //Toast.makeText(context,s,Toast.LENGTH_SHORT).show();

        String s1="?sdate="+ss+"&userid="+sss;
        try
        {

            URL url=new URL(dateverify_URL+s1);
            HttpURLConnection con=(HttpURLConnection) url.openConnection();
            br=new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            sb=new StringBuffer();
            while((line=br.readLine())!=null)
            {
                sb.append(line+"\n");
            }

        }
        catch (Exception e) {
            // TODO: handle exception
            return e.toString();
        }

        return sb.toString().trim();

    }
    @Override
    protected void onProgressUpdate(Void... values) {
        // TODO Auto-generated method stub
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        // TODO Auto-generated method stub
        super.onPostExecute(result);
        loading.dismiss();
        Toast.makeText(context,result, Toast.LENGTH_SHORT).show();
        String res[]=result.split(" ");
        if(res[0].equals("Welcome"))
        {
            trainnumber=res[1];
            trainname=res[2];
            context.startActivity(new Intent(context, TrainBogiActivity.class));
            //NavigationActivity name1=new NavigationActivity(res[1],res[2]);
        }
        else
        {
         //   Toast.makeText(context,s,Toast.LENGTH_SHORT).show();
        Toast.makeText(context,"No trains available",Toast.LENGTH_SHORT).show();
        }

    }


}
