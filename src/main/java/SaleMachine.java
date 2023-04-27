public class SaleMachine {

	private int countOfBeer, countOfOrangeJuice, countOfFiveJiao, countOfOneYuan;// 售货机中4个资源变量，分别代表啤酒的数量、橙汁的数量、5角硬币的数量、1元硬币的数量
	private String[] typeOfGoods = { "Beer", "OrangeJuice" };// 售货机中的商品类型:"啤酒"、"橙汁"
	private String resultOfDeal;// 销售结果

	public SaleMachine()// 默认构造函数
	{
		initial();// 初始化
	}

	public void initial()// 将各类资源的数量清0
	{
		countOfBeer = 0; // 售货机啤酒数量清零
		countOfOrangeJuice = 0;// 售货机橙汁数量清零
		countOfFiveJiao = 0;// 售货机5角硬币数量清零
		countOfOneYuan = 0;// 售货机1元硬币数量清零
	}

	public SaleMachine(int fiveJiao, int oneYuan, int numOfBeer, int numOfOrange)
	// 有参数的构造函数，将实际参数传递给形参，对类中属性变量初始化
	{
		countOfFiveJiao = fiveJiao;
		countOfOneYuan = oneYuan;
		countOfBeer = numOfBeer;
		countOfOrangeJuice = numOfOrange;
	}

	public String currentState()// 获取售货机当前四种资源变量数量值
	{
		String state = "Current State\n" + "Beer: " + countOfBeer + "\n" + "Orange Juice: " + countOfOrangeJuice + "\n"
				+ "5 Jiao: " + countOfFiveJiao + "\n" + "1 Yuan: " + countOfOneYuan;
		return state;
	}

	public String operation(String type, String money)// 售货机操作控制程序
	// type参数代表客户选择的购买商品类型，money参数代表客户投币类型
	{
		if (money.equalsIgnoreCase("5J")) // 如果客户投入5角钱
		{
			if (type != null && type.equals(typeOfGoods[0])) // 如果客户选择啤酒
			{
				if (countOfBeer > 0) // 如果还有啤酒，进行交易，修改资源数量
				{
					// 路径S1输出信息
					countOfBeer--;
					countOfFiveJiao++;
					resultOfDeal = "Input Information \n" + "Type: Beer; Money: 5 Jiao; Change: 0\n\n";
					return resultOfDeal;
				} else // 没有啤酒，输出啤酒短缺的信息
				{
					// 路径S2输出信息
					resultOfDeal = "Failure Information \n" + "Beer Shortage";
					return resultOfDeal;
				}
			} else if (type != null && type.equals(typeOfGoods[1])) // 客户选择橙汁
			{
				if (countOfOrangeJuice > 0) // 如果有橙汁，进行交易，修改各类资源的数量
				{
					// 路径S3输出信息
					countOfOrangeJuice--;
					countOfFiveJiao++;
					resultOfDeal = "Input Information \n" + "Type: OrangeJuice; Money: 5 Jiao; Change: 0\n\n";
					return resultOfDeal;
				} else // 没有橙汁，输出橙汁短缺信息
				{
					// 路径S4输出信息
					resultOfDeal = "Failure Information \n" + "Type Error";
					return resultOfDeal;
				}
			} else // 既不是啤酒也不是橙汁，输出类型错误信息
			{
				// 路径S5输出信息
				resultOfDeal = "Failure Information \n" + "Type Error";
				return resultOfDeal;
			}
		} else if (money.equalsIgnoreCase("1Y")) // 如果客户投入一元钱
		{
			if (countOfFiveJiao > 0) // 如果售货机有5角零钱
			{
				if (type != null && type.equals(typeOfGoods[0]))// 如果客户选择啤酒
				{
					// 路径S6输出信息,如果客户选择啤酒而且还有啤酒
					if (countOfBeer >= 0) {
						countOfBeer--;
						countOfFiveJiao++;
						countOfOneYuan++;
						resultOfDeal = "Input Information \n" + "Type: Beer; Money: 1 Yuan; Change: 5 Jiao\n\n";
						return resultOfDeal;
					} else {
						// 路径S7输出信息,如果客户选择啤酒而且没有啤酒
						resultOfDeal = "Failure Information \n" + "Beer Shortage";
						return resultOfDeal;
					}
				} else if (type != null && type.equals(typeOfGoods[1]))// 如果客户选择橙汁
				{
					if (countOfOrangeJuice > 0) {// 如果有橙汁，进行交易，修改资源状态
						// 路径S8输出信息
						countOfOrangeJuice--;
						countOfFiveJiao--;
						countOfOneYuan++;
						resultOfDeal = "Input Information: \n" + "Type: OrangeJuice; Money: 1 Yuan; Change: 5 Jiao\n\n";
						return resultOfDeal;
					} else {// 没有橙汁，输出橙汁短缺信息
						// 路径S9输出信息
						resultOfDeal = "Failure Information \n" + "OrangeJuice Shortage";
						return resultOfDeal;
					}
				} else {// 既不是啤酒也不是橙汁，输出类型错误信息
					// 路径S10输出信息
					resultOfDeal = "Failure Information \n" + "Type Error";
					return resultOfDeal;

				}
			} else // 售货机没有5角零钱，输出零钱短缺
			{
				// 路径S11输出信息
				resultOfDeal = "Failure Information \n" + "Change Shortage";
				return resultOfDeal;
			}
		} else // 客户输入不是5J和1Y,输出投币的错误
		{
			// 路径S12输出信息
			resultOfDeal = "Failure Information \n" + "Money Error";
			return resultOfDeal;
		}

	}
}
