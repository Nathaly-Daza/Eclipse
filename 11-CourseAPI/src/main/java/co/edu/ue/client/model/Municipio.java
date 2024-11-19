package co.edu.ue.client.model;

public class Municipio {
	//1.Atributos
	 	private String region;
		private String departamento;
	    private String municipio;
		private String codDepartamento;

	    // 2. Constructores : Uno para inicializar todos los campos.

	    public Municipio(String region, String departamento, String municipio, String codDepartamento) {
			super();
			this.region = region;
			this.departamento = departamento;
			this.municipio = municipio;
			this.codDepartamento = codDepartamento;
		}
	    
	    //Métodos getter y setter: Para acceder y modificar los valores de los atributos.
	    public String getRegion() {
			return region;
		}

		public void setRegion(String region) {
			this.region = region;
		}

		public String getDepartamento() {
			return departamento;
		}

		public void setDepartamento(String departamento) {
			this.departamento = departamento;
		}

		public String getMunicipio() {
			return municipio;
		}

		public void setMunicipio(String municipio) {
			this.municipio = municipio;
		}

		public String getCodDepartamento() {
			return codDepartamento;
		}

		public void setCodDepartamento(String codDepartamento) {
			this.codDepartamento = codDepartamento;
		}
		/*@Override
	    public String toString() {
	        return "Municipio{" +
	                "departamento='" + departamento + '\'' +
	                ", municipio='" + municipio + '\'' +
	                '}';
	    }
		*/


		
}
