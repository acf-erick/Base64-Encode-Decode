package com.example.base64app;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputText;
    private TextView resultText;
    private Button encodeButton, decodeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializando os componentes do layout
        inputText = findViewById(R.id.inputText);
        resultText = findViewById(R.id.resultText);
        encodeButton = findViewById(R.id.encodeButton);
        decodeButton = findViewById(R.id.decodeButton);

        // Botão para codificar o texto em Base64
        encodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputText.getText().toString();
                if (!input.isEmpty()) {
                    String encoded = Base64.encodeToString(input.getBytes(), Base64.DEFAULT);
                    resultText.setText("Codificado: " + encoded);
                } else {
                    resultText.setText("Por favor, insira o texto.");
                }
            }
        });

        // Botão para decodificar o texto de Base64
        decodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputText.getText().toString();
                if (!input.isEmpty()) {
                    try {
                        byte[] decodedBytes = Base64.decode(input, Base64.DEFAULT);
                        String decoded = new String(decodedBytes);
                        resultText.setText("Decodificado: " + decoded);
                    } catch (IllegalArgumentException e) {
                        resultText.setText("Erro na decodificação. Verifique o texto.");
                    }
                } else {
                    resultText.setText("Por favor, insira o texto.");
                }
            }
        });
    }
}
