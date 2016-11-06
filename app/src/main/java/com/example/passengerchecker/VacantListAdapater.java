package com.example.passengerchecker;

/**
 * Created by jeevansai on 06/11/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class VacantListAdapater extends RecyclerView.Adapter<VacantListAdapater.PersonViewHolder> {
    int c=0;
    Context ctx;
    public static class PersonViewHolder extends RecyclerView.ViewHolder{
        List<Passenger> personss=new ArrayList<Passenger>();
        //CardView cv;
        CardView cv;
        Context ctx;
        TextView pname,age,sex,seatno,coachno,source,destination,doj,arrival,departure,trno,trname,status,cb,pnrno,mobileno;

        PersonViewHolder(View itemView, Context ctx, List<Passenger> personss) {
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

    VacantListAdapater(List<Passenger> persons, Context ctx){
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
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vacant_passenger_card, viewGroup, false);
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
        personViewHolder.cb.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                //String result=RetrievePassengerList.uo.get(i);
                Intent i=new Intent(ctx,EnterVPDetails.class);
                ctx.startActivity(i);
                /*String res[]=result.split(" ");
                AdminAccept aa=new AdminAccept(ctx);
                aa.execute(res[0],res[1],res[2],res[3],res[4],res[5],res[6]);
                //Toast.makeText(ctx,"Accept Clicked at pos : "+i+" Username : "+res[0]+"Ordernumber "+res[1],Toast.LENGTH_SHORT).show();
                delete_accept(i);
                */// Toast.makeText(ctx,"Accept Clicked at pos : "+i,Toast.LENGTH_SHORT).show();
            }
        });
        //personViewHolder.cb.setChecked(persons.get(i).isSelected());

    }

    @Override
    public int getItemCount() {
        return persons.size();
    }
}