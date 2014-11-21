package packagename.app.com.appname.core;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import packagename.app.com.appname.R;

public class SplashScreen extends ActionBarActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      Injector.inject(this);
      setContentView(R.layout.splash_screen_activity);
      setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
   }
}
