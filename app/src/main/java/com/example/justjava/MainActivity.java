package com.example.justjava;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);


    }

    private void display(int number){
        TextView quantityTextview = (TextView)findViewById(R.id.quantity);
        quantityTextview.setText("" + number);
    }
    private void payable(int cup){
        TextView pay = (TextView)findViewById(R.id.payableamount);
        pay.setText("$" + (cup*5));
    }



    public void increment(View view) {


        quantity += 1;
        display(quantity);
        payable(quantity);
    }

    public void decrement(View view){

        quantity -= 1;
        display(quantity);
        payable(quantity);

    }
    private int calculateprice(){
        int price = quantity*5;
        return price;

    }
    public void submitorder(View view){
        String pricemessage = "It will cost you $" + calculateprice() + "\nThank you!";
        String ordersumchange = "ORDER SUMMARY";
        displayMessage(pricemessage);
        pricemessagechange(ordersumchange);
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
    }
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.payableamount);
        priceTextView.setText(message);
    }
    private void pricemessagechange(String ordersummary){
        TextView ordersum = (TextView) findViewById(R.id.textView);
        ordersum.setText(ordersummary);
    }
}