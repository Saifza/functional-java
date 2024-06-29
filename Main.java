package learnstream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import learnstream.Employee;
import learnstream.Department;

public class Main {

	public static void main(String[] args) {
		
		 List<Employee> employee = List.of(
				    new Employee(1, "James", 1400,"male", new Department(1, "HR")),
				    new Employee(2, "Norman", 2050,"male", new Department(1, "HR")),
				    new Employee(3, "Stephanie", 1250,"female", new Department(2, "Finance")),
				    new Employee(4, "Francis", 2100,"male", new Department(2, "Finance")),
				    new Employee(5, "Karl", 2300,"male", new Department(2, "Finance")),
				    new Employee(6, "Rod",1000,"male", new Department(3, "Admin")),
				    new Employee(7, "Newhart", 950,"male", new Department(3, "Admin")),
		            new Employee(8, "Jennifer", 1150,"female", new Department(3, "Admin")),
		            new Employee(9, "Jane", 1000,"female", new Department(4, "IT")),
		            new Employee(10, "Philip", 980,"male", new Department(4, "IT")),
		            new Employee(11, "Elaine", 1560,"female", new Department(2, "Finance")));
	
// Find maximum salary by department		 
		 
		 Map<Department, Optional<Employee>> maxSalaryByDepartment = employee.stream()
	                .collect(Collectors.groupingBy(Employee::getDepartment,
	                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));

	        maxSalaryByDepartment.forEach((department, emp) -> {
	            if (emp.isPresent()) {
	                System.out.println("Max salary in department of " + department.name + ": " + emp.get().getSalary());
	            } else {
	                System.out.println("No person found in department " + department.name);
	            }
	     });
		 

		 // Find average salary in each department
		
	
		
		
		  
		    Double averageSalaryOfHr = employee.stream()
		    .filter(e->e.getDepartment().getName()=="HR")
		    .collect(Collectors.averagingInt(Employee::getSalary));
		    
		    System.out.println("Average Salary in HR: "+ averageSalaryOfHr);
		    
		    Optional<Integer> maxSalaryOfHr = employee.stream()
		    .filter(e->e.getDepartment().getName()=="HR")
		    .collect(Collectors.mapping(Employee::getSalary, Collectors.maxBy(Comparator.naturalOrder())));
		
		 if(maxSalaryOfHr.isPresent())   
	    System.out.println("Maximum Salary in HR: "+maxSalaryOfHr.get());
	
// Find the maximum salary of a female employee 
		 
		    Optional<Integer> maxSalaryOfFemaleEmployee = employee.stream()
		    .filter(e->e.getGender()=="female")
		    .collect(Collectors.mapping(Employee::getSalary, Collectors.maxBy(Comparator.naturalOrder())));
		
		   if(maxSalaryOfFemaleEmployee.isPresent()) 
			   System.out.println("Maximum salary of female employeë "+ maxSalaryOfFemaleEmployee.get());
	
// Find maximum salary of a female employee along with the department name and employee name.		 
		 
		 Optional<DepartmentSalary> maxSalaryOfFemale = employee.stream()
	                .filter(e -> e.getGender().equals("female"))
	                .collect(Collectors.groupingBy(
	                        e -> e.getDepartment().getName(),
	                        Collectors.collectingAndThen(
	                                Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)),
	                                Optional::get
	                        )))
	                .entrySet().stream()
	                .map(entry -> new DepartmentSalary(entry.getKey(), entry.getValue().getName(), entry.getValue().getSalary()))
	                .max(Comparator.comparingInt(DepartmentSalary::getSalary));

	        maxSalaryOfFemale.ifPresent(max ->
	                System.out.println("Department: " + max.getDepartmentName() +
	                        ", Employee Name: " + max.getEmployeeName() +
	                        ", Max Salary: " + max.getSalary()));

	
	        
	        // Group employees by their gender and then from each group find the employee with maximum salary 
	        //The output will be a map where the key is the gender and the value is an Optional 
	        //containing the employee with the highest salary.
	        
	        
	        Map<String, Optional<Employee>> highestPaidByGender = employee.stream()
	                .collect(Collectors.groupingBy(
	                        Employee::getGender,
	                        Collectors.mapping(
	                                e -> e,
	                                Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))
	                        )
	                ));

	        highestPaidByGender.forEach((gender, emp) -> 
	                System.out.println("Gender: " + gender + ", Highest Paid: " + employee));
	        
	        
	   
	}


		 
	}

    class DepartmentSalary {
        String departmentName;
        String employeeName;
        int salary;
       
        
        public DepartmentSalary(String departmentName, String employeeName, int salary) {
            this.departmentName = departmentName;
            this.employeeName=employeeName;
            this.salary = salary;
        }

        public String getDepartmentName() {
            return departmentName;
        }
        
       	

		public String getEmployeeName() {
			return employeeName;
		}

		public int getSalary() {
            return salary;
        }
    }
	

