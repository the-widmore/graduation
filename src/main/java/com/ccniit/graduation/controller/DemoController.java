package com.ccniit.graduation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

	private static final Logger LOG = LoggerFactory.getLogger(DemoController.class);

	public static final String VIEW_DEMO = "/demo/demo.html";

	@RequestMapping(value = { VIEW_DEMO }, method = RequestMethod.GET)
	public String demo(ModelMap modelMap) {
		return VIEW_DEMO;
	}

	public static final String VIEW_DEMO_ADVANCE_DATA_ANALYSE = "/demo/advanceDataAnalyse.html";

	@RequestMapping(value = { VIEW_DEMO_ADVANCE_DATA_ANALYSE }, method = RequestMethod.GET)
	public String advanceDataAnalyse(ModelMap modelMap) {

		return VIEW_DEMO_ADVANCE_DATA_ANALYSE;
	}

	public static final String VIEW_DEMO_EXPORT_DATA = "/demo/exportData.html";

	@RequestMapping(value = { VIEW_DEMO_EXPORT_DATA }, method = RequestMethod.GET)
	public String exportData(ModelMap modelMap) {

		return VIEW_DEMO_EXPORT_DATA;
	}

	public static final String VIEW_DEMO_LINKMAN_UPLOAD = "/demo/linkmanUpload.html";

	@RequestMapping(value = { VIEW_DEMO_LINKMAN_UPLOAD }, method = RequestMethod.GET)
	public String linkmanUpload(ModelMap modelMap) {

		return VIEW_DEMO_LINKMAN_UPLOAD;
	}

	public static final String VIEW_DEMO_PHONE_DEMO = "/demo/phoneDemo.html";

	@RequestMapping(value = { VIEW_DEMO_PHONE_DEMO }, method = RequestMethod.GET)
	public String phoneDemo(ModelMap modelMap) {

		return VIEW_DEMO_PHONE_DEMO;
	}

	public static final String VIEW_DEMO_POLL_RESULT_SHARE = "/demo/pollResultShare.html";

	@RequestMapping(value = { VIEW_DEMO_POLL_RESULT_SHARE }, method = RequestMethod.GET)
	public String pollResultShare(ModelMap modelMap) {

		return VIEW_DEMO_POLL_RESULT_SHARE;
	}

	public static final String VIEW_DEMO_POLL_TYPE = "/demo/pollType.html";

	@RequestMapping(value = { VIEW_DEMO_POLL_TYPE }, method = RequestMethod.GET)
	public String pollType(ModelMap modelMap) {

		return VIEW_DEMO_POLL_TYPE;
	}

	public static final String VIEW_PROCESS_DEMO = "/demo/processDemo.html";

	@RequestMapping(value = { VIEW_PROCESS_DEMO }, method = RequestMethod.GET)
	public String processDemo(ModelMap modelMap) {
		
		return VIEW_PROCESS_DEMO;
	}

	public static final String VIEW_DEMO_VOTE_CHART = "/demo/voteChart.html";

	@RequestMapping(value = { VIEW_DEMO_VOTE_CHART }, method = RequestMethod.GET)
	public String voteChart(ModelMap modelMap) {

		return VIEW_DEMO_VOTE_CHART;
	}

	public static final String VIEW_DEMO_VOTE_SUMMARY = "/demo/voteSummary.html";

	@RequestMapping(value = { VIEW_DEMO_VOTE_SUMMARY }, method = RequestMethod.GET)
	public String voteSummary(ModelMap modelMap) {

		return VIEW_DEMO_VOTE_SUMMARY;
	}

	////////////////////

	public static final String DOWNLOAD_LINKMAN_TEMPLATE_REQUEST_MAPPING = "/demo/dowmloadLinkmanTemplate.do";
	private static final String FILE_DIR = "/WEB-INF/downloads/";

	@RequestMapping(value = DOWNLOAD_LINKMAN_TEMPLATE_REQUEST_MAPPING, method = RequestMethod.GET)
	@ResponseBody
	public FileSystemResource downloadLinkmanTemplate(HttpServletRequest request, HttpServletResponse response) {
		String file = request.getSession().getServletContext().getRealPath(FILE_DIR) + "/LinkmanUploadTemplate.xls";

		LOG.debug("{}", file);

		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=linkmanTemplate.xls");
		FileSystemResource resource = new FileSystemResource(file);
		return resource;
	}

}
