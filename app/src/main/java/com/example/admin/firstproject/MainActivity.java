package com.example.admin.firstproject;

import android.app.AlertDialog;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.DialogInterface;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText textField = (EditText)findViewById(R.id.editText);
        final TextView textView = (TextView)findViewById(R.id.textView);

        Button pressButton = (Button)findViewById(R.id.press_this);

        pressButton.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                AlertDialog.Builder alertBox = new AlertDialog.Builder(MainActivity.this);
                alertBox.setTitle("Alert box");
                alertBox.setMessage("Hey you clicked me");
                alertBox.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                //alertBox.show();
                String textField_text = textField.getText().toString();
                if (textField_text.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please input your text", Toast.LENGTH_LONG).show();
                }
                else{
                    textView.setText(textField_text);
                    Toast.makeText(getApplicationContext(), "Well done! congratulation", Toast.LENGTH_LONG).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("text_input", textField_text);
                    Intent intent = new Intent(MainActivity.this, Layout2Activity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
                }
            }
        });

        Button playBtn = (Button)findViewById(R.id.button_play);
        playBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindService(new Intent(MainActivity.this, FirstService.class), mConnection, Context.BIND_AUTO_CREATE);
        mBoundService.startPlayer();
        }
        });

        Button stopBtn = (Button)findViewById(R.id.button_stop);
        stopBtn.setOnClickListener(new Button.OnClickListener() {
@Override
public void onClick(View v) {
        mBoundService.stopPlayer();
        }
        });
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

private FirstService mBoundService;
private ServiceConnection mConnection = new ServiceConnection() {
@Override
public void onServiceConnected(ComponentName name, IBinder service) {
        mBoundService = ((FirstService.LocalBinder)service).getService();
        }

@Override
public void onServiceDisconnected(ComponentName name) {
        mBoundService = null;
        }
        };
        }
