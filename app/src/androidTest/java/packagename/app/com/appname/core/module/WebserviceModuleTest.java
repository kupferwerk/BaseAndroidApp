package packagename.app.com.appname.core.module;

import android.test.AndroidTestCase;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class WebserviceModuleTest extends AndroidTestCase {

   private WebserviceModule webserviceModule;

   public void testProvideHttpCache() {
      assertThat(webserviceModule.provideHttpCache(getContext()), notNullValue());
   }

   public void testProvideHttpClient() {
      final Cache cache = webserviceModule.provideHttpCache(getContext());
      assertThat(webserviceModule.provideHttpClient(cache, null), notNullValue());
   }

   public void testProvideHttpLoggingInterceptor() {
      assertThat(webserviceModule.provideHttpLoggingInterceptor(), notNullValue());
   }

   public void testProvidePicasso() {
      assertThat(webserviceModule.providePicasso(getContext(), new OkHttpClient()), notNullValue());
   }

   public void testProvideRestAdapter() {
      assertThat(webserviceModule.provideRetrofit(getContext(), new OkHttpClient()),
            notNullValue());
   }

   @Override
   protected void setUp() throws Exception {
      super.setUp();
      webserviceModule = new WebserviceModule();
   }
}
