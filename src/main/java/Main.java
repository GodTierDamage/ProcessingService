public class Main {

    public static void main(String[] args) {
        Student mrTest = new Student(1, "Vito", "", "Karleone",
                3, 2, 3.4f);
        Student fullNameStudent = new Student(2, "Иван", "Иванович", "Иванов",
                1, 4, 5.0f);
        Student test = new Student(5, "Some", null, "Body",
                4, 1, 4.3f);
        University mitUniversity = new University(1, "Massachusetts Institute of Technology", "MIT",
                1861, StudyProfile.COMPUTER_SCIENCE);
        University mgpuUniversity = new University(2, "Московский городской педагогический университет",
                "МГПУ", 1995, StudyProfile.PEDAGOGY);

        System.out.println(mrTest);
        System.out.println(fullNameStudent);
        System.out.println(test);
        System.out.println(mitUniversity);
        System.out.println(mgpuUniversity);
    }
}
