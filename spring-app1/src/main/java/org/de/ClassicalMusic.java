package org.de;

import jdk.internal.instrumentation.InstrumentationTarget;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.List;

@Component
@Scope("singleton")
public class ClassicalMusic implements Music {
    private ClassicalMusic() {
    }

    public static ClassicalMusic getClassicalMusic() {
        return new ClassicalMusic();
    }

    @Override
    public List<String> getSong() {
        return Arrays.asList("Classic Music 1",
                "Classic Music 2", "Classic Music 3");
    }

    @PostConstruct
    public void doMyInit() {
        System.out.println("Doing my initialisation");
    }

    @PreDestroy
    public void doMyDestroy() {
        System.out.println("Doing my destruction");
    }
}
