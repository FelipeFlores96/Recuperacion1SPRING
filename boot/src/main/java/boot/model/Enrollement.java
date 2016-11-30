package boot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "enrollement")
public class Enrollement implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int enrollementId;
	@Column(name = "course_id")
	private int courseId;
	@Column(name = "student_id")
	private int studentId;
	@Column()
	private int grade;

	public Enrollement() {
		this(0, 0, 0);
	}

	public Enrollement( int courseId, int studentId, int grade) {
		super();
		this.studentId = studentId;
		this.courseId=courseId;
		this.grade=grade;
	}

	public int getEnrollementId() {
		return enrollementId;
	}

	public void setEnrollementId(int enrollementId) {
		this.enrollementId = enrollementId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Enrollement [enrollementId=" + enrollementId + ", courseId=" + courseId + ", studentId=" + studentId
				+ ", grade=" + grade + "]";
	}

}
