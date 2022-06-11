package com.rerollyourbody.gymbro.core.APIResource;

public class APIPaths {
    //PLAN
    public static final String API_VERSION_1_PATH = "/v1";
    public static final String API_VERSION_1_PLAN = API_VERSION_1_PATH + "/plan";
    public static final String PLAN_ID_PATH = "/{planId}";
    public static final String PLAN_ID_PATH_VARIABLE = "planId";

    //ROUTINE
    public static final String API_VERSION_1_ROUTINE = API_VERSION_1_PLAN + "/routine";
    public static final String ROUTINE_ID_PATH = API_VERSION_1_ROUTINE + "/{routine}";
    public static final String ROUTINE_ID_PATH_VARIABLE = "routine";
}
