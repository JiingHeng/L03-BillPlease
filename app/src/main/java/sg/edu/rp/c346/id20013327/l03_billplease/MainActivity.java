package sg.edu.rp.c346.id20013327.l03_billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton NoSVS;
    ToggleButton GST;
    EditText etCost;
    EditText etNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NoSVS = findViewById(R.id.SVS);
        GST = findViewById(R.id.GST);
        etCost = findViewById(R.id.etCost);
        etNumber = findViewById(R.id.etNumber);



        NoSVS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(NoSVS.isChecked() == true) {
                    GST.setEnabled(false);
                    GST.setBackgroundColor(Color.GRAY);
                } else if(GST.isChecked() == true) {
                    NoSVS.setEnabled(false);
                    NoSVS.setBackgroundColor(Color.GRAY);
                } else {
                    Toast.makeText(MainActivity.this,
                            "Check on of the buttons",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}