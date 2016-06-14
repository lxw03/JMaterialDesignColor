package com.dev.liji.materialdesigncolor.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by liji on 16-6-14.
 */
public class MaterialDesignColor implements Parcelable {

    private String name;
    private String level;
    private String value;
    private Integer MDColor;

    public Integer getMDColor() {
        return MDColor;
    }

    public void setMDColor(Integer MDColor) {
        this.MDColor = MDColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public MaterialDesignColor() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.level);
        dest.writeString(this.value);
        dest.writeValue(this.MDColor);
    }

    protected MaterialDesignColor(Parcel in) {
        this.name = in.readString();
        this.level = in.readString();
        this.value = in.readString();
        this.MDColor = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Creator<MaterialDesignColor> CREATOR = new Creator<MaterialDesignColor>() {
        @Override
        public MaterialDesignColor createFromParcel(Parcel source) {
            return new MaterialDesignColor(source);
        }

        @Override
        public MaterialDesignColor[] newArray(int size) {
            return new MaterialDesignColor[size];
        }
    };
}
