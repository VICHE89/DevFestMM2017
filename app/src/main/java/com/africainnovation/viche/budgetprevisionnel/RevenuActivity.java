package com.africainnovation.viche.budgetprevisionnel;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.africainnovation.viche.budgetprevisionnel.databinding.ActivityRevenuBinding;

import java.util.ArrayList;
import java.util.List;

public class RevenuActivity extends AppCompatActivity {

    private List<Revenu> revenuList = new ArrayList<>();
    private RevenuAdapter mAdapter;

    private ActivityRevenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(RevenuActivity.this, R.layout.activity_revenu);


        mAdapter = new RevenuAdapter(revenuList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

        binding.rvRevenu.setLayoutManager(mLayoutManager);
        binding.rvRevenu.setItemAnimator(new DefaultItemAnimator());
        binding.rvRevenu.setAdapter(mAdapter);

        binding.edtPrix.addTextChangedListener(new MyTextWatcher(binding.edtPrix));

        prepareDepenseData();

        binding.btnSuivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

                revenuList.add(new Revenu(designation, quantite, prix, total));

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
