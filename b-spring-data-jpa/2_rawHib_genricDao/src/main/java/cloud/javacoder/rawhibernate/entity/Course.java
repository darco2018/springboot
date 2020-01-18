package cloud.javacoder.rawhibernate.entity;

import javax.persistence.*;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int workload;
    private int rate;

    // Many Courses to One Teacher
    @ManyToOne  // the Teacher will be the FOREIGN KEY (index) in Course
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_course_teacher"))
    private Teacher teacher;

    // no id filed in the constructor
    public Course(String name, int workload, int rate, Teacher teacher) {
        this.name = name;
        this.workload = workload;
        this.rate = rate;
        this.teacher = teacher;
    }

    public Course() {
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", workload=" + workload +
                ", rate=" + rate +
                ", teacher=" + teacher +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWorkload() {
        return workload;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
