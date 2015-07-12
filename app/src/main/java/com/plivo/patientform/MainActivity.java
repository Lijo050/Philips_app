package com.plivo.patientform;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.parse.Parse;
import com.parse.ParseObject;


public class MainActivity extends ActionBarActivity {

    private EditText _number;
    private EditText _name;
    private EditText _date;
    private Spinner _travel;
    private EditText _vehicle;
    private EditText _seat;
    private EditText _dest;
    private EditText _landmark;
    private EditText _med;
    private EditText _qty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "K99G1rM9oFec4JK85S93wUHkgRcOSEBEM5VAevvh", "OyMWpPPG4uwVfyobDnRcyvzHa0Ocj34EbDFE8UAg");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.


        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void submit(View view) {
        _name = ((EditText) findViewById(R.id.name));
        _number = ((EditText) findViewById(R.id.contact));
        _date = ((EditText) findViewById(R.id.date));
        _travel = (Spinner) findViewById(R.id.travel);
        _vehicle = ((EditText) findViewById(R.id.vehicle));
        _seat = ((EditText) findViewById(R.id.seat));
        _dest = ((EditText) findViewById(R.id.dest));
        _landmark = ((EditText) findViewById(R.id.landmark));
        _med = ((EditText) findViewById(R.id.med_name));
        _qty = ((EditText) findViewById(R.id.med_qty));

        String name = _name.getText().toString();
        String number = _number.getText().toString();
        String date = _date.getText().toString();
        String travel = _travel.getSelectedItem().toString();
        String vehicle = _vehicle.getText().toString();
        String seat = _seat.getText().toString();
        String dest = _dest.getText().toString();
        String landmark = _landmark.getText().toString();
        String med = _med.getText().toString();
        String qty = _qty.getText().toString();

        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("Name", name);
        testObject.put("Number", number);
        testObject.put("Date", date);
        testObject.put("Travel", travel);
        testObject.put("Vehicle", vehicle);
        testObject.put("Seat", seat);
        testObject.put("Dest", dest);
        testObject.put("Landmark", landmark);
        testObject.put("Med", med);
        testObject.put("Qty", qty);

        testObject.saveInBackground();
        Log.e("philips", name);
        _name.setText("");
        _number.setText("");
        _date.setText("");
        _vehicle.setText("");
        _seat.setText("");
        _dest.setText("");
        _landmark.setText("");
        _med.setText("");
        _qty.setText("");
    }
}
