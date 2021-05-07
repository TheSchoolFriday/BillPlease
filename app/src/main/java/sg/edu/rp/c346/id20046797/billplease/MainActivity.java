package sg.edu.rp.c346.id20046797.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

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

        // ToggleButton Group
        ToggleButton tbSVS = findViewById(R.id.toggleButtonSVS);
        ToggleButton tbGST = findViewById(R.id.toggleButtonGST);

        btnSplit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                boolean SVS = false;
                if(tbSVS.isChecked()) {
                    SVS = true;
                }

                boolean GST = false;
                if(tbGST.isChecked()) {
                    GST = true;
                }

                double TotalAmount = Double.parseDouble(ETtotalAmount.getText().toString());
                int TotalPax = Integer.parseInt(ETtotalPax.getText().toString());
                double discount = Double.parseDouble(ETDiscount.getText().toString());

                if (discount <= 100 && discount >= 0) {

                } else {
                    displayPrice.setText("You can't have discount more than 100% or lesser than 0%");
                }

                // Check Payment Options
//                int paymentRadioCheck = radioGroupPay.getCheckedRadioButtonId();

            }
        });

    }
}