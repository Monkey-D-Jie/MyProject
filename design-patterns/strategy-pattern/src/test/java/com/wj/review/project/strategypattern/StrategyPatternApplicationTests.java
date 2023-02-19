package com.wj.review.project.strategypattern;

import com.wj.review.project.strategypattern.factory.StrategyFactory;
import com.wj.review.project.strategypattern.service.DesignDoSomething;
import com.wj.review.project.strategypattern.service.DoSomething;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StrategyPatternApplicationTests {

	@Autowired
	private DoSomething doSomething;

	@Autowired
	private List<DesignDoSomething> doSomethingList;

	@Autowired
	private StrategyFactory strategyFactory;

	@Test
	void contextLoads() {
	}

	@Test
	public void noDesigneatTest(){
		String name1="王二";
		String name2="张三";
		String name3="李四";
		System.out.println(doSomething.eat(name1));
		System.out.println(doSomething.eat(name2));
		System.out.println(doSomething.eat(name3));
	}

	/**
	 * 这样写的好处是，把每一个待做事的对象抽离出来。
	 * 让它们分别独立，可以比较自由地发挥自己的业务延伸空间。
	 * 同时，也能借助“相似逻辑”的特点，简单地调用执行方法，
	 * 即可实现在‘黑箱’中完成自己的业务目标。
	 */
	@Test
	public void designWangErTest(){
		String curName="李四";
		//这里每一次寻找都要需要先遍历才行。是否有一步到位的方式来做呢？当然有，我们可以把这种简单的查询交给map去做，因为map本身就是可以用来做简单查询的。
		//DesignDoSomething curDo = doSomethingList.stream().filter(curPer-> curPer.isCurPerson(curName)).findFirst().orElse(null);
		//更改为策略方法后，获取到curDo对象的方式变成了下面这样
		DesignDoSomething curDoLisi = strategyFactory.getCurStrategy(curName);
		if (curDoLisi != null) {
			System.out.println(curDoLisi.eat(curName));
			curDoLisi.needGarlic(curName);
		}else{
			System.out.println("===>>> not found available object");
		}
		String curName2 = "张三";
		DesignDoSomething curStrategyZs = strategyFactory.getCurStrategy(curName2);
		System.out.println(curStrategyZs.eat(curName2));
		curStrategyZs.needGarlic(curName2);

	}


}
