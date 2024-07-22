package com.example.childrenprojects;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.childrenprojects.db.entities.Transaction;

import org.w3c.dom.Text;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder> {
 private Context context;
 private List<Transaction> list;
    public  void setEventsList(List<Transaction> eventsList){
        this.list = eventsList;
        notifyDataSetChanged();
    }
    public TransactionAdapter(Context context, List<Transaction> transactionList){
        this.context = context;
        this.list = transactionList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_transaction,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.money.setText(list.get(position).summa);
        holder.whoT.setText(list.get(position).name);
        holder.dateT.setText(list.get(position).date);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView money, whoT,dateT;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            money = (TextView) itemView.findViewById(R.id.summaT);
            whoT = (TextView) itemView.findViewById(R.id.who);
            dateT = (TextView) itemView.findViewById(R.id.dateT);
        }
    }
}
