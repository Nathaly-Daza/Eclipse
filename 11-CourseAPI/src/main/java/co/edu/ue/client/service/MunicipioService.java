package co.edu.ue.client.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import co.edu.ue.client.model.Municipio;


@Service
public class MunicipioService  implements MunicipioServiceI{

	    final String URL = "https://www.datos.gov.co/resource/xdk5-pm3f.json";
	    //Usa RestTemplate para hacer una solicitud GET a la URL de la API 
	    @Autowired
	    RestTemplate restTemplate;

	    //Este método devuelve una lista con todos los municipios obtenidos de la API.
	    @Override
	    public List<Municipio> listMunicipios() {
	    	//Se creo una lista vacía donde se guardarán los municipios después de procesarlos.
	    	//Funciona para convertit el JSON recibido a una lista de objetos Municipio usando ObjectMapper.
	        List<Municipio> municipios = new ArrayList<>();
	        try {
	        	//Debemos hacer una solicitud HTTP GET a la API usando RestTemplate no template, no me lo tomo. 
	            // La respuesta de la api se obtiene como un String
	            String response = restTemplate.getForObject(URL, String.class);
	            
	            //Object Mapper es una herramienta de la biblioteca de Jackson que convierte JSON a los objetos de java.
	            // Parseamos la respuesta JSON
	            ObjectMapper mapper = new ObjectMapper();
	            //Este convierte el string JSON en un arrayNode o la lista de objetos JSON
	            ArrayNode array = (ArrayNode) mapper.readTree(response);

	            // Iteramos sobre el array JSON para mapear los objetos a la clase Municipio
	            //Se recorre cada objeto en nuestro arreglo de JSON
	            for (JsonNode node : array) {
	                ObjectNode json = (ObjectNode) node;
	                Municipio municipio = new Municipio(
	                        json.get("region").asText(),
	                        json.get("departamento").asText(),
	                        json.get("municipio").asText(),
	                        json.get("c_digo_dane_del_departamento").asText() 
	                );
		            //Obteniendo cada propiedad y las agregamos a un nuevo Objeto llamado Municipio, con los nuevos datos lo agregamos a la lista
	                municipios.add(municipio);
	            }
	            //Nos sirve para Manejar posibles errores durante el mapeo como que el API no siva o el Json.
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        //Devolvcemos la lista de los municipios ya procesados
	        return municipios;
	    }

	    //Este método nos sirve para filtrar los municipios que pertenecen a un departamento específico.
	    @Override
	    //Llamamos a listMunicipios para obtener todos los muunicipios.
	    public List<Municipio> searchDepartamento(String name) {
	    	//Filtramos los municipios cuyo atributo departamento coincida 
	    	//(Ignoramos el Case) con el nombre proporcionado.
	        return listMunicipios()
	        		//Nos permite convertir la lista en un flujo de datos que podamos procesar
	                .stream()
	                //Nos permite filtrar los departamentos que coincidadn por nombre y usamos el Ignore para que no importe mayusculas o minisculas
	                .filter(m -> m.getDepartamento().equalsIgnoreCase(name))
	                //Vuelve a convertir en una Lista
	                .collect(Collectors.toList());
	    }

}
