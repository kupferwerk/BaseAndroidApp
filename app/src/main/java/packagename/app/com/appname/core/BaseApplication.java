package packagename.app.com.appname.core;

import android.app.Application;

import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import packagename.app.com.appname.core.module.ApplicationModule;

public class BaseApplication extends Application {

   @Inject
   CrashTracker crashTracker;

   @Inject
   Picasso picasso;

   @Override
   public void onCreate() {
      super.onCreate();
      Injector.init(getModules(), this);
      Injector.inject(this);
   }

   private List<Object> getModules() {
      return Arrays.<Object>asList(new ApplicationModule(this));
   }
}
