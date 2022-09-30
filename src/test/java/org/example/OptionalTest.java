package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class OptionalTest {

    @Test
    public void optionalTest() {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        Optional<OnlineClass> optional = springClasses.stream().filter(s -> s.getTitle().startsWith("sprisng")).findFirst();

        System.out.println(optional.isPresent());
        optional.ifPresent(s -> System.out.println(s.getTitle()));

        OnlineClass onlineClass = optional.orElseGet(OptionalTest::CreateClass);
        System.out.println(onlineClass.getTitle());


    }

    private static OnlineClass CreateClass(){
        System.out.println("Create New Class");
        return new OnlineClass(10, "New class", false);
    }
}
