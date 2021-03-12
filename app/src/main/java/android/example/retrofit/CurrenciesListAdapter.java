package android.example.retrofit;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CurrenciesListAdapter extends ArrayAdapter<Currencies> {
    private Context context;
    int resource;

    public CurrenciesListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Currencies> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name = getItem(position).getCur_Name();
        String value = getItem(position).getCur_Scale()
                        + " " + getItem(position).getCur_Abbreviation()
                        + " = " + getItem(position).getCur_OfficialRate();
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource, parent, false);

        ImageView image = (ImageView) convertView.findViewById(R.id.imageView);
        TextView tName = (TextView) convertView.findViewById(R.id.cur_name);
        TextView tValue = (TextView) convertView.findViewById(R.id.cur_value);

        tName.setText(name);
        tValue.setText(value);

        if(position % 2 == 0){
            image.setImageDrawable(convertView.getResources().getDrawable(R.drawable.france));
        }else if(position % 3 == 0){
            image.setImageDrawable(convertView.getResources().getDrawable(R.drawable.russia));
        }else {
            image.setImageDrawable(convertView.getResources().getDrawable(R.drawable.german));
        }
        return convertView;
    }
}
