package sonia.moviemania.com.moviemania.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by soniawadji on 19/05/18.
 */

@Scope
@Retention(RetentionPolicy.CLASS)
public @interface MovieApplicationScope {
}
