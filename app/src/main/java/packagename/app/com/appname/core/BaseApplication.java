package packagename.app.com.appname.core;

import android.app.Application;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import packagename.app.com.appname.core.module.ApplicationModule;

public class BaseApplication extends Application {

   @Inject
   CrashTracker crashTracker;

   @Override
   public void onCreate() {
      super.onCreate();
      Injector.init(getModules(), this);
   }

   private List<Object> getModules() {
      return Arrays.<Object>asList(new ApplicationModule(this));
   }
}
