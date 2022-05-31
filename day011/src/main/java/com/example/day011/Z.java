package com.example.day011;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Date 2022/5/31
 */
@Qualifier
@Documented
@Retention(RUNTIME)
public @interface Z {
}
