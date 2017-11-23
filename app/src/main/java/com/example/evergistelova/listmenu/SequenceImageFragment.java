package com.example.evergistelova.listmenu;

import android.app.Fragment;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class SequenceImageFragment extends Fragment {

    Point point = null;
    ImageView img;
    List listImages;
    int currentIndex;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.sequence_image, container, false);

        img = (ImageView) view.findViewById(R.id.image1);
        System.out.println("img = "+img.getDrawable());

        listImages = new ArrayList();
        listImages.add(R.drawable.image1);
        listImages.add(R.drawable.image2);
        listImages.add(R.drawable.image3);
        listImages.add(R.drawable.image4);
        listImages.add(R.drawable.image5);

        currentIndex = 0;

        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                point = new Point();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        point.x = (int)event.getX();
                        point.y = (int)event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        point.x = (int)event.getX();
                        point.y = (int)event.getY();
                        break;
                    case MotionEvent.ACTION_UP :
                        if (event.getX() > 0 && event.getX() < view.getWidth()/2) {
                            if (currentIndex > 0 && currentIndex <= 4) {
                                img.setImageResource((int)listImages.get(currentIndex-1));
                                currentIndex--;
                            }
                        }
                        if ( event.getX() >= view.getWidth()/2) {
                            if (currentIndex >= 0 && currentIndex < 4) {
                                img.setImageResource((int)listImages.get(currentIndex+1));
                                currentIndex++;
                            }
                        }
                        point = null;
                        break;
                    default :
                        break;
                }
                return true;
            }
        });
        return view;
    }
}
