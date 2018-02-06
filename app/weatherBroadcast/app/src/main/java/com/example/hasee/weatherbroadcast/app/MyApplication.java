package com.example.hasee.weatherbroadcast.app;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hasee.weatherbroadcast.R;

/**
 * Created by hasee on 2018/1/27.
 */

public class MyApplication {
    public static TextView cityTv, timeTv, humidityTv, weekTv, pmDataTv, pmQualityTv,
            temperatureTv, climateTv, windTv;
    public static ImageView weatherImg, pmImg;

    public static void init(View view){
        TextView t = (TextView) view.findViewById(R.id.city);
        t.setText(cityTv.getText());
        t = (TextView) view.findViewById(R.id.time);
        t.setText(timeTv.getText());
        t = (TextView)view.findViewById(R.id.humidity);
        t.setText(humidityTv.getText());
        t = (TextView) view.findViewById(R.id.week_today);
        t.setText(weekTv.getText());
        t = (TextView) view.findViewById(R.id.pm_data);
        t.setText(pmDataTv.getText());
        t = (TextView) view.findViewById(R.id.pm2_5_quality);
        t.setText(pmQualityTv.getText());
        t = (TextView) view.findViewById(R.id.temperature);
        t.setText(temperatureTv.getText());
        t = (TextView) view.findViewById(R.id.climate);
        t.setText(climateTv.getText());
        t = (TextView) view.findViewById(R.id.wind);
        t.setText(windTv.getText());
        ImageView i=(ImageView) view.findViewById(R.id.pm2_5_img);
        i.setImageDrawable(pmImg.getDrawable());
        i=(ImageView) view.findViewById(R.id.weather_img);
        i.setImageDrawable(weatherImg.getDrawable());
        i=(ImageView)view.findViewById(R.id.pm2_5_img);
        i.setImageDrawable(pmImg.getDrawable());
    }
}
