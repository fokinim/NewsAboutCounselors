import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
@Embeddable
public class PurchaseKey implements Serializable {
    @Column(name = "student_name", insertable = false, updatable = false, length = 125)
    private String studentName;
    @Column(name = "course_name", insertable = false, updatable = false, length = 125)
    private String courseName;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
