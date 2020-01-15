package com.softserve.util;

import com.softserve.constant.ServletResponseParameter;

import javax.servlet.http.HttpServletRequest;

public class IdSupplier {

    public Long supplyId(HttpServletRequest req) {
        return Long.parseLong(req.getParameter(ServletResponseParameter.RECORD_ID.getServletParameter()));
    }
}
