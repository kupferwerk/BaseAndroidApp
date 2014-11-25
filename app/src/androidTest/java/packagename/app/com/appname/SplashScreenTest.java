package packagename.app.com.appname;

import android.test.ActivityInstrumentationTestCase2;

import javax.inject.Inject;

import packagename.app.com.appname.core.BaseApplication;
import packagename.app.com.appname.core.TestInjector;

public class SplashScreenTest extends ActivityInstrumentationTestCase2<SplashScreen> {

   @Inject
   BaseApplication application;
   private SplashScreen activity;

   public SplashScreenTest() {
      super(SplashScreen.class);
   }

   public void testCrashTracker() {
      assertNotNull(activity.crashTracker);
   }

   public void testPicasso() throws Exception {
      assertNotNull(activity.picasso);
   }

   public void testRestAdapter() throws Exception {
      assertNotNull(activity.restAdapter);
   }

   @Override
   protected void setUp() throws Exception {
      super.setUp();
      TestInjector.inject(getInstrumentation().getTargetContext(), this);
      activity = getActivity();
   }
}