package my.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Client {

    public static void main(String[] args){
//        Конвейерный стиль: совсем современно и кратко

        List<Integer> data = new ArrayList<>();
        data.add(1); data.add(2); data.add(3);

        data.stream()
            .map(x -> x * x)
            .filter(x -> x > 3)
            .forEach(x -> {
                System.out.println(x);
            });
    }

    public static void main5(String[] args){
//        Использование стандартных функциональных интефейсов:
//        Function, Consumer и Predicate, а также Stream API
//        - набора классов, содержащих полезные методы
//        типа forEach, filter, map и др.

        List<Integer> data = new ArrayList<>();
        data.add(1); data.add(2); data.add(3);

        List<Integer> results;

        results = data.stream().map(x -> x * x).collect(Collectors.toList());

        results = results
                .stream()
                .filter(x -> x > 3)
                .collect(Collectors.toList());

        results.forEach(x -> {
            System.out.println(x);
        });
    }

    public static void main4(String[] args){
//        Использование стандартных функциональных интефейсов:
//        Function, Consumer и Predicate (см. класс IntegerCollectionTransformer2)
//        Но это по-прежнему "изобретение велосипеда".
//        Надо использовать стандартные классы вместо IntegerCollectionTransformer2
        List<Integer> data = new ArrayList<>();
        data.add(1); data.add(2); data.add(3);

        IntegerCollectionTransformer2 ict = new IntegerCollectionTransformer2();
        List<Integer> results = ict.transform(data, x -> x * x);

        results = ict.filter(results, x -> (x > 3));

        ict.forEach(results, x -> {
            System.out.println(x);
        });
    }

    public static void main3(String[] args) {
//        Это работа в современном духе: функциональный стиль.
//        Но это "изобретение велосипеда".
//        Надо использовать готовые классы и интерфейсы
        List<Integer> data = new ArrayList<>();
        data.add(1); data.add(2); data.add(3);

        IntegerCollectionTransformer1 ict = new IntegerCollectionTransformer1();
//        List<Integer> results = ict.transform(data, x -> {return x * x * x;});
        int param = 2;
//        List<Integer> results = ict.transform(data, x ->  x * x * x * param);
//        List<Integer> results = ict.transform(data, x -> {
//            x += 1;
//            x *= 3;
//            x = x * x;
//            return x;
//        });

        TransformInteger lambda = x ->  x * x * x * param;
        List<Integer> results = ict.transform(data, lambda);

        for(int x: results) {
            System.out.println(x);
        }
    }

    public static void main2(String[] args) {
//        Это работа в духе конца 90-ых:
//        действие "заворчивается" внутрь класса в виде метода
//        и используется экземпляр анонимного класса
//        System.out.println("Hello, world!");
        List<Integer> data = new ArrayList<>();
        data.add(1); data.add(2); data.add(3);

        IntegerCollectionTransformer1 ict = new IntegerCollectionTransformer1();
        List<Integer> results = ict.transform(data, new TransformInteger() {
            @Override
            public Integer doTransform(Integer x) {
                return x * x * x;
            }
        });

        for(int x: results) {
            System.out.println(x);
        }
    }

    public static void main1(String[] args) {
//        Это работа любителя
//        System.out.println("Hello, world!");
        List<Integer> data = new ArrayList<>();
        data.add(1); data.add(2); data.add(3);

        IntegerCollectionTransformer ict = new IntegerCollectionTransformer();
        List<Integer> results = ict.squares(data);
        for(int x: results) {
            System.out.println(x);
        }
    }

}
