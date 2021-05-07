package sg.edu.rp.c346.id20046797.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    // Values are initiated inside the OnCreate Method, but just for this lesson.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // EditText Group
        EditText ETtotalAmount = findViewById(R.id.editTextAmount);
        EditText ETtotalPax = findViewById(R.id.editTextPax);
        EditText ETDiscount = findViewById(R.id.editTextDiscount);

        // TextView Group
        TextView displayPrice = findViewById(R.id.textViewTotalPay);
        TextView displayType = findViewById(R.id.textViewPaymentType);

        // Button Group
        Button btnSplit = findViewById(R.id.buttonSplit);
        Button btnReset = findViewById(R.id.buttonReset);

        // RadioGroup Group
        RadioGroup radioGroupPay = findViewById(R.id.RadioGroupPayment);

        // RadioButton
        RadioButton rbCash = findViewById(R.id.radioButtonCash);
        RadioButton rbPaynow = findViewById(R.id.radioButtonPayNow);


        // ToggleButton Group
        ToggleButton tbSVS = findViewById(R.id.toggleButtonSVS);
        ToggleButton tbGST = findViewById(R.id.toggleButtonGST);

        btnSplit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String paymentType = "";

                double discount = 0.0;
                double surcharge = 1.0;
                try {
                    discount = Double.parseDouble(ETDiscount.getText().toString());
                } catch (Exception E) {
                    displayPrice.setText("Invalid Operator: " + E);
                }

                boolean SVS = false;
                if(tbSVS.isChecked()) {
                    SVS = true;
                    surcharge += 0.10;
                }

                boolean GST = false;
                if(tbGST.isChecked()) {
                    GST = true;
                    surcharge += 0.07;
                }

                int paymentRadioCheck = radioGroupPay.getCheckedRadioButtonId();
                if(paymentRadioCheck == R.id.radioButtonCash)  {
                    paymentType = " in Cash";
                } else {
                    paymentType = " via PayNow to 9283 2392";
                }

                if (discount <= 100 && discount >= 0) {
                    discount /= 100;
                    try {
                        double TotalAmount = Double.parseDouble(ETtotalAmount.getText().toString());
                        int TotalPax = Integer.parseInt(ETtotalPax.getText().toString());

                        double finalAmountAfterDisc = TotalAmount-(TotalAmount*discount);
                        finalAmountAfterDisc = finalAmountAfterDisc * surcharge;
                        double finalAmountAfterSplit = finalAmountAfterDisc / TotalPax;

                        String FAAD = String.format("%.2f", finalAmountAfterDisc);
                        String FAAS = String.format("%.2f", finalAmountAfterSplit);
                        displayPrice.setText("Total Bill: $" + FAAD);
                        displayType.setText("Each Bill: $" + FAAS + paymentType);
                    } catch (Exception E){
                        displayPrice.setText("Invalid Operator: " + E);
                    }

                } else {
                    displayPrice.setText("Can't have discount more than 100% or lesser than 0%");
                }

            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayPrice.setText("");
                displayType.setText("");
                tbGST.setChecked(false);
                tbSVS.setChecked(false);
                ETtotalAmount.setText("");
                ETtotalPax.setText("");
                ETDiscount.setText("");
                rbCash.setChecked(false);
                rbPaynow.setChecked(false);

            }
        });

    }
}