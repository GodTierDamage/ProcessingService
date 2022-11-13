package services;

import enums.StudyProfile;
import moduls.University;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompareUniversitiesTest {

    @Test
    public void compareUniversitiesByID(){
        University university = new University("001_MYid", "Марсианский гуманитарный университет", "МГУ", 886, StudyProfile.LINGUISTICS);
        University university1 = new University("001_MYid", "Марсианский гуманитарный университет", "МГУ", 886, StudyProfile.LINGUISTICS);
        University university2 = new University("002_MYid", "Университет Имени Безымянного Ученого", "УИБУ", 2347, StudyProfile.PHYSICS);



        assertEquals("Wrong comparing result", StringUtils.compare(university1.getId(), university.getId()),
                CompareUniversitiesByID.compareByID(university1, university));
        assertEquals("Wrong comparing result", StringUtils.compare(university.getId(), university2.getId()),
                CompareUniversitiesByID.compareByID(university, university2));
        assertEquals("Wrong comparing result", StringUtils.compare(university2.getId(), university.getId()),
                CompareUniversitiesByID.compareByID(university2, university));
    }

    @Test
    public void compareUniversitiesByFullName(){
        University university = new University("001_MYid", "Марсианский гуманитарный университет", "МГУ", 886, StudyProfile.LINGUISTICS);
        University university1 = new University("001_MYid", "Марсианский гуманитарный университет", "МГУ", 886, StudyProfile.LINGUISTICS);
        University university2 = new University("002_MYid", "Университет Имени Безымянного Ученого", "УИБУ", 2347, StudyProfile.PHYSICS);

        assertEquals("Wrong comparing result", StringUtils.compare(university1.getFullName(), university.getFullName()),
                CompareUniversitiesByFullName.compareByFullName(university1, university));
        assertEquals("Wrong comparing result", StringUtils.compare(university.getFullName(), university2.getFullName()),
                CompareUniversitiesByFullName.compareByFullName(university, university2));
        assertEquals("Wrong comparing result", StringUtils.compare(university2.getFullName(), university.getFullName()),
                CompareUniversitiesByFullName.compareByFullName(university2, university));
    }

    @Test
    public void compareUniversitiesByShortName(){
        University university = new University("001_MYid", "Марсианский гуманитарный университет", "МГУ", 886, StudyProfile.LINGUISTICS);
        University university1 = new University("001_MYid", "Марсианский гуманитарный университет", "МГУ", 886, StudyProfile.LINGUISTICS);
        University university2 = new University("002_MYid", "Университет Имени Безымянного Ученого", "УИБУ", 2347, StudyProfile.PHYSICS);

        assertEquals("Wrong comparing result", StringUtils.compare(university1.getShortName(), university.getShortName()),
                CompareUniversitiesByShortName.compareByShortName(university1, university));
        assertEquals("Wrong comparing result", StringUtils.compare(university.getShortName(), university2.getShortName()),
                CompareUniversitiesByShortName.compareByShortName(university, university2));
        assertEquals("Wrong comparing result", StringUtils.compare(university2.getShortName(), university.getShortName()),
                CompareUniversitiesByShortName.compareByShortName(university2, university));
    }

    @Test
    public void compareUniversitiesByYearOfFoundation(){
        University university = new University("001_MYid", "Марсианский гуманитарный университет", "МГУ", 886, StudyProfile.LINGUISTICS);
        University university1 = new University("001_MYid", "Марсианский гуманитарный университет", "МГУ", 886, StudyProfile.LINGUISTICS);
        University university2 = new University("002_MYid", "Университет Имени Безымянного Ученого", "УИБУ", 2347, StudyProfile.PHYSICS);



        assertEquals("Wrong comparing result", 0,
                CompareUniversitiesByYearOfFoundation.compareByYearOfFoundation(university, university1));
        assertEquals("Wrong comparing result", 1,
                CompareUniversitiesByYearOfFoundation.compareByYearOfFoundation(university2, university1));
        assertEquals("Wrong comparing result", -1,
                CompareUniversitiesByYearOfFoundation.compareByYearOfFoundation(university, university2));
    }

    @Test
    public void compareUniversitiesByStudyProfile(){
        University university = new University("001_MYid", "Марсианский гуманитарный университет", "МГУ", 886, StudyProfile.LINGUISTICS);
        University university1 = new University("001_MYid", "Марсианский гуманитарный университет", "МГУ", 886, StudyProfile.LINGUISTICS);
        University university2 = new University("002_MYid", "Университет Имени Безымянного Ученого", "УИБУ", 2347, StudyProfile.PHYSICS);


        assertEquals("Wrong comparing result", StringUtils.compare(university1.getMainStudyProfile().getProfileName(), university.getMainStudyProfile().getProfileName()),
                CompareUniversitiesByStudyProfile.compareByStudyProfile(university1, university));
        assertEquals("Wrong comparing result", StringUtils.compare(university.getMainStudyProfile().getProfileName(), university2.getMainStudyProfile().getProfileName()),
                CompareUniversitiesByStudyProfile.compareByStudyProfile(university, university2));
        assertEquals("Wrong comparing result", StringUtils.compare(university2.getMainStudyProfile().getProfileName(), university.getMainStudyProfile().getProfileName()),
                CompareUniversitiesByStudyProfile.compareByStudyProfile(university2, university));
    }

}