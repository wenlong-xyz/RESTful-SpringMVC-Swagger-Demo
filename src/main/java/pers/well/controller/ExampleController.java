package pers.well.controller;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.well.model.BaseResult;
import pers.well.model.Token;
import pers.well.service.AuthService;
import pers.well.service.StudentService;

import javax.servlet.http.HttpServletResponse;

@Api(value = "Service-Controller", description = "业务接口示例")
@Controller
@RequestMapping(value="/demo")
public class ExampleController extends BaseController {
	@Autowired
	AuthService authService;

	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ApiOperation(value = "登录接口示例，返回Token", httpMethod = "Get", response = BaseResult.class, notes = "登录示例")
	public String login(@RequestParam(value = "name", required = true) String name, @RequestParam(value = "password", required = true) String password ) {
		Token token = authService.login(name,password);
		if(token == null){
			return buildFailedResultInfo(HttpServletResponse.SC_UNAUTHORIZED,"The login and/or password you specified are not correct.");
		}
		else{
			return buildSuccessResultInfo(token);
		}
	}


	@Autowired
	StudentService studentService;

	@ResponseBody
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	@ApiOperation(value = "无Token的接口示例", httpMethod = "Get", response = BaseResult.class, notes = "无Token的接口示例")
	public String showStudentList(@RequestParam(value = "id", required = true) int id) {

		return buildSuccessResultInfo(studentService.getSudent(id));
	}

	@ResponseBody
	@RequestMapping(value = "/token/student", method = RequestMethod.GET)
	@ApiOperation(value = "带Token的接口示例", httpMethod = "Get", response = BaseResult.class, notes = "带Token的接口示例")
	public String showStudentListWithToken(@RequestParam(value = "id", required = true) int id) {

		return buildSuccessResultInfo(studentService.getSudent(id));
	}

}
