package packagename.app.com.appname.core.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import packagename.app.com.appname.core.BaseApplication;
import packagename.app.com.appname.core.CrashTracker;

@Module
public class ApplicationModule {

   private final Context context;
   private final BaseApplication application;

   public ApplicationModule(BaseApplication application) {
      this.application = application;
      this.context = application.getApplicationContext();
   }

   @Provides
   @Singleton
   CrashTracker provideCrashTracker(BaseApplication application) {
      CrashTracker crashTracker = new CrashTracker(application);
      crashTracker.init();
      return crashTracker;
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

   /* TODO: Add here more application specific provided objects. */
}
