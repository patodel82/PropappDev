package icaro.mapus;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.model.LatLng;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Pato&Agus on 6/8/2017.
 */

public class ViewPagerAdapter extends PagerAdapter  {
    Context context;
    Integer [] images1 = {R.drawable.prop1,R.drawable.prop2};
    Integer [] images2 = {R.drawable.prop3,R.drawable.prop2};
    LayoutInflater inflater;
    public ViewPagerAdapter(Context context, Bundle b) {
        this.context = context;
int a=2;
    }
    @Override
    public int getCount() {
        return images1.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

@Override
    public Object instantiateItem(ViewGroup container, int position) {
        // Declare Variables
        ImageView imgflag;
        inflater = (LayoutInflater) context .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.viewpager_item, container,
                false);
        // Locate the ImageView in viewpager_item.xml
        imgflag = (ImageView) itemView.findViewById(R.id.photos);
        // Capture position and set to the ImageView
        String smarker = Filters.getmarker();
        switch (smarker){ case "1":imgflag.setImageResource(images1[position]);break;
            case "2" :imgflag.setImageResource(images2[position]);break;}
        // Add viewpager_item.xml to ViewPager
        ((ViewPager) container).addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
        ((ViewPager) container).removeView((RelativeLayout) object);

    }
}
