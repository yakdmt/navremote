package xyz.yakdmt.navremote.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by yakdmt on 25/11/15.
 */
@Retention(RetentionPolicy.RUNTIME)  @Target(ElementType.FIELD)
public @interface Column {
    String name();
}
