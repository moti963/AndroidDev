package com.motiky.serviceapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class SmsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        Object[] smsObj = (Object[]) bundle.get("pdus");

        for (Object obj: smsObj) {
            SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) obj);

            String mobNo = smsMessage.getDisplayOriginatingAddress();
            String message = smsMessage.getDisplayMessageBody();
        }
    }
}
