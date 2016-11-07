package com.example.passengerchecker;

/**
 * Created by jeevansai on 04/11/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class PassengerListAdapter extends RecyclerView.Adapter<PassengerListAdapter.PersonViewHolder> {
    int c=0;
    Context ctx;
    int flag=0;
    public static class PersonViewHolder extends RecyclerView.ViewHolder{
        List<Passenger> personss=new ArrayList<Passenger>();
        //CardView cv;

        CardView cv;
        Context ctx;
        TextView pname,age,sex,seatno,coachno,source,destination,doj,arrival,departure,trno,trname,status,cb,pnrno,mobileno;

        PersonViewHolder(View itemView,Context ctx,List<Passenger> personss) {
            super(itemView);
            this.ctx=ctx;
            this.personss=personss;
            //cv = (CardView) itemView.findViewById(R.id.card1);
            cv = (CardView) itemView.findViewById(R.id.card1);

            pname  = (TextView)itemView.findViewById(R.id.pnamev);
            age= (TextView)itemView.findViewById(R.id.agev);
            sex= (TextView)itemView.findViewById(R.id.sexv);
            seatno= (TextView)itemView.findViewById(R.id.seatnov);
            coachno= (TextView)itemView.findViewById(R.id.coachnov);
            source= (TextView)itemView.findViewById(R.id.sourcev);
            destination= (TextView)itemView.findViewById(R.id.destinationv);
            doj= (TextView)itemView.findViewById(R.id.dojv);
            arrival= (TextView)itemView.findViewById(R.id.arrivalv);
            departure= (TextView)itemView.findViewById(R.id.departurev);
            trno= (TextView)itemView.findViewById(R.id.trnov);
            trname= (TextView)itemView.findViewById(R.id.trnamev);
            status= (TextView)itemView.findViewById(R.id.statusv);
            mobileno= (TextView) itemView.findViewById(R.id.mobilenov);
            pnrno= (TextView) itemView.findViewById(R.id.pnrnov);

            cb= (Button) itemView.findViewById(R.id.cb);
        }
    }

    List<Passenger> persons;

    PassengerListAdapter(List<Passenger> persons, Context ctx){
        this.persons = persons;
        this.ctx=ctx;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
    public void delete_accept(int position)
    {
        persons.remove(position);
        RetrievePassengerList.uo.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,getItemCount());

    }
    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.passeneger_card, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v,ctx,persons);
        return pvh;
    }

    @Override
    public void onBindViewHolder(final PersonViewHolder personViewHolder, final int i) {
        personViewHolder.pname.setText(persons.get(i).pname);
        personViewHolder.age.setText(String.valueOf(persons.get(i).age));
        personViewHolder.sex.setText(persons.get(i).sex);
        personViewHolder.seatno.setText(String.valueOf(persons.get(i).seatno));
        personViewHolder.coachno.setText(persons.get(i).coachno);
        personViewHolder.source.setText(persons.get(i).source);
        personViewHolder.destination.setText(persons.get(i).destination);
        personViewHolder.doj.setText(persons.get(i).doj);
        personViewHolder.arrival.setText(persons.get(i).arrival);
        personViewHolder.departure.setText(persons.get(i).departure);
        personViewHolder.trno.setText(persons.get(i).trainnumber);
        personViewHolder.trname.setText(persons.get(i).trainname);
        personViewHolder.status.setText(persons.get(i).status);
        personViewHolder.mobileno.setText(persons.get(i).mobileno);
        personViewHolder.pnrno.setText(persons.get(i).pnrno);
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+5:30"));
        Date currentLocalTime = cal.getTime();
        DateFormat date = new SimpleDateFormat("HH:mm a");
// you can get seconds by adding  "...:ss" to it
        date.setTimeZone(TimeZone.getTimeZone("GMT+5:30"));


        String localTime = date.format(currentLocalTime);
        Toast.makeText(ctx,localTime,Toast.LENGTH_LONG).show();
        Log.v("time",localTime);

        String lt1[] = localTime.split(" ");
        String lt2[] = lt1[0].split(":");
        //Toast.makeText(ctx, lt1[0] + " bgjb " + lt1[1], Toast.LENGTH_LONG).show();
        //Toast.makeText(ctx, lt2[0] + " bgjb " + lt2[1], Toast.LENGTH_LONG).show();

        int chr = Integer.parseInt(lt2[0]);
        if (chr>=13)
        {
            chr=chr-12;
            Toast.makeText(ctx,String.valueOf(chr),Toast.LENGTH_SHORT).show();
        }
        int cmin = Integer.parseInt(lt2[1]);
        // Toast.makeText(ctx, chr + " hi " + cmin, Toast.LENGTH_LONG).show();


        String tm = persons.get(i).arrival;
      Toast.makeText(ctx, " Arrival "+tm, Toast.LENGTH_LONG).show();

        char[] tmc=tm.toCharArray();
        //Toast.makeText(ctx, String.valueOf(tmc[1]), Toast.LENGTH_LONG).show();

        StringBuilder sbh = new StringBuilder();
        StringBuilder sbm = new StringBuilder();
        StringBuilder sba = new StringBuilder();
        String h = "", m = "", a = "";
        sbh.append(String.valueOf(tmc[0]));
        sbh.append(String.valueOf(tmc[1]));
        h = sbh.toString();
        // Toast.makeText(ctx, "hr : " + h, Toast.LENGTH_LONG).show();
        int dh = Integer.parseInt(h);
        //Toast.makeText(ctx, "hr : " + dh, Toast.LENGTH_LONG).show();

        sbm.append(String.valueOf(tmc[3]));
        sbm.append(String.valueOf(tmc[4]));

        m = sbm.toString();
        //    Toast.makeText(ctx, "min : " + m, Toast.LENGTH_LONG).show();
        int dm = Integer.parseInt(m);
        //  Toast.makeText(ctx, "min : " + dm, Toast.LENGTH_LONG).show();
        sba.append(String.valueOf(tmc[5]));
        sba.append(String.valueOf(tmc[6]));
        a = sba.toString();
        //  Toast.makeText(ctx,a,Toast.LENGTH_LONG).show();
        flag = 0;
        if (a.equals(lt1[1])) {
            if (dh <=chr )
            {
                if(dh==chr)
                {
                    if(dm < cmin)
                    {
                        flag = 1;
                    }
                    else
                        flag=0;
                }
                flag=1;
            }

            else
            {
                flag=0;
            }

        }


        personViewHolder.cb.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick (View v) {
                if (flag == 1) {
                    String result = RetrievePassengerList.uo.get(i);
                    String res[] = result.split(" ");
                    AdminAccept aa = new AdminAccept(ctx);
                    aa.execute(res[0], res[1], res[2], res[3], res[4], res[5], res[6]);
                    //Toast.makeText(ctx,"Accept Clicked at pos : "+i+" Username : "+res[0]+"Ordernumber "+res[1],Toast.LENGTH_SHORT).show();
                    delete_accept(i);
                    // Toast.makeText(ctx,"Accept Clicked at pos : "+i,Toast.LENGTH_SHORT).show();
                }

                else if (flag==0)
                {
                    Toast.makeText(ctx,"Arrival time is greater than current time",Toast.LENGTH_SHORT).show();
                }

            }

        });
        //personViewHolder.cb.setChecked(persons.get(i).isSelected());

    }

    @Override
    public int getItemCount() {
        return persons.size();
    }
}