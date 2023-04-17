package org.tunsie.projetmobile;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Cat extends AppCompatActivity {
    private RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categrie);

        Intent intent1=getIntent();
        String message= intent1.getStringExtra("nom");
        TextView textview=findViewById(R.id.textView);
        textview.setText(textview.getText()+" "+message+" à votre librairie");


        radioGroup = findViewById(R.id.radioGroup1);
        Button suivant = findViewById(R.id.suivant);

        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioButtonID = radioGroup.getCheckedRadioButtonId();
                View radioButton = radioGroup.findViewById(radioButtonID);
                int idx = radioGroup.indexOfChild(radioButton);

                Intent intent;
                switch (idx) {
                    case 0:
                        intent = new Intent(Cat.this, santeFitnessEtRegime.class);
                        break;
                    case 1:
                        intent = new Intent(Cat.this, educationEtEnseignement.class);
                        break;
                    case 2:
                        intent = new Intent(Cat.this, affairesEtArgent.class);
                        break;
                    case 3:
                        intent = new Intent(Cat.this, livresPourEnfants.class);
                        break;
                    case 4:
                        intent = new Intent(Cat.this, artsEtPhotographie.class);
                        break;
                    default:
                        intent = new Intent(Cat.this, Cat.class);
                        break;
                }

                startActivity(intent);
            }
        });
        Button précédent = findViewById(R.id.précédent);

        précédent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cat.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
