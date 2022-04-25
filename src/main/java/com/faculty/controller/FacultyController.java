package com.faculty.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.faculty.bean.FacultyBean;
import com.faculty.bean.SubjectFileBean;
import com.faculty.dao.FacultyDao;
import com.faculty.services.FacultyService;
import com.student.bean.StudentBean;
import com.util.DataValidation;

@Controller
public class FacultyController {

	@Autowired
	FacultyDao facultyDao;

	@Autowired
	FacultyService facultyService;

	@GetMapping("/students")
	public String gotoStudents(Model model) {

		model.addAttribute("studentList", facultyDao.getAllStudents());

		return "faculty/StudentList";
	}

	@GetMapping("/facultyProfile")
	public String gotoProfile(Model model) {
		return "faculty/FacultyProfile";
	}

	@GetMapping("/facSignOut")
	public String logout(HttpSession session) {
		session.invalidate();
		return "../../index";
	}

	@GetMapping("/aDash")
	public String gotoDashboard(Model model, HttpSession session) {
		FacultyBean facultyBean = (FacultyBean) session.getAttribute("facultyData");
		model.addAttribute("studentcount", facultyDao.getAllStudents().size() + 1);
		model.addAttribute("facultycount", facultyDao.getAllFaculty().size() + 1);
		model.addAttribute("filecount", facultyDao.getAllSubjectFile(facultyBean.getSub_id()).size() + 1);

		return "faculty/FacultyDashboard";
	}

	@GetMapping("/addStudent")
	public String gotoAddStudents() {
		return "faculty/AddStudent";
	}

	@GetMapping("/uploadForm")
	public String gotoUploadFileForm(Model model, HttpSession session) {

		FacultyBean facultyBean = (FacultyBean) session.getAttribute("facultyData");
		System.out.println("inside the form url");
		String pathString = "E:\\Spring_Program\\E-Pathshala\\src\\main\\webapp\\resources\\Subject\\"
				+ facultyBean.getSub_name() + "";

		ArrayList<SubjectFileBean> fileList = (ArrayList<SubjectFileBean>) facultyDao
				.getAllSubjectFile(facultyBean.getSub_id());

		for (int i = 0; i < fileList.size(); i++) {
			SubjectFileBean bean = fileList.get(i);

//			System.out.println("File name : " + bean.getFile_name());
//			System.out.println("File Desc : " + bean.getFile_desc());
//			System.out.println("SubjectName : " + bean.getSub_name());

		}

		model.addAttribute("FileList", fileList);
		model.addAttribute("path", pathString);

		return "faculty/UploadFile";
	}

	@PostMapping("insertStudent")
	public String insertStudent(StudentBean bean, Model model) {

		String fpassword = bean.getSfname() + bean.getSid();
		System.out.println("Student Password is : " + fpassword);

		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		boolean flag4 = false;
		boolean flag5 = false;

		if (DataValidation.nameValidation(bean.getSfname()) == true) {
			flag1 = true;
			System.out.println("flag1 = true");
			model.addAttribute("fname", bean.getSfname());
		} else {
			flag1 = false;
			model.addAttribute("fname", bean.getSfname());
			model.addAttribute("fnameError", " *Invalid Name! Name must be contain only character");
		}

		if (DataValidation.nameValidation(bean.getSlname()) == true) {
			flag2 = true;
			model.addAttribute("lname", bean.getSlname());
		} else {
			flag2 = false;
			model.addAttribute("lname", bean.getSlname());
			model.addAttribute("lnameError", " *Invalid Name! Name must be contain only character");
		}

		if (DataValidation.nameValidation(bean.getSmname()) == true) {
			flag5 = true;
			model.addAttribute("mname", bean.getSmname());
		} else {
			flag5 = false;
			model.addAttribute("mname", bean.getSmname());
			model.addAttribute("mnameError", " *Invalid Name! Name must be contain only character");
		}

		if (DataValidation.emailValidation(bean.getSemail()) == true) {
			flag3 = true;
			model.addAttribute("emil", bean.getSemail());
		} else {
			flag3 = false;
			model.addAttribute("emil", bean.getSemail());
			model.addAttribute("emailError", " *Invalid Email!");
		}

		if (DataValidation.phoneValidation(String.valueOf(bean.getSphone()))) {
			flag4 = true;
			model.addAttribute("phone", bean.getSphone());
			System.out.println("flag6 = true  phone - " + bean.getSphone());
		} else {
			flag4 = false;
			model.addAttribute("phone", bean.getSphone());
			model.addAttribute("phoneError", "*Invalid Phone Number!");
		}

		if (flag1 == false || flag2 == false || flag3 == false || flag4 == false || flag5 == false) {
			return "faculty/AddStudent";
		} else {

			bean.setSpassword(fpassword);

			if (facultyDao.insertStudent(bean) > 0) {
				System.out.println("Faculty Added");
				return "redirect: students";
			} else {
				model.addAttribute("errormsg1", "Something Went wrong, Please try again!");
				return "faculty/AddStudent";
			}

		}

	}

	@GetMapping("/deleteStudent")
	public String dltStudent(@RequestParam("sid") int sid) {

		if (facultyDao.deleteStudent(sid) > 0) {
			return "redirect: students";
		}
		return "redirect: students";
	}

	@RequestMapping("editStudent")
	public String edtStud(@RequestParam("sid") int sid, Model model) {

		StudentBean bean = facultyDao.studentByID(sid);
		model.addAttribute("bean", bean);

		return "faculty/EditStudent";
	}

