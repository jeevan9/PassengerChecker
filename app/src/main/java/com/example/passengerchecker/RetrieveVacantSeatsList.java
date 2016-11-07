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

public class  RetrieveVacantSeatsList extends AsyncTask<String,Void,String>{
    private Context context;
    public static int count2 = 0;
    ProgressDialog loading;

    public static ArrayList<Passenger> vacantArrayList=new ArrayList<Passenger>();
    public static ArrayList<String> uo2=new ArrayList<String>();
    public RetrieveVacantSeatsList()
    {

    }
    public RetrieveVacantSeatsList(Context cxt)
    {
        context=cxt;
    }
    private static final String vacant_passenger_URL="http://jeevan123.net46.net/login/getvacantseats.php";

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
        String s="?source="+VacantSeatsActivity.source+"&trainnumber="+DateVerification.trainnumber+"&sdate="+NavigationActivity.selected_date;
        try
        {

            URL url=new URL(vacant_passenger_URL+s);
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

            while (count2 < ja.length()) {
                JSONObject jo2 = ja.getJSONObject(count2);
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
                uo2.add(count2,pname+" "+String.valueOf(seatno)+" "+coachno+" "+trno+" "+trname+" "+doj+" "+pnrnumber);
          //      Toast.makeText(context,uo2.get(count2),Toast.LENGTH_LONG).show();
                vacantArrayList.add(new Passenger(pname,age,sex,seatno,coachno,source,destination,doj,arrival,departure,trno,trname,status,mobileno,pnrnumber));
                count2++;
            }
            context.startActivity(new Intent(context, VacantSeatsListActivity.class));
        }

        catch (Exception e) {
            // Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }

    }


}