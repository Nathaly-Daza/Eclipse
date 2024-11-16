package co.edu.ue.model;

import java.util.ArrayList;

public class Course {
	//1.Atributos->nombres de atributos significativos
	private String name;
	private String descripcion;
	private double duration;
	private double cost;
	ArrayList<Course> ListCourses = new ArrayList<>();
	
	//2.Constructores->permiten la inicializacion de atributos
	//el constructor esta casado con la instanciación
	//Puedo tener más de un constructor->sobrecarga de constructores
	//el constructor siempre es público
	//constructor vacio
	public Course() {}
	//constructor con parametros -> inicial los atributos de la clase
	public Course(String name, String descripcion, double duration, double cost) {
		super();
		this.name = name;
		this.descripcion = descripcion;
		this.duration = duration;
		this.cost = cost;
	}
	//sobrecarga de constructores -> tener más de un constructor
	public Course(String name) {
		super();
		this.name = name;
	}
	//3. metodos de acceso -> getters y setters para acceder a los atributos
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	// creamos un método para retornar una lista de cursos y retornar un arraylist de cursos agregados
	public ArrayList<Course> myListCourses(){
		
		/*para instaciar objetos
		 * NombreClase nombreObjeto = new NombreClase()
		 * */
		//instanciar un objeto de tipo Course y agregarlo a la lista de cursos ListCourses
		this.ListCourses.add(new Course("JAVA", "CURSO BÁSICO JAVA", 40.5, 20));
		this.ListCourses.add(new Course("PYTHON", "CURSO BÁSICO PYTHON", 30.5, 25));
		this.ListCourses.add(new Course("C++", "CURSO BÁSICO C++", 23.5, 21.5));
		return this.ListCourses;
	}
	// creamos un método para agregar un curso a la lista de cursos y retornar un arraylist de cursos agregados
	public ArrayList<Course> postCourse(Course myCourse){
		//validar que el objeto myCourse tenga datos, cada uno de los elementos
		ArrayList<Course> courses = new ArrayList<>();
		courses = this.ListCourses;
		courses.add(myCourse);
		this.ListCourses = courses;
		return this.ListCourses;
	}
	// creamos un método para buscar un curso de la lista de cursos por nombre de curso y retornar un arraylist de cursos encontrados
	public ArrayList<Course> searchCourses(String name){
		ArrayList<Course> auxList = new ArrayList<>();
		ArrayList<Course> coursesReturn = new ArrayList<>();
		auxList = this.ListCourses;
		for(Course c: auxList) {
			if(c.getName().contains(name)){
				coursesReturn .add(c);
			}
		}
		return coursesReturn;
	}
	// creamos un método para actualizar un curso de la lista de cursos y retornar un arraylist de cursos actualizados
	public ArrayList<Course> updateCourse(Course myCourse){ // obtener el curso a actualizar y el curso
        ArrayList<Course> coursesReturn = new ArrayList<>(); 
        coursesReturn = this.ListCourses;
        for(Course c: coursesReturn) {
            if(c.getName().equals(myCourse.getName())){
                c.setName(myCourse.getName());
                c.setDescripcion(myCourse.getDescripcion());
                c.setDuration(myCourse.getDuration());
                c.setCost(myCourse.getCost());
            }
        }
        this.ListCourses = coursesReturn;
        return this.ListCourses;
	}
	// creamos un método para eliminar un curso de la lista de cursos
	public ArrayList<Course> deleteCourse(String name){
		ArrayList<Course> coursesReturn = new ArrayList<>();
		coursesReturn = this.ListCourses;
		coursesReturn.removeIf(c->c.getName().equals(name));
		this.ListCourses = coursesReturn;
		return this.ListCourses;
	}
	
	//4. Sobreescribir métodos de la clase Object para mostrar la información de la clase Course de forma personalizada
	@Override
	public String toString() {
		return "Course [name=" + name + ", descripcion=" + descripcion + ", duration=" + duration + ", cost=" + cost
				+ "]";
	}
}
