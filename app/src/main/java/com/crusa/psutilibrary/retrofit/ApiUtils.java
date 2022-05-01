package com.crusa.psutilibrary.retrofit;

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "http://localhost:8080/";

    public static LibraryPSUTIApiService getAPIService() {

        return RetrofitClientInstance.getClient(BASE_URL).create(LibraryPSUTIApiService.class);
    }
}
