package com.example.passengerchecker;

/**
 * Created by jeevansai on 06/11/2016.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

public class  GetVacancySource extends AsyncTask<String,Void,String>{
    private Context context;
    String cdate;
    public static int count1 = 0;
    ProgressDialog loading;
    public static ArrayList<String> vacantcoaches=new ArrayList<String>();
    public GetVacancySource()
    {

    }
    public GetVacancySource(Context cxt)
    {
        context=cxt;
    }
    private static final String getcoach2_url="http://jeevan123.net46.net/login/getvacantseatssource.php";

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
        //Toast.makeText(context,ss, Toast.LENGTH_SHORT).show();
        //Toast.makeText(context,s,Toast.LENGTH_SHORT).show();

        String s1="?trainnumber="+DateVerification.trainnumber+"&sdate="+NavigationActivity.selected_date;
        try
        {

            URL url=new URL(getcoach2_url+s1);
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
        if (result != null) {
            try
            {
                JSONObject jo = new JSONObject(result);
                JSONArray ja = jo.getJSONArray("server_response");
                if(count1<=0)
                {
                    while (count1 < ja.length()) {
                        JSONObject jo2 = ja.getJSONObject(count1);
                        vacantcoaches.add(jo2.getString("source"));
                        count1++;
                    }
                }
                context.startActivity(new Intent(context, VacantSeatsActivity.class));
            }
            catch (Exception e) {
                Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
            }


        }
        else
        {
            Toast.makeText(context, "There are no coaches for "+DateVerification.trainname, Toast.LENGTH_SHORT).show();
        }
    }

}

