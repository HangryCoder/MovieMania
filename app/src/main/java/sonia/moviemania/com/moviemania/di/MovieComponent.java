package sonia.moviemania.com.moviemania.di;

import dagger.Component;
import sonia.moviemania.com.moviemania.api.MovieAPI;

@MovieApplicationScope
@Component(modules = MovieModule.class)
public interface MovieComponent {

    MovieAPI getMovieModule();
}
