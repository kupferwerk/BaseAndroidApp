package packagename.app.com.appname.core;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;

import packagename.app.com.appname.R;
import packagename.app.com.appname.core.activitiy.AdjustStatusbar;

/**
 * Extend this class if you have a standard action bar behaviour. You have to override
 * getLayoutResourceId to benefit from this base activity. If you want to draw and handle the
 * actionbar yourself for example with a coordinator layout do not extend this activity.
 */
public abstract class BaseActionBarActivity extends AppCompatActivity {

   private static final int INVALID_LAYOUT_ID = -1;

   @LayoutRes
   protected int getLayoutResourceId() {
      return INVALID_LAYOUT_ID;
   }

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      final int layoutResourceId = getLayoutResourceId();
      if (layoutResourceId != INVALID_LAYOUT_ID) {
         initStandardView(layoutResourceId);
         final View toolBarView = findViewById(R.id.toolbar);
         if (toolBarView != null) {
            setSupportActionBar((Toolbar) toolBarView);
         }
         AdjustStatusbar.addColorAndHeight(this);
      }
   }

   @LayoutRes
   private void initStandardView(int layoutResourceId) {
      setContentView(R.layout.activity_base);
      final ViewGroup container = (ViewGroup) findViewById(R.id.container);
      getLayoutInflater().inflate(layoutResourceId, container, true);
   }
}
