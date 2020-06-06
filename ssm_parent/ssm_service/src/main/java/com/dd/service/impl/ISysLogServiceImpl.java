package com.dd.service.impl;

import com.dd.SysLog;
import com.dd.dao.ISysLogDao;
import com.dd.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ISysLogServiceImpl implements ISysLogService {

    @Autowired
    private ISysLogDao sysLogDao;


    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }

    public List<SysLog> findAll() throws Exception {
        return sysLogDao.findAll();
    }
}
