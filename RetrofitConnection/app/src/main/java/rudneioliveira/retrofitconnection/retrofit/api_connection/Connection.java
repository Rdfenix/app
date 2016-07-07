/**
 * Created by rudnei.oliveira on 23/06/2016.
 */
package rudneioliveira.retrofitconnection.retrofit.api_connection;
import java.util.List;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import rudneioliveira.retrofitconnection.Users.User;

public class Connection {

    private static String URL = "http://192.168.0.217:3000"; // caminho gerado pelo API node transformando os dados do banco em JSON
    private static Retrofit restAdapter = null; // adaptador do plugin Retrofit.

    //funcao que captura os dados do json e transforma os dados em java object.
    public static getAllApi get(){
        if(restAdapter == null){
            restAdapter = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return restAdapter.create(getAllApi.class);
    }
//interface que captura os dados atras do caminho informado na url, exemplo : http://192.168.0.217:3000/result
    public interface getAllApi{
        @GET("/")
        Call<List<User>> getUser();
    }
}
