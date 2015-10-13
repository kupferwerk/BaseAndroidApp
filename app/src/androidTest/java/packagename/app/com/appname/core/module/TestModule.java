package packagename.app.com.appname.core.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Provides;
import packagename.app.com.appname.core.BaseApplication;

@Component (modules = { ApplicationModule.class, WebserviceModule.class })
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
