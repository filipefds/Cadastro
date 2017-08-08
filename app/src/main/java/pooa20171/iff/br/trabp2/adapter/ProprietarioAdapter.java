package pooa20171.iff.br.trabp2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pooa20171.iff.br.trabp2.R;
import pooa20171.iff.br.trabp2.model.Proprietario;

/**
 * Created by filipefds on 07/08/17.
 */

public class ProprietarioAdapter extends RecyclerView.Adapter {
    private List<Proprietario> proprietarios;
    private Context context;
    private static ClickRecyclerViewListener clickRecyclerViewListener;

    public ProprietarioAdapter(List<Proprietario> proprietarios, Context context, ClickRecyclerViewListener clickRecyclerViewListener) {
        this.proprietarios = proprietarios;
        this.context = context;
        this.clickRecyclerViewListener = clickRecyclerViewListener;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_proprietario, parent, false);
        ProprietarioViewHolder proprietarioViewHolder = new ProprietarioViewHolder(view);
        return proprietarioViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        ProprietarioViewHolder holder = (ProprietarioViewHolder) viewHolder;

        Proprietario proprietario = proprietarios.get(position);

        holder.nome.setText(proprietario.getNome());
        holder.endereco.setText(proprietario.getEndereco());
        holder.bairro.setText(proprietario.getBairro());
        holder.cidade.setText(proprietario.getCidade());
        holder.cnh.setText(proprietario.getCnh());
        holder.telefone.setText(proprietario.getTelefone());
        holder.email.setText(proprietario.getEmail());
        holder.latitude.setText(proprietario.getLatitude());
        holder.longitude.setText(proprietario.getLongitude());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private class ProprietarioViewHolder extends RecyclerView.ViewHolder {

        private final TextView nome;
        private final TextView endereco;
        private final TextView bairro;
        private final TextView cidade;
        private final TextView cnh;
        private final TextView telefone;
        private final TextView email;
        private final TextView latitude;
        private final TextView longitude;

        public ProprietarioViewHolder(View itemView) {
            super(itemView);
            nome = (TextView) itemView.findViewById(R.id.nome);
            endereco = (TextView) itemView.findViewById(R.id.endereco);
            bairro = (TextView) itemView.findViewById(R.id.bairro);
            cidade = (TextView) itemView.findViewById(R.id.cidade);
            cnh = (TextView) itemView.findViewById(R.id.cnh);
            telefone = (TextView) itemView.findViewById(R.id.telefone);
            email = (TextView) itemView.findViewById(R.id.email);
            latitude = (TextView) itemView.findViewById(R.id.latitude);
            longitude = (TextView) itemView.findViewById(R.id.longitude);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickRecyclerViewListener.onClick(proprietarios.get(getAdapterPosition()));
                }
            });

        }
    }
}
