package pooa20171.iff.br.trabp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import pooa20171.iff.br.trabp2.model.Proprietario;

public class Main3Activity extends AppCompatActivity {

    EditText nome, endereco, bairro, cidade, cnh, telefone, email, latitude, longitude;
    Button btnSalvar, btnDeletar, btnEditar;
    int id;
    Proprietario proprietario;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        nome = (EditText) findViewById(R.id.det_nome);
        bairro = (EditText) findViewById(R.id.det_bairro);
        endereco = (EditText) findViewById(R.id.det_endereco);
        cidade = (EditText) findViewById(R.id.det_cidade);
        cnh = (EditText) findViewById(R.id.det_cnh);
        telefone = (EditText) findViewById(R.id.det_telefone);
        email = (EditText) findViewById(R.id.det_email);
        latitude = (EditText) findViewById(R.id.det_latitude);
        longitude = (EditText) findViewById(R.id.det_longitude);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        btnDeletar = (Button) findViewById(R.id.btnDeletar);
        btnEditar = (Button) findViewById(R.id.btnEditar);

        Intent intent = getIntent();
        id = (int) intent.getSerializableExtra("id");
        realm = Realm.getDefaultInstance();

        if (id != 0) {
            btnSalvar.setEnabled(false);
            btnSalvar.setClickable(false);
            btnSalvar.setVisibility(View.INVISIBLE);
            proprietario = realm.where(Proprietario.class).equalTo("id", id).findFirst();

            nome.setText(proprietario.getNome());
            bairro.setText(proprietario.getBairro());
            endereco.setText(proprietario.getEndereco());
            cidade.setText(proprietario.getCidade());
            cnh.setText(proprietario.getCnh());
            telefone.setText(proprietario.getTelefone());
            email.setText(proprietario.getEmail());
            latitude.setText(proprietario.getLatitude());
            longitude.setText(proprietario.getLongitude());


        } else {
            btnEditar.setEnabled(false);
            btnEditar.setClickable(false);
            btnEditar.setVisibility(View.INVISIBLE);
            btnEditar.setEnabled(false);
            btnEditar.setClickable(false);
            btnEditar.setVisibility(View.INVISIBLE);

        }

        btnSalvar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                salvar();
            }
        });

        btnEditar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                editar();
            }
        });

        btnDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deletar();
            }
        });

    }


    public void salvar() {

        int proximoID = 1;
        if(realm.where(Proprietario.class).max("id") !=null)
            proximoID = realm.where(Proprietario.class).max("id").intValue()+1;

        realm.beginTransaction();
        Proprietario proprietario = new Proprietario();
        proprietario.setId(proximoID);
        proprietario.setNome(nome.getText().toString());
        proprietario.setNome(bairro.getText().toString());
        proprietario.setNome(endereco.getText().toString());
        proprietario.setNome(cidade.getText().toString());
        proprietario.setNome(cnh.getText().toString());
        proprietario.setNome(telefone.getText().toString());
        proprietario.setNome(email.getText().toString());
        proprietario.setNome(latitude.getText().toString());
        proprietario.setNome(longitude.getText().toString());

        realm.copyToRealm(proprietario);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Proprietario Cadastrado",Toast.LENGTH_LONG).show();
        this.finish();

    }
    public void editar() {

        realm.beginTransaction();

        proprietario.setNome(nome.getText().toString());
        proprietario.setNome(bairro.getText().toString());
        proprietario.setNome(endereco.getText().toString());
        proprietario.setNome(cidade.getText().toString());
        proprietario.setNome(cnh.getText().toString());
        proprietario.setNome(telefone.getText().toString());
        proprietario.setNome(email.getText().toString());
        proprietario.setNome(latitude.getText().toString());
        proprietario.setNome(longitude.getText().toString());

        realm.copyToRealm(proprietario);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Proprietario editado",Toast.LENGTH_LONG).show();
        this.finish();

    }

    public void deletar(){
        realm.beginTransaction();
        proprietario.deleteFromRealm();
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Proprietario deletado",Toast.LENGTH_LONG).show();
        this.finish();

    }

}
