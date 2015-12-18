package college.edu.tomer.recyclerviewadvanced;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.etAdd)
    EditText etAdd;
    @Bind(R.id.btnAdd)
    Button btnAdd;
    @Bind(R.id.addNew)
    LinearLayout addNew;
    @Bind(R.id.mRecycler)
    RecyclerView mRecycler;
    @Bind(R.id.fab)
    FloatingActionButton fab;

    //Private data members:
    private MRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        initViews();
    }

    @OnClick(R.id.btnAdd)
    void addNew() {
        if (etAdd.getText().toString().length() > 0) {
            adapter.addNew(etAdd.getText().toString());
            etAdd.setText("");
        }
    }


    @OnClick(R.id.fab)
    void fabClicked(View v) {
        Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }


    private void initViews() {
        ArrayList<String> data = new ArrayList<>();
        data.add("Hello");
        data.add("World");
        data.add("Hello");
        data.add("World");
        data.add("Hello");
        data.add("World");
        data.add("Hello");

        adapter = new MRecyclerAdapter(data, mRecycler);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.setAdapter(adapter);


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
