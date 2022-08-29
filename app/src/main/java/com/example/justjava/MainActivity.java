package com.example.justjava;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.TextView;

import org.w3c.dom.Text;

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
    public TextView payable(int cup){
        TextView pay = (TextView)findViewById(R.id.payableamount);
        pay.setText("$" + (cup*5));
        return pay;
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
        String ordersumchange = "ORDER SUMMARY";
        pricemessagechange(ordersumchange);

        CheckBox whippedcream = (CheckBox) findViewById(R.id.checkBox);
        boolean addWhippedCream = whippedcream.isChecked();

        CheckBox chocolate = (CheckBox) findViewById(R.id.checkBox2);
        boolean addChocolate = chocolate.isChecked();

        int price = calculateprice();

        String message = createOrderSummary(price, addWhippedCream, addChocolate);
        displayMessage(message);

    }
    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate) {
        if(addWhippedCream == true && addChocolate== true){

            String summary = "\nIt will cost you $" + (price+4)
                    + ".\n$4 is charged extra for the Whipped Cream and the Chocolate.\nThank You!";

            return summary;
        }
        else if(addWhippedCream == true && addChocolate == false) {
            String summary = "\nIt will cost you $" + (price + 2)
                    + "\n$2 is charged extra for the Whipped Cream.\nThank You!";
            return summary;
        }
        else if(addWhippedCream == false && addChocolate == true) {
            String summary = "\nIt will cost you $" + (price + 2)
                    + "\n$2 is charged extra for the Chocolate.\nThank You!";
            return summary;
        }
        else{
            String summary = "\nIt will cost you $" + calculateprice() +
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