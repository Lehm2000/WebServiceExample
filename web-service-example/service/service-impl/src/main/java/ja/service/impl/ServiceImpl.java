package ja.service.impl;

import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;

import ja.dao.api.Dao;
import ja.schema.Person;
import ja.schema.Persons;
import ja.service.api.Service;


public class ServiceImpl implements Service 
{
	@Autowired
	public Dao dao;

	public boolean AddPerson(String personXML) {
		
		StringReader reader = new StringReader(personXML);
		
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Persons.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Persons persons = (Persons) jaxbUnmarshaller.unmarshal(reader);
			
			List<ja.schema.Persons.Person> personList = persons.getPerson();
			
			for(ja.schema.Persons.Person person: personList)
			{
				dao.AddPerson(person.getFirstName(), person.getLastName(), person.getAge());
			}
			
		} catch (JAXBException e) {
			
			e.printStackTrace();
		}
		
		
		return false;
	}

	
    
}
