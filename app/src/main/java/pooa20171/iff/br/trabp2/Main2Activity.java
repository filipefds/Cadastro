package pooa20171.iff.br.trabp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

import io.realm.Realm;
import pooa20171.iff.br.trabp2.adapter.ClickRecyclerViewListener;
import pooa20171.iff.br.trabp2.adapter.ProprietarioAdapter;
import pooa20171.iff.br.trabp2.model.Proprietario;

public class Main2Activity extends AppCompatActivity implements ClickRecyclerViewListener {

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        realm = Realm.getDefaultInstance();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                intent.putExtra("id",0);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(Object object) {
        Proprietario proprietario = (Proprietario) object;
        Intent intent = new Intent(Main2Activity.this,Main3Activity.class);
        intent.putExtra("id",proprietario.getId());
        startActivity(intent);

    }

    private List<Proprietario> getProprietarios(){

        return (List)realm.where(Proprietario.class).findAll();

    }

    protected void onResume() {
        super.onResume();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcv);

        recyclerView.setAdapter(new ProprietarioAdapter(getProprietarios(),this,this));
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layout);


    }

    @Override
    public void finish(){
        realm.close();

    }

}
