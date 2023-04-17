package org.tunsie.projetmobile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class LogInActivity extends AppCompatActivity {
    EditText Username, Password;
    Button Suivant, Precedent;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        Username = findViewById(R.id.Username);
        Password = findViewById(R.id.Password);
        Suivant = findViewById(R.id.btnSuivant);
        Precedent = findViewById(R.id.btnPrecednt);
        Suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = Username.getText().toString();
                String password = Password.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "il est obligatoire de remplir le champ", Toast.LENGTH_SHORT).show();
                } else {
                    if (username.equals("user") && password.equals("password")) {
                        Toast.makeText(getApplicationContext(), "succeés", Toast.LENGTH_SHORT).show();
                    } else {
                        //Toast.makeText(getApplicationContext(), "erreur", Toast.LENGTH_SHORT).show();
                        Suivant.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent1 = new Intent(LogInActivity.this, Cat.class);
                                intent1.putExtra("nom", Username.getText().toString());
                                startActivity(intent1);
                            }
                        });
                    }
                }
            }
        });
        Precedent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogInActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}