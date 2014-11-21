package packagename.app.com.appname.core;

import android.test.ApplicationTestCase;

public class ApplicationTest extends ApplicationTestCase<BaseApplication> {

   public ApplicationTest() {
      super(BaseApplication.class);
   }

   public void testCrashTracker() {
      assertNotNull(getApplication().crashTracker);
   }

   public void testPicasso() throws Exception {
      assertNotNull(getApplication().picasso);
   }

   public void testRestAdapter() throws Exception {
      assertNotNull(getApplication().restAdapter);
   }

   @Override
   protected void setUp() throws Exception {
      super.setUp();
      createApplication();
   }
}