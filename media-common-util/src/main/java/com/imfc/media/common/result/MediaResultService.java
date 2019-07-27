package com.imfc.media.common.result;

public class MediaResultService {
    private static MediaResultService mrs = new MediaResultService();

    private MediaResultService(){};

    public static MediaResultService getInst(){
        return mrs;
    }

    public MediaResult getOkResult(Object value){
        MediaResult mr = new MediaResult();
        mr.setCode("200");
        mr.setValue(value);
        return mr;
    }

    public MediaResult getErrorResult(String msg){
        MediaResult mr = new MediaResult();
        mr.setCode("500");
        mr.setMsg(msg);
        return mr;
    }
}
