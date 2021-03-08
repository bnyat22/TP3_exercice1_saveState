package com.example.tp3_exercice1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.UUID;

public class Inscription extends AppCompatActivity {

    EditText nom , prenom , age , ntel;
    TextView id;
   // Button sub;
    private static final String PRENOM = "prenom";
    private static final String NOM = "nom";
    private static final String AGE = "age";
    private static final String NTEL = "tel";
    private static final String ID = "id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom = (EditText) findViewById(R.id.nom);
        prenom = (EditText) findViewById(R.id.prenom);
        age = (EditText) findViewById(R.id.age);
        ntel = (EditText) findViewById(R.id.nTel);
        id = (TextView) findViewById(R.id.identite);
      // sub = (Button) findViewById(R.id.sub);



        if (savedInstanceState != null)
        {
            nom.setText(savedInstanceState.getString(NOM));
            prenom.setText(savedInstanceState.getString(PRENOM));
            age.setText(savedInstanceState.getString(AGE));
            ntel.setText(savedInstanceState.getString(NTEL));
            id.setText(savedInstanceState.getString(ID));

        }
        if (id.getText().toString().equals(""))
        {
            id.setText(generateId());
        }



    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {

        super.onSaveInstanceState(outState);
        outState.putString(NOM , nom.getText().toString());
        outState.putString(PRENOM , prenom.getText().toString());
        outState.putString(AGE , age.getText().toString());
        outState.putString(NTEL , ntel.getText().toString());
        outState.putString(ID ,id.getText().toString());

    }

  private String generateId()
  {
     // String secure = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

      String secure = UUID.randomUUID().toString();
      return secure;
  }

}
