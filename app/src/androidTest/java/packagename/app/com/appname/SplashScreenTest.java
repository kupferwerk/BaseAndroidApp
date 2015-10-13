package packagename.app.com.appname;

import android.test.ActivityInstrumentationTestCase2;

public class SplashScreenTest extends ActivityInstrumentationTestCase2<SplashScreen> {

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
      activity = getActivity();
   }
}