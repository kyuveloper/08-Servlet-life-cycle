package com.ohgiraffers.mvc.employee.controller;

import com.google.protobuf.WireFormat;
import com.ohgiraffers.mvc.employee.dto.EmpDTO;
import com.ohgiraffers.mvc.employee.dto.EmpDeleteDTO;
import com.ohgiraffers.mvc.employee.dto.EmpInsertDTO;
import com.ohgiraffers.mvc.employee.dto.EmpUpdateDTO;
import com.ohgiraffers.mvc.employee.service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/employees")
public class SelectEmpServlet extends HttpServlet {
    private EmpService empService;

    @Override   // init은 리소스를 할당하는 경우 사용한다.
    public void init() throws ServletException {
        empService = new EmpService();
        System.out.println(empService + "현재 상태");
    }

    @Override
    public void destroy() {
        empService = null;
        System.out.println(empService + "현재 상태");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empId = request.getParameter("empId");

        String path = null; // 조회 목적마다 페이지가 다름

        if (empId == null) {
            //전체 조회
            // get /employees 값 없이 전체 조회
            List<EmpDTO> empList = empService.selectAllEmp();

            request.setAttribute("empList", empList);
            path = "/WEB-INF/views/employee/empList.jsp";
        } else {
            // get /employees?empId=200 으로 200번인 사원 조회
            // 단일 사원 조회
            Object result = empService.selectEmp(empId);
            if(result instanceof EmpDTO){
                result = (EmpDTO)result;
            }else {
                result = (String) result;
            }
            request.setAttribute("emp", result);
            path = "/WEB-INF/views/employee/showEmpInfo.jsp";
        }
        request.getRequestDispatcher(path).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        EmpInsertDTO insert = new EmpInsertDTO();
        EmpDeleteDTO delete = new EmpDeleteDTO();

        if (req.getParameter("empDelName") != null) {
            delete.setEmpDelName(req.getParameter("empDelName"));
            delete.setEmpDelId(Integer.parseInt(req.getParameter("empDelId")));

            String path;
            int dresult = empService.delete(delete);
            System.out.println(dresult);
            if (dresult > 0) {
                path = "/WEB-INF/views/common/successDelPage.jsp";
                req.setAttribute("message", "해당 직원 삭제 완료");
            } else {
                path = "/WEB-INF/views/common/errorDelPage.jsp";
                req.setAttribute("message", "직원 삭제 실패");
            }
            req.getRequestDispatcher(path).forward(req, resp);
        }

        if (req.getParameter("empName") != null) {
            insert.setEmpId(req.getParameter("empId"));
            insert.setEmpName(req.getParameter("empName"));
            insert.setEmpNo(req.getParameter("empNo"));
            insert.setEmail(req.getParameter("email"));
            insert.setPhone(req.getParameter("phone"));
            insert.setDeptCode(req.getParameter("deptCode"));
            insert.setJobCode(req.getParameter("jobCode"));
            insert.setSalLevel(req.getParameter("salLevel"));
            insert.setSalary(Integer.parseInt(req.getParameter("salary")));
            insert.setBonus(Double.parseDouble(req.getParameter("bonus")));
            insert.setManagerId(req.getParameter("managerId"));
            insert.setHireDate(java.sql.Date.valueOf(req.getParameter("hireDate")));

            String path;
            int result = empService.insert(insert);
            if (result > 0) {
                path = "/WEB-INF/views/common/successPage.jsp";
                req.setAttribute("message", "신규 직원 등록 완료");
            } else {
                path = "/WEB-INF/views/common/errorPage.jsp";
                req.setAttribute("message", "직원 등록 실패");
            }
            req.getRequestDispatcher(path).forward(req, resp);
        }

        /*if (req.getParameter("empIdToUpdate") != null) {
            // 이동할 수정 폼으로 redirect
            resp.sendRedirect(req.getContextPath() + "/employees/update?empId=" + req.getParameter("empIdToUpdate"));
        } else if (req.getParameter("empId") != null) {
            // Update 처리 코드
            EmpUpdateDTO update = new EmpUpdateDTO();
            update.setEmpId(req.getParameter("empId"));
            update.setEmpName(req.getParameter("empName"));
            update.setEmail(req.getParameter("email"));
            update.setPhone(req.getParameter("phone"));
            update.setDeptCode(req.getParameter("deptCode"));
            update.setJobCode(req.getParameter("jobCode"));
            update.setSalLevel(req.getParameter("salLevel"));
            // ... (나머지 필드 설정)

            String path;
            int uResult = empService.update(update);
            if (uResult > 0) {
                path = "/WEB-INF/views/common/successUpdatePage.jsp";
                req.setAttribute("message", "직원 정보 수정 완료");
            } else {
                path = "/WEB-INF/views/common/errorUpdatePage.jsp";
                req.setAttribute("message", "직원 정보 수정 실패");
            }
            req.getRequestDispatcher(path).forward(req, resp);
        }*/

    }
}