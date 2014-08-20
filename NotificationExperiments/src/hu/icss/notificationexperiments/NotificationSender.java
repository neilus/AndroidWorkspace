package hu.icss.notificationexperiments;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class NotificationSender extends Activity {
	private Button notifyBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_sender);
        notifyBtn = (Button) findViewById(R.id.notifyer_btn);
        notifyBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				createNotification(v);
				
			}
        	
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.notification_sender, menu);
        return true;
    }
    
    public void createNotification(View view){
    	NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    	Notification notification = new Notification(R.drawable.ic_launcher, "A new notification", System.currentTimeMillis());
    	notification.flags |= Notification.FLAG_AUTO_CANCEL;
    	
    	Intent intent = new Intent(this, NotificationReciever.class);
    	PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 0);
    	notification.setLatestEventInfo(this, "This is the title", "This is the text", activity);
    	notification.number ++;
    	
    	notificationManager.notify(0, notification);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
