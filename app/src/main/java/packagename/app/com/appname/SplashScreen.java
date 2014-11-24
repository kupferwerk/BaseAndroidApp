package packagename.app.com.appname;

import android.os.Bundle;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import packagename.app.com.appname.core.BaseActivity;
import packagename.app.com.appname.core.CrashTracker;
import retrofit.RestAdapter;

public class SplashScreen extends BaseActivity {

   @Inject
   Picasso picasso;

   @Inject
   RestAdapter restAdapter;

   @Inject
   CrashTracker crashTracker;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      setContentView(R.layout.splash_screen_activity);
      super.onCreate(savedInstanceState);
   }
}
