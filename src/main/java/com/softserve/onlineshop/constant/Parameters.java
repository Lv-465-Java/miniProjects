package com.softserve.onlineshop.constant;

import java.io.File;

public interface Parameters {
    String IMG_DIR = System.getProperty("user.home") + File.separator +
            "images" + File.separator;
}
