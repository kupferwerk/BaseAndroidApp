package packagename.app.com.appname.core;

import android.test.ActivityInstrumentationTestCase2;

import javax.inject.Inject;

public class SplashScreenTest extends ActivityInstrumentationTestCase2<SplashScreen> {

   private SplashScreen activity;

   @Inject BaseApplication application;

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