package android.example.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Currencies {
    @SerializedName("Cur_ID")
    @Expose
    private int Cur_ID;

    @SerializedName("Date")
    @Expose
    private String Date;

    @SerializedName("Cur_Abbreviation")
    @Expose
    private String Cur_Abbreviation;

    @SerializedName("Cur_Scale")
    @Expose
    private int Cur_Scale;

    @SerializedName("Cur_Name")
    @Expose
    private String Cur_Name;

    @SerializedName("Cur_OfficialRate")
    @Expose
    private double Cur_OfficialRate;


    public int getCur_ID() {
        return Cur_ID;
    }

    public void setCur_ID(int cur_ID) {
        Cur_ID = cur_ID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getCur_Abbreviation() {
        return Cur_Abbreviation;
    }

    public void setCur_Abbreviation(String cur_Abbreviation) {
        Cur_Abbreviation = cur_Abbreviation;
    }

    public int getCur_Scale() {
        return Cur_Scale;
    }

    public void setCur_Scale(int cur_Scale) {
        Cur_Scale = cur_Scale;
    }

    public String getCur_Name() {
        return Cur_Name;
    }

    public void setCur_Name(String cur_Name) {
        Cur_Name = cur_Name;
    }

    public double getCur_OfficialRate() {
        return Cur_OfficialRate;
    }

    public void setCur_OfficialRate(double cur_OfficialRate) {
        Cur_OfficialRate = cur_OfficialRate;
    }
}
