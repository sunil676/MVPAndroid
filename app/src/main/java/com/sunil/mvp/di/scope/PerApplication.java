package com.sunil.mvp.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by sunil on 5/3/2017.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerApplication {
}
