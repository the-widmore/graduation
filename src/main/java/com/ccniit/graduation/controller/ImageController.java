package com.ccniit.graduation.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.code.kaptcha.impl.DefaultKaptcha;

@Controller
public class ImageController {

	private static final Logger LOG = LoggerFactory.getLogger(ImageController.class);

	@Resource
	DefaultKaptcha captchaProducer;

	@RequestMapping(value = "/captchaImage", method = RequestMethod.GET)
	public void handleRequest(HttpServletResponse response) throws IOException {

		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("image/jpeg");
		String capText = captchaProducer.createText();

		// TODO PUT capText to session,use shiro

		BufferedImage image = captchaProducer.createImage(capText);
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(image, "jpg", out);
		try {
			out.flush();
		} catch (IOException e) {
			LOG.error("输出图片错误", e);
		} finally {
			out.close();
		}
	}

	@RequestMapping(value = "favicon", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> getFavicon(HttpServletRequest request) throws FileNotFoundException {

		String faviconPath = request.getServletContext().getRealPath("/") + "/favicon.ico";
		File file = new File(faviconPath);
		ResponseEntity.ok().contentLength(file.length()).contentType(MediaType.IMAGE_JPEG)
				.body(new FileInputStream(file));
		return null;
	}

}
