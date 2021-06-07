package sg.edu.rp.c346.id19045083.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etElement = findViewById(R.id.editTextColour);
        EditText etIndexElement = findViewById(R.id.editTextPosition);
        Button btnAdd = findViewById(R.id.buttonAddItem);
        Button btnRemove = findViewById(R.id.buttonRemoveItem);
        Button btnUpdate = findViewById(R.id.buttonUpdateItem);
        ListView lvColour = findViewById(R.id.listViewColour);

        ArrayList<String> alColours = new ArrayList<>();
        alColours.add("Red");
        alColours.add("Orange");

        ArrayAdapter aaColour  = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alColours);
        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                alColours.add(etElement.getText().toString());
                alColours.add(Integer.parseInt(etIndexElement.getText().toString()), etElement.getText().toString());
                aaColour.notifyDataSetChanged();
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = alColours.get(position);
                Toast.makeText(MainActivity.this, colour, Toast.LENGTH_SHORT).show();
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alColours.remove(Integer.parseInt(etIndexElement.getText().toString()));
                aaColour.notifyDataSetChanged();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alColours.set(Integer.parseInt(etIndexElement.getText().toString()), etElement.getText().toString());
                aaColour.notifyDataSetChanged();
            }
        });

    }
}