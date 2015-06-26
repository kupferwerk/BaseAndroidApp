package packagename.app.com.appname.core.activitiy.behaviours;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import packagename.app.com.appname.R;
import packagename.app.com.appname.core.activitiy.behaviours.ActionBarBehavior;

public class StandardToolBarBehavior implements ActionBarBehavior {

   @Override
   public void apply(AppCompatActivity activity) {
      final View toolBarView = activity.findViewById(R.id.toolbar);
      if (toolBarView != null) {
         activity.setSupportActionBar((Toolbar) toolBarView);
      }
   }
}
