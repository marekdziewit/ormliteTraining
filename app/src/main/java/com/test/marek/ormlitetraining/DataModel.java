package com.test.marek.ormlitetraining;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "data_model")
public class DataModel {

    @DatabaseField(generatedId = true)
    int id;

    @DatabaseField
    String title;

    @DatabaseField
    String description;
}
