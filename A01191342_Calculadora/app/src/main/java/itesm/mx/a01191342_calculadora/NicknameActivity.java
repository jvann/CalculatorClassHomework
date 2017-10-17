package itesm.mx.a01191342_calculadora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NicknameActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnListo;
    private EditText etUsername;
    private String NICKNAME_KEY = "Nickname_Activity";
    private int REQUEST_CODE = 0;
    private int RESULT_CODE_CALCULADORA = 1;
    private Bundle bDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);

        btnListo = (Button) findViewById(R.id.button_set_username);
        etUsername = (EditText) findViewById(R.id.edit_username);

        if (savedInstanceState != null) {
            etUsername.setText(savedInstanceState.getString(NICKNAME_KEY));
        }

        btnListo.setOnClickListener(this);
    }

    @Override
    public  void onClick(View v) {

        String sNombre =  etUsername.getText().toString();
        if (!sNombre.equals("")) {
            Intent intent = new Intent(NicknameActivity.this, CalculadoraActivity.class);
            intent.putExtra("nickname", etUsername.getText().toString());
            if (bDatos != null) {

                intent.putExtra("sumCounter", bDatos.getInt("sumCounter"));
                intent.putExtra("substractCounter", bDatos.getInt("substractCounter"));
                intent.putExtra("multiplicationCounter", bDatos.getInt("multiplicationCounter"));
                intent.putExtra("divisionCounter", bDatos.getInt("divisionCounter"));
            }

            startActivityForResult(intent, REQUEST_CODE);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        //Alamcena los datos en una estrucutura llave-valor
        savedInstanceState.putString(NICKNAME_KEY, etUsername.getText().toString());
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onActivityResult(int resuqestCode, int resultCode, Intent data) {
        super.onActivityResult(resuqestCode, resultCode, data);

        if ((resuqestCode == REQUEST_CODE) && (resultCode == RESULT_CODE_CALCULADORA)) {
            bDatos = data.getExtras();
        }
    }
}
