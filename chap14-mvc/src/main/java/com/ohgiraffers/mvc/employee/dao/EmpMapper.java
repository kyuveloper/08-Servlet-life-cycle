package com.ohgiraffers.mvc.employee.dao;

import com.ohgiraffers.mvc.employee.dto.EmpDTO;
import com.ohgiraffers.mvc.employee.dto.EmpDeleteDTO;
import com.ohgiraffers.mvc.employee.dto.EmpInsertDTO;
import com.ohgiraffers.mvc.employee.dto.EmpUpdateDTO;

import java.util.List;

public interface EmpMapper {
    EmpDTO selectByEmpId(int empId);

    List<EmpDTO> selectAllEmp();

    int insert(EmpInsertDTO insert);

    int delete(EmpDeleteDTO delete);

    int update(EmpUpdateDTO update);
}