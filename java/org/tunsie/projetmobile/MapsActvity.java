package org.tunsie.projetmobile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

public class MapsActvity extends AppCompatActivity {
    Button suivant,precedent;
    EditText addressEditText;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_actvity);
        addressEditText = findViewById(R.id.addressEditText);
        suivant = findViewById(R.id.B);
        precedent = findViewById(R.id.A);
    }

    public void onSearchClicked(View view) {
        String address = addressEditText.getText().toString();
        double latitude = 37.7749;
        double longitude = -122.4194;
        Uri gmmIntentUri = Uri.parse("geo:" + latitude + "," + longitude+ "geo:0,0?q="+address);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapsActvity.this, Affichage.class);
                startActivity(intent);
            }
        });

        precedent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapsActvity.this, MethodeDePaiment.class);
                startActivity(intent);
            }
        });
    }
}