package sg.edu.rp.c346.id21024750.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText etinput;
    EditText etinput2;
    EditText etinput3;
    TextView tvAmount;
    TextView tvNum;
    TextView discounttv;
    TextView tvBill;
    TextView tvPays;
    ToggleButton tgbnSVS;
    ToggleButton tgbnGST;
    Button splitbn;
    Button resetbn;
    RadioButton cashrb;
    RadioButton pnrb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etinput = findViewById(R.id.etinput);
        etinput2 = findViewById(R.id.etinput2);
        etinput3 = findViewById(R.id.etinput3);
        tvAmount = findViewById(R.id.tvAmount);
        tvNum = findViewById(R.id.tvNum);
        discounttv = findViewById(R.id.discounttv);
        tvBill = findViewById(R.id.tvBill);
        tvPays = findViewById(R.id.tvPays);
        tgbnSVS = findViewById(R.id.tgbnSVS);
        tgbnGST = findViewById(R.id.tgbnGST);
        splitbn = findViewById(R.id.splitbn);
        resetbn = findViewById(R.id.resetbn);
        cashrb = findViewById(R.id.cashrb);
        pnrb = findViewById(R.id.pnrb);

        splitbn.setOnClickListener(new View.OnClickListener(){;
            @Override
            public void onClick (View view) {
                if (etinput.getText().toString().length() == 0 || etinput2.getText().toString().length() == 0) {

                } else {
                    String data1 = etinput.getText().toString();
                    String data2 = etinput2.getText().toString();

                    double amount = Double.parseDouble(data1);
                    double newAmount = 0;
                    int pax = Integer.parseInt(data2);

                    if (tgbnGST.isChecked() == true && tgbnSVS.isChecked() == true) {
                        newAmount = amount * 1.10 * 1.07;
                    } else if (tgbnGST.isChecked() == false && tgbnSVS.isChecked() == true) {
                        newAmount = amount * 1.10;
                    } else if (tgbnGST.isChecked() == true && tgbnSVS.isChecked() == false) {
                        newAmount = amount * 1.07;
                    } else {
                        newAmount = amount;
                    }

                    double eachPays = newAmount / pax;
                    tvBill.setText("Total amount: $" + newAmount + "");
                    String msg = String.format("%.2f", eachPays);
                    tvPays.setText("Each pays: $" + msg + "");


                }
            );






    });
        });
    }}