package me.sombrero;

import java.lang.annotation.*;

/**
 * 원래 애노테이션은 클래스까지만 남고, 클래스로딩 시 메모리에는 올라가지 않음.
 * 애노테이션도 같이 읽어와서 메모리에 올리고 싶을 경우에는..
 *  => @Retention(RetentionPolicy.RUNTIME) 사용.
 *          (원래 기본값은 RetentionPolicy.CLASS)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD}) // 애노테이션을 붙일 수 있는 위치 제한.
@Inherited // 클래스 상속 시 애노테이션도 상속됨.
public @interface MyAnnotation {

    String name() default "sombrero";

    int number() default 100;

    String value() default "Hi"; // value로 이름을 주면 사용 시 이름을 명시 안해도 됨.

}
