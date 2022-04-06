package com.example.demo.service.impl;


import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.employee.Employee;
import com.example.demo.repository.IEmployeeRepository;
import com.example.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.saveEmployee(employee.getCode(), employee.getName(),
                employee.getDateOfBirth(), employee.getGender(), employee.getDeleteFlag(),
                employee.getImage(), employee.getPhone(),
                employee.getAddress(), employee.getEmployeePosition().getId());

    }

//    @Override
//    public boolean existsEmployeeByCode(String spaceCode) {
//        return employeeRepository.existsEmployeeByCode(spaceCode) != null;
//    }

    @Override
    public boolean checkCodeEmployee(String spaceCode) {
        List<Employee> employees = employeeRepository.findAllEmployee();
        for (Employee e : employees) {
            if (e.getCode().equals(spaceCode)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void editEmployee(Employee employee) {
        employeeRepository.editEmployee(employee.getCode(), employee.getName(), employee.getDateOfBirth(),
                employee.getDeleteFlag(), employee.getGender(), employee.getImage(), employee.getPhone(),
                employee.getAddress(), employee.getEmployeePosition().getId(), employee.getId());
    }

    @Override
    public EmployeeDTO findByEmployeeId(Integer id) {
        return employeeRepository.findEmployeeById(id);
    }

    @Override
    public Page<Employee> findAllEmployee(Pageable pageable) {
        return this.employeeRepository.findAllEmployee(pageable);
    }

    @Override
    public Page<Employee> findAllEmployeeByKeyword(String keyword, Pageable pageable) {
        return this.employeeRepository.findAllEmployeeByKeyword(keyword, pageable);
    }

    @Override
    public Optional<Employee> findEployeeById(Integer id) {
        return this.employeeRepository.findEployeeById(id);
    }

    @Override
    public void deleteById(Integer id) {
        this.employeeRepository.deleteById(id);
    }

    //Bảo tìm nhân viên theo mã nhân viên
    @Override
    public Employee findEmployeeByCode(String employeeCode) {
        return employeeRepository.getEmployeeByCode(employeeCode);
    }


    @Override
    public Employee getEmployeeByUsername(String username) {
        return employeeRepository.findEmployeeByAppUser(username);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Boolean existsEmployeeByCode(String employeeCode) {
        return employeeRepository.getEmployeeByCode(employeeCode) != null;
    }
}
