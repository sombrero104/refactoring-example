package me.sombrero.di;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ContainerService {

    /**
     * 아래 메소드에서 사용한 <T>T 의 의미는..
     *   => 파라미터로 받은 클래스타입으로 객체를 반환하고 싶을 때 사용.
     */
    public static <T>T getObject(Class<T> classType) {
        /*return (T) new BookRepository();*/
        T instance = createInstance(classType);
        Arrays.stream(classType.getDeclaredFields()).forEach(field -> {
            Inject annotation = field.getAnnotation(Inject.class);
            if(annotation != null) {
                Object fieldInstance = createInstance(field.getType());
                field.setAccessible(true);
                try {
                    field.set(instance, fieldInstance);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException();
                }
            }
        });
        return instance;
    }

    private static <T> T createInstance(Class<T> classType) {
        try {
            return classType.getConstructor(null).newInstance();
        } catch (InstantiationException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException();
        }
    }

}
