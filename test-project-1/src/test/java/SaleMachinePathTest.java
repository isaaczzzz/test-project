import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SaleMachinePathTest {
    @Test
    void testOperationS1() {
        // 投入5角，选择啤酒，有啤酒
        // 5个5角，5个1元，5瓶啤酒，5瓶橙汁
        SaleMachine saleMachine = new SaleMachine(5, 5, 5, 5);
        String expected = "Input Information \n" + "Type: Beer; Money: 5 Jiao; Change: 0\n\n";
        String actual = saleMachine.operation("Beer", "5J");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testOperationS2() {
        // 投入5角，选择啤酒，无啤酒
        // 5个5角，5个1元，0瓶啤酒，5瓶橙汁
        SaleMachine saleMachine = new SaleMachine(5, 5, 0, 5);
        String expected = "Failure Information \n" + "Beer Shortage";
        String actual = saleMachine.operation("Beer", "5J");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testOperationS3() {
        // 投入5角，选择橙汁，有橙汁
        // 5个5角，5个1元，5瓶啤酒，5瓶橙汁
        SaleMachine saleMachine = new SaleMachine(5, 5, 5, 5);
        String expected = "Input Information \n" + "Type: OrangeJuice; Money: 5 Jiao; Change: 0\n\n";
        String actual = saleMachine.operation("OrangeJuice", "5J");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testOperationS4() {
        // 投入5角，选择橙汁，无橙汁
        // 5个5角，5个1元，5瓶啤酒，0瓶橙汁
        SaleMachine saleMachine = new SaleMachine(5, 5, 5, 0);
        String expected = "Failure Information \n" + "OrangeJuice Shortage";
        String actual = saleMachine.operation("OrangeJuice", "5J");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void testOperationS5() {
        // 投入5角既不是啤酒也不是橙汁
        // 5个5角，5个1元，5瓶啤酒，5瓶橙汁
        SaleMachine saleMachine = new SaleMachine(5, 5, 5, 5);
        String expected = "Failure Information \n" + "Type Error";
        String actual = saleMachine.operation("Coke", "5J");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void testOperationS6() {
        // 投入1元，选择啤酒，有啤酒
        // 5个5角，5个1元，5瓶啤酒，5瓶橙汁
        SaleMachine saleMachine = new SaleMachine(5, 5, 5, 5);
        String expected = "Input Information \n" + "Type: Beer; Money: 1 Yuan; Change: 5 Jiao\n\n";
        String actual = saleMachine.operation("Beer", "1Y");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void testOperationS7() {
        // 投入1元，选择啤酒，无啤酒
        // 5个5角，5个1元，0瓶啤酒，5瓶橙汁
        SaleMachine saleMachine = new SaleMachine(5, 5, 0, 5);
        String expected = "Failure Information \n" + "Beer Shortage";
        String actual = saleMachine.operation("Beer", "1Y");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void testOperationS8() {
        // 投入1元，选择橙汁，有橙汁
        // 5个5角，5个1元，5瓶啤酒，5瓶橙汁
        SaleMachine saleMachine = new SaleMachine(5, 5, 5, 5);
        String expected = "Input Information \n" + "Type: OrangeJuice; Money: 1 Yuan; Change: 5 Jiao\n\n";
        String actual = saleMachine.operation("OrangeJuice", "1Y");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void testOperationS9() {
        // 投入1元，选择橙汁，无橙汁
        // 5个5角，5个1元，5瓶啤酒，0瓶橙汁
        SaleMachine saleMachine = new SaleMachine(5, 5, 5, 0);
        String expected = "Failure Information \n" + "OrangeJuice Shortage";
        String actual = saleMachine.operation("OrangeJuice", "1Y");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void testOperationS10() {
        // 投入1元既不是啤酒也不是橙汁
        // 5个5角，5个1元，5瓶啤酒，5瓶橙汁
        SaleMachine saleMachine = new SaleMachine(5, 5, 5, 5);
        String expected = "Failure Information \n" + "Type Error";
        String actual = saleMachine.operation("Coke", "1Y");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void testOperationS11() {
        // 售货机没有5角零钱
        // 0个5角，5个1元，5瓶啤酒，5瓶橙汁
        SaleMachine saleMachine = new SaleMachine(0, 5, 5, 5);
        String expected = "Failure Information \n" + "Change Shortage";
        String actual = saleMachine.operation("Beer", "1Y");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void testOperationS12() {
        // 客户输入不是5J和1Y
        // 5个5角，5个1元，5瓶啤酒，5瓶橙汁
        SaleMachine saleMachine = new SaleMachine(5, 5, 5, 5);
        String expected = "Failure Information \n" + "Money Error";
        String actual = saleMachine.operation("Beer", "5Y");
        Assertions.assertEquals(expected, actual);
    }
}
