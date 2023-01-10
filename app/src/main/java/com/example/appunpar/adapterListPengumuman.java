package com.example.appunpar;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.appunpar.databinding.ItemListPengumumanBinding;

import java.util.List;

public class adapterListPengumuman extends BaseAdapter {
    private static class ViewHolder {
        TextView titleTextView;
        TextView tagsTextView;
    }

    private List<modelPengumuman> announcements;
    private LayoutInflater inflater;

    public adapterListPengumuman(Context context, List<modelPengumuman> announcements) {
        this.announcements = announcements;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return announcements.size();
    }

    @Override
    public modelPengumuman getItem(int position) {
        return announcements.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Dapatkan objek pengumuman saat ini
        modelPengumuman announcement = getItem(position);

        // Cek apakah view yang ada sudah digunakan sebelumnya
        ViewHolder viewHolder;
        if (convertView == null) {
            // Jika belum, inflate layout item_list_pengumuman dan set viewHolder
            ItemListPengumumanBinding binding = ItemListPengumumanBinding.inflate(inflater, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.titleTextView = binding.judulPengumuman;
            viewHolder.tagsTextView = binding.tag;
            convertView = binding.getRoot();
            convertView.setTag(viewHolder);
        } else {
            // Jika sudah, ambil viewHolder yang sudah ada
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Set nilai TextViews
        viewHolder.titleTextView.setText(announcement.getTitle());
        viewHolder.tagsTextView.setText(TextUtils.join(", ", announcement.getTags()));
        return convertView;
    }
}