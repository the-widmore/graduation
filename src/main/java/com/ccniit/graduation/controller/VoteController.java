package com.ccniit.graduation.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VoteController {

	private static final Logger LOG = LoggerFactory.getLogger(VoteController.class);

	public static final String VIEW_VOTE = "/vote/startVote.html";

	@RequestMapping(value = { VIEW_VOTE }, method = RequestMethod.GET)
	public String vote(ModelMap modelMap) {

		return VIEW_VOTE;
	}

	public static final String VIEW_CREATE_VOTE_FROM_FLIE = "/vote/createVoteFromFile.html";

	@RequestMapping(value = { VIEW_CREATE_VOTE_FROM_FLIE }, method = RequestMethod.GET)
	public String createVoteFromFile(ModelMap modelMap) {

		return VIEW_CREATE_VOTE_FROM_FLIE;
	}

	public static final String VIEW_CREATE_VOTE = "/vote/createVote.html";

	@RequestMapping(value = { VIEW_CREATE_VOTE }, method = RequestMethod.GET)
	public String createVote(ModelMap modelMap) {

		return VIEW_CREATE_VOTE;
	}

	public static final String VIEW_CREATE_ADVANCE_VOTE = "/vote/createAdvanceVote.html";

	@RequestMapping(value = { VIEW_CREATE_ADVANCE_VOTE }, method = RequestMethod.GET)
	public String createAdvanceVote(ModelMap modelMap) {

		return VIEW_CREATE_ADVANCE_VOTE;
	}

	public static final String VIEW_EDIT_VOTE = "/vote/editVote.html";

	@RequestMapping(value = { VIEW_EDIT_VOTE }, method = RequestMethod.GET)
	public String editVote() {

		return VIEW_EDIT_VOTE;
	}

	public static final String FROM_VOTE_PREVIEW = "/vote/previewVote.do";
	public static final String VIEW_VOTE_PREVIEW = "/vote/previewVote.html";

	@RequestMapping(value = { FROM_VOTE_PREVIEW }, method = RequestMethod.POST)
	public String previewVoteAction(@RequestParam("voteText") String voteText, Model model) {

		model.addAttribute("voteText", voteText);

		return VIEW_VOTE_PREVIEW;
	}

	public static final String FROM_VOTE_SUBMIT = "/vote/submitVote.html";
	public static final String FROM_VOTE_SUBMIT_SUCCESS = "/vote/voteSubmitSuccess.html";

	@RequestMapping(value = { FROM_VOTE_SUBMIT }, method = RequestMethod.POST)
	public String submitVoteAction(HttpServletRequest request) {

		Map<String, String[]> paramaterMap = request.getParameterMap();
		int questionCounter = paramaterMap.size();

		LOG.info("questionCounter:{0}", questionCounter);

		for (Map.Entry<String, String[]> entry : paramaterMap.entrySet()) {
			System.out.println(entry.getKey());
			String[] values = entry.getValue();
			for (int i = 0; i < values.length; i++) {
				LOG.info(values[i]);
			}
		}

		return FROM_VOTE_SUBMIT_SUCCESS;
	}

}
