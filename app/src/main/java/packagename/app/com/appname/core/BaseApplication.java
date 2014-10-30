package packagename.app.com.appname.core;

import android.app.Application;

public class BaseApplication extends Application {

   @Override
   public void onCreate() {
      super.onCreate();
      initCrashTracker();
   }

   private void initCrashTracker() {
      CrashTrackerLogger crashLogger = new CrashTrackerLogger(this);
      crashLogger.init();
      registerActivityLifecycleCallbacks(crashLogger);
   }
}
