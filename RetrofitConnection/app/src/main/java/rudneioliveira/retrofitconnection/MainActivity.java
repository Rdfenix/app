package rudneioliveira.retrofitconnection;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rudneioliveira.retrofitconnection.CustomAdapter.CustomAdapter;
import rudneioliveira.retrofitconnection.Users.User;
import rudneioliveira.retrofitconnection.retrofit.api_connection.Connection;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<User> users;
    private CustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //instancia as variaveis contidas no projeto
        listView = (ListView) findViewById(R.id.listID);

        //essa funcao cuida da conexao feita atravez do api gerado.
        Connection.get().getUser().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                // variavel que captura o java object.
                users = response.body();
                // adaptador criado para receber os dados e adicionalos a uma listView
                adapter = new CustomAdapter(MainActivity.this, users);
                //ListView setando o adapter ja com os dados.
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }
}
