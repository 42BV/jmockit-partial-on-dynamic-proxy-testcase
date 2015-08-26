package nl.tweeenveertig.partialmock;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class SomeService {

    @Cacheable("default")
    public int publicCall() {
        privateCall();
        return 42;
    }

    public void privateCall() {
        throw new UnsupportedOperationException("This must not be thrown when the tests run");
    }

}
