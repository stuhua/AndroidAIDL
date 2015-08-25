package com.mt178.aidlclient;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mt178.aidlservice.IMyAidlInterface;

public class MainActivity extends AppCompatActivity {
    private IMyAidlInterface mAidl;

    private ServiceConnection mServiceConn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mAidl = IMyAidlInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mAidl = null;
        }
    };


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bindService(View view) {
        Intent intent = new Intent();
        intent.setAction("com.mt178.aidl.calc");
        bindService(intent, mServiceConn, Context.BIND_AUTO_CREATE);
    }

    public void unbindService(View view) {
        unbindService(mServiceConn);
    }

    public void addInvoked(View view) throws Exception {
        if (mAidl != null) {
            int addRes = mAidl.add(12, 12);
            Toast.makeText(this, addRes + "", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "服务器被异常杀死，请重新绑定服务端", Toast.LENGTH_SHORT)
                    .show();

        }
    }


    public void minInvoked(View view) throws Exception {
        if (mAidl != null) {
            int addRes = mAidl.min(58, 12);
            Toast.makeText(this, addRes + "", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "服务端未绑定或被异常杀死，请重新绑定服务端", Toast.LENGTH_SHORT)
                    .show();

        }

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
}
