package sonia.moviemania.com.moviemania;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import sonia.moviemania.com.moviemania.data.Movie;
import sonia.moviemania.com.moviemania.data.MovieDataSource;
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
    @BindView(R.id.backgroundImage)
    ImageView backgroundImage;

    private MoviePresenter moviePresenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getResources().getString(R.string.loading_message));
        progressDialog.setCanceledOnTouchOutside(false);

        moviePresenter = new MoviePresenter(this, new MovieRespository());

        moviePresenter.fetchMovieData();

    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void displayMovieData(Movie movie) {
        movieNameTV.setText(movie.getMovieName());
        movieRatingsTV.setText(movie.getMovieRatings());
        movieGenreTV.setText(movie.getMovieGenre().get(0));
        movieReleaseDateTV.setText(movie.getMovieReleaseDate());
        movieDurationTV.setText(movie.getMovieDuration());
        movieDescriptionTV.setText(movie.getMovieDescription());

        ArrayList<String> moviePostersBasedOnResolution = movie.getMoviePoster();
        if (moviePostersBasedOnResolution.size() > 0) {
            Glide.with(this)
                    .load(moviePostersBasedOnResolution.get(2))
                    .into(backgroundImage);
        }
    }

    @Override
    public void displayError(String error) {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        Utils.myToast(getApplicationContext(), "Error " + error);
    }
}
