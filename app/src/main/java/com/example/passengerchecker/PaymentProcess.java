package com.example.passengerchecker;

import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.telephony.SmsManager;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by jeevansai on 08/11/2016.
 */

public class PaymentProcess extends AsyncTask<String,Void,String> {
    private Context context;
    String name,emailid;
    ProgressDialog loading;
    public static String logged_in_user="";
    public static String ttmobile_number="";
    public PaymentProcess()
    {
        this.name="name";
        this.emailid="emailid";
    }
    public PaymentProcess(Context cxt)
    {
        context=cxt;
    }
    private static final String payment_URL="http://jeevan123.net46.net/login/tcpayment.php";

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
        String bname="",cardno="",chname="",expiry="",cvvno="",mobno="",fine="";
         bname=arg0[0];
        cardno=arg0[1];
        chname=arg0[2];
        expiry=arg0[3];
        cvvno=arg0[4];
        mobno=arg0[5];
        fine=arg0[6];
        String s="?bname="+bname+"&cno="+cardno+"&cname="+chname+"&expiry="+expiry+"&cvv="+cvvno+"&mobileno="+arg0[5]+"&reqamt="+fine+"&source="+VacantSeatsActivity.source+"&destination=VINUKONDA"+"&trainnumber="+DateVerification.trainnumber;
        try
        {

            URL url=new URL(payment_URL+s);
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
        if(res[0].equals("Payment")) {
            try {
                String messageToSend = "From IRCTC ==> "+result;

                String messageToSend1 = "Fine paid  ==> "+result;
                String no = res[2];

                SmsManager smsOperation = SmsManager.getDefault();
                PendingIntent sentPI;
                String sent = "SMS_SENT";
                sentPI = PendingIntent.getBroadcast(context, 0, new Intent(sent), 0);
                smsOperation.sendTextMessage(no, null, messageToSend, sentPI, null);
                smsOperation.sendTextMessage(Login.ttmobile_number, null, messageToSend1, sentPI, null);
                Toast.makeText(context, "SMS Sent Seuccessfully ", Toast.LENGTH_SHORT).show();
                context.startActivity(new Intent(context, PaymentSuccesfulActivity.class));


                 } catch (Exception e) {
                e.toString();
                Toast.makeText(context, e + "  Message Not Delivered ", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
