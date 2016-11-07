package com.example.passengerchecker;

/**
 * Created by jeevansai on 03/11/2016.
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

public class  RetrievePassengerList extends AsyncTask<String,Void,String>{
    private Context context;
    public static int count1 = 0;
    ProgressDialog loading;
    //callback callback;

    public static ArrayList<Passenger> passengerArrayList=new ArrayList<>();
    public static ArrayList<String> uo=new ArrayList<String>();
    public RetrievePassengerList()
    {

    }
    public RetrievePassengerList(Context cxt)
    {
        context=cxt;
    }
    private static final String passenger_URL="http://jeevan123.net46.net/login/retreievepassengerlist.php";

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
        String s="?coachnumber="+arg0[0]+"&trainnumber="+DateVerification.trainnumber+"&sdate="+NavigationActivity.selected_date;
        try
        {

            URL url=new URL(passenger_URL+s);
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
        try {
            JSONObject jo = new JSONObject(result);
            JSONArray ja = jo.getJSONArray("server_response");

            while (count1 < ja.length()) {
                JSONObject jo2 = ja.getJSONObject(count1);
                String pname=jo2.getString("pname");
                int age=jo2.getInt("age");
                String sex=jo2.getString("sex");
                int seatno=jo2.getInt("seatno");
                String coachno=jo2.getString("coachno");
                String  source=jo2.getString("source");
                String destination=jo2.getString("destination");
                String doj=jo2.getString("doj");
                String arrival=jo2.getString("arrival");
                String departure=jo2.getString("departure");
                String trno=jo2.getString("trainnumber");
                String trname=jo2.getString("trainname");
                String status=jo2.getString("status");
                String mobileno=jo2.getString("mobileno");
                String pnrnumber=jo2.getString("pnrnumber");
                // Toast.makeText(context,"pname "+pname+" date "+doj+"arrival " +arrival,Toast.LENGTH_LONG).show();
                uo.add(count1,pname+" "+String.valueOf(seatno)+" "+coachno+" "+trno+" "+trname+" "+doj+" "+pnrnumber);
               // Toast.makeText(context,uo.get(count1),Toast.LENGTH_LONG).show();

                passengerArrayList.add(new Passenger(pname,age,sex,seatno,coachno,source,destination,doj,arrival,departure,trno,trname,status,mobileno,pnrnumber));
                count1++;
            }

            //System.out.print(passengerArrayList.get(1).arrival);
           // Toast.makeText(context,passengerArrayList.get(1).arrival,Toast.LENGTH_SHORT).show();
           // callback.send(passengerArrayList);
            context.startActivity(new Intent(context,PassengerListActivity.class));
        }

        catch (Exception e) {
             Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }




    }

    /*public void setInit(callback callback1)
    {
        this.callback=callback1;
    }
/*
public interface callback
{
    public void send(ArrayList<Passenger> passengers);
}*/
}