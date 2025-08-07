package com.examhub.examhub.common.constant;

import java.util.HashMap;
import java.util.Map;

public class MSG_CONST {
    private MSG_CONST() {}
    public static final Map<String, String> MSG = new HashMap<>();
    public static final String SUCCESS = "S0001";
    public static final String WARNING = "W0001";
    public static final String ERROR = "E0001";

    static {
        //common
        MSG.put("C0001", "Created Successfully");
        MSG.put("C0002", "Updated Successfully");
        MSG.put("C0003", "Deleted Successfully");
        MSG.put("C0004", "Removed Successfully");
        MSG.put("C0005", "Fetched Successfully");
        MSG.put("C0006", "Imported Successfully");
        MSG.put("C0007", "Submitted Successfully");

        MSG.put("C0008", "In-progress");
        MSG.put("C0009", "Wait");
        MSG.put("C0010", "Denied");
        MSG.put("C0011", "Success");
        MSG.put("C0012", "Failed");

    }
}
