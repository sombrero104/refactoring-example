package me.sombrero;

import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Hello world!
 */
public class App {

    public static void main( String[] args ) throws ClassNotFoundException, NoSuchFieldException {

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


        Class<Book> bookClass = Book.class;

        /*System.out.println("--------------------------------------------------");
        Arrays.stream(bookClass.getFields()).forEach(System.out::println);
        System.out.println("--------------------------------------------------");
        Arrays.stream(bookClass.getDeclaredFields()).forEach(System.out::println);
        System.out.println("--------------------------------------------------");
        System.out.println(bookClass.getDeclaredField("B"));
        System.out.println("--------------------------------------------------");*/

        Book book = new Book();

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

        Arrays.stream(Book.class.getDeclaredMethods()).forEach(method -> {
            int modifiers = method.getModifiers();
            System.out.println("# method: " + method);
            System.out.println("- getReturnType: " + method.getReturnType().getName());
            System.out.println("- getParameterCount: " + method.getParameterCount());

            System.out.print("- getParameterTypes: ");
            Arrays.stream(method.getParameterTypes()).forEach(System.out::print);
            System.out.print(" ");
            System.out.println();
        });
    }
}
