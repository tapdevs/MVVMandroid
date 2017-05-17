package com.tapdevs.myapp.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by  Jan Shair on 08/02/2017.
 */

public class GameData {


        @SerializedName("response")
        @Expose
        private String response;
        @SerializedName("currency")
        @Expose
        private String currency;
        @SerializedName("data")
        @Expose
        private List<GameObject> data = null;

        public String getResponse() {
            return response;
        }

        public void setResponse(String response) {
            this.response = response;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public List<GameObject> getData() {
            return data;
        }

        public void setData(List<GameObject> data) {
            this.data = data;
        }


}
