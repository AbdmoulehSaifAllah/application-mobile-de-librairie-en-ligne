package org.tunsie.projetmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class educationEtEnseignement extends AppCompatActivity {
    private CheckBox[] bookCheckboxes = new CheckBox[5];
    private Button calculateBtn;
    private TextView totalPriceTextView;
    private float[] bookPrices = {16.35f, 18.2f, 28.0f, 37.0f, 22.0f};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_et_enseignement);

        bookCheckboxes[0] = findViewById(R.id.checkbox_livre1);
        bookCheckboxes[1] = findViewById(R.id.checkbox_livre2);
        bookCheckboxes[2] = findViewById(R.id.checkbox_livre3);
        bookCheckboxes[3] = findViewById(R.id.checkbox_livre4);
        bookCheckboxes[4] = findViewById(R.id.checkbox_livre5);

        calculateBtn = findViewById(R.id.btn_calculer);
        totalPriceTextView = findViewById(R.id.tv_resultat);

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float totalPrice = 0.0f;

                for (int i = 0; i < bookCheckboxes.length; i++) {
                    if (bookCheckboxes[i].isChecked()) {
                        totalPrice += bookPrices[i];
                    }
                }

                totalPriceTextView.setText(String.format("Total Price: $%.2f", totalPrice));
            }
        });

        Button submitBtn = findViewById(R.id.suivant);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(educationEtEnseignement.this, MethodeDePaiment.class);
                startActivity(intent);
            }
        });

        Button précédent = findViewById(R.id.précédent);

        précédent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(educationEtEnseignement.this, Cat.class);
                startActivity(intent);
            }
        });
    }
}
