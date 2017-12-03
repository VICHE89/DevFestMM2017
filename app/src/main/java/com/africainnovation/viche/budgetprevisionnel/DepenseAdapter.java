package com.africainnovation.viche.budgetprevisionnel;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by viche on 03/12/2017.
 */

public class DepenseAdapter extends  RecyclerView.Adapter<DepenseAdapter.DepenseViewHolder>{

    private List<Depense> depensesList;


    public DepenseAdapter(List<Depense> depensesList) {
        this.depensesList = depensesList;
    }

    @Override
    public DepenseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_depense, parent, false);

        return new DepenseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DepenseViewHolder holder, int position) {
        Depense depense = depensesList.get(position);

        String pos = 1+position+"";

        holder.tvIndex.setText(pos);

        holder.tvDesignation.setText(depense.getDesignation());
        holder.tvQuantite.setText(depense.getQuantite());
        holder.tvPrix.setText(depense.getPrix());
        holder.tvTotal.setText(depense.getTotal());
    }

    @Override
    public int getItemCount() {
        return depensesList.size();
    }


    public class DepenseViewHolder extends RecyclerView.ViewHolder {
        public TextView tvIndex, tvDesignation, tvQuantite, tvPrix, tvTotal;

        public DepenseViewHolder(View view) {
            super(view);
            tvIndex = (TextView) view.findViewById(R.id.tv_index);
            tvDesignation = (TextView) view.findViewById(R.id.tv_designation);
            tvQuantite = (TextView) view.findViewById(R.id.tv_quantite);
            tvPrix = (TextView) view.findViewById(R.id.tv_prix);
            tvTotal = (TextView) view.findViewById(R.id.tv_totale);
        }
    }

}
