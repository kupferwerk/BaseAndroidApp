package packagename.app.com.appname.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import net.hockeyapp.android.CrashManager;
import net.hockeyapp.android.CrashManagerListener;
import net.hockeyapp.android.Tracking;
import net.hockeyapp.android.UpdateManager;

import packagename.app.com.appname.BuildConfig;
import packagename.app.com.appname.R;

public class CrashTrackerLogger implements Application.ActivityLifecycleCallbacks {
   private final Application application;

   public CrashTrackerLogger(Application inApplication) {
      this.application = inApplication;
   }

   public void init() {
      CrashManager.register(application, application.getString(R.string.hockey_app_id),
            new CrashManagerListener() {

               @Override
               public boolean shouldAutoUploadCrashes() {
                  return true;
               }
            });
   }

   @Override
   public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

   }

   @Override
   public void onActivityDestroyed(Activity activity) {

   }

   @Override
   public void onActivityPaused(Activity activity) {
      Tracking.stopUsage(activity);
   }

   @Override
   public void onActivityResumed(final Activity activity) {
      if (BuildConfig.DEBUG) {
         UpdateManager.register(activity, application.getString(R.string.hockey_app_id));
      }
      Tracking.startUsage(activity);
      //      View viewById = activity.findViewById(R.id.btn_feedback);
      //      if (viewById != null) {
      //         viewById.setOnClickListener(new View.OnClickListener() {
      //            @Override
      //            public void onClick(View v) {
      //               FeedbackManager.register(activity, activity.getString(R.string
      // .hockey_app_id), null);
      //               FeedbackManager.showFeedbackActivity(activity);
      //            }
      //         });
      //      }
   }

   @Override
   public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

   }

   @Override
   public void onActivityStarted(Activity activity) {

   }

   @Override
   public void onActivityStopped(Activity activity) {

   }
}
