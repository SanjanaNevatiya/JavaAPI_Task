This API provides two key functionalities: creating a new employee and retrieving employee details.

Task 1: Create Employee
The POST /employees endpoint allows clients to add a new employee by providing name, email, departmentId, and roleId in the request body. The API requires a valid access token in the request header for authorization. If the token is invalid or expired, a 401 Unauthorized response is returned. Upon successful addition, a 201 Created response with the message "Employee Added" is returned.

Task 2: Get Employee Details
The GET /employees/{id} endpoint retrieves an employee's details by their ID. It also requires a valid access token in the request header. If the token is invalid, a 401 Unauthorized response is returned, and if the employee does not exist, a 404 Not Found response is returned with the message "Employee Not Found". The employee details include their department and role, retrieved using JPA's JOIN FETCH to fetch data from related tables (employees, departments, and roles) in a single query.

The database schema includes employees, departments, and roles tables, with foreign key relationships to ensure data integrity and efficient data retrieval.
