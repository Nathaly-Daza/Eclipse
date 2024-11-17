package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the type_curses database table.
 * 
 */
@Entity
@Table(name="type_curses")
@NamedQuery(name="TypeCurse.findAll", query="SELECT t FROM TypeCurse t")
public class TypeCurse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="type_id")
	private int typeId;

	@Column(name="type_description")
	private String typeDescription;

	//bi-directional many-to-one association to Curse
	@OneToMany(mappedBy="typeCurs")
	private List<Curse> curses;

	public TypeCurse() {
	}

	public int getTypeId() {
		return this.typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeDescription() {
		return this.typeDescription;
	}

	public void setTypeDescription(String typeDescription) {
		this.typeDescription = typeDescription;
	}

	public List<Curse> getCurses() {
		return this.curses;
	}

	public void setCurses(List<Curse> curses) {
		this.curses = curses;
	}

	public Curse addCurs(Curse curs) {
		getCurses().add(curs);
		curs.setTypeCurs(this);

		return curs;
	}

	public Curse removeCurs(Curse curs) {
		getCurses().remove(curs);
		curs.setTypeCurs(null);

		return curs;
	}

}