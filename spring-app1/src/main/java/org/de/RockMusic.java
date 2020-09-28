package org.de;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class RockMusic implements Music {
    @Override
    public List<String> getSong() {
        return Arrays.asList("Rock Music 1",
                "Rock Music 2", "Rock Music 3");
    }
}
