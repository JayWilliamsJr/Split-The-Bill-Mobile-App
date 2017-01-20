package net.androidbootcamp.splitthebill;

import android.app.Activity;
import android.icu.util.Currency;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.Format;

public class SplitCalculator extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_split_calculator);

        Button split = (Button)findViewById(R.id.btnSplit);
    }
    public void onClickSplitButton (View v) {
        int partySize;
        double billSubtotal;
        double splitBill;
        double gratuity;
        double billTotal;
        String serviceRating;
        double gratuityRate = 0.18;

        EditText party = (EditText)findViewById(R.id.txtParty);
        EditText bill = (EditText)findViewById(R.id.txtBill);
        Spinner service = (Spinner)findViewById(R.id.txtService);
        TextView result = (TextView)findViewById(R.id.txtResult);

        partySize = Integer.parseInt(party.getText().toString());
        billSubtotal = Double.parseDouble(bill.getText().toString());
        serviceRating = service.getSelectedItem().toString();
        gratuity = billSubtotal * gratuityRate;
        billTotal = billSubtotal + gratuity;
        splitBill = billTotal / partySize;
        DecimalFormat currency = new DecimalFormat("$#0.00");
        result.setText("Your service rating is "+serviceRating+"\nYour total tip amount is "+
                currency.format(gratuity)+"\nYour price per party member is "+currency.format(splitBill));
    }
}
