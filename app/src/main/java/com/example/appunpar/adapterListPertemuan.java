package com.example.appunpar;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.appunpar.databinding.ItemListPengumumanBinding;
import com.example.appunpar.databinding.ItemListPertemuanBinding;

import java.util.List;

public class adapterListPertemuan extends BaseAdapter {
    private static class ViewHolder {
        TextView titleTextView;
        TextView tanggalTextview;
        TextView jamTextview;

    }

    private List<modelPertemuan> appointment;
    private LayoutInflater inflater;

    public adapterListPertemuan(Context context, List<modelPertemuan> appointment) {
        this.appointment = appointment;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return appointment.size();
    }

    @Override
    public modelPertemuan getItem(int position) {
        return appointment.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Dapatkan objek pengumuman saat ini
        modelPertemuan appointment = getItem(position);
// Cek apakah view yang ada sudah digunakan sebelumnya
        adapterListPertemuan.ViewHolder viewHolder;
        if (convertView == null) {
            // Jika belum, inflate layout item_list_pertemuan dan set viewHolder
            ItemListPertemuanBinding binding = ItemListPertemuanBinding.inflate(inflater, parent, false);
            viewHolder = new adapterListPertemuan.ViewHolder();
            viewHolder.titleTextView = binding.title;
            viewHolder.tanggalTextview = binding.tanggalPertemuan;
            viewHolder.jamTextview = binding.jamPertemuan;
            convertView = binding.getRoot();
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (adapterListPertemuan.ViewHolder) convertView.getTag();
        }

        // Set nilai TextViews
        viewHolder.titleTextView.setText(appointment.getTitle());
        //ambil tanggal saja dari appointment.getstart_datetime()
        String tanggal=appointment.getStartDatetime().substring(0,10);
        viewHolder.tanggalTextview.setText(tanggal);
        //ambil jam saja dari appointment.getstart_datetime() dan appointment.getend_datetime() yang dipisah dengan " - "
        String start_time=appointment.getStartDatetime().substring(11,16);
        String end_time=appointment.getEndDatetime().substring(11,16);
        viewHolder.jamTextview.setText(start_time + " - " +end_time);

        return convertView;
    }
}
