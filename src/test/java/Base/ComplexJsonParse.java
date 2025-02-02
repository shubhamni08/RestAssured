package Base;

import io.restassured.path.json.JsonPath;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class ComplexJsonParse {
    public static void main(String[] args) {
        JsonPath js = new JsonPath(PayLoad.coursePrice());
//        now we'll get mock JSON response we need to do below task
//        6. Verify if Sum of all Course prices matches with Purchase Amount
        System.out.println(js);

//        1. Print No of courses returned by API
        int courses = js.getInt("courses.size()");
        System.out.println("No of courses - " + courses);

//        2. Print Purchase Amount
        int purchaseAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println("Purchase Amount - " + purchaseAmount);

//        3. Print Title of the first course
        String firstCourseTitle = js.get("courses[0].title");
        System.out.println("Title of the first course - " + firstCourseTitle);

//        4. Print All course titles and their respective Prices
        List<String> courseTitles = js.getList("courses.title");
        List<Integer> coursePrices = js.getList("courses.price");
        System.out.println("Print All course titles and their respective Prices - ");

        IntStream.range(0, courseTitles.size())
                .mapToObj(i -> courseTitles.get(i) + " - " + coursePrices.get(i))
                .forEach(System.out::println);

//        5. Print no of copies sold by RestAssured Course
         List<Map<String, Objects>> courseList = js.getList("courses");
        int copies = js.getInt("courses.find { it.title == 'RestAssured' }.copies");
        System.out.println("Copies of RestAssured course purchased: " + copies);


    }
}
