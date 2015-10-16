package Helper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import Model.Employee;

/**
 * @author Priyamvada
 *
 *Singleton Class
 */
public class EmployeeModelHelper {
	private static EmployeeModelHelper modelHelper = new EmployeeModelHelper();

	/**
	 * @return instance Variable
	 */
	public static EmployeeModelHelper getEmployeeModelHelper() {
		return modelHelper;
	}

	/**Getting detail of this employee
	 * @param id :employee id
	 * @return :employee instance
	 */
	public static Employee getEmployeeForId(int id) {

		if (EmployeeCache.entityCache.containsKey(id)) {//if contain this employee then return employee
			return EmployeeCache.entityCache.get(id);
		}
		return null;
	}

	/** Updating details of employee
	 * @param employee :employee object
	 */
	public static void updateEmployee(Employee employee) {
		if (EmployeeCache.entityCache.containsKey(employee.getEmployeeId())) {//if this employee exist then update
			EmployeeCache.entityCache.put(employee.getEmployeeId(), employee);

		}

	}

	/**Add employee to cache
	 * @param employee employee object
	 */
	public static void addEmployee(Employee employee) {
		if (!EmployeeCache.entityCache.containsKey(employee.getEmployeeId())) {//if not exist then add 
			employee.setEmployeeId(EmployeeCache.entityCache.size() + 1); //autoincreament of employeeid
			EmployeeCache.entityCache.put(employee.getEmployeeId(), employee);
		}
	}

	/**Getting list of all employees
	 * @return :list of employee
	 */
	public static List<Employee> getAllEmployees() {
		List<Employee> list = new ArrayList<Employee>();
		Iterator<Entry<Integer, Employee>> entries = EmployeeCache.entityCache
				.entrySet().iterator();//iterating map
		while (entries.hasNext()) {
			Entry<?, ?> entry = entries.next();
			list.add((Employee) entry.getValue());
		}
		return list;

	}

}