package com.example.admin.firstproject;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Layout2Activity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout2);

        final EditText receiver = (EditText)findViewById(R.id.receiver_textbox);
        final Button back_btn = (Button)findViewById(R.id.button_back);

        final Button getIt_btn = (Button)findViewById(R.id.button_send);
        Bundle receiver_item = this.getIntent().getExtras();
        final String received_text = receiver_item.getString("text_input");

        receiver.setText(received_text);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent layout_main = new Intent(Layout2Activity.this, MainActivity.class);
                startActivity(layout_main);
                finish();
            }
        });

        getIt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent broadcast_intent = new Intent(Layout2Activity.this, Receiver.class);
                broadcast_intent.putExtra("send_text", received_text);
                sendBroadcast(broadcast_intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_layout2, menu);
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
}
