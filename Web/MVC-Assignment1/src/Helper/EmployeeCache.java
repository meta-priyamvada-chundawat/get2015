package Helper;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import Model.Employee;

/**
 * @author Priyamvada
 *
 */
public class EmployeeCache {
	static Map<Integer,Employee> entityCache; //Thread-safe Cache (Map)

	/**
	 *  initialized during the application start-up with 5 Sample Employees
	 */
	public EmployeeCache() {
		entityCache = new ConcurrentHashMap<Integer, Employee>();
		entityCache.put(1, new Employee(1, "Arushi", "a@gmail.com", 22.4,new Date()) );
		entityCache.put(2, new Employee(2, "Anshita", "an@gmail.com", 21.4,new Date()) );
		entityCache.put(3, new Employee(3, "Deepali", "d@gmail.com", 21.4,new Date()) );
		entityCache.put(4, new Employee(4, "Priyamada", "p@gmail.com", 23.4,new Date()) );
		entityCache.put(5, new Employee(5, "Sumitra", "s@gmail.com", 23.4,new Date()) );
	}

	
	

	
	
	
	
	

}
