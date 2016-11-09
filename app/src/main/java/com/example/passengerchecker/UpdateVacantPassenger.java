package com.example.passengerchecker;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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
/**
 * Created by jeevansai on 09/11/2016.
 */
public class  UpdateVacantPassenger extends AsyncTask<String,Void,String> {
        private Context context;
        String name,emailid;
        ProgressDialog loading;

        public UpdateVacantPassenger()
        {
            this.name="name";
            this.emailid="emailid";
        }
        public UpdateVacantPassenger(Context cxt)
        {
            context=cxt;
        }
        private static final String update_url="http://jeevan123.net46.net/login/updatevacpass.php";

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
            String npname=arg0[0];
            String nage=arg0[1];
            String nsex=arg0[2];
            String nmobileno=arg0[3];
            String s1="?npname="+npname+"&nage="+nage+"&nsex="+nsex+"&nmobileno="+nmobileno;
            String s2="&opname="+VacantListAdapater.pname1+"&oseatno="+String.valueOf(VacantListAdapater.seatno1)+"&ocoachno="+VacantListAdapater.coachno1+"&source="+VacantListAdapater.source1+"&destination="+VacantListAdapater.destination1+"&doj="+VacantListAdapater.doj1+"&pnrno="+VacantListAdapater.pnrno1;
            
            String s=s1+s2;
            try
            {

                URL url=new URL(update_url+s);
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
            /*String res[]=result.split(" ");

            Toast.makeText(context,res[0]+" "+res[1], Toast.LENGTH_SHORT).show();
            if(res[0].equals("Welcome"))
            {
                name=res[1];
                emailid=res[2];
                String user_id=res[3];

                context.startActivity(new Intent(context, NavigationActivity.class));
                //NavigationActivity name1=new NavigationActivity(res[1],res[2]);
            }
*/
        }


    }

