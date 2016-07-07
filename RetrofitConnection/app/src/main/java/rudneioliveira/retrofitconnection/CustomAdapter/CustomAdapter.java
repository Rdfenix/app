/**
 * Created by rudnei.oliveira on 23/06/2016.
 */

package rudneioliveira.retrofitconnection.CustomAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;
import rudneioliveira.retrofitconnection.R;
import rudneioliveira.retrofitconnection.Users.User;

public class CustomAdapter extends BaseAdapter {
    // lista de variaves para criar o adapter customizado.
    private List<User> users;
    private LayoutInflater mInflater;
    private Context context;

    // seta as variaveis para gerar o contexto e inflar ele
    public CustomAdapter(Context context, List<User> users){
        this.context = context;
        this.users = users;

        mInflater = LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return users.size(); //conta quantos dados serao usados.
    }

    @Override
    public Object getItem(int position) {
        return users.get(position); // verifica a posicao do mesmo
    }

    @Override
    public long getItemId(int position) {
        return position; //pega a posicao dos dados
    }
    // funcao reponsavel por inflar os dados no layput
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyViewHolder myViewHolder;

        if(convertView == null){
            //adapter_row é um xml (layout secundario) feito para receber os dados e transformalos em textview
            convertView = mInflater.inflate(R.layout.adapter_row, parent, false);
            myViewHolder = new MyViewHolder(convertView);
            convertView.setTag(myViewHolder);

        }else{
            myViewHolder = (MyViewHolder) convertView.getTag();
        }

        User user = users.get(position);

        myViewHolder.nome.setText(user.getName());
        myViewHolder.login.setText(user.getLogin());
        myViewHolder.senha.setText(user.getPassword());

        return convertView;
    }
    // parecido com o construct para gerar o transform dos dados.
    private class MyViewHolder{
        TextView nome, login, senha;
        //responsavel por colocar os dados nos devidos lugares.
        public MyViewHolder(View item){
            nome     = (TextView) item.findViewById(R.id.nome);
            login    = (TextView) item.findViewById(R.id.login);
            senha    = (TextView) item.findViewById(R.id.senha);
        }
    }

}
