package packagename.app.com.appname.core;

import android.app.Application;

import java.util.Arrays;
import java.util.List;

import packagename.app.com.appname.core.module.ApplicationModule;

public class BaseApplication extends Application {

   @Override
   public void onCreate() {
      super.onCreate();
      Injector.init(getModules(), this);
   }

   private List<Object> getModules() {
      return Arrays.<Object>asList(new ApplicationModule(this));
   }
}
