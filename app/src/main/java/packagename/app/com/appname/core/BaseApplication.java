package packagename.app.com.appname.core;

import android.app.Application;

import com.squareup.picasso.Picasso;

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
      Injector.init(getRootModule(), this);
   }

   private Object getRootModule() {
      return new ApplicationModule(this);
   }
}
