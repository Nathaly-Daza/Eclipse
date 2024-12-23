package co.edu.ue.model;

import java.util.ArrayList;

public class Course {
	//1.Atributos -> nombres de atributos significativos
	//Atributos encapsulados
	private String name;
	private String description;
	private double duration;
	private double cost;
	ArrayList<Course> ListCourses = new ArrayList<>();
	
	//2. Constructor -> permiten la inicializacion de atributos
	//El onstructor esta casado con la instanciacion
	//Puedo tener mas de un constructor -> Sobre carga de constructores
	//El constructor siempre es público
	
	public Course() {
		this.myListCourses();
	}

	public Course(String name, String description, double duration, double cost) {
		super();
		this.name = name;
		this.description = description;
		this.duration = duration;
		this.cost = cost;
	}

	public Course(String name) {
		super();
		this.name = name;
	}
	
	//3.Metodos de acceso

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
/*	public boolean isValidCourse(Course myCourse) {
	    // Validar que el objeto no sea nulo
	    if (myCourse == null) {
	        return false;
	    }

	    // Expresiones regulares
	    String nameRegex = "^[a-zA-Z\\s]+$";
	    String descriptionRegex = "^[a-zA-Z0-9\\s.,-]+$";

	    // Validar el nombre
	    if (myCourse.getName() == null || !myCourse.getName().matches(nameRegex)) {
	        return false;
	    }

	    // Validar la descripción
	    if (myCourse.getDescription() == null || !myCourse.getDescription().matches(descriptionRegex)) {
	        return false;
	    }

	    // Validar la duración
	    if (myCourse.getDuration() <= 0) {
	        return false;
	    }

	    // Validar el costo
	    if (myCourse.getCost() <= 0) {
	        return false;
	    }

	    return true; // Todos los campos son válidos
	}
*/

	public ArrayList<Course> myListCourses(){
		//para instaciar objetos
		//NombreClase nombreObjeto = new NombreClase()
		//instanciar un objeto de tipo Course y agregarlo a la lista de cursos ListCourses
		if(this.ListCourses.isEmpty()) {
		this.ListCourses.add(new Course("JAVA", "CURSO BÁSICO JAVA", 40.5, 20));
		this.ListCourses.add(new Course("PYTHON", "CURSO BÁSICO PYTHON", 30.5, 25));
		this.ListCourses.add(new Course("C++", "CURSO BÁSICO C++", 23.5, 21.5));
		}
		return this.ListCourses;
	}
	
	public ArrayList<Course> postCourses(Course myCourse) {
	/*    if (!isValidCourse(myCourse)) {
	        throw new IllegalArgumentException("El curso no es válido. Por favor verifica los datos.");
	    }*/
		//Validar que el objeto myCourse tenga datos en cada uno de los elementos
		ArrayList<Course> courses = new ArrayList<>();
		courses = this.ListCourses;
		courses.add(myCourse);
		this.ListCourses = courses;
		return this.ListCourses;
	}
	
	//Metodo para buscar cursos
	public ArrayList<Course> searchCourses(String name){
		ArrayList<Course> auxList = new ArrayList<>();
		ArrayList<Course> coursesReturn = new ArrayList<>();
		auxList = this.ListCourses;
	 /*   if (!isValidCourse(myCourse)) {
	        throw new IllegalArgumentException("El curso no es válido. Por favor verifica los datos.");
	    }*/
		for(Course c: auxList) {
			if(c.getName().contains(name)) {
				coursesReturn .add(c);
			}
		}		
		return coursesReturn;
	}
	
	// Método para eliminar un curso de la lista de cursos
	public ArrayList<Course> deleteCourse(String name){
		ArrayList<Course> coursesReturn = new ArrayList<>();
		coursesReturn = this.ListCourses;
		coursesReturn.removeIf(c->c.getName().equals(name));
		this.ListCourses = coursesReturn;
		return this.ListCourses;
	}
	
	// Método para actualizar un curso de la lista de cursos y retornar el arrayList
	public ArrayList<Course> updateCourse(Course myCourse){
        ArrayList<Course> coursesReturn = new ArrayList<>(); 
        coursesReturn = this.ListCourses;
        for(Course c: coursesReturn) {
            if(c.getName().equals(myCourse.getName())){
                c.setName(myCourse.getName());
                c.setDescription(myCourse.getDescription());
                c.setDuration(myCourse.getDuration());
                c.setCost(myCourse.getCost());
            }
        }
        this.ListCourses = coursesReturn;
        return this.ListCourses;
	}
	
	
	@Override
	public String toString() {
		return "Course [name=" + name + ", description=" + description + ", duration=" + duration + ", cost=" + cost
				+ "]";
	}

//Ver GET http://localhost:8080/apiweb/courses
//Añadir POST http://localhost:8080/apiweb/courses 
//Actualizar POST http://localhost:8080/apiweb/updateCourses
//Eliminar DELETE http://localhost:8080/apiweb/deleteCourses/JAVA
		
}


