package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {

        Predicate<String> predicate = (s) -> s.startsWith("h");

        System.out.println(predicate.test("hello"));

        BookInterFace bookInterFace = (number) -> number + 10;

        System.out.println(bookInterFace.doInit(10));
    }

    @Test
    public void test() {
        UnaryOperator<String> hi = (s) -> "hi " + s;
        System.out.println(hi.apply("Kibong"));

        UnaryOperator<String> hiGreeting = Greeting::hello;

        System.out.println(hiGreeting.apply("kibong"));

        Supplier<Greeting> greetingSupplier = Greeting::new;

        System.out.println(greetingSupplier.get());
    }

    @Test
    public void interfaceTest() {
        Bar bar = new FooImpl("kibong");
        bar.printName();
        bar.upperCaseString();
        bar.printHello();

    }

    @Test
    public void streamApiTest() {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> keesunEvents = new ArrayList<>();
        keesunEvents.add(springClasses);
        keesunEvents.add(javaClasses);

        System.out.println("spring 으로 시작하는 수업");
        springClasses.stream()
                .filter(s -> s.getTitle().startsWith("spring"))
                .forEach(s -> System.out.println(s.getId()));
        // TODO

        System.out.println("close 되지 않은 수업");
        springClasses.stream()
                .filter(Predicate.not(OnlineClass::isClosed))
                .forEach(s -> System.out.println(s.getId()));
        // TODO

        System.out.println("수업 이름만 모아서 스트림 만들기");
        springClasses.stream().map(OnlineClass::getTitle).forEach(System.out::println);
        // TODO

        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
        keesunEvents.stream().flatMap(Collection::stream).map(OnlineClass::getTitle).forEach(System.out::println);
        // TODO

        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
        Stream.iterate(10,i -> i+1).skip(10).limit(10).forEach(System.out::println);
        // TODO

        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
        boolean test = javaClasses.stream().anyMatch(s -> s.getTitle().contains("Test"));
        System.out.println(test);
        // TODO

        System.out.println("스프링 수업 중에 제목에 spring이 들어간 것만 모아서 List로 만들기");
        List<String> testList = springClasses.stream().filter(s -> s.getTitle().contains("spring")).map(OnlineClass::getTitle).collect(Collectors.toList());
        testList.forEach(System.out::println);
        // TODO
    }
}
