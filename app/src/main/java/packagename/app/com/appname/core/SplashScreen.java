package packagename.app.com.appname.core;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import packagename.app.com.appname.R;
import retrofit.RestAdapter;

public class SplashScreen extends ActionBarActivity {

   @Inject
   Picasso picasso;

   @Inject
   RestAdapter restAdapter;

   @Inject
   CrashTracker crashTracker;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      Injector.inject(this);
      setContentView(R.layout.splash_screen_activity);
      setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
   }
}
