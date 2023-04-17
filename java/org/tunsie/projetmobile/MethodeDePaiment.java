package org.tunsie.projetmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MethodeDePaiment extends AppCompatActivity {

    private RadioGroup paymentRadioGroup;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_methode_de_paiment);

        paymentRadioGroup = findViewById(R.id.radioGroupPaiment);
        submitButton = findViewById(R.id.suivant);

        // Set click listener for submit button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedRadioButtonId = paymentRadioGroup.getCheckedRadioButtonId();

                RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);

                String selectedPaymentMethod = selectedRadioButton.getText().toString();

                Intent intent = new Intent(MethodeDePaiment.this, MethodeDePaiment.class);

                intent.putExtra("selected_payment_method", selectedPaymentMethod);

                startActivity(intent);
            }
        });



        Button suivant = findViewById(R.id.suivant);

        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MethodeDePaiment.this, MapsActvity.class);
                startActivity(intent);
            }
        });

        Button précédent = findViewById(R.id.précédent);

        précédent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MethodeDePaiment.this, Cat.class);
                startActivity(intent);
            }
        });
    }
}