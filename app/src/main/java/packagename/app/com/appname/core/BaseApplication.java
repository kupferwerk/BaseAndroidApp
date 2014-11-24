package packagename.app.com.appname.core;

import android.app.Application;

import packagename.app.com.appname.core.module.RootModule;

public class BaseApplication extends Application {

   @Override
   public void onCreate() {
      super.onCreate();
      Injector.init(getInjectionModule(), this);
   }

   protected Object getInjectionModule() {
      return new RootModule(this);
   }
}
