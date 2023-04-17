package org.tunsie.projetmobile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Affichage extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage);
   Intent intent2=getIntent();
   String msg= intent2.getStringExtra("username");
    TextView textview=findViewById(R.id.textview);
    textview.setText(textview.getText()+"\t"+" ton commmande a eté enregistré avec succées votre commande sera venir aprés 7 jours");
    }
}