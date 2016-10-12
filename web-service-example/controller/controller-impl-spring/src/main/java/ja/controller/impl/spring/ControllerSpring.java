package ja.controller.impl.spring;

import java.sql.SQLException;

import ja.dao.impl.DaoImplHibernate;
import ja.mockdatabase.h2.MockDatabaseH2;
import ja.service.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ControllerSpring 
{
	@Autowired
	public Service service;
	
	ControllerSpring() throws ClassNotFoundException, SQLException
	{
		// Bring up database... you'd never do this in a real controller
		MockDatabaseH2 database = new MockDatabaseH2();
	}
	
	@RequestMapping(value={"/test"}, method = RequestMethod.GET)
	@ResponseBody
	public String Test()
	{
		
		return "Success";
	}
	
	@RequestMapping(value={"/adduser"}, method = RequestMethod.POST)
	@ResponseBody
	public String AddPerson(@RequestBody String body)
	{
		
		service.AddPerson(body);
		
		return "Success";
	}
	
}
