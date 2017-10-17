package itesm.mx.a01191342_calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    private Bundle datos;
    private TextView tvUsername;
    private TextView sumCounter;
    private TextView substractCounter;
    private TextView multiplicationCounter;
    private TextView divisionCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvUsername = (TextView) findViewById(R.id.text_user);
        sumCounter = (TextView) findViewById(R.id.text_sum);
        substractCounter = (TextView) findViewById(R.id.text_sub);
        multiplicationCounter = (TextView) findViewById(R.id.text_mult);
        divisionCounter = (TextView) findViewById(R.id.text_div);

        datos = getIntent().getExtras();

        if (datos != null){
            String nickname = datos.getString("nickname");
            String sSumCounter = datos.getString("sumCounter");
            String sSubstractCounter = datos.getString("substractCounter");
            String sMultiplicationCounter = datos.getString("multiplicationCounter");
            String sDivisionCounter = datos.getString("divisionCounter");
//
            tvUsername.setText(nickname);
            sumCounter.setText(sSumCounter);
            substractCounter.setText(sSubstractCounter);
            multiplicationCounter.setText(sMultiplicationCounter);
            divisionCounter.setText(sDivisionCounter);        }
    }
}
