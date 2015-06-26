package packagename.app.com.appname.core;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import packagename.app.com.appname.R;
import packagename.app.com.appname.core.activitiy.ColorStatusBar;
import packagename.app.com.appname.core.activitiy.behaviours.ActionBarBehavior;
import packagename.app.com.appname.core.activitiy.behaviours.StandardToolBarBehavior;

public abstract class BaseActivity extends AppCompatActivity {

   private static final int INVALID_LAYOUT_ID = -1;

   protected ActionBarBehavior getActionBarBehavior() {
      return new StandardToolBarBehavior();
   }

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
      }
      final ActionBarBehavior behavior = getActionBarBehavior();
      if (behavior != null) {
         behavior.apply(this);
      }
      ColorStatusBar.colorize(this);
   }

   @LayoutRes
   private void initStandardView(int layoutResourceId) {
      setContentView(R.layout.activity_base);
      final ViewGroup container = (ViewGroup) findViewById(R.id.container);
      getLayoutInflater().inflate(layoutResourceId, container, true);
   }
}
