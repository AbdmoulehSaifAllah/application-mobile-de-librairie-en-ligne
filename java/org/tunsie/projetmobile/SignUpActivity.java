package org.tunsie.projetmobile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class SignUpActivity extends AppCompatActivity {
    EditText Username, Email, Password, ConfirmPassword;
    Button Suivant1, Precedent1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        Username = findViewById(R.id.Username);
        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.Password);
        ConfirmPassword = findViewById(R.id.ConfirmPassword);
        Suivant1 = (Button) findViewById(R.id.btnSuivant1);
        Precedent1 = (Button) findViewById(R.id.btnPrecedent1);
        Suivant1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = Username.getText().toString();
                String email = Email.getText().toString();
                String password = Password.getText().toString();
                String confirmPassword = ConfirmPassword.getText().toString();
                if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "il est Obligatoire de remplir tous les champs", Toast.LENGTH_SHORT).show();
                } else {
                    if (!password.equals(confirmPassword)) {
                        Toast.makeText(getApplicationContext(), "mot de passe non confirmé", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "succée", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignUpActivity.this,Cat.class);
                        intent.putExtra("nom", Username.getText().toString());
                        startActivity(intent);

                    }
                }
            }
        });
        Precedent1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}