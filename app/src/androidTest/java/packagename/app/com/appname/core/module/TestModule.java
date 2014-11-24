package packagename.app.com.appname.core.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import packagename.app.com.appname.core.BaseApplication;
import packagename.app.com.appname.core.SplashScreenTest;

@Module (
      includes = {RootModule.class},
      overrides = true,
      complete = false,
      injects = {SplashScreenTest.class})
public class TestModule {
   private Context context;
   private BaseApplication application;

   public TestModule(Context context) {
      this.context = context;
      this.application = (BaseApplication) context.getApplicationContext();
   }

   @Provides
   @Singleton
   BaseApplication provideBaseApplication() {
      return application;
   }

   @Provides
   @Singleton
   Context provideContext() {
      return context;
   }

   // TODO Override here the injections for Test cases setup.
}
