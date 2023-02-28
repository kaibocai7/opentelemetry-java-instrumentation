import io.opentelemetry.instrumentation.rxjava.v3.common.AbstractRxJava3Test;
import io.opentelemetry.instrumentation.rxjava.v3_0.TracingAssembly;
import io.opentelemetry.instrumentation.testing.InstrumentationTestRunner;
import io.opentelemetry.instrumentation.testing.LibraryTestRunner;
import io.opentelemetry.instrumentation.testing.junit.InstrumentationExtension;
import io.opentelemetry.instrumentation.testing.junit.LibraryInstrumentationExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.RegisterExtension;

public class RxJava33Test extends AbstractRxJava3Test {
  @RegisterExtension
  static final InstrumentationExtension testing = LibraryInstrumentationExtension.create();
  static TracingAssembly tracingAssembly = TracingAssembly.create();
  private static final InstrumentationTestRunner RUNNER = LibraryTestRunner.instance();

  @Override
  protected InstrumentationExtension testing() {
    return testing;
  }

  @Override
  public InstrumentationTestRunner testRunner() {
    return RUNNER;
  }

  @BeforeAll
  public void setupSpec() {
    tracingAssembly.enable();
  }

  public InstrumentationTestRunner getTestRunner() {
    return RUNNER;
  }
}
