package com.africainnovation.viche.budgetprevisionnel;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.africainnovation.viche.budgetprevisionnel.databinding.ActivityDepenseBinding;

import java.util.ArrayList;
import java.util.List;

public class DepenseActivity extends AppCompatActivity {

    private List<Depense> depenseList = new ArrayList<>();
    private DepenseAdapter mAdapter;

    private ActivityDepenseBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(DepenseActivity.this, R.layout.activity_depense);


        mAdapter = new DepenseAdapter(depenseList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

        binding.rvDepense.setLayoutManager(mLayoutManager);
        binding.rvDepense.setItemAnimator(new DefaultItemAnimator());
        binding.rvDepense.setAdapter(mAdapter);

        binding.edtPrix.addTextChangedListener(new MyTextWatcher(binding.edtPrix));

        prepareDepenseData();

        binding.btnSuivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DepenseActivity.this, RevenuActivity.class));
            }
        });
    }

    private void prepareDepenseData() {

        binding.btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String designation = binding.edtDesignation.getText().toString();

                String quantite = binding.edtQuantite.getText().toString();
                String prix = binding.edtPrix.getText().toString();

                String total = ((Integer)(Integer.parseInt(quantite)*Integer.parseInt(prix))).toString();

                depenseList.add(new Depense(designation, quantite, prix, total));

                mAdapter.notifyDataSetChanged();

                binding.edtDesignation.setText("");
                binding.edtQuantite.setText("");
                binding.edtPrix.setText("");

            }
        });

    }

    /****
     * Private class understanding input state
     *                                       ****/
    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view){
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

            String quantite = binding.edtQuantite.getText().toString();
            String prix = binding.edtPrix.getText().toString();

            Integer val = 0;
            try {
                val = ((Integer)(Integer.parseInt(quantite)*Integer.parseInt(prix)));
            }catch (NumberFormatException e)
            {

            }
            String total = "Total: "+val.toString();

            binding.tvTotal.setText(total);

        }
    }


}
