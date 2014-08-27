package hu.icss.sqlightexperiment;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;


public class SqlightActivity extends Activity {
	MyDBAdapter dbAdapter;
	ListView list;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlight);
        
        final Spinner faculties = (Spinner) findViewById(R.id.faculties_spinner);
        final EditText studentName = (EditText) findViewById(R.id.student_name);
        Button addStudent = (Button) findViewById(R.id.add_student);
        Button deleteEngineers = (Button) findViewById(R.id.delete_engineers);
        list = (ListView) findViewById(R.id.student_list);
        
        dbAdapter = new MyDBAdapter(SqlightActivity.this);
        dbAdapter.open();
        // Fill the spinner with 3 faculty values
        String[] allFaculties = {"Engineering","Business","Arts"};
        faculties.setAdapter(new ArrayAdapter<String>(SqlightActivity.this,android.R.layout.simple_list_item_1,allFaculties));
        loadList();
        
        addStudent.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v){
        		dbAdapter.insertStudent(studentName.getText().toString(),faculties.getSelectedItemPosition() +1);
        		loadList();
        	}
        });
        deleteEngineers.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dbAdapter.deleteAllEngineers();
				loadList();
			}
		});
    }
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sqlight, menu);
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
    
    public void loadList(){
		ArrayList<String> allStudents = new ArrayList<String>();
		allStudents = dbAdapter.selectAllStudents();
		
		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				SqlightActivity.this,android.R.layout.simple_list_item_1, allStudents);
		
		list.setAdapter(adapter);
	}
}
