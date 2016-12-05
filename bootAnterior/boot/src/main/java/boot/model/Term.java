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

@Entity(name="term2term")
public class Term implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="relationship_type_id")
	private int relationshipTypeId;
	@Column(name="term1_id")
	private int term1Id;	
	@Column(name="term2_id")
	private int term2Id;
	@Column(name="complete")
	private int complete;

	public Term(int id, int relationshipTypeId, int term1Id, int term2Id, int complete) {
		super();
		this.id = id;
		this.relationshipTypeId = relationshipTypeId;
		this.term1Id = term1Id;
		this.term2Id = term2Id;
		this.complete = complete;
	}

	public Term() {
		this(0,0,0,0,0);
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getRelationshipTypeId() {
		return relationshipTypeId;
	}



	public void setRelationshipTypeId(int relationshipTypeId) {
		this.relationshipTypeId = relationshipTypeId;
	}



	public int getTerm1Id() {
		return term1Id;
	}



	public void setTerm1Id(int term1Id) {
		this.term1Id = term1Id;
	}



	public int getTerm2Id() {
		return term2Id;
	}



	public void setTerm2Id(int term2Id) {
		this.term2Id = term2Id;
	}



	public int getComplete() {
		return complete;
	}



	public void setComplete(int complete) {
		this.complete = complete;
	}



	@Override
	public String toString() {
		return "Term [id=" + id + ", relationshipTypeId=" + relationshipTypeId + ", term1Id=" 
	+ term1Id + ", term2Id=" + term2Id+ ", complete=" + complete + "]";
	}
	
	
}
