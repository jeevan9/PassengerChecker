package com.example.passengerchecker;

/**
 * Created by jeevansai on 05/11/2016.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.telephony.SmsManager;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

public class  AdminAccept extends AsyncTask<String,Void,String>{
    private Context context;
    String username="";
    ProgressDialog loading;
    String pname="";
    String seatno="";
    //int sno=Integer.valueOf(seatno);
    String coachno="";
    String trno="";
    String trname="";
    String doj="";
    public AdminAccept(Context cxt)
    {
        context=cxt;
    }
    private static final String login_url_d="http://jeevan123.net46.net/login/accept_passenger_list.php";

    public AdminAccept()
    {

    }
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
        pname=arg0[0];
        seatno=arg0[1];
        //int sno=Integer.valueOf(seatno);
        coachno=arg0[2];
        trno=arg0[3];
        trname=arg0[4];
        doj=arg0[5];
        String oa="?pname="+pname+"&seatno="+seatno+"&coachno="+coachno+"&trno="+trno+"&trname="+trname+"&doj="+doj;
        try
        {

            URL url=new URL(login_url_d+oa);
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
        //Toast.makeText(context, "doj "+doj ,Toast.LENGTH_LONG).show();

     //   Toast.makeText(context,result,Toast.LENGTH_SHORT).show();
        String res[]=result.split(" ");
        if(res[0].equals("Your"))
        {

            try {
                //Your ticket from"." ".$sql3[0]." "."to"." ".$sql3[1]."  "."on"." ".$doj+" "+"is verified successfully"+" "+res[11];
                String messageToSend="Your ticket "+ "pnrnumber "+res[13]+" from"+" "+res[3]+" to  "+res[5]+" "+"on"+" "+res[8]+" "+"is verified successfully";
                SmsManager smsOperation = SmsManager.getDefault();
                PendingIntent sentPI;
                String sent="SMS_SENT";
                sentPI=PendingIntent.getBroadcast(context,0,new Intent(sent),0);
               // Toast.makeText(context," Mobile no : "+ res[12],Toast.LENGTH_LONG).show();
                smsOperation.sendTextMessage(res[12], null, messageToSend, sentPI, null);
                Toast.makeText(context, "Order Accepted and SMS Sent Seuccessfully ", Toast.LENGTH_SHORT).show();
            }
            catch (Exception e) {
                e.toString();
                Toast.makeText(context, e + "  Message Not Delivered ", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(context,result,Toast.LENGTH_SHORT).show();
        }

    }


}
