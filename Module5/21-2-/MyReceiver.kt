package com.example.sensorex

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent)
    {
        if(intent.action.equals(Intent.ACTION_AIRPLANE_MODE_CHANGED))
        {
            Toast.makeText(context, "Airplane Mode Changed", Toast.LENGTH_SHORT).show();
        }
    }
}