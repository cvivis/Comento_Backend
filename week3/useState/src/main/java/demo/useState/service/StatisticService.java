package demo.useState.service;

import java.util.HashMap;
import java.util.Map;

public interface StatisticService {
    public HashMap<String,Object> yearlogin (String year);
    public Map<String, Object> loginDep(String year, String dep);
    public Map<String, Object> logincount(String year);
    public Map<String, Object> Avglogincount(String year);
    public Map<String, Object> NoholiLoginNum(String year );
}
