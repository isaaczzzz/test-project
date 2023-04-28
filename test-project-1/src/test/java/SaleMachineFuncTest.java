import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SaleMachineFuncTest {
    private SaleMachine saleMachine;

    @Test
    void testFunc1() {
        saleMachine = new SaleMachine(5, 5, 5, 5);
        // 测试功能一：客户投入5角钱或1元钱的硬币，按下“橙汁”或“啤酒”按钮，售货机将相应价格的饮料输出
        String expected = "Input Information \n" + "Type: OrangeJuice; Money: 5 Jiao; Change: 0\n\n";
        String actual = saleMachine.operation("OrangeJuice", "5J");
        Assertions.assertEquals(expected, actual);

        expected = "Input Information \n" + "Type: Beer; Money: 1 Yuan; Change: 5 Jiao\n\n";
        actual = saleMachine.operation("Beer", "1Y");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void testFunc2() {
        // 测试功能二：啤酒无货
        saleMachine = new SaleMachine(5, 5, 0, 5);
        String expected = "Failure Information \n" + "Beer Shortage";
        String actual = saleMachine.operation("Beer", "5J");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void testFunc3() {
        // 测试功能三：橙汁无货
        saleMachine = new SaleMachine(5, 5, 5, 0);
        String expected = "Failure Information \n" + "OrangeJuice Shortage";
        String actual = saleMachine.operation("OrangeJuice", "5J");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void testFunc4() {
        // 测试功能四：缺零钱
        saleMachine = new SaleMachine(0, 5, 5, 5);
        String expected = "Failure Information \n" + "Change Shortage";
        String actual = saleMachine.operation("OrangeJuice", "1Y");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void testFunc5() {
        // 测试功能五：类型错误
        saleMachine = new SaleMachine(5, 5, 5, 5);
        String expected = "Failure Information \n" + "Type Error";
        String actual = saleMachine.operation("Milk", "5J");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void testFunc6() {
        // 测试功能六：投币错误
        saleMachine = new SaleMachine(5, 5, 5, 5);
        String expected = "Failure Information \n" + "Money Error";
        String actual = saleMachine.operation("Beer", "2Y");
        Assertions.assertEquals(expected, actual);
    }
}
