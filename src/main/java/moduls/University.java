package moduls;

import com.google.gson.annotations.SerializedName;
import enums.StudyProfile;

import java.util.Objects;

public class University {

    private final String id;

    @SerializedName("Полное название")
    private String fullName;

    @SerializedName("Аббревиатура названия")
    private String shortName;

    @SerializedName("Год основания")
    private final int yearOfFoundation;

    @SerializedName("Основной учебный профиль")
    private final StudyProfile mainStudyProfile;

    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainStudyProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainStudyProfile = mainStudyProfile;
    }

    @Override
    public String toString() {
        return String.format("""
                University name: %s
                University short name: %s
                University id: %s
                Year of foundation: %d
                Study profile: %s
                """, fullName, shortName, id, yearOfFoundation, mainStudyProfile);
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public StudyProfile getMainStudyProfile() {
        return mainStudyProfile;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof University)) return false;
        University that = (University) o;
        return yearOfFoundation == that.yearOfFoundation && Objects.equals(id, that.id) && Objects.equals(fullName, that.fullName) && Objects.equals(shortName, that.shortName) && mainStudyProfile == that.mainStudyProfile;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, shortName, yearOfFoundation, mainStudyProfile);
    }
}
