package security;

import java.nio.charset.StandardCharsets;
import java.util.Random;

public class SaltGenImpl implements SaltGen {
    @Override
    public String get() {
        Random random = new Random();
        byte[] bytes = new byte[32];
        random.nextBytes(bytes);
        return new String(bytes, StandardCharsets.US_ASCII);
    }
}
