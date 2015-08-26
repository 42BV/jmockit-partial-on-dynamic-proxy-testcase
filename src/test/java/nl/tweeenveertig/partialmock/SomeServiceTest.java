package nl.tweeenveertig.partialmock;

import mockit.StrictExpectations;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static mockit.Deencapsulation.invoke;
import static org.junit.Assert.assertEquals;

public class SomeServiceTest extends AbstractSpringTest {

    @Autowired
    private SomeService someService;

    @Test
    public void publicCallOnDynamicProxy() {

        new StrictExpectations(someService) {{
            invoke(someService, "privateCall");
        }};

        assertEquals(42, someService.publicCall());
    }

    @Test
    public void publicCallOnConstructedService() {

        final SomeService someService = new SomeService();

        new StrictExpectations(someService) {{
            invoke(someService, "privateCall");
        }};

        assertEquals(42, someService.publicCall());
    }

}
