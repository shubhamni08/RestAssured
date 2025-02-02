package Files;

public class PayLoad {

    public static String addPlace(){
        return "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.3838,\n" +
                "    \"lng\": 34.4242\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Rahul Shetty Academy\",\n" +
                "  \"phone_number\": \"(+91) 98 239 2387\",\n" +
                "  \"address\": \"58 Rasul jiwa comp\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"https://rahulshettyacademy.com\",\n" +
                "  \"language\": \"french-IN\"\n" +
                "}";
    }


    public static String coursePrice(){
        return "{\n" +
                "  \"dashboard\": {\n" +
                "    \"purchaseAmount\": 910,\n" +
                "    \"website\": \"www.rahulshettyacademy.com\"\n" +
                "  },\n" +
                "  \"courses\": [\n" +
                "    {\n" +
                "      \"title\": \"Java\",\n" +
                "      \"price\": 50,\n" +
                "      \"copies\": 6\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Selenium\",\n" +
                "      \"price\": 40,\n" +
                "      \"copies\": 4\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"RestAssured\",\n" +
                "      \"price\": 45,\n" +
                "      \"copies\": 10\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }
}
