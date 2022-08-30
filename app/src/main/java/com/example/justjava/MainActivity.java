package com.example.justjava;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);


    }
    private void name(String userinput){

    }

    private void display(int number){
        TextView quantityTextview = (TextView)findViewById(R.id.quantity);
        quantityTextview.setText("" + number);
    }
    public TextView payable(int cup){
        TextView pay = (TextView)findViewById(R.id.payableamount);
        pay.setText("$" + (cup*5));
        return pay;
    }



    public void increment(View view) {

        if (quantity >= 100) {
            quantity = 100;
            display(quantity);
            payable(quantity);
        } else {
            quantity += 1;
            display(quantity);
            payable(quantity);
        }
    }

    public void decrement(View view) {

        if (quantity <= 0) {
            quantity = 0;
            display(quantity);
            payable(quantity);
        } else {
            quantity -= 1;
            display(quantity);
            payable(quantity);

        }
    }
    private int calculateprice(){
        int price = quantity*5;
        return price;

    }
    public void submitorder(View view){
        String ordersumchange = "ORDER SUMMARY";
        pricemessagechange(ordersumchange);

        CheckBox whippedcream = (CheckBox) findViewById(R.id.checkBox);
        boolean addWhippedCream = whippedcream.isChecked();

        CheckBox chocolate = (CheckBox) findViewById(R.id.checkBox2);
        boolean addChocolate = chocolate.isChecked();

        int price = calculateprice();



        EditText username = (EditText) findViewById(R.id.UserNameInput);
        String name = username.getText().toString();

        String message = createOrderSummary(price, name ,addWhippedCream, addChocolate);
        displayMessage(message);





    }
    private String createOrderSummary(int price, String username ,boolean addWhippedCream, boolean addChocolate) {

            if (addWhippedCream == true && addChocolate == true) {

                double amount1 = price + (quantity*4);
                String summary = "Hello " + username +
                        "\nIt will cost you $" + amount1
                        + ".\n$" + (quantity*4) + " is charged extra for the Whipped Cream and the Chocolate.\nThank You!";

                return summary;
            } else if (addWhippedCream == true && addChocolate == false) {
                double amount2 = ((price) + (quantity*2));
                String summary = "Hello " + username +
                        "\nIt will cost you $" + amount2
                        + "\n$" + (quantity*2) + " is charged extra for the Whipped Cream.\nThank You!";
                return summary;
            } else if (addWhippedCream == false && addChocolate == true) {
                double amount3 = (price + (quantity*2));
                String summary = "Hello " + username +
                        "\nIt will cost you $" + amount3
                        + "\n$" + (quantity*2) +  " is charged extra for the Chocolate.\nThank You!";
                return summary;
            } else {
                String summary = "Hello " + username +
                        "\nIt will cost you $" + calculateprice() +
                        "\nThank you!";
                return summary;
            }
        }




        public void reset(View view){
        clear();
    }
    private void clear(){
        TextView pay = (TextView)findViewById(R.id.payableamount);
        pay.setText("$0");
        TextView quantities = (TextView)findViewById(R.id.quantity);
        quantities.setText("0");
        TextView ordersum = (TextView)findViewById(R.id.textView);
        ordersum.setText("PRICE");
        quantity = 0;

        EditText name = ((EditText) findViewById(R.id.UserNameInput));
        name.setText(" ");

        CheckBox check = (CheckBox) findViewById(R.id.checkBox);
        check.setChecked(false);

        CheckBox check2 = (CheckBox) findViewById(R.id.checkBox2);
        check2.setChecked(false);



    }
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.payableamount);
        priceTextView.setTextSize(20);
        priceTextView.setText(message);
    }
    private void pricemessagechange(String ordersummary){
        TextView ordersum = (TextView) findViewById(R.id.textView);
        ordersum.setText(ordersummary);
    }
}