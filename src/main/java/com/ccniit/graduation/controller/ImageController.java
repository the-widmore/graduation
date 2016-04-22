package com.ccniit.graduation.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ccniit.graduation.util.ShiroUtils;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;

@Controller
public class ImageController {

	private static final Logger LOG = LoggerFactory.getLogger(ImageController.class);

	@Resource
	private DefaultKaptcha defaultKaptcha;

	@RequestMapping(value = "/captchaImage", method = RequestMethod.GET)
	public void handleRequest(HttpServletResponse response) throws IOException {

		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("image/jpeg");
		String capText = defaultKaptcha.createText();

		// TOPUT capText to session,use shiro
		ShiroUtils.addAttribute(Constants.KAPTCHA_SESSION_KEY, capText);

		BufferedImage image = defaultKaptcha.createImage(capText);
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

	protected static final String VOTE_COVER_IMAGE_URL = "/vote/cover/{voteId}";

	@RequestMapping(value = VOTE_COVER_IMAGE_URL, method = RequestMethod.GET)
	public String getVoteCover(@PathVariable("voteId") Long voteId) {
		// TODO Auto generated method stub
		return null;
	}

}
