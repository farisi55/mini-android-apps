package com.example.banus.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    String message = "Free";
    boolean hasWhippedCream = false;
    boolean haschocolate = false;
    String valuenama = "Nama";
    String[] addresses_to = {"farisi55@gmail.com"};
    //String addresses_from = "farisi55@yahoo.com";
    String subject = "coba";
    String priceMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
    public void displayQuantity(int jumlah) {
        TextView scoreView = (TextView) findViewById(R.id.text_quantity);
        scoreView.setText(String.valueOf(jumlah));
    }

    public void increamentquantity (View view) {
        if (quantity == 100) {
            Toast.makeText(MainActivity.this, "Kamu tidak bisa beli lebih 100 kopi",
            Toast.LENGTH_SHORT).show();

            return;
        }
        quantity = quantity + 1;
        //displayQuantity(quantity);
    }
    //////
    public void decreamentquantity (View view) {
        if (quantity == 0) {
            Toast.makeText(MainActivity.this, "Kamu tidak bisa beli kurang 1 kopi",
                    Toast.LENGTH_SHORT).show();

            return;
        }
        quantity = quantity - 1;
        //displayQuantity(quantity);
    }
    */
    ///======

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamcheckbox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamcheckbox.isChecked();
        Log.v("MainActivity", "has WhippedCream:" + hasWhippedCream);
        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean haschocolate = chocolate.isChecked();
        Log.v("MainActivity", "has Chocolate:" + haschocolate);
        EditText nama = (EditText) findViewById(R.id.edit_text_name);
        String valuenama = nama.getText().toString();
        Log.v("MainActivity", "Nama: " + valuenama);
        int price = calculatePrice(hasWhippedCream, haschocolate);
        String priceMessage = createOrderSummary(valuenama, price, hasWhippedCream, haschocolate);
        displayMessage(priceMessage);

        //
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("mailto:"));
        //intent.putExtra(Intent.EXTRA_REFERRER, addresses_from);
        intent.putExtra(Intent.EXTRA_EMAIL, addresses_to);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee order for:" + valuenama);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    public void increamentquantity(View view) {
        if (quantity == 100) {
            Toast.makeText(MainActivity.this, "You cannot have more than 100 coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decreamentquantity(View view) {
        if (quantity == 0) {
            Toast.makeText(MainActivity.this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    private int calculatePrice(boolean addWhippedCream, boolean addchocolate) {
        // First calculate the price of one cup of coffee
        int basePrice = 5;

        // If the user wants whipped cream, add $1 per cup
        if (addWhippedCream) {
            basePrice = basePrice + 1;
        }

        // If the user wants chocolate, add $2 per cup
        if (addchocolate) {
            basePrice = basePrice + 2;
        }

        // Calculate the total order price by multiplying by the quantity
        return quantity * basePrice;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    private String createOrderSummary(String valuenama, int price, boolean addWhippedCream, boolean addchocolate) {
        priceMessage = "Name:" + valuenama;
        priceMessage += "\nAdd Whipped Cream: " + addWhippedCream;
        priceMessage += "\nAdd Chocolate:" + addchocolate;
        priceMessage += "\nQuantity:" + quantity;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }

    /*
    public void composeEmail(String[] addresses, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    */



}
