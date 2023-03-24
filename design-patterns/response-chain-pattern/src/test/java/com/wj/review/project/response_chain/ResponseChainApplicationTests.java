package com.wj.review.project.response_chain;

import com.wj.review.project.response_chain.do_study_v1.StudyV1;
import com.wj.review.project.response_chain.do_study_v2.HaveBreakfastFilterV1;
import com.wj.review.project.response_chain.do_study_v3.FilterChain;
import com.wj.review.project.response_chain.do_study_v3.HaveBreakfastFilterV2;
import com.wj.review.project.response_chain.do_study_v3.WashFaceFilterV2;
import com.wj.review.project.response_chain.do_study_v3.WashHairFilterV2;
import com.wj.review.project.response_chain.event.Study;
import com.wj.review.project.response_chain.do_study_v2.WashFaceFilterV1;
import com.wj.review.project.response_chain.do_study_v2.WashHairFilterV1;
import com.wj.review.project.response_chain.event.PreparationList;
import org.junit.jupiter.api.Test;

//@RunWith(SpringRunner.class)
//@SpringBootTest
/**
 * 2023年3月24日10:55:37 更新
 * 本意是想通过以下的两个注解来实现
 * 不启动整个Springboot应用程序，
 * 直接运行下方的@Test注解的。
 * 但目前这种方法不太好使。
 */
//@TestPropertySource("classpath:application.properties")  //配置文件注入
//@ContextConfiguration(classes=StudyV1.class)
class ResponseChainApplicationTests {




	/**
	 * 2023年3月24日11:05:56 更新
	 * 测试结果
	 *
	 * 非核心：洗脸
	 * 非核心：洗头
	 * 非核心：吃早饭
	 * 核心流程：可以出门去上学了
	 * =====================
	 * 想想，如果需要在核心流程之前再插入些其他的动作，
	 * 是不是就要去改study方法的具体实现了呢？
	 * 这样能达到目的，但它就有点违背我们软件开发原则中的
	 * ‘开闭原则’了——对扩展开放，对修改关闭。
	 * 在小的场景里看起来似乎没什么影响，
	 * 但如果放大到项目开发中，
	 * 带来的问题可能就大了。
	 * 有时候为了解决非核心流程里的一个问题，
	 * 反而导致核心流程受影响，就有点‘得不偿失’了。
	 * 所以，我们最好还是按照原则来办事。
	 */
	@Test
	public void studyV1Test(){
		//①：准备各事项
		PreparationList curPreparationList = new PreparationList();
		curPreparationList.setWashFace(true);
		curPreparationList.setWashHair(true);
		curPreparationList.setHavebreakfast(true);
		//②：准备完成，执行核心方法
		StudyV1 studyV1 = new StudyV1();
		studyV1.study(curPreparationList);
	}

	/**
	 * 2023年3月24日13:43:21 更新
	 * 测试结果
	 * 已洗脸
	 * 已吃早饭
	 * 核心流程：可以去上学了
	 * =====================
	 * 毫无疑问，在最终的结果上是一样的。
	 * 但这种方法的好处也比较明显
	 * ①：核心和非核心事件做到很好的分离；
	 * ②：非核心事件上的处理上也有了更多的自由空间
	 * 缺点也有
	 * 责任链上的对象在创建的时候，有顺序上的约束。
	 * 正向的逻辑：洗脸--->吃饭--->上学
	 * 但在代码的编写上要倒过来，
	 * 如果链路过长，且需要对顺序做更改的，就不太方便了。
	 *
	 * 从washFaceFilter起始，
	 * 每一个链上的对象都要执行处理的动作，来完成各自负责的工作，即prepare方法。
	 * 工作完成后，又通过传递的方式，通知下一个事件处理对象开始工作。
	 * 直到最后一个对象完成自己的工作后，
	 * 就可以执行核心的方法了。
	 * 整个过程有点像多个人，组合成一条队伍，然后不断传递砖块儿一样。
	 * 直到最后把砖块儿放到正确的地方。
	 *
	 * 目前这种模式，但凡中间要减少一环或者增加一环，亦或者调换下顺序，
	 * 都不太方便。
	 * 有没有更好的方式呢？
	 *
	 */
	@Test
	public void studyV2Test(){
		//①：准备需要执行的非核心事项
		PreparationList preparationList = new PreparationList();
		preparationList.setWashFace(true);
		//可以不洗头
		preparationList.setWashHair(false);
		preparationList.setHavebreakfast(true);

		//②：准备核心事件对象
		Study study = new Study();

		//③：用责任链将它们窜起来
		HaveBreakfastFilterV1 havebreakfastFilter = new HaveBreakfastFilterV1(null);
		//先洗脸，再洗头，最后吃早饭。吃完早饭，就算把事情做完了。
		WashHairFilterV1 washHairFilter = new WashHairFilterV1(havebreakfastFilter);
		WashFaceFilterV1 washFaceFilter = new WashFaceFilterV1(washHairFilter);
		//从洗脸开始
		washFaceFilter.doFilter(preparationList,study);
	}


	/**
	 * 2023年3月24日14:27:08 更新
	 * 测试结果
	 * 已洗头
	 * 已经吃过饭了
	 * 已洗脸
	 * 核心流程：可以去上学了
	 * =====================
	 * 这种升级了的责任链模式，就可以很好地规避v2版本中出现的问题。
	 * 1）顺序调整有影响；
	 * 2）filter调用顺序僵化；
	 * 参见下方的说明。
	 *
	 * 我们经常开发的web项目中，
	 * 外部的请求在进入到Controller层前，
	 * 都会经过过滤器的过滤。
	 * 它也是一种将 ‘非核心，但需要统一’的逻辑抽离出来的思想。
	 * 这样的好处也显而易见：专注于你的核心就可以了，其他的都不用管。
	 * 是一种很好的应用。
	 * 可以这么说吧：过滤器链是责任链模式的升级版的体现。
	 */
	@Test
	public void studyV3Test(){
		PreparationList curPreparationList = new PreparationList();
		curPreparationList.setWashFace(true);
		curPreparationList.setWashHair(true);
		curPreparationList.setHavebreakfast(true);
		/**
		 * 要增加或者删减，直接定义对象就好了，
		 * 也不用顾忌它们间的顺序。
		 * 而且，它们只需要管自己的具体实现
		 * 要做什么，怎么去做，或者说要加上扩展的，都可以。
		 */
		WashHairFilterV2 washHairFilterV2 = new WashHairFilterV2();
		HaveBreakfastFilterV2 haveBreakfastFilterV2 = new HaveBreakfastFilterV2();
		WashFaceFilterV2 washFaceFilterV2 = new WashFaceFilterV2();

		/**
		 * 同样的，核心事件执行对象也是类似。
		 * 要做什么就做自己的，也是被隔离开来的。
		 */
		Study study = new Study();

		/**
		 * 最终要做什么事情，交给过滤器链这个对象就好了。
		 * 它负责把前面的这些对象串联起来，
		 * 让它们能在你希望的逻辑下被执行到。
		 */
		FilterChain filterChain = new FilterChain(study);
		//此处随便怎么换顺序都可以，对其他已在链中的对象不会产生丝毫影响。
		filterChain.addFilter(washHairFilterV2);
		filterChain.addFilter(washFaceFilterV2);
		filterChain.addFilter(haveBreakfastFilterV2);

		filterChain.doFilter(curPreparationList,filterChain);

	}



}
