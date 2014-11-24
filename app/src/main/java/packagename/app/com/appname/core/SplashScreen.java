package packagename.app.com.appname.core;

import android.os.Bundle;

import packagename.app.com.appname.R;

public class SplashScreen extends BaseActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      setContentView(R.layout.splash_screen_activity);
      super.onCreate(savedInstanceState);
   }
}
