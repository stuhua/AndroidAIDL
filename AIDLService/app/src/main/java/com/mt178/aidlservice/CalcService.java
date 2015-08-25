package com.mt178.aidlservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;


/**
 * Created by Administrator on 2015/8/24.
 */
public class CalcService extends Service {


    @Nullable

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    IMyAidlInterface.Stub mBinder = new IMyAidlInterface.Stub() {

        @Override
        public int add(int x, int y) throws RemoteException {
            return x + y;
        }

        @Override
        public int min(int x, int y) throws RemoteException {
            return x - y;
        }
    };
}
