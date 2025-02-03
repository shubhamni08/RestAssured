package Base;

import Files.PayLoad;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.IntStream;

public class TestSumValidation {

    @Test
    public void testSumOfCourses(){
        JsonPath js = new JsonPath(PayLoad.coursePrice());
        int purchaseAmt = js.getInt("dashboard.purchaseAmount");
        System.out.println(purchaseAmt);


        List<Integer> coursePrice = js.get("courses.price");
        List<Integer> courseCopies = js.get("courses.copies");
        System.out.println(coursePrice+" "+courseCopies);
        int totalSum = IntStream.range(0,courseCopies.size())
                .map(i->coursePrice.get(i)*courseCopies.get(i))
                .sum();

        Assert.assertEquals(totalSum,purchaseAmt);

    }
}
