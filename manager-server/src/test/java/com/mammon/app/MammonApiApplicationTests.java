//package com.mammon.app;
//
//import com.github.pagehelper.PageInfo;
//import com.ocean.ManagerServerBoot;
//import com.ocean.identity.domain.UserInDto;
//import com.ocean.identity.domain.UserOutDto;
//import com.ocean.identity.service.UserService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ManagerServerBoot.class)
//public class MammonApiApplicationTests {
//	@Autowired
//	private UserService userService;
//
//	@Test
//	public void userList(){
//		UserInDto userInDto = new UserInDto();
//        PageInfo<UserOutDto> pageInfo = userService.findPageInfo(userInDto);
//        for (UserOutDto userOutDto : pageInfo.getList()) {
//            System.out.println(userOutDto);
//        }
//    }
//
//    @Test
//    public void test(){
//
//    }
//
//}
