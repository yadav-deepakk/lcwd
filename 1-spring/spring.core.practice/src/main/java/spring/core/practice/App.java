package spring.core.practice;

public class App {
	public static void main(String[] args) {

		/*
		 * =============================================
		 * 			Done core java approach.
		 * =============================================
		 */
//		Laptop ideapad = new Laptop();
//		ideapad.setName("lenovo ideapad 320");

//		HardDrive seggate = new HardDrive("Seggate", 512 * 1024 * 1024L);
//		ideapad.setHarddrive(seggate);

		/*
		 * ======================================================== 
		 * 		approach(XML based configuration). 
		 * ========================================================
		 */
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("beansConfig.xml");
//		Laptop ideapad = ctx.getBean("ideapad", Laptop.class);
//		System.out.println("Manufactured Laptop is : " + ideapad);
//		((AbstractApplicationContext) ctx).close();

		/*
		 * ======================================================= 
		 * approach(java configuration based). 
		 * =======================================================
		 */
//		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//		Laptop ideapad320 = ctx.getBean("ideapad320", Laptop.class);
//		Laptop ideapad330 = ctx.getBean("ideapad330", Laptop.class);
//
//		System.out.println("Laptop ideapad320 details : " + ideapad320);
//		System.out.println("Laptop ideapad330 details : " + ideapad330);
//
//		((AbstractApplicationContext) ctx).close();

	}
}
