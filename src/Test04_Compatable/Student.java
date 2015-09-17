package Test04_Compatable;

enum Grade {GradeOne, GradeTwo, GradeThree, GradeFour, GradeFive, GradeSix,
            GradeSeven, GradeEight, GradeNine, GradeTen, GradeEleven, GradeTwelve
}

enum Gender {male, female}

public class Student implements Comparable<Student>{
    private Long id;
    private String name;
    private Gender gender;
    private Grade grade;
    private double score; 
    
    public Student(Long id, String name, Gender gender, Grade grade, double score) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.grade = grade;
        this.score = score;
    }
    
    public int compareTo(Student other) {
        int s1_grade = this.getGrade().ordinal();
        int s2_grade = other.getGrade().ordinal();
        return (s1_grade == s2_grade ? (int)(this.getScore() - other.getScore()) : (s1_grade - s2_grade)); 
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
    
    

}
