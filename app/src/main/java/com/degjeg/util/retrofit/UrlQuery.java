package com.degjeg.util.retrofit;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Administrator on 2017-11-15.
 */

@Documented
@Target(PARAMETER)
@Retention(RUNTIME)
// @Query("")
public @interface UrlQuery  {
    /** The query parameter name. */
    String value();

    /**
     * Specifies whether the parameter {@linkplain #value() name} and value are already URL encoded.
     */
    boolean encoded() default false;
}

