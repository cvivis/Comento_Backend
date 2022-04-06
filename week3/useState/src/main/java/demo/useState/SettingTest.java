package demo.useState;

import demo.useState.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SettingTest {

    @RequestMapping("/")
    @ResponseBody
    public Map<String, Object> test() throws Exception{
        Map<String, Object> test = new HashMap<>();
        test.put("test1", 0);
        test.put("test2", 1);
        return test;
    }

    @Autowired
    private StatisticService service;

    @ResponseBody
    @RequestMapping("/login") // 월별 접속자수
    public Map<String, Object> loginMonth(String yearMonth) throws Exception{

        return service.yearlogin(yearMonth);
    }

    @ResponseBody
    @RequestMapping("/login") //부서별월별로그인수
    public Map<String, Object> loginDep(String year,String dep) throws Exception{

        return service.depLogin(year,dep);
    }

    @ResponseBody
    @RequestMapping("/login") // 일자별 접속자 수
    public Map<String, Object> logincount(String year) throws Exception{

        return service.dayLogin(year);
    }

    @ResponseBody
    @RequestMapping("/avgLogin") // 평균하루 로그인 수
    public Map<String, Object> Avglogincount(String year) throws Exception{

        return service.avgLogin(year);
    }

    @ResponseBody
    @RequestMapping("/NotHolidayLogin") // 휴일을제외한로그인  수
    public Map<String, Object> NoholiLoginNum(String year ) throws Exception{
//year == 년도
        return service.Noholiday(year);
    }

}
