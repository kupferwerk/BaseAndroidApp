package packagename.app.com.appname.core;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;

import packagename.app.com.appname.R;

public class SplashScreen extends ActionBarActivity {

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      return super.onCreateOptionsMenu(menu);
   }

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      Injector.inject(this);
      setContentView(R.layout.splash_screen_activity);
   }
}
