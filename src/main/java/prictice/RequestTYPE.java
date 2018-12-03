package prictice;

public enum RequestTYPE {
    checkReq(0),
    checkResp(1),
    underwriteReq(10)
    ;
    private int code;
    private int code(){
        return 0;
    }
    private int getCode(){
        return this.code;
    }
    private RequestTYPE(int code){
        this.code=code;
    }

    public static void main(String[] args) {
        System.out.println();
        RequestTYPE requestTYPE=RequestTYPE.checkResp;
        System.out.println(requestTYPE.getCode());
        System.out.println(RequestTYPE.underwriteReq.getCode());
    }
}
