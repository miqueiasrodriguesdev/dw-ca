package com.miqueias_r.infrastructure.client.dto.response;

public class AutorizarResponse {
    private String status;
    private Data data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        private Boolean authorization;

        public Boolean getAuthorization() {
            return authorization;
        }

        public void setAuthorization(Boolean authorization) {
            this.authorization = authorization;
        }
    }
}
