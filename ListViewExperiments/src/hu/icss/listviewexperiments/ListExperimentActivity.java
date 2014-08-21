package hu.icss.listviewexperiments;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ListExperimentActivity extends Activity {
	private String[] theList = new String[]{"1st item", "2nd list item", "3rd item"};
	private ArrayAdapter adapterList;
	private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_experiment);
        
        listView = (ListView) findViewById(R.id.listView1);
        adapterList = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1);
        listView.setAdapter(adapterList);
        for (int i = 0; i < theList.length; i++) {
			adapterList.add(theList[i]);
		}
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list_experiment, menu);
        return true;
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
