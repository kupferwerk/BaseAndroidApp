package packagename.app.com.appname.core;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import packagename.app.com.appname.R;
import packagename.app.com.appname.core.activitiy.behaviours.ActionBarBehavior;
import packagename.app.com.appname.core.activitiy.behaviours.StandardToolBarBehavior;

public abstract class BaseActivity extends AppCompatActivity {

   /**
    * The usage of this method is not allowed when using BaseActivity, because this base
    * implementation already inflates a layout with a toolbar. Override method getLayoutResourceId()
    * to inflate your custom activity layout within the BaseActivity's container. Delete this method
    * if you do not want this behaviour.
    *
    * @param layoutResId the layout to inflate.
    */
   @Override
   public void setContentView(int layoutResId) {
      throw new IllegalArgumentException("Method setContentView is not allowed when" +
            " using BaseActivity. Use method getLayoutResourceId() instead.");
   }

   protected ActionBarBehavior getActionBarBehavior() {
      return new StandardToolBarBehavior();
   }

   protected abstract int getLayoutResourceId();

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      super.setContentView(R.layout.activity_base);
      getActionBarBehavior().apply(this);
      setStatusBarColor();
      inflateActivityLayout();
   }

   private int getStatusBarHeight() {
      int result = 0;
      int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
      if (resourceId > 0) {
         result = getResources().getDimensionPixelSize(resourceId);
      }
      return result;
   }

   private void inflateActivityLayout() {
      final ViewGroup container = (ViewGroup) findViewById(R.id.container);
      getLayoutInflater().inflate(getLayoutResourceId(), container, true);
   }

   @TargetApi (Build.VERSION_CODES.KITKAT)
   private void setStatusBarColor() {
      if (!getResources().getBoolean(R.bool.should_color_status_bar)) {
         return;
      }
      View statusBar = findViewById(R.id.statusBarBackground);
      if (statusBar == null) {
         return;
      }
      Window window = getWindow();
      window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
      int statusBarHeight = getStatusBarHeight();
      if (statusBarHeight != 0) {
         int color = getResources().getColor(R.color.primary_dark);
         statusBar.getLayoutParams().height = +statusBarHeight;
         statusBar.setBackgroundColor(color);
         statusBar.setVisibility(View.VISIBLE);
      } else {
         statusBar.setVisibility(View.GONE);
      }
   }
}
