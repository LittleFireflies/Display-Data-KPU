package id.sch.smktelkom_mlg.learn.datakpu.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.learn.datakpu.JSONResponse;
import id.sch.smktelkom_mlg.learn.datakpu.R;
import id.sch.smktelkom_mlg.learn.datakpu.model.Data;

/**
 * Created by LittleFireflies on 10-Dec-16.
 */

public class CandidacyAdapter extends RecyclerView.Adapter<CandidacyAdapter.ViewHolder> {
    private ArrayList<JSONResponse> candidacyList;
    private ArrayList<Data> dataList;

    public CandidacyAdapter(ArrayList<JSONResponse> candidacyList) {
        this.candidacyList = candidacyList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_candidacy, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvNoUrut.setText(candidacyList.get(position).getData().getNourut());
        holder.tvCalon.setText(candidacyList.get(position).getData().getCalon());
        holder.tvWakil.setText(candidacyList.get(position).getData().getWakil());
        holder.tvCandidacy.setText("Provinsi "
                + candidacyList.get(position).getData().getProvinsi()
                + " Dapil "
                + candidacyList.get(position).getData().getDapil());
    }

    @Override
    public int getItemCount() {
        return candidacyList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvCandidacy;
        private TextView tvNoUrut;
        private TextView tvCalon;
        private TextView tvWakil;

        public ViewHolder(View itemView) {
            super(itemView);

            tvCandidacy = (TextView) itemView.findViewById(R.id.tvCandidacy);
            tvNoUrut = (TextView) itemView.findViewById(R.id.tvNoUrut);
            tvCalon = (TextView) itemView.findViewById(R.id.tvCalon);
            tvWakil = (TextView) itemView.findViewById(R.id.tvWakil);
        }
    }
}
