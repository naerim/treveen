package com.ssafy.tripinfo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.tripinfo.model.Tripinfo;
import com.ssafy.tripinfo.model.service.TripinfoService;
import com.ssafy.util.PageNavigation;

@RestController
@RequestMapping("/tripinfo")
public class TripinfoController {
	private final Logger logger = LoggerFactory.getLogger(TripinfoController.class);
	
	private TripinfoService tripinfoService;

	public TripinfoController(TripinfoService tripinfoService) {
		super();
		this.tripinfoService = tripinfoService;
	}
	
	@GetMapping("/list")
	public ResponseEntity<Map<String, Object>> list(@RequestParam Map<String, String> map) throws Exception {
		logger.debug("list parameter pgno : {}", map.get("pgno"));

		List<Tripinfo> list = tripinfoService.listTripinfo(map);
		PageNavigation pageNavigation = tripinfoService.makePageNavigation(map);
		
		Map<String, Object> result = new HashMap<>();
		result.put("tripinfo", list);
		result.put("navigation", pageNavigation);
		result.put("pgno", map.get("pgno"));
		result.put("key", map.get("key"));
		result.put("word", map.get("word"));
//		param.put("tripinfo/list");
		
		return ResponseEntity.ok(result);
	}
}
