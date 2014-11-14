package packagename.app.com.appname.core.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import packagename.app.com.appname.core.BaseApplication;
import packagename.app.com.appname.core.CrashTracker;

@Module (injects = {BaseApplication.class})
public class ApplicationModule {
   private BaseApplication app;

   public ApplicationModule(BaseApplication app) {
      this.app = app;
   }

   @Provides
   @Singleton
   public CrashTracker provideCrashTracker() {
      CrashTracker crashTracker = new CrashTracker(app);
      crashTracker.init();
      return crashTracker;
   }
}
