package packagename.app.com.appname.core;

import android.app.Activity;
import android.os.Bundle;

import packagename.app.com.appname.R;

public class SplashScreen extends Activity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.splash_screen_activity);
   }
}
