import java.lang.reflect.Method;

/**
 * @author Priyamvada ---class to parse the annotation
 *
 */
public class TestAnnotationParser {
	/**
	 * Function to parse the class and run their methods through annotation
	 * 
	 * @param tempClass
	 *            ---class in which we have to parse the annotation
	 * @throws Exception
	 */
	public void parse(Class<?> tempClass) throws Exception {

		Method[] methods = tempClass.getMethods();

		for (Method method : methods) {

			if (method.isAnnotationPresent(RequestForEnhancement.class)) {
				RequestForEnhancement test = method
						.getAnnotation(RequestForEnhancement.class);
				int info = test.id();
				String synopsis = test.synopsis();
				System.out.println("annotation is awesome!");
				// try to invoke the method with param
				method.invoke(Employee.class.newInstance(), info, synopsis,
						test.engineer(), test.date());

			}

		}
	}
}
