package learn.ebpearls.com.daggerdemo.screens.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.FrameLayout;

import com.squareup.picasso.Picasso;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import butterknife.ButterKnife;
import learn.ebpearls.com.daggerdemo.R;

@SuppressLint("ViewConstructor")
public class RepoListItem extends FrameLayout {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.fullDate();
    private final Picasso picasso;

    public RepoListItem(Context context, Picasso picasso) {
        super(context);
        this.picasso = picasso;
        inflate(getContext(), R.layout.list_item_repo, this);
        ButterKnife.bind(this);
    }


}
