package ir.mhkz.loginandsignup.DTO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserDto implements Serializable {

    @SerializedName("date_of_birth")
    @Expose
    private String date_of_birth;
    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("surname")
    private String surname;

    @SerializedName("passportNumber")
    private String passport_number;


    @SerializedName("kafil_ish_haqi_yillik")
    private String kafil_ish_haqi_yillik;

    @SerializedName("kafil_ism_familya")
    private String kafil_ism_familya;

    @SerializedName("ish_haqi")
    private String ish_haqi;

    @SerializedName("kredit_summasi")
    private String kredit_summasi;


    public UserDto(String date_of_birth, String name, String surname, String passport_number, String kafil_ish_haqi_yillik, String kafil_ism_familya, String ish_haqi, String kredit_summasi) {
        this.date_of_birth = date_of_birth;
        this.name = name;
        this.surname = surname;
        this.passport_number = passport_number;
        this.kafil_ish_haqi_yillik = kafil_ish_haqi_yillik;
        this.kafil_ism_familya = kafil_ism_familya;
        this.ish_haqi = ish_haqi;
        this.kredit_summasi = kredit_summasi;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassport_number() {
        return passport_number;
    }

    public void setPassport_number(String passport_number) {
        this.passport_number = passport_number;
    }

    public String getKafil_ish_haqi_yillik() {
        return kafil_ish_haqi_yillik;
    }

    public void setKafil_ish_haqi_yillik(String kafil_ish_haqi_yillik) {
        this.kafil_ish_haqi_yillik = kafil_ish_haqi_yillik;
    }

    public String getKafil_ism_familya() {
        return kafil_ism_familya;
    }

    public void setKafil_ism_familya(String kafil_ism_familya) {
        this.kafil_ism_familya = kafil_ism_familya;
    }

    public String getIsh_haqi() {
        return ish_haqi;
    }

    public void setIsh_haqi(String ish_haqi) {
        this.ish_haqi = ish_haqi;
    }

    public String getKredit_summasi() {
        return kredit_summasi;
    }

    public void setKredit_summasi(String kredit_summasi) {
        this.kredit_summasi = kredit_summasi;
    }
}