package com.kotlin.baselibrary.injection

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import javax.inject.Scope
import java.lang.annotation.RetentionPolicy.RUNTIME


/**
 * Identifies a type that the injector only instantiates once. Not inherited.
 *
 * @see javax.inject.Scope @Scope
 */
@Scope
@Documented
@Retention(RUNTIME)
annotation class PerComponentScope