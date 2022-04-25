package com.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.admin.bean.SubjectBean;
import com.admin.dao.AdminDao;
import com.faculty.bean.FacultyBean;
import com.util.DataValidation;

@Controller
public class AdminController {

	@Autowired
	AdminDao adminDao;

	@GetMapping("/aSubjects")
	public String subjectController() {
		return "admin/Subject";
	}

	@GetMapping("/adminProfile")
	public String gotoProfile() {
		return "admin/AdminProfile";
	}

	@GetMapping("/dashboard")
	public String gotoDashboard() {
		return "admin/AdminDashboard";
	}

	@PostMapping("addSubject")
	public String addSubjectString(SubjectBean subBean, Model model) {

		int res = adminDao.insertSub(subBean);

		if (res > 0) {
			return "redirect: subjects";
		} else {

			model.addAttribute("err", "Something went wrong, Please try again!");
			return "redirect: subjects";
		}

	}

	@RequestMapping("subjects")
	public String allSubjects(Model model) {

		model.addAttribute("subjectList", adminDao.subjects());

		return "admin/Subject";
	}

	@RequestMapping("deleteSub")
	public String dltSub(@RequestParam("sub_id") int sub_id) {

		if (adminDao.deleteSubject(sub_id) > 0) {
			return "redirect: subjects";
		}
		return "redirect: subjects";
	}

	@RequestMapping("editSub")
	public String editSub(@RequestParam("sub_id") int sub_id, Model model) {
		System.out.println("Sub_id : " + sub_id);

		SubjectBean bean = adminDao.subjectsByID(sub_id);

		model.addAttribute("sub_bean", bean);

		return "admin/EditSubject";
	}

	@PostMapping("updateSub")
	public String updateSub(SubjectBean bean, Model model) {

		if (adminDao.updateSub(bean) > 0) {
			return "redirect: subjects";
		}
		return "redirect: subjects";

	}

	@RequestMapping("addFaculty")
	public String gotoFacultyForm(Model model) {

		model.addAttribute("subjectList", adminDao.subjects());

		return "admin/AddFaculty";
	}

	@PostMapping("insertFaculty")
	public String insertFaculty(FacultyBean bean, Model model) {

		String fpassword = bean.getFfname() + bean.getFid();

		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		boolean flag4 = false;

		if (DataValidation.nameValidation(bean.getFfname()) == true) {
			flag1 = true;
			System.out.println("flag1 = true");

		} else {
			flag1 = false;
			model.addAttribute("fname", bean.getFfname());
			model.addAttribute("fnameError", " *Invalid Name! Name must be contain only character");
		}

		if (DataValidation.nameValidation(bean.getFlname()) == true) {
			flag2 = true;

		} else {
			flag2 = false;
			model.addAttribute("lname", bean.getFlname());
			model.addAttribute("lnameError", " *Invalid Name! Name must be contain only character");
		}

		if (DataValidation.emailValidation(bean.getFemail()) == true) {
			flag3 = true;

		} else {
			flag3 = false;
			model.addAttribute("emil", bean.getFemail());
			model.addAttribute("emailError", " *Invalid Email!");
		}

		if (DataValidation.phoneValidation(String.valueOf(bean.getFphone()))) {
			flag4 = true;
			System.out.println("flag6 = true  phone - " + bean.getFphone());
		} else {
			flag4 = false;
			model.addAttribute("phone", bean.getFphone());
			model.addAttribute("phoneerror", "*Invalid Phone Number!");
		}

		if (flag1 == false || flag2 == false || flag3 == false || flag4 == false) {
			model.addAttribute("subjectList", adminDao.subjects());
			return "admin/AddFaculty";
		} else {

			bean.setFpassword(fpassword);

			if (adminDao.insertFaculty(bean) > 0) {
				System.out.println("Faculty Added");
				return "redirect: faculties";
			} else {
				model.addAttribute("errormsg1", "Something Went wrong, Please try again!");
				model.addAttribute("subjectList", adminDao.subjects());
				return "admin/AddFaculty";
			}

		}

	}

	@RequestMapping("faculties")
	public String facultyList(Model model) {

		model.addAttribute("facultyList", adminDao.getAllFaculty());

		return "admin/FacultyList";
	}

	@RequestMapping("deleteFac")
	public String dltFaculty(@RequestParam("fid") int fid) {

		if (adminDao.deleteFaculty(fid) > 0) {
			return "redirect: faculties";
		}
		return "redirect: faculties";
	}

	@RequestMapping("editFac")
	public String editFaculty(@RequestParam("fid") int fid, Model model) {
		System.out.println("Sub_id : " + fid);

		FacultyBean bean = adminDao.facultyByID(fid);
		model.addAttribute("subjectList", adminDao.subjects());
		model.addAttribute("bean", bean);

		return "admin/EditFaculty";
	}

	@PostMapping("updateFac")
	public String updateFac(FacultyBean bean, Model model) {

		String fpassword = bean.getFfname() + bean.getFid();

		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		boolean flag4 = false;

		if (DataValidation.nameValidation(bean.getFfname()) == true) {
			flag1 = true;
			System.out.println("flag1 = true");

		} else {
			flag1 = false;
			model.addAttribute("fname", bean.getFfname());
			model.addAttribute("fnameError", " *Invalid Name! Name must be contain only character");
		}

		if (DataValidation.nameValidation(bean.getFlname()) == true) {
			flag2 = true;

		} else {
			flag2 = false;
			model.addAttribute("lname", bean.getFlname());
			model.addAttribute("lnameError", " *Invalid Name! Name must be contain only character");
		}

		if (DataValidation.emailValidation(bean.getFemail()) == true) {
			flag3 = true;

		} else {
			flag3 = false;
			model.addAttribute("emil", bean.getFemail());
			model.addAttribute("emailError", " *Invalid Email!");
		}

		if (DataValidation.phoneValidation(String.valueOf(bean.getFphone()))) {
			flag4 = true;
			System.out.println("flag6 = true  phone - " + bean.getFphone());
		} else {
			flag4 = false;
			model.addAttribute("phone", bean.getFphone());
			model.addAttribute("phoneerror", "*Invalid Phone Number!");
		}

		if (flag1 == false || flag2 == false || flag3 == false || flag4 == false) {
			model.addAttribute("subjectList", adminDao.subjects());
			return "admin/EditFaculty";
		} else {

			bean.setFpassword(fpassword);

			if (adminDao.updateFaculty(bean) > 0) {
				System.out.println("Faculty updated");
				return "redirect: faculties";
			} else {
				model.addAttribute("errormsg1", "Something Went wrong, Please try again!");
				model.addAttribute("subjectList", adminDao.subjects());
				return "admin/EditFaculty";
			}

		}
	}

}
