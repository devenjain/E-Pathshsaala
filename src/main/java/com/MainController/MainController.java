package com.MainController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.admin.bean.AdminBean;
import com.admin.dao.AdminDao;
import com.faculty.bean.FacultyBean;
import com.faculty.dao.FacultyDao;
import com.student.bean.StudentBean;
import com.student.dao.StudentDao;

@Controller
public class MainController {

	@Autowired
	AdminDao adminDao;

	@Autowired
	FacultyDao facultyDao;

	@Autowired
	StudentDao studentDao;

	@PostMapping("auth")
	public String display(@RequestParam("email") String email, @RequestParam("password") String password,
			@RequestParam("whoIs") String whoIs, Model model, HttpSession session) {

		model.addAttribute("email", email);
		model.addAttribute("password", password);
		model.addAttribute("whoIs", whoIs);

		System.out.println("Email : " + email);
		System.out.println("password : " + password);
		System.out.println("WHo : " + whoIs);

		if (whoIs.equals("1")) {

			AdminBean bean = adminDao.checkLogin(email, password);

			if (bean != null) {

				session.setAttribute("adminData", bean);
				System.out.println(bean.getAfname());
//				return "admin/AdminDashboard";
				return "redirect: dashboard";

			} else {
				model.addAttribute("err", "Invalid Credential!");
				return "../../index";
			}
		}

		if (whoIs.equals("2")) {

			FacultyBean bean = facultyDao.checkLogin(email, password);

			if (bean != null) {

				session.setAttribute("facultyData", bean);
				return "redirect: aDash";

			} else {
				model.addAttribute("err", "Invalid Credential!");
				return "../../index";
			}
		}

		if (whoIs.equals("3")) {

			StudentBean bean = studentDao.checkLogin(email, password);

			if (bean != null) {

				session.setAttribute("studentData", bean);
				return "redirect: sDash";

			} else {
				model.addAttribute("err", "Invalid Credential!");
				return "../../index";
			}
		}

		return null;
	}

}
