package sonia.moviemania.com.moviemania.component;

import dagger.Component;
import sonia.moviemania.com.moviemania.module.MovieModule;

@Component
public interface MovieComponent {

    MovieModule getMovieModule();
}
