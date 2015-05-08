package packagename.app.com.appname.core.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import packagename.app.com.appname.core.BaseApplication;
import packagename.app.com.appname.core.CrashTracker;

@Module (complete = false, library = true)
public class ApplicationModule {

   @Provides
   @Singleton
   CrashTracker provideCrashTracker(BaseApplication application) {
      CrashTracker crashTracker = new CrashTracker(application);
      crashTracker.init();
      return crashTracker;
   }

   /* TODO: Add here more application specific provided objects. */
}
