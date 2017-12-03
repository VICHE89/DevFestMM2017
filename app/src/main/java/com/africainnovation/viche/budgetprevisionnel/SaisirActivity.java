
package com.africainnovation.viche.budgetprevisionnel;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.africainnovation.viche.budgetprevisionnel.databinding.ActivitySaisirBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SaisirActivity extends AppCompatActivity {

    private ActivitySaisirBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(SaisirActivity.this, R.layout.activity_saisir);

        binding.btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("presentation");

                // Creating new user node, which returns the unique key value
                // new user node would be /users/$userid/

                String nom  = binding.edtNom.getText().toString();
                String profil  = binding.edtProfil.getText().toString();
                String finalite  = binding.edtFinalite.getText().toString();
                String atouts  = binding.edtAtout.getText().toString();

                String presentationId = mDatabase.push().getKey();

                // creating user object
                Presentation presentation = new Presentation(nom, profil, finalite, atouts);

                // pushing user to 'users' node using the userId
                mDatabase.child(presentationId).setValue(presentation);

                startActivity(new Intent(SaisirActivity.this, DepenseActivity.class));
            }
        });
    }
}
