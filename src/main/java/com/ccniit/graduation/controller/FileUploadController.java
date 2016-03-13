package com.ccniit.graduation.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

@Controller
public class FileUploadController {

	private static final Logger LOG = LoggerFactory.getLogger(FileUploadController.class);

	public static final long FILE_UPLOAD_LIMIT = 5400000;
	public static final String FILE_UPLOAD_TEMP_DIR = "/WEB-INF/fileUpload/temp/";
	public static final String FILE_UPLOAD_DIR = "WEB-INF/fileUpload/";
	public static final String FORM_FILE_UPLOAD = "/user/fileUpload.do";
	public static final String VIEW_FILE_UPLOAD_SUCCESS = "/user/fileUploadSuccess.html";

	@RequestMapping(value = { FORM_FILE_UPLOAD }, method = RequestMethod.POST)
	public String fileUploadAction(@RequestParam("file") MultipartFile file, Model model, HttpServletRequest request) {

		String realPath = null;
		try {
			realPath = WebUtils.getRealPath(request.getServletContext(), FILE_UPLOAD_TEMP_DIR);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		if (file.isEmpty()) {
			model.addAttribute("errorMessageEmptyFile", "no file be chossed");
			return FORM_FILE_UPLOAD;
		}

		if (file.getSize() > FILE_UPLOAD_LIMIT) {
			model.addAttribute("errorMessageEmptyFile", "file size over limit size");
			return FORM_FILE_UPLOAD;
		}

		try {
			byte[] fileByte = IOUtils.toByteArray(file.getInputStream());
			String fileName = realPath + file.getOriginalFilename();
			File targetFile = new File(fileName);

			LOG.info(targetFile.getAbsolutePath());

			FileOutputStream fos = new FileOutputStream(targetFile);
			BufferedOutputStream bos = new BufferedOutputStream(fos);

			bos.write(fileByte);
			bos.close();

			// rename file name TODO

		} catch (Exception e) {
			LOG.error(e.getMessage());
		}

		return VIEW_FILE_UPLOAD_SUCCESS;
	}

	@RequestMapping(value = { VIEW_FILE_UPLOAD_SUCCESS }, method = RequestMethod.GET)
	public String fileUploadSuccess() {

		return VIEW_FILE_UPLOAD_SUCCESS;
	}

}
