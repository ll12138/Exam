package com.oxy.controller;

import javax.annotation.Resource;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oxy.service.PaperService;
import com.oxy.utils.JsonResult;
import com.oxy.utils.JsonResult2;
import com.oxy.vo.paper.AutoGeneratingVO;
import com.oxy.vo.paper.PagePaperVO;
import com.oxy.vo.paper.PaperIdVO;
import com.oxy.vo.paper.SAQIdVO;
import com.oxy.vo.paper.SelectIdVO;

/**
 * @date 2019年3月20日上午10:19:35
 * @Description 试卷控制器
 */
@RestController
@RequestMapping("/paper")
@CrossOrigin
public class PaperController extends BaseController {
	@Resource
	private PaperService paperService;

	@RequestMapping(value = "/autoGenerating", method = RequestMethod.POST, produces = {
			"application/json;charset=utf-8" })
	public JsonResult add(@Validated @RequestBody AutoGeneratingVO vo) {
		paperService.insert(vo);
		return new JsonResult(0, "添加成功");
	}

	@RequestMapping(value = "/page", method = RequestMethod.POST, produces = { "application/json;charset=utf-8" })
	public JsonResult pageResult(@Validated @RequestBody PagePaperVO vo) {
		return new JsonResult(0, paperService.page(vo), "成功");
	}

	/**
	 * @Description 考试安排选择
	 * @param subject
	 *            科目
	 */
	@GetMapping("/constant")
	public JsonResult listOption(@RequestParam(value = "subject", required = false) String subject) {
		return new JsonResult(0, paperService.listOption(subject), "成功");
	}

	@RequestMapping(value = "/", method = RequestMethod.DELETE, produces = { "application/json;charset=utf-8" })
	public JsonResult delete(@RequestBody PaperIdVO vo) {
		paperService.delete(vo.getPaperid());
		return new JsonResult(0, "删除成功");
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = { "application/json;charset=utf-8" })
	public JsonResult getPaper(@RequestParam Integer paperid) {
		return new JsonResult(0, paperService.selectById(paperid), "成功");
	}

	@RequestMapping(value = "/select", method = RequestMethod.POST, produces = { "application/json;charset=utf-8" })
	public JsonResult getSelectById(@RequestBody SelectIdVO vo) {
		return new JsonResult(0, paperService.getSelectById(vo.getQuestionids()), "成功");
	}

	@RequestMapping(value = "/saq", method = RequestMethod.POST, produces = { "application/json;charset=utf-8" })
	public JsonResult getSAQById(@RequestBody SAQIdVO vo) {
		return new JsonResult(0, paperService.getSAQById(vo.getSaqids()), "成功");
	}

	@RequestMapping(value = "/select", method = RequestMethod.DELETE, produces = { "application/json;charset=utf-8" })
	public JsonResult deleteSelect(@RequestBody SelectIdVO vo) {
		paperService.deleteSelect(vo);
		return new JsonResult(0, "删除成功");
	}

	@RequestMapping(value = "/saq", method = RequestMethod.DELETE, produces = { "application/json;charset=utf-8" })
	public JsonResult deleteSAQ(@RequestBody SAQIdVO vo) {
		paperService.deleteSAQ(vo);
		return new JsonResult(0, "删除成功");
	}

	@RequestMapping(value = "/addSelect", method = RequestMethod.POST, produces = { "application/json;charset=utf-8" })
	public JsonResult addSelect(@RequestBody SelectIdVO vo) {
		paperService.addSelect(vo);
		return new JsonResult(0, "成功");
	}

	@RequestMapping(value = "/addSAQ", method = RequestMethod.POST, produces = { "application/json;charset=utf-8" })
	public JsonResult addSAQ(@RequestBody SAQIdVO vo) {
		paperService.addSAQ(vo);
		return new JsonResult(0, "成功");
	}

}
