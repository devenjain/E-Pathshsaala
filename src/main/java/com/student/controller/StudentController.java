package com.student.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.admin.dao.AdminDao;
import com.faculty.bean.SubjectFileBean;
import com.faculty.dao.FacultyDao;
import com.student.dao.StudentDao;

@Controller
public class StudentController {

	@Autowired
	StudentDao studentDao;

	@Autowired
	FacultyDao facultyDao;

	@Autowired
	AdminDao adminDao;

	@GetMapping("/sDash")
	public String gotoDashboard(Model model) {

		model.addAttribute("subjects", adminDao.subjects());

		return "student/StudentDashboard";
	}

	@GetMapping("/subFiles")
	public String getFile(@RequestParam("sub_id") int sub_id, @RequestParam("sub_name") String sub_name, Model model) {

		ArrayList<SubjectFileBean> fileList = (ArrayList<SubjectFileBean>) facultyDao.getAllSubjectFile(sub_id);

		model.addAttribute("FileList", fileList);
		model.addAttribute("sub_name", sub_name);
		model.addAttribute("sub_id", sub_id);
		return "student/SubjectFiles";
	}

	@GetMapping("/studentProfile")
	public String gotoProfile() {
		return "student/StudentProfile";
	}

}
