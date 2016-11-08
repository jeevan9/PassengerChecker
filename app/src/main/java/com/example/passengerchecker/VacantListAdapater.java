package com.example.passengerchecker;

/**
 * Created by jeevansai on 06/11/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class VacantListAdapater extends RecyclerView.Adapter<VacantListAdapater.PersonViewHolder1> {
    int c=0;
    public static String pname1="",coachno1="",source1="",destination1="",doj="";
    Context ctx;
    public static class PersonViewHolder1 extends RecyclerView.ViewHolder{
        List<Passenger> personss2=new ArrayList<Passenger>();
        //CardView cv;
        CardView cvv;
        Context ctx;
        TextView pname,age,sex,seatno,coachno,source,destination,doj,arrival,departure,trno,trname,status,cb,pnrno,mobileno;

        PersonViewHolder1(View itemView, Context ctx, List<Passenger> personss) {
            super(itemView);
            this.ctx=ctx;
            this.personss2=personss;
            //cv = (CardView) itemView.findViewById(R.id.card1);
            cvv = (CardView) itemView.findViewById(R.id.card2);

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

            cb= (Button) itemView.findViewById(R.id.cb1);
        }
    }

    List<Passenger> persons2;

    VacantListAdapater(List<Passenger> persons2, Context ctx){
        this.persons2 = persons2;
        this.ctx=ctx;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
    @Override
    public PersonViewHolder1 onCreateViewHolder(ViewGroup viewGroup, int i) {
        //View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.passeneger_card, viewGroup, false);
View v=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vacant_passenger_card,viewGroup,false);
        PersonViewHolder1 pvh = new PersonViewHolder1(v,ctx,persons2);
        return pvh;
    }

    @Override
    public void onBindViewHolder(final PersonViewHolder1 personViewHolder, final int i) {
        personViewHolder.pname.setText(persons2.get(i).pname);
        personViewHolder.age.setText(String.valueOf(persons2.get(i).age));
        personViewHolder.sex.setText(persons2.get(i).sex);
        personViewHolder.seatno.setText(String.valueOf(persons2.get(i).seatno));
        personViewHolder.coachno.setText(persons2.get(i).coachno);
        personViewHolder.source.setText(persons2.get(i).source);
        personViewHolder.destination.setText(persons2.get(i).destination);
        personViewHolder.doj.setText(persons2.get(i).doj);
        personViewHolder.arrival.setText(persons2.get(i).arrival);
        personViewHolder.departure.setText(persons2.get(i).departure);
        personViewHolder.trno.setText(persons2.get(i).trainnumber);
        personViewHolder.trname.setText(persons2.get(i).trainname);
        personViewHolder.status.setText(persons2.get(i).status);
        personViewHolder.mobileno.setText(persons2.get(i).mobileno);
        personViewHolder.pnrno.setText(persons2.get(i).pnrno);
        //Log.v("vacantbind","at pos "+String.valueOf(i));
        Toast.makeText(ctx,"vacantbind"+String.valueOf(i),Toast.LENGTH_SHORT).show();
        personViewHolder.cb.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                //Log.v("vacantbindbutt","at pos "+String.valueOf(i));

                Toast.makeText(ctx,"vacantbind butt"+String.valueOf(i),Toast.LENGTH_SHORT).show();
                pname1=persons2.get(i).pname;
                coachno1=persons2.get(i).coachno;
                source1=persons2.get(i).source;
                destination1=persons2.get(i).destination;
                doj=persons2.get(i).doj;

                Intent i=new Intent(ctx,EnterVPDetails.class);
                ctx.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return persons2.size();
    }
}