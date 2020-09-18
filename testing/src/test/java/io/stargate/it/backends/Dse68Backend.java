package io.stargate.it.backends;

import com.github.peterwippermann.junit4.parameterizedsuite.ParameterizedSuite;
import java.util.Collections;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(ParameterizedSuite.class)
public class Dse68Backend extends AllBackendSuite {
  @Parameterized.Parameters(name = "{index}: {0}")
  public static Iterable<Object[]> functions() {
    return Collections.singletonList(new Object[] {"datastax/dse-server:6.8.1", true, "6.8"});
  }
}
