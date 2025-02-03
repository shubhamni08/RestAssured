package Base;

import Files.PayLoad;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.util.List;
import java.util.stream.IntStream;

public class ComplexJsonParse {
    public static void main(String[] args) {
        JsonPath js = new JsonPath(PayLoad.coursePrice());
//        now we'll get mock JSON response we need to do below task
//        6. Verify if Sum of all Course prices matches with Purchase Amount
        System.out.println(js);

//        1. Print No of courses returned by API
        int noOfCourses = js.getInt("courses.size()");
        System.out.println("No of courses - " + noOfCourses);
        System.out.println("-----------------------------");
//        2. Print Purchase Amount
        int purchaseAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println("Purchase Amount - " + purchaseAmount);
        System.out.println("-----------------------------");
//        3. Print Title of the first course
        String firstCourseTitle = js.get("courses[0].title");
        System.out.println("Title of the first course - " + firstCourseTitle);
        System.out.println("-----------------------------");
//        4. Print All course titles and their respective Prices
        List<String> courseTitles = js.getList("courses.title");
        List<Integer> coursePrices = js.getList("courses.price");
        System.out.println("Print All course titles and their respective Prices - ");
        System.out.println("Using Java8");
        IntStream.range(0, courseTitles.size())
                .forEach(i -> System.out.println(courseTitles.get(i) + " - " + coursePrices.get(i)));

        System.out.println("-----------------------------");
        System.out.println("Using old for loop");
        for(int i=0;i<courseTitles.size();i++){
            System.out.println(courseTitles.get(i) +" "+coursePrices.get(i));
        }
        System.out.println("-----------------------------");
//        5. Print no of copies sold by RestAssured Course
        List<Integer> courseCopies = js.getList("courses.copies");
        IntStream.range(0, courseTitles.size())
                .filter(i->courseTitles.get(i).equalsIgnoreCase("RestAssured"))
                .findFirst()
                .ifPresent(i->System.out.println("Copies of RestAssured course purchased: " + courseCopies.get(i)));
        System.out.println("-----------------------------");

//        6. Verify if sum of all courses prices matches with Purchase Amount.
        int totalAmount = IntStream.range(0,courseTitles.size())
                .map(i->coursePrices.get(i)*courseCopies.get(i))
                .sum();
        System.out.println("sum of all courses prices - "+totalAmount);
        System.out.println(
                totalAmount == purchaseAmount
                        ? "Total amount matches the purchase amount!"
                        : "Mismatch! Total amount: " + totalAmount + ", Purchase amount: " + purchaseAmount
        );

        Assert.assertEquals(totalAmount,purchaseAmount);
    }
}