	@PostMapping("updateStudent")
	public String updateStudent(StudentBean bean, Model model) {

		String fpassword = bean.getSfname() + bean.getSid();
		System.out.println("Student Password is : " + fpassword);

		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		boolean flag4 = false;
		boolean flag5 = false;

		if (DataValidation.nameValidation(bean.getSfname()) == true) {
			flag1 = true;
			System.out.println("flag1 = true");
			model.addAttribute("fname", bean.getSfname());
		} else {
			flag1 = false;
			model.addAttribute("fname", bean.getSfname());
			model.addAttribute("fnameError", " *Invalid Name! Name must be contain only character");
		}

		if (DataValidation.nameValidation(bean.getSlname()) == true) {
			flag2 = true;
			model.addAttribute("lname", bean.getSlname());
		} else {
			flag2 = false;
			model.addAttribute("lname", bean.getSlname());
			model.addAttribute("lnameError", " *Invalid Name! Name must be contain only character");
		}

		if (DataValidation.nameValidation(bean.getSmname()) == true) {
			flag5 = true;
			model.addAttribute("mname", bean.getSmname());
		} else {
			flag5 = false;
			model.addAttribute("mname", bean.getSmname());
			model.addAttribute("mnameError", " *Invalid Name! Name must be contain only character");
		}

		if (DataValidation.emailValidation(bean.getSemail()) == true) {
			flag3 = true;
			model.addAttribute("emil", bean.getSemail());
		} else {
			flag3 = false;
			model.addAttribute("emil", bean.getSemail());
			model.addAttribute("emailError", " *Invalid Email!");
		}

		if (DataValidation.phoneValidation(String.valueOf(bean.getSphone()))) {
			flag4 = true;
			model.addAttribute("phone", bean.getSphone());
			System.out.println("flag6 = true  phone - " + bean.getSphone());
		} else {
			flag4 = false;
			model.addAttribute("phone", bean.getSphone());
			model.addAttribute("phoneError", "*Invalid Phone Number!");
		}

		if (flag1 == false || flag2 == false || flag3 == false || flag4 == false || flag5 == false) {
			model.addAttribute("bean", facultyDao.studentByID(bean.getSid()));
			return "faculty/EditStudent";
		} else {

			bean.setSpassword(fpassword);

			if (facultyDao.updatStudent(bean) > 0) {
				System.out.println("student updates");
				return "redirect: students";
			} else {
				model.addAttribute("errormsg1", "Something Went wrong, Please try again!");
				model.addAttribute("bean", facultyDao.studentByID(bean.getSid()));
				return "faculty/EditStudent";
			}

		}

	}

	@PostMapping("uploadFile")
	public String uplaodFile(@RequestParam("subjectFile") MultipartFile file,
			@RequestParam("file_desc") String file_desc, HttpSession session, Model model) {

		System.out.println("File name : " + file.getOriginalFilename());

		if (file.getContentType().equals("image/jpeg") || file.getContentType().equals("image/jp")
				|| file.getContentType().equals("image/png") || file.getContentType().equals("application/pdf")) {

//			String extension = FilenameUtils.getExtension(file.getOriginalFilename());
//			System.out.println("File Type by extension : " + extension);

			System.out.println("File type by methos ; " + file.getContentType());

			FacultyBean facultyBean = (FacultyBean) session.getAttribute("facultyData");

			System.out.println("Subject name : " + facultyBean.getSub_name());

			String pathString = "E:\\Spring_Program\\E-Pathshala\\src\\main\\webapp\\resources\\Subject\\"
					+ facultyBean.getSub_name() + "";

			Path folder = Paths.get(pathString);

			if (!Files.exists(folder)) {

				try {
					Files.createDirectory(folder);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			facultyService.saveFile(file, folder);

			File checkFile = new File(pathString + "\\" + file.getOriginalFilename() + "");

			if (checkFile.exists()) {

				SubjectFileBean fileBean = new SubjectFileBean();

				fileBean.setFid(facultyBean.getFid());
				fileBean.setFile_desc(file_desc);
				fileBean.setFile_name(file.getOriginalFilename());
				fileBean.setFile_type(file.getContentType());
				fileBean.setSub_id(facultyBean.getSub_id());

				if (facultyDao.insertFileBean(fileBean) > 0) {
					System.out.println("File uploaded!!!!!!!!!");
					return "redirect: uploadForm";
				}

			} else {
				model.addAttribute("uploadingError", "Something Went wrong!!");
				return "faculty/UploadFile";
			}

			return "redirect: uploadForm";

		}

		else {
			model.addAttribute("uploadingError", "Upload Fail! Uplaod only png, jpg, jpeg or pdf");
			return "faculty/UploadFile";
		}
	}

	@GetMapping("/displayFile")
	public String display(@RequestParam("fname") String fname, @RequestParam("ftype") String ftype,
			@RequestParam("folder") String folder, Model model) {

		model.addAttribute("fname", fname);
		model.addAttribute("fileType", ftype);
		model.addAttribute("folder", folder);

		return "faculty/DisplayFile";
	}

	@GetMapping("/dltFile")
	public String dltFie(@RequestParam("fid") int fid) {

		if (facultyDao.deleteFile(fid) > 0) {
			return "redirect: uploadForm";
		}
		return "redirect: uploadForm";
	}

}
