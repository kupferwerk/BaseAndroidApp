package packagename.app.com.appname.core.module;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class WebserviceModuleTest {

   private Context context;
   private WebserviceModule webserviceModule;

   @Before
   public void setUp() {
      context = InstrumentationRegistry.getTargetContext();
      webserviceModule = new WebserviceModule();
   }

   @Test
   public void testProvideHttpCache() {
      assertThat(webserviceModule.provideHttpCache(context), notNullValue());
   }

   @Test
   public void testProvideHttpClient() {
      final Cache cache = webserviceModule.provideHttpCache(context);
      assertThat(webserviceModule.provideHttpClient(cache, null), notNullValue());
   }

   @Test
   public void testProvideHttpLoggingInterceptor() {
      assertThat(webserviceModule.provideHttpLoggingInterceptor(), notNullValue());
   }

   @Test
   public void testProvidePicasso() {
      assertThat(webserviceModule.providePicasso(context, new OkHttpClient()), notNullValue());
   }

   @Test
   public void testProvideRestAdapter() {
      assertThat(webserviceModule.provideRetrofit(context, new OkHttpClient()), notNullValue());
   }
}
