package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the Vaccations database table.
 * 
 */
@Entity
@Table(name="Vaccations")
@NamedQuery(name="Vaccation.findAll", query="SELECT v FROM Vaccation v")
public class Vaccation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdVaccation")
	private int idVaccation;

	@Column(name="EndDate")
	private Timestamp endDate;

	@Column(name="StartDate")
	private Timestamp startDate;

	public Vaccation() {
	}

	public int getIdVaccation() {
		return this.idVaccation;
	}

	public void setIdVaccation(int idVaccation) {
		this.idVaccation = idVaccation;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

}