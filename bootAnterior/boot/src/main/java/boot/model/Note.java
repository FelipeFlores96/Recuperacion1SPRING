package boot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "note")
public class Note implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 45)
	private String student;
	@Column(length = 45)
	private String description;
	@Temporal(TemporalType.DATE)
	@Column(name = "date_created")
	private Date dateCreated;
	@Column(length = 45)
	private String subject;

	public Note(int id, String student, String description, Date dateCreated, String subject) {
		super();
		this.id = id;
		this.student = student;
		this.description = description;
		this.dateCreated = dateCreated;
		this.subject = subject;
	}

	public Note() {
		this(0, "", "", new Date(), "");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", student=" + student + ", description=" + description + ", dateCreated="
				+ dateCreated + ", subject=" + subject + "]";
	}

}
