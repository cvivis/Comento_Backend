package demo.useState.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.useState.dao.StatisticMapper;

@Service
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    private StatisticMapper uMapper;

    @Override
    public HashMap<String, Object> yearlogin (String year) {
        //TODO Auto-generated method stub
        HashMap<String, Object> retVal = new HashMap<String,Object>();

        try {
            retVal = uMapper.selectYearLogin(year);
            retVal.put("year", year);
            retVal.put("is_success", true);

        }catch(Exception e) {
            e.printStackTrace();
            retVal.put("totCnt", -999);
            retVal.put("year", year);
            retVal.put("is_success", false);
        }

        return retVal;
    }

    @Override
    public Map<String, Object> loginDep(String year, String dep) {
        return null;
    }

    @Override
    public Map<String, Object> logincount(String year) {
        return null;
    }

    @Override
    public Map<String, Object> Avglogincount(String year) {
        return null;
    }

    @Override
    public Map<String, Object> NoholiLoginNum(String year) {
        return null;
    }
}
