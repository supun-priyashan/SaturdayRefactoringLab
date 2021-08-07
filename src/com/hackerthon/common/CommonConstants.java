package com.hackerthon.common;

public class CommonConstants {

  public static final String CONFIG_PROPERTIES="../config/config.properties";

  public static final String XML_PATH="src/com/hackerthon/config/EmployeeQuery.xml";

  public static final String QUERY="query";

	/** Constant for url key of MySQL database in config.properties */
	public static final String URL = "url";

	/** Constant for user name key of MySQL database in config.properties */
	public static final String USERNAME = "username";

	/** Constant for password key of MySQL database in config.properties */
	public static final String PASSWORD = "password";


	public static final String ID="id";
	public static final String EMPLOYEE_REQUEST="src/com/hackerthon/config/EmployeeRequest.xml";
	public static final String EMPLOYEE_MODIFIED="src/com/hackerthon/config/Employee-modified.xsl";
	public static final String EMPLOYEE_RESPONSE="src/com/hackerthon/config/EmployeeResponse.xml";
	public static final String EMPLOYEE_COUNT="count(//Employees/Employee)";
	public static final String EMPLOYEE_ID_1="//Employees/Employee[";
	public static final String EMPLOYEE_ID_2="]/EmployeeID/text()";
	public static final String EMPLOYEE_NAME_KEY="]/EmployeeFullName/text()";
	public static final String EMPLOYEE_FACULTY_KEY="]/FacultyName/text()";
	public static final String EMPLOYEE_DEPARTMENT_KEY="]/Department/text()";
	public static final String EMPLOYEE_DESIGNATION_KEY="]/Designation/text()";
	public static final String EMPLOYEE_ADDRESS_KEY="]/EmployeeFullAddress/text()";



	public static final String XPATH_EMP_ID = "XpathEmployeeIDKey";

	public static final String XPATH_EMP_DESIGNATION = "XpathDesignationKey";

	public static final String XPATH_EMP_DEPARTMENT = "XpathDepartmentKey";

	public static final String XPATH_EMP_FACULTY = "XpathFacultyNameKey";

	public static final String XPATH_EMP_ADDRESS = "XpathEmployeeAddressKey";

	public static final String XPATH_EMP_NAME = "XpathEmployeeNameKey";


	/** Constant for driver key of MySQL database in config.properties */
	public static final String DRIVER_NAME = "driverName";

	/** Constant for query id of drop_table in EmployeeQuery.xml */
	public static final String QUERY_ID_DROP_TABLE = "delete_employee" ;

	/** Constant for query id of create_table in EmployeeQuery.xml */
	public static final String QUERY_ID_CREATE_TABLE = "create_employee_table";

	/** Constant for query id of insert_employees in EmployeeQuery.xml */
	public static final String QUERY_ID_INSERT_EMPLOYEES = "insert_employee";

	/** Constant for query id of get_employee_byId in EmployeeQuery.xml */
	public static final String QUERY_ID_GET_EMPLOYEE_BY_ID = "get_employee_ById";

	/** Constant for query id of get_all_employees in EmployeeQuery.xml */
	public static final String QUERY_ID_GET_ALL_EMPLOYEES = "get_employees";

	/** Constant for delete_employee in EmployeeQuery.xml */
	public static final String DELETE_EMPLOYEE = "get_employees";