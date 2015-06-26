package packagename.app.com.appname.core.activitiy;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import packagename.app.com.appname.R;

public class ColorStatusBar {

   @TargetApi (Build.VERSION_CODES.KITKAT)
   public static void colorize(@NonNull Activity activity) {
      if (!activity.getResources().getBoolean(R.bool.should_color_status_bar)) {
         return;
      }
      View statusBar = activity.findViewById(R.id.statusBarBackground);
      if (statusBar == null) {
         return;
      }
      Window window = activity.getWindow();
      window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
      int statusBarHeight = getStatusBarHeight(activity);
      if (statusBarHeight != 0) {
         int color = activity.getResources().getColor(R.color.primary_dark);
         statusBar.getLayoutParams().height = +statusBarHeight;
         statusBar.setBackgroundColor(color);
         statusBar.setVisibility(View.VISIBLE);
      } else {
         statusBar.setVisibility(View.GONE);
      }
   }

   private static int getStatusBarHeight(Activity activity) {
      int result = 0;
      int resourceId =
            activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
      if (resourceId > 0) {
         result = activity.getResources().getDimensionPixelSize(resourceId);
      }
      return result;
   }
}
