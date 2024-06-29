# Employee Management Stream API Example

This repository contains a simple Java application that demonstrates the use of Java Stream API for various operations on a list of employees. The application is structured into three classes: `Main`, `Employee`, and `Department`.

## Classes

### 1. `Main`
The `Main` class contains the main method which is the entry point of the application. It performs several operations on a list of employees using Java Streams.

#### Operations:
- **Find maximum salary by department**
- **Find average salary in each department**
- **Find the maximum salary of a female employee**
- **Find maximum salary of a female employee along with the department name and employee name**
- **Group employees by their gender and find the employee with the maximum salary in each group**

### 2. `Employee`
The `Employee` class represents an employee with attributes:
- `int id`
- `String name`
- `Integer salary`
- `String gender`
- `Department department`

#### Methods:
- Getters and setters for each attribute
- `toString()` method for displaying employee information

### 3. `Department`
The `Department` class represents a department with attributes:
- `int id`
- `String name`

#### Methods:
- Getters and setters for each attribute
- `toString()` method for displaying department information
- `equals()` and `hashCode()` methods for comparing department objects

## Usage

To run the application, execute the `Main` class. The main method initializes a list of employees and performs various operations using Java Streams.

### Example Output
```plaintext
Max salary in department of HR: 2050.0
Max salary in department of Finance: 2300.0
Max salary in department of Admin: 1150.0
Max salary in department of IT: 1000.0
Average Salary in HR: 1725.0
Maximum Salary in HR: 2050
Maximum salary of female employee: 1560
Department: Finance, Employee Name: Elaine, Max Salary: 1560
Gender: male, Highest Paid: Optional[Employee [id=1, name=James, salary=1400, department=Department [id=1, name=HR]]]
Gender: female, Highest Paid: Optional[Employee [id=3, name=Stephanie, salary=1250, department=Department [id=2, name=Finance]]]
