package sonia.moviemania.com.moviemania.component;

import dagger.Component;
import sonia.moviemania.com.moviemania.module.MovieApplicationScope;
import sonia.moviemania.com.moviemania.module.MovieModule;
import sonia.moviemania.com.moviemania.network.MovieAPI;

@MovieApplicationScope
@Component(modules = MovieModule.class)
public interface MovieComponent {

    MovieAPI getMovieModule();
}
