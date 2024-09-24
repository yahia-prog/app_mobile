package com.example.yahiagecalculat;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class gMainActivity extends AppCompatActivity {

    private EditText note1, note2, note3, note4;
    private Button buttonCalculer;
    private TextView textViewResultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        note1 = findViewById(R.id.note1);
        note2 = findViewById(R.id.note2);
        note3 = findViewById(R.id.note3);
        note4 = findViewById(R.id.note4);
        buttonCalculer = findViewById(R.id.buttonCalculer);
        textViewResultat = findViewById(R.id.textViewResultat);

        buttonCalculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double n1 = Double.parseDouble(note1.getText().toString());
                double n2 = Double.parseDouble(note2.getText().toString());
                double n3 = Double.parseDouble(note3.getText().toString());
                double n4 = Double.parseDouble(note4.getText().toString());

                double moyenne = (n1 + n2 + n3 + n4) / 4;
                String mention = obtenirMention(moyenne);

                textViewResultat.setText("Moyenne : " + String.format("%.2f", moyenne) + "\nMention : " + mention);
            }
        });
    }

    private String obtenirMention(double moyenne) {
        if (moyenne >= 16) return "Excellent";
        else if (moyenne >= 14) return "Très bien";
        else if (moyenne >= 12) return "Bien";
        else if (moyenne >= 10) return "Assez bien";
        else return "Échec";
    }
}

