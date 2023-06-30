package com.ict.cloud.common.helper;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description:
 * 封装一些正则相关的操作
 */
public final class RegHepler {

    public static final String REG_IMAGE= "^(?:[a-zA-Z]*)(?:(-)([0-9]{4}|\\d\\d\\.\\d\\d|\\d\\.\\d))(?:(-)(desktop|server))(?:(-)[a-zA-Z]+[0-9]+_[0-9]*)(?:\\.qcow2)";
    //public static final String RGE_IMAGES = "^(?:[a-zA-Z]*)(?:(-)([0-9]{4}|\\d\\d\\.\\d\\d|\\d\\.\\d))(?:(-)(desktop|server))(?:(-)[a-zA-Z]*[0-9]*(_*)[0-9]*)";
    //public static final String RGE_IMAGES = "(^[a-zA-Z]{6})(-)([0-9]{4}|\\d\\d\\.\\d\\d|\\d\\.\\d|\\d\\d)(-)(efi|gpt)(?:(-)[a-zA-Z]*[0-9]*(_*)[0-9]*)";
    //public static final String RGE_IMAGES = "(^[a-zA-Z]{6,9})(-)([0-9]{4}|\\d\\d\\.\\d\\d|\\d\\.\\d|\\d\\d)(-)([A-Z]\\d[A-D]|[A-Z]{2}|efi|gpt)(_R4900|_2288HV5|)(?:(-)[a-zA-Z]*[0-9]*(_*)[0-9]*)";
    public static final String RGE_IMAGES = "(?:^[a-zA-Z]{6,9})(?:-)(?:[0-9]{4}|\\d\\d\\.\\d\\d|\\d\\.\\d|\\d\\d)(?:-)(?:[A-Z]\\d[A-D]|[A-Z]{2}|efi|gpt)(_R4900|_2288HV5|)(?:-)(?:[a-zA-Z]*[0-9]*(_*)[0-9]*)";
    private static Pattern numericPattern = Pattern.compile("^[0-9\\-]+$");
    private static Pattern numericStringPattern = Pattern.compile("^[0-9\\-\\-]+$");
    private static Pattern floatNumericPattern = Pattern.compile("^[0-9\\-\\.]+$");
    private static Pattern abcPattern = Pattern.compile("^[a-z|A-Z]+$");
    private static Pattern imagePattern = Pattern.compile(RGE_IMAGES);

    public final static boolean isIegalImage(String imageName){
        boolean ret = false;
        if(imageName!=null && !imageName.isEmpty()){
            Matcher matcher = imagePattern.matcher(imageName);
            if(matcher.find()){
                ret = true;
            }
        }
        return ret;
    }
}
