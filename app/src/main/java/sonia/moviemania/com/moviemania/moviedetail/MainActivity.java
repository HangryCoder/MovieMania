package sonia.moviemania.com.moviemania.moviedetail;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sonia.moviemania.com.moviemania.R;
import sonia.moviemania.com.moviemania.data.Movie;
import sonia.moviemania.com.moviemania.data.MovieRespository;
import sonia.moviemania.com.moviemania.utils.Utils;

public class MainActivity extends AppCompatActivity implements MovieContract.View {

    @BindView(R.id.movieNameTV)
    TextView movieNameTV;
    @BindView(R.id.movieRatingsTV)
    TextView movieRatingsTV;
    @BindView(R.id.movieGenreTV)
    TextView movieGenreTV;
    @BindView(R.id.movieReleaseDateTV)
    TextView movieReleaseDateTV;
    @BindView(R.id.movieDurationTV)
    TextView movieDurationTV;
    @BindView(R.id.movieDescriptionTV)
    TextView movieDescriptionTV;
    @BindView(R.id.videoPlayer)
    VideoView videoPlayer;
    @BindView(R.id.watchTrailerBtn)
    TextView watchTrailerBtn;
    @BindView(R.id.movieThumbnail)
    ImageView movieThumbnail;
    @BindView(R.id.movieDetailLayout)
    ScrollView movieDetailLayout;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.errorTV)
    TextView errorTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        MoviePresenter moviePresenter = new MoviePresenter(this, new MovieRespository());

        moviePresenter.fetchMovieData();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        movieDetailLayout.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        movieDetailLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void displayMovieData(Movie movie) {
        movieNameTV.setText(movie.getMovieName());
        movieRatingsTV.setText(movie.getMovieRatings());
        movieGenreTV.setText(movie.getMovieGenre().get(0));
        if (movie.getMovieReleaseDate() != null) {
            String releaseDate = "Year " + movie.getMovieReleaseDate().split("-")[0];
            movieReleaseDateTV.setText(releaseDate);
        }

        long movieDurationInLong = Long.parseLong(movie.getMovieDuration()) / (1000 * 60);
        String movieDurationString = movieDurationInLong + " minutes";

        movieDurationTV.setText(movieDurationString);
        movieDescriptionTV.setText(movie.getMovieDescription());

        videoPlayer.setVideoURI(Uri.parse(movie.getMovieTrailerUrl()));

        ArrayList<String> moviePostersBasedOnResolution = movie.getMovieThumbnailLandscape();
        if (moviePostersBasedOnResolution.size() > 0) {
            Glide.with(this)
                    .load(moviePostersBasedOnResolution.get(0))
                    .into(movieThumbnail);
        }
    }

    @Override
    public void displayError(String error) {
        progressBar.setVisibility(View.INVISIBLE);
        movieDetailLayout.setVisibility(View.INVISIBLE);
        errorTV.setVisibility(View.VISIBLE);
        Utils.myToast(getApplicationContext(), "Error " + error);
    }

    @OnClick(R.id.watchTrailerBtn)
    public void watchTrailer() {
        if (!videoPlayer.isPlaying()) {
            videoPlayer.start();
            movieThumbnail.setVisibility(View.INVISIBLE);
            watchTrailerBtn.setText(getResources().getString(R.string.pause_trailer));
        } else {
            videoPlayer.pause();
            movieThumbnail.setVisibility(View.VISIBLE);
            watchTrailerBtn.setText(getResources().getString(R.string.watch_trailer));
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (videoPlayer.isPlaying()) {
            videoPlayer.pause();
            movieThumbnail.setVisibility(View.VISIBLE);
            watchTrailerBtn.setText(getResources().getString(R.string.watch_trailer));
        }
    }
}
