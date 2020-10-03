package me.sombrero;

import java.lang.reflect.*;
import java.util.Arrays;

/**
 * Hello world!
 */
public class App {

    public static void main( String[] args ) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        /**
         * 클래스 인스턴스 접근 방법 1.
         */
        /*Class<Book> bookClass = Book.class;*/

        /**
         * 클래스 인스턴스 접근 방법 2.
         */
        /*Book book = new Book();
        Class<? extends Book> aClass = book.getClass();*/

        /**
         * 클래스 인스턴스 접근 방법 3.
         */
        /*Class<?> aClass1 = Class.forName("me.sombrero.Book");*/


        /*Class<Book> bookClass = Book.class;*/

        /*System.out.println("--------------------------------------------------");
        Arrays.stream(bookClass.getFields()).forEach(System.out::println);
        System.out.println("--------------------------------------------------");
        Arrays.stream(bookClass.getDeclaredFields()).forEach(System.out::println);
        System.out.println("--------------------------------------------------");
        System.out.println(bookClass.getDeclaredField("B"));
        System.out.println("--------------------------------------------------");*/

        /*Book book = new Book();*/

        /*Arrays.stream(bookClass.getDeclaredFields()).forEach(field -> {
            try {
                field.setAccessible(true); // public이 아닌 접근지시자의 접근 허용.
                System.out.printf("%s %s \n", field, field.get(book));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });*/

        /*Arrays.stream(bookClass.getDeclaredMethods()).forEach(System.out::println);*/

        /*Arrays.stream(bookClass.getDeclaredConstructors()).forEach(System.out::println);*/

        /*Class<? super MyBook> superclass = MyBook.class.getSuperclass();
        System.out.println(superclass);*/

        /*Class<?>[] interfaces = MyBook.class.getInterfaces();
        Arrays.stream(interfaces).forEach(System.out::println);*/

        /*Arrays.stream(Book.class.getDeclaredFields()).forEach(field -> {
            int modifiers = field.getModifiers();
            System.out.println(field);
            System.out.println("- isStatic: " + Modifier.isStatic(modifiers));
            System.out.println("- isPublic: " + Modifier.isPublic(modifiers));
            System.out.println("- isProtected: " + Modifier.isProtected(modifiers));
            System.out.println("- isPrivate: " + Modifier.isPrivate(modifiers));
        });*/

        /*Arrays.stream(Book.class.getDeclaredMethods()).forEach(method -> {
            int modifiers = method.getModifiers();
            System.out.println("# method: " + method);
            System.out.println("- getReturnType: " + method.getReturnType().getName());
            System.out.println("- getParameterCount: " + method.getParameterCount());

            System.out.print("- getParameterTypes: ");
            Arrays.stream(method.getParameterTypes()).forEach(System.out::print);
            System.out.print(" ");
            System.out.println();
        });*/

        /*Arrays.stream(MyBook.class.getAnnotations()).forEach(System.out::println);*/
        /*Arrays.stream(Book.class.getDeclaredAnnotations()).forEach(System.out::println);*/

        /*Arrays.stream(Book.class.getDeclaredFields()).forEach(field -> {
            Arrays.stream(field.getAnnotations()).forEach(annotation -> {
                if(annotation instanceof MyAnnotation) {
                    MyAnnotation myAnnotation = (MyAnnotation)annotation;
                    System.out.println(myAnnotation.value());
                    System.out.println(myAnnotation.number());
                }
            });
        });*/

        Class<?> bookClass = Class.forName("me.sombrero.Book2");
        /*Constructor<?> constructor = bookClass.getConstructor(null);
        Book2 book2 = (Book2) constructor.newInstance();*/
        Constructor<?> constructor = bookClass.getConstructor(String.class);
        Book2 book2 = (Book2) constructor.newInstance("Hello!!");
        /*System.out.println(book2);*/

        /*Field a = Book2.class.getDeclaredField("A");
        System.out.println(a.get(null));
        a.set(null, "Hm......");
        System.out.println(a.get(null));*/

        /*Field b = Book2.class.getDeclaredField("B");
        b.setAccessible(true);
        System.out.println(b.get(book2));
        b.set(book2, "Nice!!");
        System.out.println(b.get(book2));*/

        /*Method c = Book2.class.getDeclaredMethod("c");
        c.setAccessible(true);
        c.invoke(book2);*/

        Method sum = Book2.class.getMethod("sum", int.class, int.class);
        int invoke = (int) sum.invoke(book2, 92, 124);
        System.out.println(invoke);
    }
}
