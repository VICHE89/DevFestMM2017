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

public class RevenuAdapter extends RecyclerView.Adapter<RevenuAdapter.RevenuViewHolder> {


    private List<Revenu> revenusList;

    public RevenuAdapter(List<Revenu> revenusList) {
        this.revenusList = revenusList;
    }

    @Override
    public RevenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_revenu, parent, false);

        return new RevenuViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RevenuViewHolder holder, int position) {
        Revenu revenu = revenusList.get(position);

        String pos = 1+position+"";

        holder.tvIndex.setText(pos);

        holder.tvDesignation.setText(revenu.getDesignation());
        holder.tvQuantite.setText(revenu.getQuantite());
        holder.tvPrix.setText(revenu.getPrix());
        holder.tvTotal.setText(revenu.getTotal());
    }

    @Override
    public int getItemCount() {
        return revenusList.size();
    }


    public class RevenuViewHolder extends RecyclerView.ViewHolder {
        public TextView tvIndex, tvDesignation, tvQuantite, tvPrix, tvTotal;

        public RevenuViewHolder(View view) {
            super(view);
            tvIndex = (TextView) view.findViewById(R.id.tv_index);
            tvDesignation = (TextView) view.findViewById(R.id.tv_designation);
            tvQuantite = (TextView) view.findViewById(R.id.tv_quantite);
            tvPrix = (TextView) view.findViewById(R.id.tv_prix);
            tvTotal = (TextView) view.findViewById(R.id.tv_totale);
        }
    }

}
