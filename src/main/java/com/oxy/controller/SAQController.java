package com.oxy.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.common.base.Objects;
import com.oxy.constant.ExamConstant.QuestionType;
import com.oxy.service.SAQService;
import com.oxy.utils.JsonResult;
import com.oxy.utils.JsonResult2;
import com.oxy.utils.ServiceOperationException;
import com.oxy.vo.itemBank.AddSaqVO;
import com.oxy.vo.itemBank.DeleteSaqVO;
import com.oxy.vo.itemBank.PageSaqVO;
import com.oxy.vo.itemBank.UpdateSaqVO;
import com.oxy.vo.saq.ImportExcelVO;

/**
 * @date 2019年3月20日上午10:19:35
 * @Description 判断题控制器
 */
@RestController
@RequestMapping("/saq")
@CrossOrigin
public class SAQController extends BaseController {
	@Value(value = "${SAQ.template.path}")
	private String SAQUrl;
	@Value(value = "${single.template.path}")
	private String selectUrl;
	@Value(value = "${student.template.path}")
	private String studentUrl;
	@Resource
	private SAQService saqService;
	private static final Logger LOGGER = LoggerFactory.getLogger(SAQController.class);

	@RequestMapping(value = "/page", method = RequestMethod.POST, produces = { "application/json;charset=utf-8" })
	public JsonResult pageResult(@Validated @RequestBody PageSaqVO vo) {
		return new JsonResult(0, saqService.page(vo), "成功");
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, produces = { "application/json;charset=utf-8" })
	public JsonResult add(@Validated @RequestBody AddSaqVO vo) {
		saqService.insert(vo);
		return new JsonResult(0, "添加成功");
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT, produces = { "application/json;charset=utf-8" })
	public JsonResult update(@Validated @RequestBody UpdateSaqVO vo) {
		saqService.update(vo);
		return new JsonResult(0, "更新成功");
	}

	@RequestMapping(value = "/", method = RequestMethod.DELETE, produces = { "application/json;charset=utf-8" })
	public JsonResult delete(@RequestBody DeleteSaqVO vo) {
		saqService.delete(vo.getSaqid());
		return new JsonResult(0, "删除成功");
	}

	@PostMapping("/import")
	public JsonResult2 importExcel(HttpServletRequest request, ImportExcelVO vo) {
		LOGGER.info("进入importExcel方法");
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultiValueMap<String, MultipartFile> multiValueMap = multipartRequest.getMultiFileMap();
		for (String key : multiValueMap.keySet()) {
			MultipartFile file = multiValueMap.getFirst(key);
			saqService.importExcel(file, vo);
		}
		return JsonResult2.success("导入成功");
	}

	/**
	 * @Description 下载模板
	 * @param type
	 *            1-判断题 2-选择题
	 */
	@GetMapping("/download")
	public void downloadFile(
			@RequestParam(required = true) @Pattern(regexp = QuestionType.REG, message = "文件类型错误") String type,
			HttpServletResponse response) {
		InputStream inputStream = null;
		String donName = "";
		if (Objects.equal(type, QuestionType.SAQ.index)) {
			inputStream = this.getClass().getClassLoader().getResourceAsStream(SAQUrl);
			donName = "判断题题库表";
		} else if (Objects.equal(type, QuestionType.SINGLE.index)) {
			inputStream = this.getClass().getClassLoader().getResourceAsStream(selectUrl);
			donName = "单选题题库表";
		} else {
			inputStream = this.getClass().getClassLoader().getResourceAsStream(studentUrl);
			donName = "学生表";
		}
		BufferedInputStream bis = new BufferedInputStream(inputStream);
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		response.addHeader("Content-Type", "application/octet-stream");
		OutputStream out = null;
		try {
			response.addHeader("Content-Disposition",
					"attachment;filename=" + URLEncoder.encode(donName + ".xlsx", "utf-8"));
			out = response.getOutputStream();
			byte[] buffer = new byte[1024];
			int len;
			while ((len = bis.read(buffer)) != -1) {
				out.write(buffer, 0, len);
			}
		} catch (IOException e) {
			LOGGER.info("发生IO异常，异常信息{}", e);
			throw new ServiceOperationException(-2, "IO异常");
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (bis != null) {
					bis.close();
				}
			} catch (IOException e) {
				LOGGER.info("发生IO异常，异常信息{}", e);
			}
		}

	}

}
