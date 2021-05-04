package sg.edu.rp.c346.id20013327.l03_billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    ToggleButton noSVS;
    ToggleButton gst;
    EditText etCost;
    EditText etNumber;
    Button split;
    Button reset;
    EditText discount;
    RadioGroup rgMode;
    TextView totalcost;
    TextView costPerPax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noSVS = findViewById(R.id.SVS);
        gst = findViewById(R.id.GST);
        etCost = findViewById(R.id.etCost);
        etNumber = findViewById(R.id.etNumber);
        split = findViewById(R.id.split);
        reset = findViewById(R.id.reset);
        rgMode = findViewById(R.id.rgMode);
        discount = findViewById(R.id.Discount);
        totalcost = findViewById(R.id.Bill);
        costPerPax = findViewById(R.id.Pays);

        if(etNumber.getText().toString().trim().length()!=0 && etNumber.getText().toString().trim().length()!=0) {
            double origAmt = Double.parseDouble(etNumber.getText().toString());
            double newAmt = 0.0;
            if(!noSVS.isChecked() && !gst.isChecked()) {
                newAmt = origAmt;
            } else if(noSVS.isChecked() && !gst.isChecked()) {
                newAmt = origAmt * 1.1;
            } else if(!noSVS.isChecked() && gst.isChecked()) {
                newAmt = origAmt * 1.07;
            } else {
                newAmt = origAmt * 1.17;
            }

            //Discount
            if(discount.getText().toString().trim().length() != 0) {
                newAmt *= 1 - Double.parseDouble(discount.getText().toString()) / 100;
            }

            String mode = "in cash";
            if(rgMode.getCheckedRadioButtonId() == R.id.PayNow) {
                mode = "via PayNow to 912345678";
            }

            totalcost.setText("Total Bill: $" + String.format("%.2f", newAmt));
            int numPerson = Integer.parseInt(etNumber.getText().toString());
            if(numPerson != 1) {
                costPerPax.setText("Each pays: $" + String.format("%.2f", newAmt / numPerson) + mode);
            } else {
                costPerPax.setText("Each pays: $" + newAmt + mode);
            }





        }

    }
}