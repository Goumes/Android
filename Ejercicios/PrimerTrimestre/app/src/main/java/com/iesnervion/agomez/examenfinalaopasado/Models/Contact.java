package com.iesnervion.agomez.examenfinalaopasado.Models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by aleja on 20/02/2018.
 */

@Entity(tableName = "contacts", indices = {@Index("id")})
public class Contact implements Parcelable
{
    @PrimaryKey (autoGenerate = true)
    @NonNull
    private int id;
    private String name;
    private String phone;
    private int age;
    private String gender;

    public Contact(String name, String phone, int age, String gender) {
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.gender = gender;
    }

    public Contact()
    {
        this.name = "pepe";
        this.phone = "954224444";
        this.age = 21;
        this.gender = "Hombre";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.phone);
        dest.writeInt(this.age);
        dest.writeString(this.gender);
    }

    protected Contact(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.phone = in.readString();
        this.age = in.readInt();
        this.gender = in.readString();
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel source) {
            return new Contact(source);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };
}
