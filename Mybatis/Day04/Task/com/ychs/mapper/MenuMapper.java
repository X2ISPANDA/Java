package com.ychs.mapper;

import com.ychs.pojo.Menu;

import java.util.List;
import java.util.Map;

public interface MenuMapper {
//    public List<Menu> getMenuByRoleid(String menuid);
    public List<Menu> getMenuByMenuid(Map map);
}
