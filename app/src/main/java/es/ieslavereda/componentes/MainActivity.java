package es.ieslavereda.componentes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBox;
    private TextView textViewCB;
    private TextView textViewS;
    private RadioGroup sexoRG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox = findViewById(R.id.miCheckBox);
        textViewCB = findViewById(R.id.textViewCB);
        sexoRG = findViewById(R.id.radioGroup);
        textViewS = findViewById(R.id.textViewS);

        sexoRG.setOnCheckedChangeListener((radioGroup, i) -> {
            if(i==R.id.hombreRadioButton) {
                textViewS.setText("HOMBRE");
            } else if (i==R.id.mujerRadioButton) {
                textViewS.setText("MUJER");
            } else if (i==R.id.otroRadioButton) {
                textViewS.setText("OTRO");
            } else {
                textViewS.setText("ERROR EN LA SELECCIÓN DE SEXO");
            }
        });

/*        sexoRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                if(i==R.id.hombreRadioButton) {
                    textViewS.setText("HOMBRE");
                } else if (i==R.id.mujerRadioButton) {
                    textViewS.setText("MUJER");
                } else if (i==R.id.otroRadioButton) {
                    textViewS.setText("OTRO");
                } else {
                    textViewS.setText("ERROR EN LA SELECCIÓN DE SEXO");
                }
            }
        });*/

        checkBox.setOnClickListener(view -> {
            if (checkBox.isChecked()){
                textViewCB.setText("CheckBox activado");
            } else {
                textViewCB.setText("CheckBox desactivado");
            }
        });
    }
}