package sonia.moviemania.com.moviemania.component;

import dagger.Component;
import sonia.moviemania.com.moviemania.module.MovieModule;
import sonia.moviemania.com.moviemania.network.MovieAPI;

@Component(modules = MovieModule.class)
public interface MovieComponent {

    MovieAPI getMovieModule();
}
