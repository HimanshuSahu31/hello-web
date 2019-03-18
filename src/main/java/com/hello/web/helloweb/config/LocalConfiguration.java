package com.hello.web.helloweb.config;

import io.molr.commons.domain.Placeholder;
import io.molr.mole.core.api.Mole;
import io.molr.mole.core.single.SingleNodeMission;
import io.molr.mole.core.single.SingleNodeMole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

import static io.molr.commons.domain.MissionParameter.required;

@Configuration
public class LocalConfiguration {

    @Bean
    public Mole singleNodeMole() {
        Set<SingleNodeMission<?>> missions = new HashSet<>();
        missions.add(helloWorld());
        missions.add(helloName());
        return new SingleNodeMole(missions);
    }

    private SingleNodeMission<Void> helloWorld() {
        return SingleNodeMission.from(() -> {
            System.out.println("Hello World");
        }).withName("hello-world");
    }

    private SingleNodeMission<Void> helloName() {
        Placeholder<String> name = Placeholder.aString("name");
        return SingleNodeMission.from((in) -> {
            System.out.println("Hello " + in.get(name));
        })
                .withParameters(required(name))
                .withName("hello-name");
    }

}
