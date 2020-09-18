package io.stargate.it.backends;

import com.github.peterwippermann.junit4.parameterizedsuite.ParameterizedSuite;
import io.stargate.it.BaseOsgiIntegrationTest;
import java.util.Collections;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(ParameterizedSuite.class)
public class Cassandra40Backend extends AllBackendSuite {
  static {
    // Allows the 4.0 backend test to run without docker host networking
    // Thereby working natively on osx
    if (BaseOsgiIntegrationTest.isMacOSX) {
      System.setProperty(BaseOsgiIntegrationTest.SKIP_HOST_NETWORKING_FLAG, "true");
      System.setProperty(BaseOsgiIntegrationTest.SEED_PORT_OVERRIDE_FLAG, "7001");
    }
  }

  @Parameterized.Parameters(name = "{index}: {0}")
  public static Iterable<Object[]> functions() {
    return Collections.singletonList(new Object[] {"datastax/cassandra:4.0", false, "4.0"});
  }
}
