package com.test.marek.ormlitetraining;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class MainActivity extends ActionBarActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    @InjectView(R.id.text_view)
    TextView textViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

    }

    @OnClick(R.id.button)
    void buttonCliked() {
        try {
            TrainingOrmLiteHelper helper = new TrainingOrmLiteHelper(this);
            DataModel item = new DataModel();
            item.description = "ELOOOO";
            item.title = "kurwa";
            helper.getModelDao().create(item);

            List<DataModel> models = helper.getModelDao().queryForAll();
            String result = "";
            for (DataModel model : models) {
                result = result + model.title + "  " + model.description + "\n";
            }

            textViews.setText(result);
        } catch (SQLException e) {
            Log.d(TAG, e.getMessage());
            Toast.makeText(
                    this, getString(R.string.something_went_wrong), Toast.LENGTH_SHORT).show();
        }
    }
}
