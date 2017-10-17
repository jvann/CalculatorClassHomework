package itesm.mx.a01191342_calculadora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class CalculadoraActivity extends AppCompatActivity implements TextView.OnClickListener {

    private float iFirst;
    private float iSecond;
    private int sumCounter;
    private int substractCounter;
    private int multiplicationCounter;
    private int divisionCounter;
    private int iOperation;
    private String CALCULADORA_ACTIVITY = "Calculadora_Activity";
    private int RESULT_CODE = 1;
    private String sDisplay;
    private String nickname;
    private Bundle sNickname;
    private Bundle bDatos;
    private Button btn_0;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Button btn_7;
    private Button btn_8;
    private Button btn_9;
    private Button btn_clear;
    private Button btn_dot;
    private Button btn_sum;
    private Button btn_substract;
    private Button btn_multiply;
    private Button btn_divide;
    private Button btn_result;
    private ImageButton imageButtonuserprofile;
    private ImageButton imageButtonback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        iFirst = 0;
        iSecond = 0;
        sumCounter = 0;
        substractCounter = 0;
        multiplicationCounter = 0;
        divisionCounter = 0;
        iOperation = 0;
        sDisplay = "";
        btn_0 = (Button) findViewById(R.id.button_0);
        btn_1 = (Button) findViewById(R.id.button_1);
        btn_2 = (Button) findViewById(R.id.button_2);
        btn_3 = (Button) findViewById(R.id.button_3);
        btn_4 = (Button) findViewById(R.id.button_4);
        btn_5 = (Button) findViewById(R.id.button_5);
        btn_6 = (Button) findViewById(R.id.button_6);
        btn_7 = (Button) findViewById(R.id.button_7);
        btn_8 = (Button) findViewById(R.id.button_8);
        btn_9 = (Button) findViewById(R.id.button_9);
        btn_clear = (Button) findViewById(R.id.button_clear);
        btn_dot = (Button) findViewById(R.id.button_dot);
        btn_sum = (Button) findViewById(R.id.button_sum);
        btn_substract = (Button) findViewById(R.id.button_substract);
        btn_multiply = (Button) findViewById(R.id.button_multiply);
        btn_divide = (Button) findViewById(R.id.button_divide);
        btn_result = (Button) findViewById(R.id.button_result);
        imageButtonuserprofile = (ImageButton) findViewById(R.id.imageButton_userprofile);
        imageButtonback = (ImageButton) findViewById(R.id.imageButton_back);

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_dot.setOnClickListener(this);
        btn_sum.setOnClickListener(this);
        btn_substract.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_result.setOnClickListener(this);
        imageButtonuserprofile.setOnClickListener(this);
        imageButtonback.setOnClickListener(this);

        sNickname = getIntent().getExtras();

        if (sNickname != null){
            nickname = sNickname.getString("nickname");
        }

        Bundle extras = getIntent().getExtras();

        if (extras != null ) {
            nickname = extras.getString("nickname");
            sumCounter = extras.getInt("sumCounter");
            substractCounter = extras.getInt("substractCounter");
            multiplicationCounter = extras.getInt("multiplicationCounter");
            divisionCounter = extras.getInt("divisionCounter");

        }

        if (savedInstanceState != null) {
//            //Restaurar los valores anteriores.
            sumCounter = savedInstanceState.getInt("sum");
            substractCounter = savedInstanceState.getInt("sub");
            multiplicationCounter = savedInstanceState.getInt("mult");
            divisionCounter = savedInstanceState.getInt("div");
            iFirst = savedInstanceState.getFloat("iFirst");
            iSecond = savedInstanceState.getFloat("iSecond");
            iOperation = savedInstanceState.getInt("iOperation");
            sDisplay = savedInstanceState.getString("sDisplay");
            nickname = savedInstanceState.getString("nickname");

            updateTextView(sDisplay);
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.button_0:
                if (sDisplay != "" && sDisplay != "0") {
                    sDisplay += "0";
                } else if (sDisplay == "0" | sDisplay == ""){
                    sDisplay = "0";
                }
                break;
            case R.id.button_1:
                sDisplay += "1";
                break;
            case R.id.button_2:
                sDisplay += "2";
                break;
            case R.id.button_3:
                sDisplay += "3";
                break;
            case R.id.button_4:
                sDisplay += "4";
                break;
            case R.id.button_5:
                sDisplay += "5";
                break;
            case R.id.button_6:
                sDisplay += "6";
                break;
            case R.id.button_7:
                sDisplay += "7";
                break;
            case R.id.button_8:
                sDisplay += "8";
                break;
            case R.id.button_9:
                sDisplay += "9";
                break;
            case R.id.button_dot:
                sDisplay += ".";
                break;
            case R.id.button_clear:
                clear();
                break;
            case R.id.button_sum:
                if (sDisplay != "") {
                    iOperation = 1;
                    operationReady();
                }
                break;
            case R.id.button_substract:
                if (sDisplay != "") {
                    iOperation = 2;
                    operationReady();
                }
                break;
            case R.id.button_multiply:
                if (sDisplay != "") {
                    iOperation = 3;
                    operationReady();
                }
                break;
            case R.id.button_divide:
                if (sDisplay != "") {
                    iOperation = 4;
                    operationReady();
                }
                break;
            case R.id.button_result:
                makeOperation();
                break;
            case R.id.imageButton_userprofile:
                Intent inten = new Intent(CalculadoraActivity.this, ProfileActivity.class);
                inten.putExtra("nickname", nickname);
                inten.putExtra("sumCounter", String.valueOf(sumCounter));
                inten.putExtra("substractCounter", String.valueOf(substractCounter));
                inten.putExtra("multiplicationCounter", String.valueOf(multiplicationCounter));
                inten.putExtra("divisionCounter", String.valueOf(divisionCounter));
                startActivity(inten);
                break;
            case R.id.imageButton_back:
                resultadoActivity();
                break;
        }

        updateTextView(sDisplay);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        //Alamcena los datos en una estrucutura llave-valor
        savedInstanceState.putInt("sum", sumCounter);
        savedInstanceState.putInt("sub", substractCounter);
        savedInstanceState.putInt("mult", multiplicationCounter);
        savedInstanceState.putInt("div", divisionCounter);
        savedInstanceState.putFloat("iFirst", iFirst);
        savedInstanceState.putFloat("iSecond", iSecond);
        savedInstanceState.putInt("iOperation", iOperation);
        savedInstanceState.putString("sDisplay", sDisplay);
        savedInstanceState.putString("nickname", nickname);
        savedInstanceState.putBundle(CALCULADORA_ACTIVITY, bDatos);
        super.onSaveInstanceState(savedInstanceState);
    }

    public void resultadoActivity() {

        Intent intent = new Intent();

        intent.putExtra("nickname", nickname);
        intent.putExtra("sumCounter", sumCounter);
        intent.putExtra("substractCounter", substractCounter);
        intent.putExtra("multiplicationCounter", multiplicationCounter);
        intent.putExtra("divisionCounter", divisionCounter);

        setResult(RESULT_CODE, intent);

        finish();
    }

    public void updateTextView(String sDisplay) {

        TextView tvDisplay = (TextView) findViewById(R.id.text_display);
        tvDisplay.setText(sDisplay);
    }

    public void operationReady() {
        iFirst = Float.parseFloat(sDisplay);
        sDisplay = "";
    }

    public void makeOperation() {

        iSecond = Float.parseFloat(sDisplay);
        switch (iOperation){
            case 0:
                Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                sDisplay = String.valueOf(iFirst+iSecond);
                sumCounter += 1;
                break;
            case 2:
                sDisplay = String.valueOf(iFirst-iSecond);
                substractCounter += 1;
                break;
            case 3:
                sDisplay = String.valueOf(iFirst*iSecond);
                multiplicationCounter += 1;
                break;
            case 4:
                if (iSecond != 0){
                    sDisplay = String.valueOf(iFirst/iSecond);
                    divisionCounter += 1;
                }else {
                    sDisplay = "ERROR";
                    Toast.makeText(this, "ERROR; 0 no puede ser un divisor", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void clear() {
        iFirst = 0;
        iSecond = 0;
        sDisplay = "";
    }
}