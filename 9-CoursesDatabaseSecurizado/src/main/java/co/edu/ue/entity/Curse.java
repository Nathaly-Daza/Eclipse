package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the curses database table.
 * 
 */
@Entity
@Table(name="curses")
@NamedQuery(name="Curse.findAll", query="SELECT c FROM Curse c")
public class Curse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cou_id")
	private int couId;

	@Column(name="cou_description")
	private String couDescription;

	@Column(name="cou_name")
	private String couName;

	@Column(name="cou_price")
	private BigDecimal couPrice;

	//bi-directional many-to-one association to TypeCurse
	@ManyToOne
	@JoinColumn(name="type_id")
	private TypeCurse typeCurs;

	public Curse() {
	}

	public int getCouId() {
		return this.couId;
	}

	public void setCouId(int couId) {
		this.couId = couId;
	}

	public String getCouDescription() {
		return this.couDescription;
	}

	public void setCouDescription(String couDescription) {
		this.couDescription = couDescription;
	}

	public String getCouName() {
		return this.couName;
	}

	public void setCouName(String couName) {
		this.couName = couName;
	}

	public BigDecimal getCouPrice() {
		return this.couPrice;
	}

	public void setCouPrice(BigDecimal couPrice) {
		this.couPrice = couPrice;
	}

	public TypeCurse getTypeCurs() {
		return this.typeCurs;
	}

	public void setTypeCurs(TypeCurse typeCurs) {
		this.typeCurs = typeCurs;
	}

}