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

    ToggleButton noSVS;
    ToggleButton gst;
    EditText etCost;
    EditText etNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noSVS = findViewById(R.id.SVS);
        gst = findViewById(R.id.GST);
        etCost = findViewById(R.id.etCost);
        etNumber = findViewById(R.id.etNumber);



        noSVS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(noSVS.isChecked() == true) {
                    gst.setEnabled(false);
                    gst.setBackgroundColor(Color.GRAY);
                } else if(gst.isChecked() == true) {
                    noSVS.setEnabled(false);
                    noSVS.setBackgroundColor(Color.GRAY);
                } else {
                    Toast.makeText(MainActivity.this,
                            "Check on of the buttons",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}