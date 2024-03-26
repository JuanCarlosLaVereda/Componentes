package es.ieslavereda.componentes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBox;
    private TextView textViewCB;
    private TextView textViewS;
    private RadioGroup sexoRG;
    private Button buttonAdd;
    private EditText nombre;
    private EditText apellidos;
    private Spinner spinner;
    private List<Usuario> usuarios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox = findViewById(R.id.miCheckBox);
        textViewCB = findViewById(R.id.textViewCB);
        sexoRG = findViewById(R.id.radioGroup);
        textViewS = findViewById(R.id.textViewS);
        nombre = findViewById(R.id.apellidosEditText);
        apellidos = findViewById(R.id.nombreEditText);
        spinner = findViewById(R.id.spinner);
        buttonAdd = findViewById(R.id.añadirButton);

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
                sexoRG.setVisibility(View.VISIBLE);
            } else {
                textViewCB.setText("CheckBox desactivado");
                //sexoRG.setVisibility(View.INVISIBLE);
                sexoRG.setVisibility(View.GONE);
            }
        });

        if (savedInstanceState==null){
            usuarios = new ArrayList<>();
            usuarios.add(new Usuario("Joaquin", "Alonso"));
            usuarios.add(new Usuario("Pepe", "Flores"));
            usuarios.add(new Usuario("JC", "antigo"));
            usuarios.add(new Usuario("La", "Que te Cuento"));
        } else {
            usuarios = (List<Usuario>) savedInstanceState.getSerializable("clave");
        }

        ArrayAdapter<Usuario> miAdaptador =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,usuarios);
        spinner.setAdapter(miAdaptador);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textViewS.setText(usuarios.get(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        buttonAdd.setOnClickListener(view -> {
            usuarios.add(new Usuario(nombre.getText().toString(), apellidos.getText().toString()));
            nombre.setText("");
            apellidos.setText("");
            miAdaptador.notifyDataSetChanged();
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putSerializable("clave",(Serializable) usuarios);
    }
}