// IMyAidlInterface.aidl
package com.mt178.aidlservice;

// Declare any non-default types here with import statements

interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
   int add(int x,int y);
   int min(int x,int y);
}
