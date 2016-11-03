package com.example.passengerchecker;

/**
 * Created by jeevansai on 03/11/2016.
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

public class  RetrievePassengerList extends AsyncTask<String,Void,String>{
    private Context context;
    public static int count1 = 0;
    ProgressDialog loading;
    public static String logged_in_user="";
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
                Toast.makeText(context,"pname "+pname+" date "+doj,Toast.LENGTH_LONG).show();
           //     uo.add(count1,username+" "+ordernum);
             //   orders.add(new Pizza_Order("Username : "+jo2.getString("username")+"  Address : "+jo2.getString("address")+"   Order-Number : "+jo2.getString("ordernumber")+or+" status : "+jo2.getString("status")));
                //orders.add(new Pizza_Order(jo2.getString("username")));

                count1++;
            }
           /* String opr="";
            for (int j=0;j<uo.size();j++)
            {
                opr=opr+" j =  "+j +uo.get(j);
            }
            Toast.makeText(context,opr,Toast.LENGTH_SHORT).show();
            context.startActivity(new Intent(context, AdminHome.class));
*/
        }

        catch (Exception e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }

    }


}
