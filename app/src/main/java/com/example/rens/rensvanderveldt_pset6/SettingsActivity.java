package com.example.rens.rensvanderveldt_pset6;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

// Imported and edited form example at: http://www.mysamplecode.com/2012/07/android-listview-checkbox-example.html

public class SettingsActivity extends AppCompatActivity {

    MyCustomAdapter dataAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        //Generate list View from ArrayList
        displayListView();

        checkButtonClick();

    }

    private void displayListView() {

        //Array list of countries
        ArrayList<Regio> regioList = new ArrayList<Regio>();
        Regio regio = new Regio("Amsterdam-Amstelland",false);
        regioList.add(regio);
        regio = new Regio("Brabant-Noord",false);
        regioList.add(regio);
        regio = new Regio("Brabant-Zuidoost",false);
        regioList.add(regio);
        regio = new Regio("Drenthe",false);
        regioList.add(regio);
        regio = new Regio("Flevoland",false);
        regioList.add(regio);
        regio = new Regio("Friesland",false);
        regioList.add(regio);
        regio = new Regio("Gelderland-Midden",false);
        regioList.add(regio);
        regio = new Regio("Gelderland-Zuid",false);
        regioList.add(regio);
        regio = new Regio("Gooi-en-Vechtstreek",false);
        regioList.add(regio);
        regio = new Regio("Groningen",false);
        regioList.add(regio);
        regio = new Regio("Haaglanden",false);
        regioList.add(regio);
        regio = new Regio("Hollands-Midden",false);
        regioList.add(regio);
        regio = new Regio("Ijsselland",false);
        regioList.add(regio);
        regio = new Regio("Kennemerland",false);
        regioList.add(regio);
        regio = new Regio("Limburg-Noord",false);
        regioList.add(regio);
        regio = new Regio("Limburg-Zuid",false);
        regioList.add(regio);
        regio = new Regio("Midden-en-West-Brabant",false);
        regioList.add(regio);
        regio = new Regio("Noord-en-Oost-Gelderland",false);
        regioList.add(regio);
        regio = new Regio("Noord-Holland-Noord",false);
        regioList.add(regio);
        regio = new Regio("Rotterdam-Rijnmond",false);
        regioList.add(regio);
        regio = new Regio("Twente",false);
        regioList.add(regio);
        regio = new Regio("Utrecht",false);
        regioList.add(regio);
        regio = new Regio("Zaanstreek",false);
        regioList.add(regio);
        regio = new Regio("Zaanstreek-Waterland",false);
        regioList.add(regio);
        regio = new Regio("Limburg-Noord",false);
        regioList.add(regio);
        regio = new Regio("Zeeland",false);
        regioList.add(regio);
        regio = new Regio("Zuid-Holland-Zuid",false);
        regioList.add(regio);

        //create an ArrayAdaptar from the String Array
        dataAdapter = new MyCustomAdapter(this, R.layout.regio_info, regioList);
        ListView listView = (ListView) findViewById(R.id.listviewSettings);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                Regio regio = (Regio) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),
                        "Clicked on Row: " + regio.getName(),
                        Toast.LENGTH_LONG).show();
            }
        });

    }

    private class MyCustomAdapter extends ArrayAdapter<Regio> {

        private ArrayList<Regio> regioList;

        public MyCustomAdapter(Context context, int textViewResourceId,
                               ArrayList<Regio> regioList) {
            super(context, textViewResourceId, regioList);
            this.regioList = new ArrayList<Regio>();
            this.regioList.addAll(regioList);
        }

        private class ViewHolder {
            CheckBox name;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            Log.v("ConvertView", String.valueOf(position));

            if (convertView == null) {
                LayoutInflater vi = (LayoutInflater)getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.regio_info, null);

                holder = new ViewHolder();
                holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);
                convertView.setTag(holder);

                holder.name.setOnClickListener( new View.OnClickListener() {
                    public void onClick(View v) {
                        CheckBox cb = (CheckBox) v ;
                        Regio regio = (Regio) cb.getTag();
                        Toast.makeText(getApplicationContext(),
                                "Toegevoegd: " + cb.getText(), Toast.LENGTH_LONG).show();
                        regio.setSelected(cb.isChecked());
                    }
                });
            }
            else {
                holder = (ViewHolder) convertView.getTag();
            }

            Regio regio = regioList.get(position);
            holder.name.setText(regio.getName());
            holder.name.setChecked(regio.isSelected());
            holder.name.setTag(regio);

            return convertView;

        }

    }

    private void checkButtonClick() {


        Button myButton = (Button) findViewById(R.id.button7);
        myButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                StringBuffer responseText = new StringBuffer();
                responseText.append("U heeft de volgende regios geselecteerd:\n");

                ArrayList<Regio> regioList = dataAdapter.regioList;
                for(int i=0;i<regioList.size();i++){
                    Regio regio = regioList.get(i);
                    if(regio.isSelected()){
                        responseText.append("\n" + regio.getName());
                    }
                }

                Toast.makeText(getApplicationContext(),
                        responseText, Toast.LENGTH_LONG).show();

            }
        });

    }

}