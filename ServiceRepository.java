package container;

import java.util.ArrayList;

public class ServiceRepository<T extends Service> {

	private ArrayList<T> service;
	
	public ServiceRepository(){
		service = new ArrayList<>();
	}
}
